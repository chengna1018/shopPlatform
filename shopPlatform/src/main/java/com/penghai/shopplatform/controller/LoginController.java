package com.penghai.shopplatform.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.penghai.shopplatform.service.LoginService;
import com.penghai.shopplatform.serviceImpl.LoginServiceImpl;

import net.sf.json.JSONObject;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/")
	public ModelAndView login(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping("/checkUsername")
	@ResponseBody
	public JSONObject checkUsername(HttpServletRequest request, HttpServletResponse response){
		String username=request.getParameter("username");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("username", username);
		JSONObject name = JSONObject.fromObject(map);
		
		return name;
		
		
		
	}
	
	@RequestMapping("/checkPassword")
	@ResponseBody
	public JSONObject checkPassword(HttpServletRequest request, HttpServletResponse response){
		String pwd=request.getParameter("password");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("password", pwd);
		JSONObject password = JSONObject.fromObject(map);
		
		return password;
		
	}
	
	@RequestMapping("/success")
	public ModelAndView loginSuccess(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("success");
		return mv;
	}
}
