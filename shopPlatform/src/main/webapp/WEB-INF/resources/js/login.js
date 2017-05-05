// JavaScript Document
var username_empty="<span>用户名不能为空</span>";
var username_error="<span>用户名不存在</span>";
var username_correct="<span>√</span>"
var password_empty="<span>密码不能为空</span>";
var password_error="<span>密码错误，请重新输入</span>";
var password_correct="<span>√</span>";
var can_login="<span>登录成功！</span>";

//获得当前根路径
function getRootPath(){
  var pathName = window.location.pathname.substring(1);
  var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
  if (webName == "") {
    return window.location.protocol + '//' + window.location.host;
  }
  else {
    return window.location.protocol + '//' + window.location.host + '/' + webName;
  }
}

function checkUsername(){
	var name=$("#username").val();
	alert(name);
	if(name==null || name==""){
		document.getElementById("username_notice").innerHTML=username_empty;
		}else{
			$.ajax({
				type:"post",
				data:{username:name},
				dataType:"json",
				url:getRootPath()+"/checkUsername",
				success:function(param){
					if(name==param){
						info(username_notice,username_correct);
						}else{
							info(username_notice,username_error);
							}
					}
				});
			}
	}
function checkPassword(){
	var password=$("#password").val();
	alert(password);
	if(password==null || password==""){
		document.getElementById("password_notice").innerHTML=password_empty;
		}else{
			$.ajax({
				type:"post",
				data:{password:password},
				dataType:"json",
				url:getRootPath()+"/checkPassword",
				success:function(param){
					if(password==param){
						info(password_notice,password_correct);
						}else{
						info(password_notice,password_error);
							}
					}
				});
			}
	}
function success(){
	
			window.location.href=getRootPath()+"/success";
			
	
	}
function info(target,infos){
	document.getElementById(target).innerHTML=infos;
	}