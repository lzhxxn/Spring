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

import soo.md.domain.Address;
import soo.md.service.AddressService;

@Controller
@RequestMapping("/address1/*")  //path가 겹치면안된다. 컨트롤러가 여러개면
public class AddressController1 {
	
	//@Autowired
	@Resource(name="addressService1")
	private AddressService service;
	
	@GetMapping("/list.do")
	public ModelAndView list() {
		List<Address> list = service.listS();
		ModelAndView mv = new ModelAndView("address1/list", "list", list);
		
		return mv;
	}
	@GetMapping("/write.do")
	public String write() {
		return "address1/write";
	}
	@PostMapping("/write.do")
	public String write(Address address) {
		service.insertS(address);
		
		return "redirect:list.do";     //23번줄이 호출되서 뷰로가고 데이터를 가져간다.
	}
	@GetMapping("del.do")
	public String delete(@RequestParam long seq) {
		service.deleteS(seq);
		return "redirect:list.do";
	}
}
