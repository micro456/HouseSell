package com.micro.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.base.BaseManager;
import com.micro.constant.UserConstant;
import com.micro.entity.User;
import com.micro.entity.UserExample;
import com.micro.entity.UserExample.Criteria;
import com.micro.service.UserManager;
import com.micro.utils.Result;

@Service
public class UserManagerImpl extends BaseManager implements UserManager {

	@SuppressWarnings("null")
	public Result auticationUser(String password, String userName) {
		// 组装查询条件
		UserExample userExample = new UserExample();

		Criteria criteria = userExample.createCriteria();
		if (userName != null && !userName.trim().equals(""))
			criteria.andNameEqualTo(userName);
		if (password != null && !password.trim().equals(""))
			criteria.andPasswordEqualTo(password);

		List<User> userList = userMapper.selectByExample(userExample);
		if (userList != null && userList.size() != 0) {
			Result result = new Result().setSuccess(true);
			result.setObject(userList.get(0));
			return result;
		}
		else
			return new Result().setErrorMsg("不存在用户").setSuccess(false);
	}

	public Result registerUser(User user) {
		// 查询注册的用户是否存在
		UserExample userExample = new UserExample();
		userExample.or().andNameEqualTo(user.getName());

		List<User> userList = userMapper.selectByExample(userExample);
		if (userList != null && userList.size() != 0)
			return new Result().setErrorMsg("该用户存在").setSuccess(false);
		else {
			try {
				userMapper.insert(user);
			} catch (Exception ex) {
				return new Result().setSuccess(true).setErrorMsg(
						"注册失败|请联系开发者");
			}
		}
		return new Result().setSuccess(true).setObject(user);
	}

	public List<User> getAllUser() {
		UserExample userExample = new UserExample();
		return userMapper.selectByExample(userExample);
	}

	public List<User> getAllBuyer() {
		UserExample userExample = new UserExample();
		List<Integer> typeList = new ArrayList<Integer>();
		typeList.add(UserConstant.BUYER);
		typeList.add(UserConstant.SELLERANDBUYER);
		userExample.or().andTypeIn(typeList);
		return userMapper.selectByExample(userExample);
	}

	public List<User> getAllSeller() {
		UserExample userExample = new UserExample();
		List<Integer> typeList = new ArrayList<Integer>();
		typeList.add(UserConstant.SELLER);
		typeList.add(UserConstant.SELLERANDBUYER);
		userExample.or().andTypeIn(typeList);
		return userMapper.selectByExample(userExample);
	}
}
