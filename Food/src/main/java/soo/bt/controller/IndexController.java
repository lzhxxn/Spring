package soo.bt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "index"; 
	}
	@RequestMapping("/about.html")
	public String about() {
		return "about"; 
	}
	@RequestMapping("/blog.html")
	public String blog() {
		return "blog"; 
	}
	@RequestMapping("/codes.html")
	public String codes() {
		return "codes"; 
	}
	@RequestMapping("/contact.html")
	public String contact() {
		return "contact"; 
	}
	@RequestMapping("/menu.html")
	public String menu() {
		return "menu"; 
	}
	@RequestMapping("/single.html")
	public String single() {
		return "single"; 
	}
	
	@RequestMapping("/index.html")
	public String index2() {
		return "index"; 
	}
}
