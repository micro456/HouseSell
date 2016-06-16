package com.micro.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.micro.dao.HouseMapper;
import com.micro.dao.HouseTypeMapper;
import com.micro.dao.RegionMapper;
import com.micro.dao.UserMapper;

// ע��ȫ����mapper
public abstract class BaseManager {

	@Autowired
	protected UserMapper userMapper;

	@Autowired
	protected HouseMapper houseMapper;
	
	@Autowired
	protected HouseTypeMapper houseTypeMapper;
	
	@Autowired
	protected RegionMapper regionMapper;
}
