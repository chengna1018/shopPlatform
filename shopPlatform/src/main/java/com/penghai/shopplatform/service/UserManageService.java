package com.penghai.shopplatform.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface UserManageService {
	/**
	 * ע��
	 * @param map
	 * @return
	 */
	//��ȡҳ���ϵ��û���
	//public JSONObject getUsername(Map<String, Object> map);
	//��ȡҳ���ϵ�����
	//public JSONObject getEmail(Map<String, Object> map);
	public JSONObject register(Map<String, Object> map);
	/**
	 * �û���¼
	 * @param map
	 * @return
	 */
	public JSONObject login(Map<String, Object> map);
	/**
	 * �û���������
	 * @param map
	 * @return
	 */
	public JSONObject changePassword(Map<String, Object> map);
	/**
	 * �����û���Ϣ
	 * @param map
	 * @return
	 */
	public JSONObject changeMessage(Map<String, Object> map);
}
