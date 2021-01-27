package soo.md.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;
import soo.md.domain.Address;
import soo.md.service.AddressService;

@Log4j
@Controller
@RequestMapping("/address/*")
public class AddressController {
	//@Autowired
	@Resource(name="addressService")
	private AddressService service;
	
	//@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@GetMapping("/list.do")
	public ModelAndView list() {
		List<Address> list = service.listS();
		
		/*ModelAndView mv = new ModelAndView();
		mv.setViewName("address/list");
		mv.addObject("list", list);*/
		ModelAndView mv = new ModelAndView("address/list", "list", list);
		
		return mv;
	}
	@GetMapping("/write.do")
	public String write() {
		return "address/write";
	}
	@PostMapping("/write.do")
	public String write(Address address) {
		service.insertS(address);
		
		return "redirect:list.do";     //23번줄이 호출되서 뷰로가고 데이터를 가져간다.
	}
	@GetMapping("del.do")
	public String delete(@RequestParam long seq, HttpSession session, HttpServletRequest request, Object page) {
		
		ServletContext application = session.getServletContext();
		log.info("#session: " + session);
		log.info("#Request: " + request);
		log.info("page: " + page);
		log.info("application: " + application);
		
		service.deleteS(seq);
		return "redirect:list.do";
	}
}





