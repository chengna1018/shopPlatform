package com.penghai.shopplatform.restEasyClient;

import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class RESTEasyClientPost {
	public String requestWithClient(){
		String result="";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url);
		try{
			Response response = target.request().post(Entity.entity(JSON.toJSONString(map), mediaType));
			if(response.getStatus()!=200){
				throw new RuntimeException("Failed with HTTP error code: " +response.getStatus());
			}
			result=response.readEntity(String.class);
			JSONObject jsonObject=JSONObject.parseObject(result);
			response.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
