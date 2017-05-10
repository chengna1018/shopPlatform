package com.penghai.shopplatform.serviceImpl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.penghai.shopplatform.restEasyClient.CommonInterface.commonInterface;
import com.penghai.shopplatform.restEasyClient.RESTEasyClientPost;
import com.penghai.shopplatform.service.UserManageService;
@Service
public class UserManageServiceImpl implements UserManageService{

	//获取用户名,注册验证用户名使用
	/*public JSONObject getUsername(Map<String, Object> map) {
		JSONObject username = RESTEasyClientPost.requestWithClient(map, "");
		return username;
	}*/
	//获取用户名邮箱
	/*public JSONObject getEmail(Map<String, Object> map){
		JSONObject email=RESTEasyClientPost.requestWithClient(map, " ");
		return email;
	}*/
	/**
	 * 用户注册
	 */
	public JSONObject register(Map<String, Object> map) {
		JSONObject result = RESTEasyClientPost.requestWithClient(map, commonInterface.URL1);
		return result;
	}
	/**
	 * 用户登录
	 */
	public JSONObject login(Map<String, Object> map) {
		JSONObject result=RESTEasyClientPost.requestWithClient(map, commonInterface.URL2);
		return result;
	}
	/**
	 * 用户更改密码
	 */
	public JSONObject changePassword(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 用户更改信息
	 */
	public JSONObject changeMessage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
