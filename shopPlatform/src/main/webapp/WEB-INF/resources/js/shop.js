// JavaScript Document

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
	 var page=$("#page").val();
	 
	
	 alert(search_content);
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
							 shopping.setAttribute("src","./resources/image/."+param[i].picture+".png");
							 info("price",param[i].price);
							 info("productname",param[i].productname);
							 info("evaluate",param[i].evaluate);
							 info("shop",param[i].shop);
							}
						 
					 }
				 });
			// }
	 }

//商品分页
 function getPage(page){
		$.ajax({
			type:'POST', 
		    dataType:"json",
		    url:url,
		    data:{
				page:page,
				id:id
			},
			success:function(param){
				content = " ";
				for (var i = 0;i<param.length;i++){
					var desc = param[i].desc;
					var name = param[i].ename;
					var picture = param[i].picture;
					var url = '<%=request.getContextPath()%>/singleEquip?id='+id;
					/* if(i<4){
						content = content + "<div class='img'><img src='./resources/image/"+picture+".png'>"+"<h4>名称："+name+"</h4>"
						+"<h5>简介："+desc+"</h5></div>";
					}else{
						content = content + "<div class='img'><img src='./resources/image/"+picture+".png'>"+"<h4>名称："+name+"</h4>"
						+"<h5>简介："+desc+"</h5></div>";
					} */
					if(i<8){
						content = content + "<div class='img'><img src='./resources/image/"+picture+".png'>"+"<h4>名称："+name+"</h4>"
						+"<h5>简介："+desc+"</h5></div>";
					}
				}
				$('#all_equips').empty();
				$('#all_equips').html(content);
				},
			error:function(data){
				alert('查询结果失败');
				}
		});
		
	};
 
//参数为当前页
	function pageNum(page){
		var searchContent=$("#word").val();
		
	$.ajax({		
		type:"POST",
		dataType:"json",
		data:{
			searchContent:searchContent,
			page:page,
			},
		url:getRootPath()+"goshop/page",
		success: function(param){
			content=" ";
			var num=Math.ceil(param.size()/20);
			for(var i=0;i<param.length;i++){
				if(i<20){
					 document.setAttribute("source","./resources/image/."+param[i].picture+".png");
					 info("price",param[i].price);
					 info("productname",param[i].productname);
					 info("evaluate",param[i].evaluate);
					 info("shop",param[i].shop);
					}
				}
				$("#all_products").empty();
				$("#all_products").html();
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


function info(target,infos){
	document.getElementById(target).innerHTML=infos;
	}
