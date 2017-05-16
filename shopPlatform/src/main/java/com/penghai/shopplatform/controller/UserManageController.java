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
		//获取后台数据
		JSONObject param=userManageService.register(map);
		System.out.println("&&&&&&&");
		return JSON.toJSONString(param);
	}
	
	//跳转到登录界面
	@RequestMapping("/login")
	public ModelAndView success(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	//登录信息填完后，点击登录按钮，即将跳转到商品的界面
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
	
	//商品界面
	@RequestMapping("/shop")
	public ModelAndView startShop(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("success");
		
		return mv;
	}
	
	//获取用户输入的搜索信息，查询所有商品
	@RequestMapping("/goshop")
	@ResponseBody
	public String shop(HttpServletRequest request, HttpServletResponse response){
		//获得前端页面的输入的搜索内容
		String searchContent=request.getParameter("searchContent");	
		String page=request.getParameter("page");
		System.out.println("搜索框中内容："+searchContent);	
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("productname", searchContent);
		map.put("page", page);
		//获取后台返回的查询结果
		JSONObject param=userManageService.getSearchMessage(map);
		
		System.out.println("页面中的所有商品："+param);
		return JSON.toJSONString(param);
		
		
		/*//获取查询出的所有商品
		String product=request.getParameter("productname");
		List<Product> products=fenYePageService.allProduct(product);
		JSONArray arrayProduct=new JSONArray();*/
		//起始页显示20个商品
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
		//求商品所占的页数
		//int num=(int)Math.ceil(products.size()/20);
		//这里要获得小苏的商品列表productList，当前页Page，并且根据商品数计算有几页（这个是我算还是小苏算）
		//临时的，把所得数据带入请求中，传入下一页
		//request.setAttribute("productList",arrayProduct);
		//request.setAttribute("page", o);
		//request.setAttribute("pageNum", num);
		//request.setAttribute("products", products);
		//return JSON.toJSONString(param);
		//return "success";
	}
	
	/**
	 * 商品分页，ajax请求
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/goshop/page")
	@ResponseBody
	public String selectDataByPage(HttpServletRequest request, HttpServletResponse response){
		//获取页面查询的内容，传给后台
		String page= request.getParameter("page");
		String searchContent=request.getParameter("searchContent");
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("page",page);
		map.put("productname", searchContent);
		//后台根据查询的内容，返回该内容所占的页数及其内容
		JSONObject param=userManageService.fenYenPage(map);		
		System.out.println("分页中的商品："+param);
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
		//保存返回的data关键字数据
		List<Product> pxList=new ArrayList<Product>();
		pxList=JSONArray.parseArray(JSON.toJSONString(jsonArray), Product.class);
		result.put("result", pxList);
		//返回界面结果
		return result;*/
	}
	
}
