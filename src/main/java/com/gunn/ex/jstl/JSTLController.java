package com.gunn.ex.jstl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gunn.ex.jsp.model.User;

@Controller
public class JSTLController {
	
	@GetMapping("/jstl/ex01")
	public String ex01() {
		
		return "jstl/ex01";
	}
	
	@GetMapping("jstl/ex02")
	public String ex02(Model model) {
		
		//과일 이름 List
		List<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("melon");
		fruits.add("peach");
		fruits.add("mango");
		
		model.addAttribute("data",fruits);
		
		List<User> userList = new ArrayList<>();
		
		User user1 = new User();
		user1.setName("권성진");
		user1.setYyyymmdd("19970223");
		user1.setEmail("tata");
		userList.add(user1);
		
		User user2 = new User();
		user1.setName("김떙대");
		user1.setYyyymmdd("20000101");
		user1.setEmail("45afd");
		userList.add(user2);
		
		model.addAttribute("userList" , userList);
		
		return"jstl/ex02";
	}
	
	@GetMapping("/jstl/ex03")
	public String ex03(Model model) {
		
		Date now = new Date();
		model.addAttribute("now", now);
		
		return"jstl/ex03";
	}
	
}
