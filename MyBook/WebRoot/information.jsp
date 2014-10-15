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
    
    <title>Book's Information page</title>
    
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
   <h1 align="CENTER"><s:property value="jspTitle"/></h1>
    <hr>
	<table border=1 align="center">
	<tr><td colspan="2"><b>Book:</b></td></tr>
	<tr>
	<td><b>Title</b></td>
	<s:iterator value="B" id="book" >
	<td>"<s:property value="#book.title"/>"</td>
	</s:iterator>
	</tr>
	<tr>
	<td><b>ISBN</b></td>
	<s:iterator value="B" id="book" >
	<td><s:property value="#book.ISBN"/></td>
	</s:iterator>
	</tr>
	<tr>
	<td><b>Publisher</b></td>
	<s:iterator value="B" id="book" >
	<td><s:property value="#book.publisher"/></td>
	</s:iterator>
	</tr>
	<tr>
	<td><b>PublishDate</b></td>
	<s:iterator value="B" id="book" >
	<td><s:property value="#book.publishDate"/></td>
	</s:iterator>
	</tr>
	<tr>
	<td><b>Price</b></td>
	<s:iterator value="B" id="book" >
	<td><s:property value="#book.price"/></td>
	</s:iterator>
	</tr>
	<tr><td colspan="2"><b>Author:</b></td></tr>
	<tr>
	<td><b>Name</b></td>
	<s:iterator value="A" id="author" >
	<td><s:property value="#author.name"/></td>
	</s:iterator>
	</tr>
	<tr>
	<td><b>AuthorID</b></td>
	<s:iterator value="A" id="author" >
	<td><s:property value="#author.authorID"/></td>
	</s:iterator>
	</tr>
	<tr>
	<td><b>Age</b></td>
	<s:iterator value="A" id="author" >
	<td><s:property value="#author.age"/></td>
	</s:iterator>
	</tr>
	<tr>
	<td><b>Country</b></td>
	<s:iterator value="A" id="author" >
	<td><s:property value="#author.country"/></td>
	</s:iterator>
	</tr>
	</table>
	<s:form align="CENTER" action="returnMyJsp.action" ><s:submit value="Return"/></s:form>
  </body>
</html>
