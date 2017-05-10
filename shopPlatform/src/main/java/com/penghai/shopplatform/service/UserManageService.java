package com.penghai.shopplatform.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface UserManageService {
	/**
	 * 注册
	 * @param map
	 * @return
	 */
	//获取页面上的用户名
	//public JSONObject getUsername(Map<String, Object> map);
	//获取页面上的邮箱
	//public JSONObject getEmail(Map<String, Object> map);
	public JSONObject register(Map<String, Object> map);
	/**
	 * 用户登录
	 * @param map
	 * @return
	 */
	public JSONObject login(Map<String, Object> map);
	/**
	 * 用户更改密码
	 * @param map
	 * @return
	 */
	public JSONObject changePassword(Map<String, Object> map);
	/**
	 * 更改用户信息
	 * @param map
	 * @return
	 */
	public JSONObject changeMessage(Map<String, Object> map);
}
