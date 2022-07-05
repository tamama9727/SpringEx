package com.gunn.ex.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/lifecycle/ex01")
public class Ex01Controller {

	@RequestMapping("/1")
	@ResponseBody
	public String printString() {
		return "예제 1번을 문자열을 response에 담는다.";
	}
	
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Integer> printMap(){
		Map<String, Integer> map = new HashMap<>();
		map.put("apple", 1500);
		map.put("banana", 1500);
		map.put("orange", 1500);
		
		return map;
	}
}
