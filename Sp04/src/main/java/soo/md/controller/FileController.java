package soo.md.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import soo.md.filesetting.Path;
import soo.md.service.FileUploadService;

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("file")
public class FileController {
	private FileUploadService service; //Spring 4.3 ~: AutoInjection (with @AllArgsConstructor )
	
	@GetMapping("form.do")
	public String formFu() {
		return "file/form";
	}
	@PostMapping("upload.do")
	public String upload(@RequestParam String name, @RequestParam  MultipartFile file) {
		log.info("#name: " + name + ", file: " + file);
		String ofname = file.getOriginalFilename();
		if(ofname != null) ofname = ofname.trim();
		if(ofname.length() != 0) {
		 String url = service.saveStore(file);
		}
		return "redirect:list.do";
	}
	
	@GetMapping("list.do")
	public ModelAndView fileList() {
		File fStore = new File(Path.FILE_STORE);
		if(!fStore.exists()) fStore.mkdirs();
		File files[] = fStore.listFiles();
		
		return new ModelAndView("file/list", "files", files);
	}
	
	@GetMapping("del.do")
	public String del(@RequestParam String fname) {
		File file = new File(Path.FILE_STORE, fname);
		if(file.exists()) file.delete();
		
		return "redirect:list.do";
	}
	
	@GetMapping("form_mt.do")
	public String formFuMt() {
		return "file/form_mt";
	}
	
	@PostMapping("upload_mt.do")
	public String uploadMt(@RequestParam ArrayList<MultipartFile> files){
		for (MultipartFile mf : files) {
			String ofname = mf.getOriginalFilename();
			if(ofname != null) ofname = ofname.trim();
			if(ofname.length() != 0) {
			String url = service.saveStore(mf);
		}
	}
		return "redirect:list.do";
	}
	
	@GetMapping("download.do")
	public ModelAndView download(@RequestParam String fname) {
		File file = new File(Path.FILE_STORE, fname);
		if(file.exists()) {
			return new ModelAndView("fileDownloadView", "downloadFile", file);     // id , 이름 , 객체 순
		}else {
			return new ModelAndView("redirect:list.do");
		}		
	}
}
