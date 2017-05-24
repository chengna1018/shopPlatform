<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./resources/js/jquery.min.js"></script>
<script type="text/javascript" src="./resources/js/jqueryPage.js"></script>
<script type="text/javascript" src="./resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./resources/js/shop.js"></script>
<link type="text/css" rel="stylesheet"
	href="./resources/css/bootstrap-combined.min.css" />
<link type="text/css" rel="stylesheet" href="./resources/css/shopping.css">
<link rel="stylesheet" href="./resources/css/jquerypage.css"/>
<title>购物</title>
</head>
<body>
	<div id="all_products"></div>
	<div id="page"></div>
	<input type="hidden" name="totalnum" value="" id="totalnum"/>
	<div id="shortcut">
		<a href="#"
			style="color: red; position: absolute; margin-left: 800px;font-size:14px;" id="register">你好，请登录</a>&nbsp;<a
			href="#" style="position: absolute; margin-left: 900px;font-size:14px;" id="login">注册</a>
	</div>  
	<div id="header">
		<div id="logo" style="float: left">
			<img src="./resources/image/logo.jpg" height="150px" width="150px" />
		</div>
		<form class="well form-search"
			style="position: absolute; left: 600px; top: 60px; background-color: #FFF; border: 0">
			<input type="text" class="input-medium search-query" name="allproducts" id="word">
			<input type="button" value="搜索" class="btn"  onclick="getPage(1)">
		</form>
	</div>
	<div style="height:auto; width: 1200px; position: absolute; top: 200px; left: 200px; background-color: white; border:1px solid #333">
	<script type="text/javascript">
	
	
	//获得当前根路径
	 function getRootPath(){
	   var pathName = window.location.pathname.substring(1);
	   var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
	   if (webName == "") {
	     return window.location.protocol + '//' + window.location.host;
	   }
	   else {
	     return window.location.protocol + '//' + window.location.host + '/' + webName+'/';
	   }
	 }
	
	 $(document).ready(function(){
		getPage(1);
		alert("getPage(1):"+getPage(1));
		$(function(){
			$("#page").Page({
		  		totalPages: parseInt($("#totalnum").val()), 
		  		liNums: 5, 
		  		activeClass: 'activP', 
		  		callBack : function(page){
			  		getPage(page);
		  		}
			});
		})
	 });
	
	//商品分页
	 function getPage(page){
		 var search_content=$("#word").val();
		 alert("获取输入框内容："+search_content);
		 
		
			$.ajax({
				type:'POST', 
			    dataType:"json",
			    url:getRootPath()+'goshop/page',
			    data:{
					searchContent:search_content,
					page:page,
				},
				success:function(param){
					var content=" ";
					var data=param.data;
					alert("获取的商品："+data);
					var num = Math.ceil(param.dataNum/20);
					$("#totalnum").val(num);
					 alert( "总的页数"+$("#totalnum").val());
					var content = " ";
					alert("初始页码:"+num);
					for (var i = 0;i<20;i++){
						var picture=data[i].picture;
						 var price=data[i].price;
						 var productname=data[i].productname;
						 var evaluate=data[i].evaluate;
						 var shop=data[i].shop;
							
						 content=content+"<div><div id='onearea' class='span4'><a href='#'><img class='size' id='picture' src='./resources/image/'"+picture+".jpg></a>"+
							"<p class='description' id='price'>"+price+"</p>"+
							"<p class='word' id='productname'>"+productname+"</p>"+
							" <p class='word' id='evaluate'>已有<p style='color:#06F;display:inline-block'>"+evaluate+"</p>条评论</p>"+
							"<p class='word' id='shop'>"+shop+"</p></div></div>";
						
					}
					content=content+"</div>";
					$('#all_products').empty();
					$('#all_products').html(content);
					},
				error:function(param){
						alert('查询结果失败');
					}
			});
			
		};
	 
	

		
	</script>
	
	

</body>
</html>