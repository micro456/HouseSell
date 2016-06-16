package com.micro.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.micro.base.BaseController;
import com.micro.constant.HouseConstant;
import com.micro.constant.UserConstant;
import com.micro.entity.House;
import com.micro.entity.HouseExample;
import com.micro.entity.HouseExample.Criteria;
import com.micro.entity.HouseType;
import com.micro.entity.Region;
import com.micro.entity.User;
import com.micro.utils.Result;

@Controller
public class HouseController extends BaseController {

	// 增加待售的房子
	public ModelAndView addHouse(HttpServletRequest request) {
		// TODO 确认页面需要填写的字段

		User user = new User();
		// 房屋所有人
		user.setName(request.getParameter("name"));
		// 类型为0
		user.setType(UserConstant.BUYER);
		// 电话
		user.setTelephone(request.getParameter("telephone"));
		// 邮箱
		user.setEmail(request.getParameter("email"));
		/*
		 * // 公司 user.setCompany(company);
		 */
		// 创建时间
		user.setCreateTime(new Date());
		// 系统密码设置
		user.setPassword(request.getParameter("password"));

		Result result = userManager.registerUser(user);
		// 获取插入的结果
		user = (User) result.getObject();

		// 添加房产信息
		House house = new House();
		// 与用户之间的关系
		house.setUserId(user.getUserId());
		// 房产名字
		house.setHouseName(request.getParameter("houseName"));
		// 房产地址
		house.setHouseAddress(request.getParameter("houseAddress"));
		// 房产价格
		house.setHousePrice(Long.valueOf(request.getParameter("housePrice")));
		// 房产面积
		house.setHouseArea(Integer.valueOf(request.getParameter("houseArea")));
		/*
		 * // 没有被卖 house.setIsSold(HouseConstant.ONSELL);
		 */
		// 所有人
		house.setOwnUser(user.getUserId());
		// 状态
		house.setStatus(HouseConstant.ONSELL);

		// Result ret = houseManager.addOnSellHouse(house);

		ModelAndView mav = new ModelAndView();
		return mav;
	}

	// 出售房产信息
	@RequestMapping("/sellHouse.do")
	@ResponseBody
	public String saveHouse(HttpSession session, HttpServletRequest request) {
		House house = new House();
		house.setHouseName(request.getParameter("houseName"));
		house.setHouseAddress(request.getParameter("houseAddress"));
		house.setHousePrice(Long.valueOf(request.getParameter("housePrice")));
		house.setHouseArea(Integer.valueOf(request.getParameter("houseArea")));
		house.setHouseType(Long.valueOf(request.getParameter("houseType")));
		house.setHouseRegion(Long.valueOf(request.getParameter("houseRegion")));
		// 获取当前用户
		User user = (User) request.getSession().getAttribute("currentUser");
		Result result = null;
		if (validateSessionReturnString(session) != null) {
			return validateSessionReturnString(session);
		} else {
			Integer type = user.getType();
			if (!UserConstant.SELLER.equals(type)
					&& !UserConstant.SELLERANDBUYER.equals(type)) {
				result = new Result();
				result.setSuccess(false).setErrorMsg("你没有出售权限");
				return parseResultToJson(result);
			}
		}
		house.setUserId(user.getUserId());
		house.setOwnUser(user.getUserId());
		// 确定待售
		house.setStatus(HouseConstant.ONSELL);
		// 创建时间
		house.setCreateTime(new Date());
		result = houseManager.addOnSellHouse(house);

		// ModelAndView mav = new ModelAndView("onSell");
		return parseResultToJson(result);
	}

	@RequestMapping("/onSell.do")
	public ModelAndView onSell(HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("onSell");
		Long typeId = null;
		if (StringUtils.isNotBlank(request.getParameter("typeId")))
			typeId = Long.valueOf(request.getParameter("typeId"));
		// User currentUser = (User)session.getAttribute("currentUser");
		// if(currentUser != null)
		// mav.addObject("username", currentUser.getName());
		
		HouseExample houseExample = new HouseExample();
		
		Criteria criteria = houseExample.createCriteria();
		
		if(StringUtils.isNotBlank(request.getParameter("typeId")))
			criteria.andHouseTypeEqualTo(Long.valueOf(request.getParameter("typeId")));
		
		if(StringUtils.isNotBlank(request.getParameter("lowPrice")))
			criteria.andHousePriceGreaterThan(Long.valueOf(request.getParameter("lowPrice")));
		
		if(StringUtils.isNotBlank(request.getParameter("highPrice")))
			criteria.andHousePriceLessThan(Long.valueOf(request.getParameter("highPrice")));
		
		if(StringUtils.isNotBlank(request.getParameter("regionId")))
			criteria.andHouseRegionEqualTo(Long.valueOf(request.getParameter("regionId")));
		
		Result result = houseManager.getOnSellHouseList(houseExample);
		
		// 最低价格和最高价格的组装
		if(StringUtils.isNotBlank(request.getParameter("lowPrice"))) {
			
		}
		if (result.getObject() != null) {
			@SuppressWarnings("unchecked")
			Map<String, Object> resultMap = (Map<String, Object>) result
					.getObject();
			// map里存放了所有人的list和房屋的list
			mav.addObject("onSellHouseList", resultMap.get("onSellHouseList"));
			// mav.addObject("sellerList", resultMap.get("sellerList"));
			mav.addObject("allHouseTypeList", houseManager.getAllHouseType()
					.getObject());
			mav.addObject("allRegionList", houseManager.getAllRegion());
		}
		return mav;

	}

	@RequestMapping("/sold.do")
	public ModelAndView sold(HttpSession session) {
		if (validateSessionReturnModelAndView(session) != null)
			return validateSessionReturnModelAndView(session);
		ModelAndView mav = new ModelAndView("sold");
		// User currentUser = (User)session.getAttribute("currentUser");
		// if(currentUser != null)
		// mav.addObject("username", currentUser.getName());
		Result result = houseManager.getSoldHouseList();
		if (result.getObject() != null) {
			@SuppressWarnings("unchecked")
			Map<String, Object> resultMap = (Map<String, Object>) result
					.getObject();
			// map里存放了所有人的list和房屋的list
			mav.addObject("soldHouseList", resultMap.get("soldHouseList"));
			mav.addObject("buyerList", resultMap.get("buyerList"));
		}
		return mav;
	}

	/*
	 * @RequestMapping("/seller.do") public String seller() { return "seller"; }
	 */

	/*
	 * @RequestMapping("/buyer.do") public String buyer() { return "buyer"; }
	 */

	@RequestMapping("/sell.do")
	public ModelAndView sell(HttpSession session) {
		if (validateSessionReturnModelAndView(session) != null)
			return validateSessionReturnModelAndView(session);
		ModelAndView mav = new ModelAndView();
		// 获取类型
		Result result = houseManager.getAllHouseType();
		mav.addObject("allHouseTypeList", result.getObject());
		mav.addObject("allRegionList", houseManager.getAllRegion());
		mav.setViewName("sell");
		return mav;
	}

	@RequestMapping("/buy.do")
	public ModelAndView buy(HttpSession session) {
		if (validateSessionReturnModelAndView(session) != null)
			return validateSessionReturnModelAndView(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("buy");
		return mav;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/test.do")
	public void test() {
		// 伪造数据
		List<User> userList = userManager.getAllSeller();

		// 把可能的地址填进去
		/*
		 * System.out.println("输入房产地址,#结束"); Scanner sc = new
		 * Scanner(System.in); Set<String> addressSet = new HashSet<String>();
		 * while(true) { String address = sc.next(); if(address.equals("#")) {
		 * break; } else addressSet.add(address); }
		 */

		// 第二种方式
		Set<String> addressSet = new HashSet<String>();
		addressSet.add("文化路");
		addressSet.add("李纸路");
		addressSet.add("中南路");
		addressSet.add("光谷");
		addressSet.add("南湖");
		addressSet.add("东湖");
		addressSet.add("湖北工业大学");
		addressSet.add("草莓园");
		addressSet.add("创业园");

		/*
		 * System.out.println("输入房产名字,#结束"); // 房屋名字 Set<String> nameSet = new
		 * HashSet<String>(); while(true) { String name = sc.next();
		 * if(name.equals("#")) { sc.close(); break; } else nameSet.add(name); }
		 */

		// 第二种方式
		Set<String> nameSet = new HashSet<String>();
		nameSet.add("别墅房");
		nameSet.add("电梯公寓");
		nameSet.add("学区房");
		nameSet.add("住宅小区");
		nameSet.add("写字楼");
		nameSet.add("创业园");
		nameSet.add("教学楼");

		// 创建人Id
		Set<Long> userIdSet = new HashSet<Long>();
		for (User user : userList) {
			userIdSet.add(user.getUserId());
		}

		Random random = new Random();
		// 随机生成价格面积
		for (int i = 0; i < 20; i++) {
			House house = new House();
			house.setCreateTime(new Date());
			// 地址
			int randomIndex = random.nextInt(addressSet.size());
			int index1 = 0;
			for (String a : addressSet) {
				if (index1 == randomIndex) {
					house.setHouseAddress(a);
					break;
				}
				index1++;
			}
			// 所有人
			int randomIndex2 = random.nextInt(userIdSet.size());
			int index2 = 0;
			for (Long userId : userIdSet) {
				if (index2 == randomIndex2) {
					house.setUserId(userId);
					// 创建时候房屋创建人和所有人为一个人
					house.setOwnUser(userId);
					break;
				}
				index2++;
			}
			// 名字
			int randomIndex3 = random.nextInt(nameSet.size());
			int index3 = 0;
			for (String name : nameSet) {
				if (index3 == randomIndex3) {
					house.setHouseName(name);
					break;
				}
				index3++;
			}
			// 面积
			house.setHouseArea(random.nextInt(200) + 100);
			// 价格
			house.setHousePrice(Long.valueOf(random.nextInt(100) + 100));
			// 状态是在销售状态
			house.setStatus(0);

			// 随机插入房产类型
			List<HouseType> allHouseTypeList = (List<HouseType>) houseManager
					.getAllHouseType().getObject();
			int randomIndex4 = random.nextInt(allHouseTypeList.size());
			int index4 = 0;
			for (HouseType houseType : allHouseTypeList) {
				if (randomIndex4 == index4) {
					house.setHouseType(houseType.getId());
					break;
				}
				index4++;
			}
			
			// 随机插入房产地区
			List<Region> allRegionList = houseManager.getAllRegion();
			int randomIndex5 = random.nextInt(allRegionList.size());
			int index5 = 0;
			for(Region region : allRegionList) {
				if(index5 == randomIndex5) {
					house.setHouseRegion(region.getId());
					break;
				} else 
					index5 ++;
			}
			
			houseManager.addOnSellHouse(house);

		}

		System.out.println("插入结束");

	}

	// 删除房屋 ajax请求
	@RequestMapping("deleteHouse.do")
	@ResponseBody
	public String deleteHouse(@RequestParam("houseId") Long houseId,
			HttpSession session) {
		if (validateSessionReturnString(session) != null)
			return validateSessionReturnString(session);
		Result result = houseManager.deleteHouseById(houseId);
		// 转换成json
		return parseResultToJson(result);
	}

	// 购买房屋ajax请求
	@RequestMapping("buyHouse.do")
	@ResponseBody
	public String buyHouse(@RequestParam("houseId") Long houseId,
			HttpSession session) {
		if (validateSessionReturnString(session) != null)
			return validateSessionReturnString(session);
		User user = (User) session.getAttribute("currentUser");
		Result result = new Result();
		if (user == null) {
			result.setSuccess(false);
			result.setErrorMsg("当前用户已经失效，请重新登陆");
		} else {
			result = houseManager.buyHouseById(houseId, user.getUserId());
		}
		return parseResultToJson(result);
	}

	// 交易信息
	@RequestMapping("tradeInfo.do")
	public ModelAndView tradeInfo(HttpSession session) {
		if (validateSessionReturnModelAndView(session) != null)
			return validateSessionReturnModelAndView(session);
		User user = (User) session.getAttribute("currentUser");
		ModelAndView mav = new ModelAndView();
		if (user != null) {
			Result tradeInfoResult = houseManager.tradeInfo();
			if (tradeInfoResult.isSuccess()) {
				try {
					@SuppressWarnings("unchecked")
					Map<String, Object> reslutMap = (Map<String, Object>) tradeInfoResult
							.getObject();
					mav.addObject("houseList", reslutMap.get("houseList"));
					mav.addObject("sellerList", reslutMap.get("sellerList"));
					mav.addObject("buyerList", reslutMap.get("buyerList"));
					mav.setViewName("tradeInfo");
				} catch (Exception ex) {
					mav.setViewName("error");
					mav.addObject("errorMsg", "map异常");
				}

			} else {
				mav.setViewName("error");
				mav.addObject("errorMsg", tradeInfoResult.getErrorMsg());
			}
		} else {
			mav.setViewName("error");
			mav.addObject("errorMsg", "当前用户已失效，请重新登陆");
		}
		return mav;
	}

	@RequestMapping("sellHouseValidate.do")
	@ResponseBody
	public String sellHouseValid(HttpServletRequest request) {
		String houseName = request.getParameter("houseName");
		String houseAddress = request.getParameter("houseAddress");
		String houseArea = request.getParameter("houseArea");
		String housePrice = request.getParameter("housePrice");
		String houseType = request.getParameter("houseType");
		String houseRegion = request.getParameter("houseRegion");

		Result result = new Result();
		StringBuffer errorMsg = new StringBuffer();
		if (!StringUtils.isNotBlank(houseName))
			errorMsg.append("房产名字不能为空,");
		if (!StringUtils.isNotBlank(houseAddress))
			errorMsg.append("房产地址不能为空,");
		// 面积验证
		if (StringUtils.isNotBlank(houseArea)) {
			try {
				Long.valueOf(houseArea);
			} catch (Exception ex) {
				errorMsg.append("房产面积请输入数字,");
			}
		} else
			errorMsg.append("房产面积不能为空,");
		// 价格验证
		if (StringUtils.isNotBlank(housePrice)) {
			try {
				Long.valueOf(housePrice);
			} catch (Exception ex) {
				errorMsg.append("房产价格请输入数字,");
			}
		} else
			errorMsg.append("房产价格不能为空,");
		// 类型
		if (!StringUtils.isNotBlank(houseType)) {
			errorMsg.append("类型不能为空 ");
		}
		
		// 地区
		if (!StringUtils.isNotBlank(houseRegion)) {
			errorMsg.append("房产区域不能为空");
		}
		if (errorMsg.toString().equals(""))
			return parseResultToJson(result.setSuccess(true));
		else {
			return parseResultToJson(result.setSuccess(false).setErrorMsg(
					errorMsg.substring(0, errorMsg.length() - 1).toString()
							+ "."));
		}
	}

}
