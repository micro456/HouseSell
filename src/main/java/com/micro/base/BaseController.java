package com.micro.base;

import java.util.HashMap;
import java.util.Map;











import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.micro.entity.User;
import com.micro.service.HouseManager;
import com.micro.service.UserManager;
import com.micro.utils.Result;

// 在这里修改了
public abstract class BaseController {
	
	@Autowired
	protected UserManager userManager;
	
	@Autowired
	protected HouseManager houseManager;
	
	// 将result转换成json ajax请求
	protected String parseResultToJson(Result result) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean isSuccess = result.isSuccess();
		resultMap.put("isSuccess", isSuccess);
		if(!result.isSuccess()) {
			resultMap.put("errorMsg", result.getErrorMsg());
		}
		JSONObject json = JSONObject.fromObject(resultMap);
		return json.toString();
	}
	
	// 判断session
	protected String validateSessionReturnString(HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		if(user == null)
			return "redirect:login.ftl";
		return null;
	}
	
	protected ModelAndView validateSessionReturnModelAndView(HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		if(user == null)
			return new ModelAndView("redirect:login.ftl");
		return null;
	}
}
