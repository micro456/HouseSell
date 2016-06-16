package com.micro.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.micro.base.BaseManager;
import com.micro.constant.HouseConstant;
import com.micro.constant.UserConstant;
import com.micro.entity.House;
import com.micro.entity.HouseExample;
import com.micro.entity.HouseType;
import com.micro.entity.HouseTypeExample;
import com.micro.entity.Region;
import com.micro.entity.RegionExample;
import com.micro.entity.User;
import com.micro.service.HouseManager;
import com.micro.utils.Result;
// this is service
@Service
public class HouseManagerImpl extends BaseManager implements HouseManager {
	
	public Result getOnSellHouseList(HouseExample houseExample) {
		
		/*Criteria criteria = houseExample.createCriteria();
		criteria.andStatusEqualTo(HouseConstant.ONSELL);
		if(typeId != null)
			criteria.andHouseTypeEqualTo(typeId);*/
		List<House> houseList = houseMapper.selectByExample(houseExample);
		Map<String, Object> houseInfoMap = new HashMap<String, Object>();
		if(houseList != null && houseList.size() > 0) {
			for(House house : houseList) {
				try {
					User user = userMapper.selectByPrimaryKey(house.getUserId());
					house.setUserName(user.getName());
					// 获取类型名字
					house.setType(houseTypeMapper.selectByPrimaryKey(house.getHouseType()).getTypeName());
					// 获取地区名字
					house.setRegion(regionMapper.selectByPrimaryKey(house.getHouseRegion()).getRegionName());
				} catch (Exception ex) {
					return new Result().setSuccess(false).setErrorMsg(ex.getMessage());
				}
			}
			houseInfoMap.put("onSellHouseList", houseList);
		}
		return new Result().setObject(houseInfoMap).setSuccess(true);
	}

	public Result getSoldHouseList() {
		HouseExample houseExample = new HouseExample();
		houseExample.or().andStatusEqualTo(HouseConstant.SOLD);
		List<House> houseList = houseMapper.selectByExample(houseExample);
		Map<String, Object> houseInfoMap = new HashMap<String, Object>();
		if(houseList != null && houseList.size() > 0) {
			List<User> buyerList = new ArrayList<User>();
			for(House house : houseList) {
				try {
					User user = userMapper.selectByPrimaryKey(house.getOwnUser());
					buyerList.add(user);
				} catch (Exception ex) {
					return new Result().setSuccess(false).setErrorMsg(ex.getMessage());
				}
			}
			houseInfoMap.put("soldHouseList", houseList);
			houseInfoMap.put("buyerList", buyerList);
		}
		return new Result().setObject(houseInfoMap).setSuccess(true);
	}

	public Result getReservedHouseList() {
		/*HouseExample houseExample = new HouseExample();
		houseExample.or().andStatusEqualTo(HouseConstant.RESERVE);
		return houseMapper.selectByExample(houseExample);*/
		return null;
	}

	public Result addOnSellHouse(House house) {
		try {
			houseMapper.insert(house);
		} catch (Exception ex) {
			return new Result().setErrorMsg("insert house error|message" + ex.getMessage()).setSuccess(false);
		}
		return new Result().setSuccess(true).setObject(house);
	}

	public Result deleteHouseById(Long houseId) {
		try {
			houseMapper.deleteByPrimaryKey(houseId);
		} catch (Exception ex) {
			return new Result().setErrorMsg("delete house error|message" + ex.getMessage()).setSuccess(false);
		}
		return new Result().setSuccess(true);
	}

	public Result buyHouseById(Long houseId, Long currentId) {
		Result result = new Result();
		try{
			House house = houseMapper.selectByPrimaryKey(houseId);
 			if(house == null) {
				result.setErrorMsg("该房屋不存在");
				result.setSuccess(false);
			} 
 			else if(house.getStatus() == HouseConstant.SOLD) {
 				result.setSuccess(false);
				result.setErrorMsg("该房屋已经销售");
 			}
 			else {
  				User user = userMapper.selectByPrimaryKey(currentId);
				if(user.getType().equals(UserConstant.BUYER) ||
						user.getType().equals(UserConstant.SELLERANDBUYER)) {
					if(user.getUserId().equals(house.getUserId())) {
						result.setSuccess(false);
						result.setErrorMsg("你不能购买自己出售的房子");
					} else {
						// 修改房屋所有人
						house.setOwnUser(currentId);
						// 修改房屋的状态
						house.setStatus(HouseConstant.SOLD);
						houseMapper.updateByPrimaryKeySelective(house);
						result.setSuccess(true);
					}
				} else {
					result.setSuccess(false);
					result.setErrorMsg("你没权限");
				}
				
			}
		} catch (Exception ex) {
			result.setSuccess(false).setErrorMsg("更新数据库异常|message:" + ex.getMessage());
		}
		return result;
	}

	public Result tradeInfo() {
		Result result = new Result();
		try {
			// 条件查询已经出售的房产
			HouseExample houseExample = new HouseExample();
			houseExample.or().andStatusEqualTo(HouseConstant.SOLD);
			List<House> houseList = houseMapper.selectByExample(houseExample);
			
			// 卖家列表
			List<User> sellerList = new ArrayList<User>();
			// 买家列表
			List<User> buyerList = new ArrayList<User>();
			for(House house : houseList) {
				/*UserExample userExample = new UserExample();
				com.micro.entity.UserExample.Criteria criteria = new UserExample().createCriteria();
				criteria.andUserIdEqualTo(house.getUserId());*/
				User seller = userMapper.selectByPrimaryKey(house.getUserId());
				User buyer = userMapper.selectByPrimaryKey(house.getOwnUser());
				sellerList.add(seller);
				buyerList.add(buyer);
			}
			Map<String, Object> tradeInfoMap = new HashMap<String, Object>();
			tradeInfoMap.put("sellerList", sellerList);
			tradeInfoMap.put("buyerList", buyerList);
			tradeInfoMap.put("houseList", houseList);
			result.setObject(tradeInfoMap);
			result.setSuccess(true);
		} catch (Exception ex) {
			result.setSuccess(false);
			result.setErrorMsg("操作异常");
		}
		return result;
	}

	public Result getAllHouseType() {
		Result result = new Result();
		try {
			List<HouseType> allHouseTypeList = houseTypeMapper.selectByExample(new HouseTypeExample());
			result.setSuccess(true);
			result.setObject(allHouseTypeList);
		} catch (Exception ex) {
			return result.setSuccess(false).setErrorMsg("get houseTypeList error | exception message : " + ex.getMessage());
		}
		return result;
	}

	public List<House> searchHouseList(HouseExample houseExample) {
		return houseMapper.selectByExample(houseExample);
	}

	public List<Region> getAllRegion() {
		return regionMapper.selectByExample(new RegionExample());
	}
	
}
