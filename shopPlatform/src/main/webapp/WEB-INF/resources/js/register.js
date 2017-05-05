// JavaScript Document
var username_empty="<span>×用户名不能为空</span>";
var username_shorter="<span>×用户名太短</span>";
var username_longer="<span>×用户名太长</span>";
var username_invalid="<span>×用户名只能是字母、数字或_,首字符只能为字母</span>";
var user_have_register="<span>×该用户已存在</span>";
var username_can_register="<span>√该用户可以注册</sapn>";

var password_empty="<sapn>×密码不能为空</span>";
var password_shorter="<span>×密码不能少于6个字符</span>";
var password_longer="<span>×密码不能多于30个字符</span>";
var password_confirm_invalid="<span>×两次密码不一致</sapn>";

var email_empty="<span>×邮箱不能为空</span>";
var email_invalidate="<span>×不符合邮箱格式</span>";
var email_have_register="<span><×邮箱已经注册/span>";
var email_can_register="<span>√该邮箱可以注册</span>";

var telephone_invalidate="<span>×请输入有效的手机号</span>";

var info_can="<span>可以注册！</span>";
var info_right="<span>填写正确！</span>";
var name_flag=false;
var email_flag=false;
var password_flag=false;

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
//检查用户名中的非法字符
function checks(obj){	
	szMsg="[!@#$%^&*()+=|\{}:'\"]";
	for(var i=1;i<szMsg.length+1;i++){
		if(obj.indexOf(szMsg.substring(i-1,i))>-1)
			return false;
		}
		return true;
	}
function checkUsername(){
	//检查用户名是否为空
	var name=$("#username").val();
	if(name==null || name==""){
		info(username_notice,username_empty);//检查用户名是否为空
		}else if(checks(name)==false){
		info(username_notice,username_invalid);//检查用户名是否含有非法字符
			}else if(name.length<6){
				info(username_notice,username_shorter);//检查用户名是否少于6个字符
				}else if(name.length>30){
					info(username_notice,username_longer);//检查用户名是否多于30个字符
					}else{
						$.ajax({
							type:"post",
							data:{username:name},
							dataType:"json",
							url:getRootPath()+"/checkUsername",
							success: function(param){
								if(name==param){
									info(username_notice,user_have_register);//用户名已经存在
									}else{
										info(username_notice,username_can_register);//用户名可以注册
										}
								}
							});
						}
	}
//检测邮箱格式
function checkEmail(){
	var temp = $("#email").val();
    var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
      if(!myreg.test(temp.value))
       {
          info(email_notice,email_invalidate);
          myreg.focus();
          return false;
             }else if(temp.length<1){
				 info(email_notice,email_empty);
				 }else{
					 $.ajax({
						 type:"post",
						 data:{email:temp},
						 dataType:"json",
						 url:getRootPath()+"checkEmail",
						 success: function(param){
							 if(temp==param){
								 info(email_notice,email_have_register);
								 }else{
									 info(email_notice,email_can_register);
									 }
							 }
						 });
					 }

	}
//密码检测
function checkPassword(){
	var password = $("#password").val();
	if(password.length<1){
		info(password_notice,password_empty);//密码不能为空
		}else if(password.value.length<6){
			info(password_notice,password_shorter);//密码不能少于6个字符
			}else if(password.value.length>30){
				info(password_notice,password_longer);//密码不能多于30个字符
				}
	}
//检测两次密码是否一致
function checkConfirmPassword(){
	var password = $("#password").val();
	var password_confirm=$("#confirm_password").val();
	if(!(password==password_confirm)){
		info(confirm_password_notice,password_confirm_invalid);//两次密码不一致
		}else{
			info(confirm_password_notice,info_right);//如果邮箱验证正确，则显示填写正确
			}
	}
//验证手机号
function checkTelephone(){
	var	telephone = $("#telephone").val();
	var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
	if(!myreg.test(telephone)) 
		{ 
   			info(telephone_notice,telephone_invalidate);
    		return false; 
		} 
	}
//如果每个都符合要求，则转向登录界面
function tologin(){
	var name=$("#username").val();
	var temp = $("#email").val();
	var password = $("#password").val();
	var password_confirm=$("#confirm_password").val();
	var	telephone = $("#telephone").val();
	if((name==username_can_register) && (temp == email_can_register) && (password_confirm==info_right) && (telephone != telephone_invalidate )){
		window.location.href="/login";
			
		}
	}
function info(target,infos){
	document.getElementById(target).innerHTML=infos;
	}