package soo.md.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;
import soo.md.domain.Address;

@Log4j
@RestController
@RequestMapping("rest")
public class RestControllerWithAddress {
	
	@GetMapping(value="/getText", produces = "text/plain;charset=utf-8")
	public String getText() {
		//return "index";                                          // index.jsp X @RestController 이기때문에 ! 스트링형태를 리턴한다.
		return "안녕^_^";
	}
	@GetMapping(value="/getAddress")
    public Address getAddress() {
    	return new Address(1, "지훙", "서울", new Date(2021-1900, 1-1, 25));
    }
	@GetMapping("getList")
	public List<Address> getList(){
		List<Address> list = new ArrayList<Address>();
		Address a1 = new Address(1, "홍길동", "서울시", new Date(2021-1900, 1-1, 25));
		Address a2 = new Address(2, "이순신", "부산시", new Date(2021-1900, 1-1, 25));
		list.add(a1); list.add(a2);
		
		return list;
	}
	
	@GetMapping("getMap")
	public Map<String, Address> getMap(){
		Map<String, Address> map = new HashMap<String, Address>();
		Address a1 = new Address(1, "홍길동", "서울시", new Date(2021-1900, 1-1, 25));
		Address a2 = new Address(2, "이순신", "부산시", new Date(2021-1900, 1-1, 25));
		map.put("first", a1); map.put("second", a2);
		
		return map;
	}
	
	@GetMapping(value="check", params = {"height", "weight"})
	public ResponseEntity<Address> check(@RequestParam("height") double h, @RequestParam double weight){
		Address a = new Address(3, ""+h, ""+weight, new Date(2021-1900, 1-1, 25));
		
		ResponseEntity<Address> result = null;
		if(h<150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(a);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(a);
		}
		return result;
	}
	//클라이언트의 요청 path로 부터 값을 추출하는 예
	@GetMapping(value="product/{cat}/{pid}")
	public String[] getPath(@PathVariable ("cat") String cat, @PathVariable int pid) {
		String strs[] = {"카테고리: " + cat + ", 상품아이디: " + pid};
		
		return strs;
	}

	@PostMapping(value="json_dto")
	public Address convert(@RequestBody Address dto) {
		log.info("#########");
		log.info("@convered dto: " + dto);
		
		return dto;
	}
}

