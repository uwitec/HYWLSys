<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <script type="text/javascript" src="ckeditor/ckeditor.js" charset="UTF-8"></script>  
      
    <title></title>  
  </head>  
  <body>  
  <form action="testServlet" method="post">
    <textarea class="ckeditor" cols="40"  name="content" rows="10" id="content" ></textarea> 
    <input type="button" onclick="edit()">
    <input type="submit" value="submit">    
  </form>
   <script type="text/javascript" charset="UTF-8">     
    //<![CDATA[    
        var editor=CKEDITOR.replace('content');    
    //]]> 
    function edit(){
        alert(editor.getData());
    }
    </script> 
  </body>  
</html>
