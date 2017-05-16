<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./resources/js/jquery.min.js"></script>
<script type="text/javascript" src="./resources/js/jqueryPage.js"></script>
<script type="text/javascript" src="./resources/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="./resources/css/bootstrap-combined.min.css" />
<link type="text/css" rel="stylesheet" href="./resources/css/shopping.css">
<link rel="stylesheet" href="./resources/css/jquerypage.css"/>
<title>购物</title>
</head>
<body>
	<div id="page"></div>
	<div id="all_products"></div>
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
			<input type="button" value="搜索" class="btn" id="search"  onclick="shop()">
		</form>
	</div>
	
	<script type="text/javascript">
	
	 content="";
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
	 
	//查询所有商品
	 function shop(){
		 var search_content=$("#word").val();
		 alert(search_content);
		 var page=$("#page").val();
			
		/* if(search_content==null || search_content==""){
			 alert(search_empty);
			 }else{*/
				 $.ajax({
					 type:"post",
					 data:{searchContent:search_content,page:page},
					 dataType:"json",
					 url:getRootPath()+"goshop",
					 success: function(param){
						 alert(param.productname);
						 for(var i=0;i<20;i++){
							 var picture=param[i].picture;
							 var price=param[i].price;
							 var productname=param[i].productname;
							 var evaluate=param[i].evaluate;
							 var shop=param[i].shop;
								content=content+"<div style='height: auto; width: 1200px; position: absolute; top: 200px; left: 200px; background-color: #FF9'>"+
								"<div><div id='onearea' class='span4'><a href='#'><img class='size' id='picture' src='./resources/image/'"+picture+".jpg></a>"+
								"<p class='description' id='price'>"+price+"</p>"+
								"<p class='word' id='productname'>"+productname+"</p>"+
								" <p class='word' id='evaluate'>已有<p style='color:#06F;display:inline-block'>"+evaluate+"</p>条评论</p>"+
								"<p class='word' id='shop'>"+shop+"</p></div></div></div>";
						 	}
						 }
					 });
				// }
		$("#all_products").html(content);
		 }

	//商品分页
	 function getPage(page){
			$.ajax({
				type:'POST', 
			    dataType:"json",
			    url:getRootPath()+"goshop/page",
			    data:{
					page:page,
					searchContent:search_content
				},
				success:function(param){
					var content = " ";
					
					for (var i = 0;i<20;i++){
						var picture=param[i].picture;
						 var price=param[i].price;
						 var productname=param[i].productname;
						 var evaluate=param[i].evaluate;
						 var shop=param[i].shop;
						
							content=content+"<div style='height: auto; width: 1200px; position: absolute; top: 200px; left: 200px; background-color: #FF9'>"+
							"<div><div id='onearea' class='span4'><a href='#'><img class='size' id='picture' src='./resources/image/'"+picture+".jpg></a>"+
							"<p class='description' id='price'>"+price+"</p>"+
							"<p class='word' id='productname'>"+productname+"</p>"+
							" <p class='word' id='evaluate'>已有<p style='color:#06F;display:inline-block'>"+evaluate+"</p>条评论</p>"+
							"<p class='word' id='shop'>"+shop+"</p></div></div></div>";
						
					}
					$('#all_products').empty();
					$('#all_products').html(content);
					},
				error:function(data){
					alert('查询结果失败');
					}
			});
			
		};
	 
	
	$(function(){
		
			$("#page").Page({
		  		totalPages: parseInt(pageNum), 
		  		liNums: 5, 
		  		activeClass: 'activP', 
		  		callBack : function(page){
			  		getPage(page);
		  		}
			});
		})

	</script>
	
	

</body>
</html>