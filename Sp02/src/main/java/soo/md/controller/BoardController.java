package soo.md.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import soo.md.domain.Board;
import soo.md.service.BoardService;

@Controller
@RequestMapping("/board/*")

public class BoardController {
	@Resource(name="boardService")
	private BoardService service;
	
	@GetMapping("/list.do")
	public ModelAndView list() {
		List<Board> list = service.listS();
		ModelAndView mv = new ModelAndView("board/list", "list", list);
		return mv;
	}
	
	@GetMapping("/write.do")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/write.do")
	public String insert(Board board) {
		service.insertS(board);
		return "redirect:list.do";
	}
	
	@GetMapping("/content.do")
	public ModelAndView content(@RequestParam long seq) {
		Board board = service.selectBySeqS(seq);
		ModelAndView mv = new ModelAndView("board/content", "board", board);
		return mv;
	}
	
	@GetMapping("del.do")
	public String delete(@RequestParam long seq) {
		service.deleteS(seq);
		return "redirect:list.do";
	}
	
	@GetMapping("/update.do")
	public ModelAndView update1(@RequestParam long seq) {
		Board board = service.update1S(seq);
		ModelAndView mv = new ModelAndView("board/update", "board", board);
		return mv;
	}
	
	@PostMapping("/update.do")
	public String update2(Board board) {
		service.update2S(board);
		return "redirect:list.do";
	}
	
}
