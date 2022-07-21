package com.gunn.ex.ajax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gunn.ex.ajax.model.NewUser;

@Repository
public interface NewUserDAO {
	
	// new_user에 테이블 모두 가져오기
	public List<NewUser> selectUserList();

	public int insertUser(
			@Param("name")String name,
			@Param("yyyymmdd")String yyyymmdd,
			@Param("introduce")String introduce,
			@Param("email")String email
			);
}
