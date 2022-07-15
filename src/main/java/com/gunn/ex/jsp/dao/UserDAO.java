package com.gunn.ex.jsp.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gunn.ex.jsp.model.User;

@Repository
public interface UserDAO {
	
	public int insertUser(
			@Param("name") String name
			,@Param("yyyymmdd") String yyyymmdd
			,@Param("introduce") String introduce
			,@Param("email") String email);
	
	public int insertWithId(User user);
	
	// 가장 최근 등록된 사용자 정보 조회
	public User selectLastUser();

}
