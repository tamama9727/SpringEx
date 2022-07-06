package com.gunn.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gunn.ex.database.bo.UsedGoodsBO;
import com.gunn.ex.database.model.UsedGoods;

@Controller
public class UsedGoodsController {

	@Autowired
	private UsedGoodsBO usedGoodsBO;
	
	//used goods 안에 있는 모든 내용을 json 으로 전달한다.
	@RequestMapping("/database/ex01/1")
	@ResponseBody
	public List<UsedGoods> ex01() {
		List<UsedGoods> list = usedGoodsBO.getUsedGoodsList();
		
		return list;
	}
}
