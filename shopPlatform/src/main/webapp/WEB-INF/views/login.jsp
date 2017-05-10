<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="type/javascript" src="./resources/js/jquery.min.js"></script>
<script type="text/javascript" src="./resources/js/tologin.js"></script>
<title>登录</title>
</head>
<body>   	
        <table width="100%" align="center" border=0>       	
            	<tr>
                	<td align="right" width="15%"><strong>用户名：</strong></td>
                    <td width="57%"><input id="username" type="text" name="username"></td>                   
                </tr>
                <tr>
                	<td align="right" width="15%"><strong>密码：</strong></td>
                    <td width="57%"><input type="password" name="password" id="password">
                    	
                    </td>     
                </tr>                           
               <tr>
               		<td><input type="hidden" value="act_register" name="act"></td>
                    <td><input type="button" id="login" value="登录"  onclick="willlogin()"></td>
               </tr>          
        </table>    
</body>
</html>