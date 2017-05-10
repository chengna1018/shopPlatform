// JavaScript Document
var username_empty="<span>×用户名不能为空</span>";
var password_empty="<sapn>×密码不能为空</span>";
var email_empty="<span>×邮箱不能为空</span>";
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

function login(){
	var username=$("#username").val();
	var password=$("#pwd").val();
	var confirm_pwd=$("#confirm_pwd").val();
	var email=$("#email").val();
	var phone=$("#phone").val();
/*	if(username==null || username==""){
		info(username_notice,username_empty);
		}else if(password==null || password==""){
			info(password_notice,password_empty);	
		}else if(email==null || email==""){
			info(email_notice,email_empty);
			
		}else {*/
			$.ajax({
				type:"post",
				data:{username:username,pwd:password,email:email,phone:phone},
				dataType:"json",
				url:getRootPath()+"register",
				success: function(param){
					alert(param.success);
					if(param.success=="0") {
						window.location.href="http://localhost:8080/shopPlatform/login";
						//document.getElementById("username_notice").innerHTML=param.message;
						//info(username_notice,param.message);
						}else if(param.success=="1"){
							document.getElementById("username_notice").innerHTML=param.message;
							//info(username_notice,param.message);
							}else if(param.success=="2"){
								document.getElementById("email_notice").innerHTML=param.message;
								//info(email_notice,param.message);
								}else if(param.success=="3"){
									document.getElementById("email_notice").innerHTML=param.message;
									//info(username_notice,param.message);
									}
					
					}
				});
			//}
	}
	

//function info(target,infos){
	/*if(param.success=="0") {
		window.location.href="login";
	}else if(param.success=="1"){
		document.getElementById(target).innerHTML=infos;
	}else if(param.success=="2"){
		document.getElementById(target).innerHTML=infos;
	}else{
		document.getElementById(target).innerHTML=infos;
	}*/
	
	//document.getElementById(target).innerHTML=infos;
	//}

