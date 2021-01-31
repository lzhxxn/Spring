package soo.md.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import soo.md.domain.Address;
import soo.md.service.AddressAjaxService;

@ResponseBody
@Controller
@RequestMapping("ajax03")
public class AjaxT03Controller {
	@Autowired
	private AddressAjaxService service;
	
	@GetMapping("search01")
	public @ResponseBody Address search01(long seq, HttpServletResponse response) {
		Address address = service.selectBySeqS(seq);
		
		return address;  // JSON DATA
	}
	@PostMapping("search02")
	public @ResponseBody List<Address> search02(String name, HttpServletResponse response) {
		List<Address> list = service.selectByNameS(name);
		
		return list;  // JSON DATA
	}
	@GetMapping("index2.do")
	public ModelAndView index() {
		return new ModelAndView("index"); // index.jsp
	}
}
