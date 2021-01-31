package soo.md.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soo.md.domain.Address;
import soo.md.service.AddressAjaxService;

@RestController
@RequestMapping("ajax04")
public class AjaxT04Controller {
	@Autowired
	private AddressAjaxService service;
	
	@GetMapping(value="search01", 
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Address search01(long seq, HttpServletResponse response) {
		Address address = service.selectBySeqS(seq);
		
		return address;
	}
	@PostMapping(value="search02", 
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Address> search02(String name, HttpServletResponse response) {
		List<Address> list = service.selectByNameS(name);
		
		return list;
	}
}
//01)append_4json_4xml.txt

	//아무것도안쓰면 XML