package com.penghai.shopplatform.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	
	//�û�ע��
	//��֤�û��������롢���䡢�ֻ�
	
	//��֤�û���
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
	 * �û�ע��
	 */
	@RequestMapping("/register")
	@ResponseBody
	public String register(HttpServletRequest request , HttpServletResponse response){
		//��ȡҳ��д����û��������롢���䡢�绰
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
		//��ȡ��̨����
		JSONObject param=userManageService.register(map);
		System.out.println("&&&&&&&");
		return JSON.toJSONString(param);
	}
	
	//��ת����¼����
	@RequestMapping("/login")
	public ModelAndView success(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	//��¼��Ϣ����󣬵����¼��ť��������ת����Ʒ�Ľ���
	@RequestMapping(value="/success",method=RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("3333lll");//��ȡҳ�洫�����û���������
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("3333"+username);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("username", username);
		map.put("pwd", password);
		System.out.println("******"+map);
		//��ȡ��̨��������
		JSONObject param=userManageService.login(map);
		return JSON.toJSONString(param);
	}
	
	//��Ʒ����
	@RequestMapping("/shop")
	public ModelAndView startShop(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("success");
		
		return mv;
	}
	
	//��ȡ�û������������Ϣ����ѯ������Ʒ
	@RequestMapping("/goshop")
	@ResponseBody
	public String shop(HttpServletRequest request, HttpServletResponse response){
		//���ǰ��ҳ����������������
		String searchContent=request.getParameter("searchContent");	
		String page=request.getParameter("page");
		System.out.println("�����������ݣ�"+searchContent);	
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("productname", searchContent);
		map.put("page", page);
		//��ȡ��̨���صĲ�ѯ���
		JSONObject param=userManageService.getSearchMessage(map);
		
		System.out.println("ҳ���е�������Ʒ��"+param);
		return JSON.toJSONString(param);
		
		
		/*//��ȡ��ѯ����������Ʒ
		String product=request.getParameter("productname");
		List<Product> products=fenYePageService.allProduct(product);
		JSONArray arrayProduct=new JSONArray();*/
		//��ʼҳ��ʾ20����Ʒ
//		for(int i=0;i<20;i++){
//			JSONObject objectProduct=new JSONObject();
//			objectProduct.put("id", param.id);
//			objectProduct.put("category", p.getCategory());
//			objectProduct.put("productname", p.getProductname());
//			objectProduct.put("price", p.getPrice());
//			objectProduct.put("shop", p.getShop());
//			objectProduct.put("evaluate", p.getEvaluate());
//			objectProduct.put("picture", p.getPicture());
//			arrayProduct.add(objectProduct);
//		}
//		System.out.println("666666"+arrayProduct);
		//����Ʒ��ռ��ҳ��
		//int num=(int)Math.ceil(products.size()/20);
		//����Ҫ���С�յ���Ʒ�б�productList����ǰҳPage�����Ҹ�����Ʒ�������м�ҳ����������㻹��С���㣩
		//��ʱ�ģ����������ݴ��������У�������һҳ
		//request.setAttribute("productList",arrayProduct);
		//request.setAttribute("page", o);
		//request.setAttribute("pageNum", num);
		//request.setAttribute("products", products);
		//return JSON.toJSONString(param);
		//return "success";
	}
	
	/**
	 * ��Ʒ��ҳ��ajax����
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/goshop/page")
	@ResponseBody
	public String selectDataByPage(HttpServletRequest request, HttpServletResponse response){
		//��ȡҳ���ѯ�����ݣ�������̨
		String page= request.getParameter("page");
		String searchContent=request.getParameter("searchContent");
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("page",page);
		map.put("productname", searchContent);
		//��̨���ݲ�ѯ�����ݣ����ظ�������ռ��ҳ����������
		JSONObject param=userManageService.fenYenPage(map);		
		System.out.println("��ҳ�е���Ʒ��"+param);
		return JSON.toJSONString(param);
		/*Map<String, Object> result=new HashMap<String, Object>();
		String productname=request.getParameter("productname");
		String page=request.getParameter("page");
		Integer pageint=Integer.parseInt(page);
		Integer start = (pageint-1)*8;
		List<Product> products=fenYePageService.fenYeProduct(productname, page);
		JSONArray jsonArray = new JSONArray();
		for(Product p:products){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", p.getId());
			jsonObject.put("category", p.getCategory());
			jsonObject.put("productname", p.getProductname());
			jsonObject.put("price", p.getPrice());
			jsonObject.put("shop", p.getShop());
			jsonObject.put("evaluate", p.getEvaluate());
			jsonObject.put("picture", p.getPicture());
			jsonArray.add(jsonObject);
		}
		//���淵�ص�data�ؼ�������
		List<Product> pxList=new ArrayList<Product>();
		pxList=JSONArray.parseArray(JSON.toJSONString(jsonArray), Product.class);
		result.put("result", pxList);
		//���ؽ�����
		return result;*/
	}
	
}
