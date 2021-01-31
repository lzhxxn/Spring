package soo.md.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import soo.md.domain.Address;
import soo.md.service.AddressAjaxService;

@Controller
@RequestMapping("ajax02")
public class AjaxT02Controller {  // 라이브러리도움을얻어서 DTO 객체를  JSON으로 바꿔준것이다. ! ObjectMapper가있으면 가능하다.
	@Autowired
	private AddressAjaxService service;
	
	@GetMapping("search01.do")
	public void search01(long seq, HttpServletResponse response) {
		Address address = service.selectBySeqS(seq);
		
		ObjectMapper om = new ObjectMapper();  // ObjectMapper쓰게되면 편하다.//결과는 마찬가지다!
		try {
			String json = om.writeValueAsString(address);  // JSON 객체로 써라
			response.setContentType("application/json;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print(json);   							
		}catch(IOException ie) {}
	}
	@PostMapping("search02.do")
	public void search02(String name, HttpServletResponse response) {
		List<Address> list = service.selectByNameS(name);
		
		ObjectMapper om = new ObjectMapper();  // ObjectMapper쓰게되면 편하다.//결과는 마찬가지다!
		try {
			String json = om.writeValueAsString(list);  // JSON 객체로 써라
			response.setContentType("application/json;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print(json);   							
		}catch(IOException ie) {}
		
	}
}
