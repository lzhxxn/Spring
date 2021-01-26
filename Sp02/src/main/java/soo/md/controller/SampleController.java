package soo.md.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;
import soo.md.domain.Human;
import soo.md.domain.HumanList;
import soo.md.domain.ToDoDTO;

@Log4j
@Controller
@RequestMapping("/sample/*")
public class SampleController {
	
	@RequestMapping("")
	public void m01() {
		log.info("m01() - default URL");
	}
	@RequestMapping("/base1")
	public void m02() {
		log.info("m02() - Get방식 & Post방식 & ...");
	}
	@RequestMapping(value="/base2", method=RequestMethod.GET)
	public void m03() {
		log.info("m03() - only Get방식");
	}
	@RequestMapping(value="/base3", method= {RequestMethod.GET, RequestMethod.POST})
	public void m04() {
		log.info("m04() - Get방식 & Post방식");
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form() {
		return "sample/form";
	}
	@RequestMapping("/param1")
	public void m05(Human dto) {
		log.info("m05() dto: " + dto);
	}
	@RequestMapping("/param2")
	public void m06(@RequestParam String name, @RequestParam int age) {
		log.info("m06() name: " + name + ", age: " + age);
	}
	@RequestMapping("/param3")
	public void m07(@RequestParam ArrayList<String> names) {
		log.info("m07() names: " + names);
	}
	@RequestMapping("/param4")
	public void m08(@RequestParam("ns") ArrayList<String> names) {
		log.info("m08() names: " + names);
	}
	@RequestMapping("/param5")
	public void m09(@RequestParam String[] names) {
		log.info("m09() names: " + names);
		for(String name: names) log.info("name: "+ name);
	}
	@RequestMapping("/param6")
	public void m10(HumanList hlist) {
		log.info("m10() hlist: " + hlist);
	}
	@RequestMapping("/param7")
	public void m11(Human dto, @RequestParam int page) {
		log.info("m11() dto: " + dto + ", page: "+ page);
	}
	@RequestMapping("/param8") // 모든게 다 지원된다.
	public void m12(ToDoDTO dto) {
		log.info("m12() dto.getCdate(): " + dto.getCdate());
	}
	//@RequestMapping(value="/json1", method=RequestMethod.GET)  //두개는 같은거다.
	@GetMapping("/json1") // GET만 된다.
	public ResponseEntity<String> m13() { //JSON
		String msg = "{\"name\":\"임연지\",  \"age\":\"25}";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=utf-8");
		
		return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
	}
	@GetMapping("/json2")
	public @ResponseBody Human m14(){ //**********************
		return new Human("세종대왕", 40);
	}
}
