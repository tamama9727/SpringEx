package com.gunn.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gunn.ex.mybatis.bo.ReviewBO;
import com.gunn.ex.mybatis.model.Review;

@Controller
public class ReviewController {

	
	@Autowired
	private ReviewBO reviewBO;
	//id가 3인 가져오기  form new_review
	
	@ResponseBody
	@RequestMapping("/mybatis/ex01/1")
	public Review review(
			@RequestParam(value="id", defaultValue="1") int id
			) {
		
		
		Review review = reviewBO.getReview(id);
		
		return review;
	}
}
