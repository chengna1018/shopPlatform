<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./resources/js/register.js"></script>
<title>注册</title>
</head>
<body>
	<form id="userForm">
    	<br/>
        <table width="100%" align="center" border=0>
        	<tbody>
            	<tr>
                	<td align="right" width="15%"><strong>用户名：</strong></td>
                    <td width="57%"><input id="username"><span id="username_notice" style="color:#F00"/>*</span></td>                   
                </tr>
                
                <tr>
                	<td align="right" width="15%"><strong>邮箱：</strong></td>
                    <td width="57%"><input id="email" onblur="checkEmail(this)"><span id="email_notice" style="color:#F00">*</span></td>                   
                </tr>
                
                <tr>
                	<td align="right" width="15%"><strong>密码：</strong></td>
                    <td width="57%"><input type="password" name="password" id="password"  onkeyup="checkIntensity(this.value)">
                    	<span id="password_notice" style="color:#F00">*</span>
                    </td>     
                </tr>
                
                <tr>
                	<td align="right" width="15%"><strong>确认密码：</strong></td>
                    <td><input type="password" id="confirm_password" name="confirm_password" onblur="checkConfirmPassword(this)">
                    	<span id="confirm_password_notice" style="color:#F00">*</span>
                    </td>
                </tr>
                
                <tr>
                	<td align="right" width="15%"><strong>手机号：</strong></td>
                    <td><input type="tel" name="telephone" id="telephone" onblur="checkTelephone(this)">
                    	<span id="telephone_notice" style="color:#F00">*</span>
                    </td>
                </tr>
               <tr>
               		<td><input type="hidden" value="act_register" name="act"></td>
                    <td><input type="button" id="register" value="确认注册" onclick="checkUsername()"></td>
               </tr>
            </tbody>
        </table>
    </form>
</body>
</html>