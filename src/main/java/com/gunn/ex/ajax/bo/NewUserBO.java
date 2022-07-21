package com.gunn.ex.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gunn.ex.ajax.dao.NewUserDAO;
import com.gunn.ex.ajax.model.NewUser;

@Service
public class NewUserBO {

	@Autowired
	private NewUserDAO newUserDAO;
	
	// new_user 테이블 모든 내용 열어오기
	public List<NewUser> getUserList(){
		return newUserDAO.selectUserList();
		
	}
	
	public int addUser(String name , String yyyymmdd , String introducec , String email) {
		return newUserDAO.insertUser(name, yyyymmdd, introducec, email);
		
	}
}
