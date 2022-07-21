package com.gunn.ex.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gunn.ex.ajax.bo.NewUserBO;
import com.gunn.ex.ajax.model.NewUser;

@Controller
@RequestMapping("/ajax/user")
public class NewUserController {

	
	@Autowired
	private NewUserBO newUserBO;
	//new_user 테이블 결과 보기
	@GetMapping("/list")
	public String userList(Model model) {
		
		List<NewUser> userList = newUserBO.getUserList();
		
		model.addAttribute("userList", userList );
		
		return "ajax/userList" ;
	}
	
	@PostMapping("/insert")
	//이름 생년월일 자기소개 이메일 전달 받고 저장
	public String addUser(
			@RequestParam("name") String name
			,@RequestParam("yyyymmdd") String yyyymmdd
			,@RequestParam("introduce") String introduce
			,@RequestParam("email") String email
			) {
		
		int count = newUserBO.addUser(name, yyyymmdd, introduce, email);
		
		return "삽입결과 : " + count;
	}
	
	@GetMapping("/input")
	public String userInput() {
		
		return "ajax/userInput";
	}
}
