package soo.md.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ajax")    // index 매핑 ! 
public class AjaxIndexController {
	
	@RequestMapping("test01.do")
	public String t01() {
		
		return "ajax/test01"; // view page return
		
	}
	@RequestMapping("test02.do")
	public String t02() {
		
		return "ajax/test02"; // view page return
		
	}
	@RequestMapping("test03.do")
	public String t03() {
		
		return "ajax/test03"; // view page return
		
	}
	@RequestMapping("test04.do")
	public String t04() {
		
		return "ajax/test04"; // view page return
		
	}
	
	@RequestMapping("requestbody.do")
	public String requestbody() {
		return "requestbody";
	}
	

}
