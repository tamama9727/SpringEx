package com.gunn.ex.mybatis.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gunn.ex.mybatis.dao.ReviewDAO;
import com.gunn.ex.mybatis.model.Review;

@Service
public class ReviewBO {
	
	//id가 3인 리뷰 가져올려고 만듬
	@Autowired
	private ReviewDAO reviewDAO;
	
	public Review getReview(int id) {
		
		Review review = reviewDAO.selectReview(id);
		
		return review;
	}

}
