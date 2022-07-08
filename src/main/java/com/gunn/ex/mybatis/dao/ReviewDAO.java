package com.gunn.ex.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gunn.ex.mybatis.model.Review;

@Repository
public interface ReviewDAO {
	
	// 테이블에서 가져올려고 만듬
	public Reveiw selectReview(@Param("id") int id);
	
}
