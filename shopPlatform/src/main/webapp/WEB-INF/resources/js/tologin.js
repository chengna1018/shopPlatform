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
		url:getRootPath()+"/success",
		success:function(param){
			if(param.success=="4"){
				window.location.href="${pageContext.request.contextPath}/success";
			}else if(param.success=="5"){
				alert(param.message);
			}
		}
	});
	
	}
	