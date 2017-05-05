<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./resources/js/login.js"></script>
<title>登录</title>
</head>
<body>
	<form id="userForm">
    	<br/>
        <table width="100%" align="center" border=0>
        	<tbody>
            	<tr>
                	<td align="right" width="15%"><strong>用户名：</strong></td>
                    <td width="57%"><input id="username" onblur="checkUsername()"><span id="username_notice" style="color:#F00"/>*</span></td>                   
                </tr>
                <tr>
                	<td align="right" width="15%"><strong>密码：</strong></td>
                    <td width="57%"><input type="password" name="password" id="password" onblur="checkPassword()">
                    	<span id="password_notice" style="color:#F00">*</span>
                    </td>     
                </tr>             
               
               <tr>
               		<td><input type="hidden" value="act_register" name="act"></td>
                    <td><input type="button" id="login" value="登录" onclick="success()"></td>
               </tr>
            </tbody>
        </table>
    </form>
</body>
</html>