package soo.md.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import lombok.extern.log4j.Log4j;
import soo.md.service.DragdropService;

@Log4j
@Controller
@RequestMapping("file")
public class DragdropController {
	
	@GetMapping("/form_dd.do")
	public String form() {
		return "drag_drop/form";
	}
	
	@Autowired
	private DragdropService service;
	
	@PostMapping("fileUpload.do")
	public String fileUpload(MultipartHttpServletRequest mhsr) {
		service.setMultipartRequest(mhsr);
		Map<String, List<Object>> map = service.getUpdateFileName();
		
		String appendData = mhsr.getParameter("temp");
		log.info("#DragdropController map: " + map + ", appendData: "+ appendData);
		
		return "redirect:list.do";
	}
}