package com.micro.controller;



import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.micro.base.BaseController;
import com.micro.constant.ModelViewResult;
import com.micro.constant.UserConstant;
import com.micro.entity.User;
import com.micro.utils.Result;

@Controller
public class UserController extends BaseController{
	

	/*// 验证当前用户
	@ModelAttribute
	public String validateSesssion(HttpSession session){
		User user = (User) session.getAttribute("currentUser");
		if(user == null)
			return "redirect:/login.ftl";
		else
			return null;
	}*/
	
	
	// 登陆页面
	@RequestMapping("/welcome.do")
	public String welcome(){
		return "redirect:/login.ftl";
	}
	
	// ajax验证登陆
	@RequestMapping("/ajaxLogin.do")
	@ResponseBody
	public String ajaxLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
		Result result = new Result();
		if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
			Result auticationResult = userManager.auticationUser(password, username);
			if(auticationResult.isSuccess()) {
				result.setSuccess(true);
			} else {
				result.setErrorMsg(auticationResult.getErrorMsg());
				result.setSuccess(false);
			}
		} else {
			// 这里页面已经验证，可省略
			result.setSuccess(false).setErrorMsg("用户名或则密码不能为空");
		}
		return parseResultToJson(result);
	}
	
	// 返回主页
	@RequestMapping("home.do")
	public ModelAndView home(HttpSession session) {
		if(validateSessionReturnModelAndView(session) != null)
			return validateSessionReturnModelAndView(session);
		ModelAndView mav = new ModelAndView("home");
		List<User> userList = userManager.getAllUser();
		mav.addObject("userList", userList);
		return mav;
	}
	
	// 登陆验证
	@SuppressWarnings("deprecation")
	@RequestMapping("/login.do")
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if(StringUtils.isNotBlank(username) || StringUtils.isNotBlank(password)) {
			// 验证是否存在该用户不存在就添加
			Result result = userManager.auticationUser(password, username);
			if(result.isSuccess()) {
				mav.setViewName("home");
				// 保存全局变量当前用户
				session.setAttribute("currentUser", result.getObject());
				session.setAttribute("username", ((User) result.getObject()).getName());
				session.setAttribute("currentUser", result.getObject());
				// 获取用户列表
				List<User> userList = userManager.getAllUser();
				if(userList != null && userList.size() > 0)
					mav.addObject("userList", userList);
				return mav;
			} else
				mav.addObject("errorMsg", "用户验证失败");
		} else
			mav.addObject("errorMsg", "用户名或则密码为空");
		mav.setViewName("error");
		return mav;
	}
	
	// 注册用户
	@RequestMapping("/register.do")
	public ModelAndView register(HttpServletRequest request) {
		String username = request.getParameter("register_username");
		String password = request.getParameter("register_password");
		String Email = request.getParameter("register_email");
		String telephone = request.getParameter("register_telephone");
		Integer type = null;
		if(StringUtils.isNotBlank(request.getParameter("type")))
			type = Integer.valueOf(request.getParameter("type"));
		else
			type = UserConstant.SELLERANDBUYER;
		
		User user = new User();
		user.setName(username);
		user.setPassword(password);
		user.setEmail(Email);
		user.setTelephone(telephone);
		user.setType(type);
		
		// 创建时间
		user.setCreateTime(new Date());
		
		Result result = userManager.registerUser(user);
		ModelAndView mav = new ModelAndView("redirect:welcome.do");
		if(result.isSuccess()) {
			mav.addObject("msg", "注册成功");
		} else {
			mav.setViewName(ModelViewResult.ERROR);
			mav.addObject("errorMsg", result.getErrorMsg());
		}
		return mav;
	}
	
	// 卖家
	@RequestMapping("/seller.do")
	public ModelAndView seller(HttpSession session) {
		if(validateSessionReturnModelAndView(session) != null)
			return validateSessionReturnModelAndView(session);
		ModelAndView mav = new ModelAndView("seller");
		List<User> sellerList = userManager.getAllSeller();
		mav.addObject("sellerList", sellerList);
		return mav;
	}
	
	// 买家
	@RequestMapping("/buyer.do")
	public ModelAndView buyer(HttpSession session) {
		if(validateSessionReturnModelAndView(session) != null)
			return validateSessionReturnModelAndView(session);
		ModelAndView mav = new ModelAndView("buyer");
		List<User> buyerList = userManager.getAllBuyer();
		mav.addObject("buyerList", buyerList);
		return mav;
	}
	
}
