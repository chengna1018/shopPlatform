package com.penghai.shopplatform.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.penghai.shopplatform.service.UserManageService;

@Controller
public class UserManageController {
	@Autowired
	private UserManageService userManageService;
	
	//用户注册
	//验证用户名、密码、邮箱、手机
	
	//验证用户名
	/*@RequestMapping(value="/checkUsername")
	@ResponseBody
	public JSONObject checkUsername(HttpServletRequest request, HttpServletResponse response){
		String username=request.getParameter("username");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("username", username);
		JSONObject name=userManageService.getUsername(map);
		return name;
	}*/
	
	@RequestMapping("/")
	public ModelAndView tologin(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("register");
		return mv;
	}
	
	/**
	 * 用户注册
	 */
	@RequestMapping("/register")
	@ResponseBody
	public String register(HttpServletRequest request , HttpServletResponse response){
		//获取页面写入的用户名、密码、邮箱、电话
		String username=request.getParameter("username");
		String password=request.getParameter("pwd");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		System.out.println("^^^^^"+phone);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("username", username);
		map.put("pwd", password);
		map.put("email", email);
		map.put("phone", phone);
		System.out.println("####"+map);
		//获取后台传出参数
		JSONObject param=userManageService.register(map);
		System.out.println("&&&&&&&");
		return JSON.toJSONString(param);
	}
	
	
	@RequestMapping("/login")
	public ModelAndView success(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value="/success",method=RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("3333lll");//获取页面传来的用户名和密码
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("3333"+username);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("username", username);
		map.put("pwd", password);
		System.out.println("******"+map);
		//获取后台传出数据
		JSONObject param=userManageService.login(map);
		return JSON.toJSONString(param);
	}
	
	@RequestMapping("/shop")
	public ModelAndView startShop(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("success");
		return mv;
	}
	
}
