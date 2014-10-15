<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Delete page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <center>
  <h1><b>Delete Book</b></h1>
  <hr>
  <s:form action="deleteBegin">
  Input the Book's ISBN:<s:textfield name="target"/>
  <s:submit />
  </s:form>
  <br>
  <b>If you don't know the ISBN of that book, return and search the book, you can delete it from the search page.</b>
  <s:form  action="returnMyJsp.action" ><s:submit value="Return"/></s:form>
  </center>
  </body>
</html>
