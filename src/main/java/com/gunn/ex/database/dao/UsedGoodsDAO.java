package com.gunn.ex.database.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gunn.ex.database.model.UsedGoods;

@Repository
public interface UsedGoodsDAO {
	
	//
	public List<UsedGoods> selectUsedGoodsList();

}
