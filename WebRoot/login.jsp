<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登录</title>
    
    <style type="text/css">
        .kaptcha{
            
        }
    </style>
     
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script></head>
   
    <script type="text/javascript">
                $(function (){  
                     $('#kaptcha').click(  
                        
                        function (){  
                            $(this).attr('src', 'kaptcha/kaptcha.do?' + Math.floor(Math.random() * 100));   
                         }  
                     );            
                 });      
     </script>
    

  <body>
       <form action="dorm/login.do">
         <label>姓名</label>
         <input type="text" name="userName" /><br>
         <label>密码</label>
         <input type="password" name="userPassword" />
         <img class="kaptcha" id="kaptcha" src="kaptcha/kaptcha.do"/><br>
         <input type="submit" value="登录" />     
     </form>
  </body>
</html>
