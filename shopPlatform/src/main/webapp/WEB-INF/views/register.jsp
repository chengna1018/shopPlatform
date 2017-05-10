<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./resources/js/jquery.min.js"></script>
<script type="text/javascript" src="./resources/js/toregister.js"></script>
<title>注册</title>
</head>
<body>
	<form id="userForm">
    	<br/>
        <table width="100%" align="center" border=0>
        	<tbody>
            	<tr>
                	<td align="right" width="15%"><strong>用户名：</strong></td>
                    <td width="57%"><input type="text" id="username"></td>                   
                </tr>
                
                <tr>
                	<td align="right" width="15%"><strong>邮箱：</strong></td>
                    <td width="57%"><input type="email" id="email"></td>                   
                </tr>
                
                <tr>
                	<td align="right" width="15%"><strong>密码：</strong></td>
                    <td width="57%"><input type="password" id="pwd" name="password">
                    	
                    </td>     
                </tr>
                
                <tr>
                	<td align="right" width="15%"><strong>确认密码：</strong></td>
                    <td><input type="password" id="confirm_pwd" name="confirm_password">                    	
                    </td>
                </tr>
                
                <tr>
                	<td align="right" width="15%"><strong>手机号：</strong></td>
                    <td><input type="tel" name="telephone" id="phone">
                    	
                    </td>
                </tr>
               <tr>
               		<td><input type="hidden" value="act_register" name="act"></td>
                    <td><input type="button" id="register" value="确认注册" onclick="login()"></td>
               </tr>
            </tbody>
        </table>
    </form>
</body>
</html>