// JavaScript Document
var username_empty="<span>用户名不能为空</span>";
var password_empty="<span>密码不能为空</span>";

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

function willlogin(){
	var username=$("#username").val();
	var password=$("#password").val();
	//var password=document.getElementById("password").value;
	alert(password);
	$.ajax({
		type:"post",
		data:{username:username,password:password},
		dataType:"json",
		url:getRootPath()+"success",
		success:function(param){
			if(param.success=="4"){
				window.location.href="http://localhost:8080/shopPlatform/success";
			}else if(param.success=="5"){
				alert(param.message);
			}
		}
	});
	/*if(username==null || username==""){
		document.getElementById("username_notice").innerHTML=username_empty;
		//info(username_notice,username_empty);
		}else if(password==null || password==""){
			document.getElementById("password_notice").innerHTML=password_empty;
			//info(password_notice,password_empty);
			}else{
				//document.getElementById("login").click(function(){
					/*$.ajax({
						type:"post",
						data:{username:username,
							password:password},
						dataType:"json",
						url:getRootPath()+"success",
						success: function(param){
							alert(param.success);
							if(param.success=="4"){
								window.location.href="http://localhost:8080/shopPlatform/success";
								//info(username_notice,param.message);
								}else if(param.success=="5"){
									document.getElementById("username_notice").innerHTML=param.message;	
								//document.getElementById("login").innerHTML=param.message;
								//info(login,param.message);
									}
							}
						});
				})*/
					
				
				
				//}
	}
	/*var username = $("#username").val();  
	var password=$("#password").val();
	alert(username);
	alert(password);
	var name_message=document.getElementById("name_message");
	var psw_message=document.getElementById("psw_message");
	
	if(username==null||username==""){
		showInfo("name_message",username_empty);
	}
	else if(password==null||password==""){
		showInfo("password_message",password_empty);
	}
	if((username!=null||username!="")&&(password!=null||password!="")){
		$.ajax({
			type:"post",
			url:getRootPath()+"/success",
			data:{
				username:username,
				password:password
			},
			
			success:function(data){
				alert(data.success);
				if(data.success=="5"){
					alert(data.message);
					}
				if(data.success=="4"){
					alert(data.message);
					
					}
				
			}
		});
	}
	}*/	

/*function info(target,infos){
	document.getElementById(target).innerHTML=infos;
	}*/