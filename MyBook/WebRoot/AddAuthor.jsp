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
    
    <title>Add Author page</title>
    
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
    <h1><b>Add Author</b></h1>
    <hr>
    <s:form action="AddAuthorBegin.action">
    <table >
    <tr><td>AuthorID:<s:textfield name="newAuthor.authorID"/></td></tr>
    <tr><td>Name:<s:textfield name="newAuthor.name"/></td></tr>
    <tr><td>Age:<s:textfield name="newAuthor.age"/></td></tr>
    <tr><td>Country:<s:textfield name="newAuthor.country"/></td></tr>
   	</table>
   	<hr>
   	<s:submit align="CENTER" value="Submit"/>
    </s:form>
  	<s:form action="returnMyJsp.action" ><s:submit  align="right" value="Return"/></s:form>
  	</center>
  </body>
</html>
