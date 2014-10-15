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
    
    <title>Add Book page</title>
    
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
    <h1><b>Add Book</b></h1>
    <hr>
    <s:form action="AddBookBegin.action">
    <table >
    <tr><td>ISBN:<s:textfield name="newBook.ISBN"/></td></tr>
    <tr><td>Title:<s:textfield name="newBook.title"/></td></tr>
    <tr><td>AuthorID:<s:textfield name="newBook.authorID"/></td></tr>
    <tr><td>Publisher:<s:textfield name="newBook.publisher"/></td></tr>
    <tr><td>PublishDate:<s:textfield name="newBook.publishDate"/></td></tr>
    <tr><td>Price:<s:textfield name="newBook.price"/></td></tr>
   	</table>
   	<hr>
   	<s:submit align="CENTER" value="Submit"/>
    </s:form>
  	<s:form action="returnMyJsp.action" ><s:submit  align="right" value="Return"/></s:form>
  	</center>
  </body>
</html>
