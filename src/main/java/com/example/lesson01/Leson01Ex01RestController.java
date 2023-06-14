package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/lesson01/ex01")
@RestController  // @Controller + @ResponseBody
public class Leson01Ex01RestController {

	//http://localhost:8080/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3() {
		return "@RestController 를 사용해 String을 리턴한다";
	}
	
	//http://localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String,Object> ex01_4(){
		Map<String,Object> map = new HashMap<>();
		map.put("aa","zz");
		map.put("gg","dd");
		map.put("hh","ww");
		return map;
	}
	
	//http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() {
		Data data = new Data(); // java bean : 내가 new 를 하면 
		data.setId(1);
		data.setName("최도윤");
		return data;
	}
	
	//http://localhost:8080/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6(){
		Data data = new Data();
		data.setId(1);
		data.setName("최도윤");
		
//		return new ResponseEntity<>(data,HttpStatus.OK);
		return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
