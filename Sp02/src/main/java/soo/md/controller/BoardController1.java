package soo.md.controller;

import java.io.File;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import soo.md.domain.Board;
import soo.md.domain.BoardListResult;
import soo.md.filesetting.Path;
import soo.md.service.BoardService;
import soo.md.service.FileUploadService;


@Log4j
//@AllArgsConstructor
@Controller
@RequestMapping("/board1/*")  
public class BoardController1 {
	
	//@Autowired
	@Resource(name="boardService1")
	private BoardService service;

	
	@RequestMapping("list.do")
	public ModelAndView list(HttpServletRequest request) {
	    HttpSession session = request.getSession();
		String keyword = request.getParameter("keyword");
		String catgo = request.getParameter("catgo");
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		
		//(1) cp 
		int cp = 1;
		if(cpStr == null) {
			Object cpObj = session.getAttribute("cp");
			if(cpObj != null) {
				cp = (Integer)cpObj;
			}
		}else {
			cpStr = cpStr.trim();
			cp = Integer.parseInt(cpStr);
		}
		session.setAttribute("cp", cp);
		
		//(2) ps 
		int ps = 3;
		if(psStr == null) {
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				ps = (Integer)psObj;
			}
		}else {
			psStr = psStr.trim();
			int psParam = Integer.parseInt(psStr);
			
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				int psSession = (Integer)psObj;
				if(psSession != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}else {
				if(ps != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}
			
			ps = psParam;
		}
		session.setAttribute("ps", ps);
		
		//(3) ModelAndView 
		
		BoardListResult listResult = null;
		ModelAndView mv = null;
		
		if(catgo!=null && keyword !=null) {
			listResult = service.getBoardListResult(catgo, keyword, cp, ps);
			mv = new ModelAndView("board1/list", "listResult", listResult);
			if(listResult.getList().size() == 0) {
				if(cp>1)
					return new ModelAndView("redirect:list.do?cp="+(cp-1));
				else
					return new ModelAndView("board1/list", "listResult", null);
			}
				return mv;
		}else {
			listResult = service.getBoardListResult(cp, ps);
			mv = new ModelAndView("board1/list", "listResult", listResult);
			if(listResult.getList().size() == 0) {
				if(cp>1)
					return new ModelAndView("redirect:list.do?cp="+(cp-1));
				else
					return new ModelAndView("board1/list", "listResult", null);
			}
		}
		return mv;
	}
	
	@GetMapping("/write.do")
	public String write() {
		return "board1/write";
	}
	
	@PostMapping("/write.do")
	public String insert(Board board, @RequestParam MultipartFile file) {
		log.info("#file: " + file);
		
		String fname = file.getName();
		String ofname = file.getOriginalFilename();
		long fsize = file.getSize();
		
		
		if(ofname == null && ofname.length() == 0){
			fname = null;
			ofname = null;
			fsize = -1;
			board.setFname(fname);
			board.setOfname(ofname);
			board.setFsize(fsize);
		}else{
			ofname = ofname.trim();
			board.setFname(fname);
			board.setOfname(fname);
			board.setFsize(fsize);
			service.insertS(board);	
		}
		service.saveStore(file);
		return "redirect:list.do";
	}
	
	@GetMapping("/reply.do")
	public String reply() {
		return "board1/reply";
	}
	@PostMapping("/reply.do")
	public String reply(Board board, @RequestParam MultipartFile file) {
		log.info("#file: " + file);
		
		String fname = file.getName();
		String ofname = file.getOriginalFilename();
		long fsize = file.getSize();
		
		
		if(ofname == null && ofname.length() == 0){
			fname = null;
			ofname = null;
			fsize = -1;
			board.setFname(fname);
			board.setOfname(ofname);
			board.setFsize(fsize);
		}else{
			ofname = ofname.trim();
			board.setFname(fname);
			board.setOfname(ofname);
			board.setFsize(fsize);
			service.insertreS(board);	
			service.saveStore(file);
		}
		return "redirect:list.do";
	}
	
	
    
	@GetMapping("/content.do")
	public ModelAndView content(long seq) {
		Board board = service.selectBySeqS(seq);
		ModelAndView mv = new ModelAndView("board1/content", "board", board);
		return mv;
	}
	
	@GetMapping("del.do")
	public String delete(@RequestParam long seq) {
		service.deleteS(seq);
		return "redirect:list.do";
	}
	
	@GetMapping("/update.do")
	public ModelAndView update1(long seq) {  //@RequestParam 생략가능하다. 자동으로 가져온다 스프링에서.
		Board board = service.update1S(seq);
		ModelAndView mv = new ModelAndView("board1/update", "board", board);
		return mv;
	}
	
	@PostMapping("/update.do")
	public String update2(Board board) {
		service.update2S(board);
		return "redirect:list.do";
	}
	
	@GetMapping("/download.do")
	public ModelAndView download(@RequestParam String fname) {
		File file = new File(Path.FILE_STORE, fname);
		if(file.exists()) {
			return new ModelAndView("fileDownloadView", "downloadFile", file);     // id , 이름 , 객체 순
		}else {
			return new ModelAndView("redirect:list.do");
		}		
	}
	
}
