<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>登录成功</title>
  </head>
  
  <body>
           登录成功 .<br> 
         <form action="register.do">
        
         <input type="submit" value="登录" /> 
     </form>
  </body>
</html>
