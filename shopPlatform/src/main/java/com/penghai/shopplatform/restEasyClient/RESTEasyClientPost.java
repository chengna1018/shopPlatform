package com.penghai.shopplatform.restEasyClient;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class RESTEasyClientPost {
	@SuppressWarnings("finally")
	public  static JSONObject requestWithClient(Map<String, Object> map,String url){
		
		String result="";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url);
		JSONObject jsonObject=new JSONObject();
		try{
			Response response = target.request().post(Entity.entity(JSON.toJSONString(map), MediaType.APPLICATION_JSON_TYPE));
			System.out.println("client"+JSON.toJSONString(map));
			if(response.getStatus()!=200){
				throw new RuntimeException("Failed with HTTP error code: " +response.getStatus());
			}
			result=response.readEntity(String.class);
			jsonObject=JSONObject.parseObject(result);
			
			response.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{

			return jsonObject;
		}
		
	}
	
}
