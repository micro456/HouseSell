package com.micro.service;


import java.util.List;

import com.micro.entity.House;
import com.micro.entity.HouseExample;
import com.micro.entity.Region;
import com.micro.utils.Result;

public interface HouseManager {
	
	// 获取所有要被销售的房产 
	public Result getOnSellHouseList(HouseExample houseExample);
	
	// 获取所有已经被预约的房产
	public Result getReservedHouseList();
	
	// 获取所有销售完的的房产
	public Result getSoldHouseList();
	
	// 增加可出售房产
	public Result addOnSellHouse(House house);
	
	// 删除房子
	public Result deleteHouseById(Long houseId);
	
	// 购买房子
	public Result buyHouseById(Long houseId, Long userId);
	
	// 交易信息
	public Result tradeInfo();
	
	// 获取所有房产类型
	public Result getAllHouseType();
	
	// 条件查询
	public List<House> searchHouseList(HouseExample houseExample);
	
	// 获取所有地区
	public List<Region> getAllRegion();
}
