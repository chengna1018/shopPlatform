package com.penghai.shopplatform.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.penghai.shopplatform.service.LoginService;

import net.sf.json.JSONObject;

@Controller
public class RegisterController {

	@Autowired
	private LoginService loginService;
	
//	@RequestMapping("/")
//	public ModelAndView register(){
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("register");
//		return mv;
//	}
	
	@RequestMapping("/checkUsername")
	@ResponseBody
	public JSONObject checkUsername(HttpServletRequest request,HttpServletResponse response){
		String username=request.getParameter("username");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("username", username);
		JSONObject name=JSONObject.fromObject(map);
		return name;
	}
	
	@RequestMapping("/checkEmail")
	@ResponseBody
	public JSONObject checkEmail(HttpServletRequest request,HttpServletResponse response){
		String myemail=request.getParameter("email");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("email", myemail);
		JSONObject email=JSONObject.fromObject(map);
		return email;
	}
}
