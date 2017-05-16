package com.penghai.shopplatform.serviceImpl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.penghai.shopplatform.restEasyClient.CommonInterface.commonInterface;
import com.penghai.shopplatform.restEasyClient.RESTEasyClientPost;
import com.penghai.shopplatform.service.UserManageService;
@Service
public class UserManageServiceImpl implements UserManageService{

	//��ȡ�û���,ע����֤�û���ʹ��
	/*public JSONObject getUsername(Map<String, Object> map) {
		JSONObject username = RESTEasyClientPost.requestWithClient(map, "");
		return username;
	}*/
	//��ȡ�û�������
	/*public JSONObject getEmail(Map<String, Object> map){
		JSONObject email=RESTEasyClientPost.requestWithClient(map, " ");
		return email;
	}*/
	/**
	 * �û�ע��
	 */
	public JSONObject register(Map<String, Object> map) {
		JSONObject result = RESTEasyClientPost.requestWithClient(map, commonInterface.URL1);
		return result;
	}
	/**
	 * �û���¼
	 */
	public JSONObject login(Map<String, Object> map) {
		JSONObject result=RESTEasyClientPost.requestWithClient(map, commonInterface.URL2);
		return result;
	}
	/**
	 * �û���������
	 */
	public JSONObject changePassword(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * �û�������Ϣ
	 */
	public JSONObject changeMessage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
	//���û���ѯ��Ʒ
	public JSONObject getSearchMessage(Map<String, Object> map) {
		JSONObject result=RESTEasyClientPost.requestWithClient(map, commonInterface.URL3);
		return result;
	}
	//��Ʒ��ҳ
	public JSONObject fenYenPage(Map<String, Object> map) {
		JSONObject result=RESTEasyClientPost.requestWithClient(map, commonInterface.URL3);
		return null;
	}
}
