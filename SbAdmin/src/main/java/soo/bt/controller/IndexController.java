package soo.bt.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	

	@RequestMapping("/")
	public String index() {
		return "index"; 
	}
	@RequestMapping("/blank.html")
	public String blank() {
		return "blank"; 
	}
	@RequestMapping("/buttons.html")
	public String buttons() {
		return "buttons"; 
	}
	@RequestMapping("/flot.html")
	public String flot() {
		return "flot"; 
	}
	@RequestMapping("/forms.html")
	public String forms() {
		return "forms"; 
	}
	@RequestMapping("/grid.html")
	public String grid() {
		return "grid"; 
	}
	@RequestMapping("/icons.html")
	public String icons() {
		return "icons"; 
	}
	
	@RequestMapping("/login.html")
	public String login() {
		return "login"; 
	}
	@RequestMapping("/morris.html")
	public String morris() {
		return "morris"; 
	}
	@RequestMapping("/notifications.html")
	public String notifications() {
		return "notifications"; 
	}
	@RequestMapping("/panels-wells.html")
	public String panelswells() {
		return "panels-wells"; 
	}
	@RequestMapping("/tables.html")
	public String tables() {
		return "tables"; 
	}
	@RequestMapping("/typography.html")
	public String typography() {
		return "typography"; 
	}

	@RequestMapping("/index.html")
	public String index2() {
		return "index"; 
	}
}
