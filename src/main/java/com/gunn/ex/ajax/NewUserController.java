package com.gunn.ex.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	//이름 생년월일 자기소개 이메일 전달 받고 저장
	public Map<String ,String> addUser(
			@RequestParam("name") String name
			,@RequestParam("yyyymmdd") String yyyymmdd
			,@RequestParam("introduce") String introduce
			,@RequestParam("email") String email
			) {
		
		int count = newUserBO.addUser(name, yyyymmdd, introduce, email);
		
		//리스펀스에 올바른 정보를 주기위해서
		Map<String, String> result = new HashMap<>();
		
		//{"result":"success"}
		if(count == 1) {
			//정상상태
			//{"result":"success"}
			result.put("result", "success");
			
			
		}else{
			//비 정상상태
			//{"result":"fail"}
			result.put("result", "fail");
		}
		
		return result;
		//return "삽입결과 : " + count;
	}
	
	@GetMapping("/input")
	public String userInput() {
		
		return "ajax/userInput";
	}
	
	@GetMapping("/is_duplicate")
	@ResponseBody
	public Map<String , Boolean> isDuplicate(@RequestParam("name") String name) {
		
		Map<String , Boolean> result = new HashMap<>();
		
		if(newUserBO.isDuplicateName(name)) {
			result.put("is_dupilcate", true);
		}else {
			result.put("is_dupilcate", false);
		}
		
		return result;
	}
	
	
	
	
}
