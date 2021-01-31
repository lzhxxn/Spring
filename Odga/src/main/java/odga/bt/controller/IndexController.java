package odga.bt.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "index"; 
	}
	@RequestMapping("/index.html")
	public String index2() {
		return "index"; 
	}
	@RequestMapping("/about")
	public String about() {
		return "about"; 
	}
	@RequestMapping("/blog_details")
	public String blog_details() {
		return "blog_details"; 
	}
	@RequestMapping("/blog")
	public String blog() {
		return "blog"; 
	}
	@RequestMapping("/catagori")
	public String catagori() {
		return "catagori"; 
	}
	@RequestMapping("/contact")
	public String contact() {
		return "contact"; 
	}
	@RequestMapping("/elements")
	public String elements() {
		return "elements"; 
	}
	@RequestMapping("/listing_details")
	public String listing_details() {
		return "listing_details"; 
	}
	@RequestMapping("/listing")
	public String listing() {
		return "listing"; 
	}
	@RequestMapping("/main")
	public String main() {
		return "main"; 
	}
	

}
