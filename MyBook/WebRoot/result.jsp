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
    
    <title>My JSP 'result.jsp' starting page</title>
    
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
    <h1 align="CENTER"><b><s:property value="jspTitle"/></b></h1>
    <hr>
    <table border=1 align="CENTER">
    <tr>
    	<!-- <td>Index</td>-->
        <td>ISBN</td>
		<td>Title</td>
		<td>authorID</td>
		<td>Publisher</td>
		<td>PublishDate</td>
		<td>Price</td>
  	</tr>
	<s:iterator value="B" id="book" status="stuts">
  	 <tr>
  	 	<!-- <td><s:property value="#stuts.index+1" /></td>-->
        <td><s:property value="#book.ISBN"/></td>
       <!--  <td><s:property value="#book.title"/></td>-->
		<td><a href="<s:url action="information.action"><s:param name="target" value="#book.ISBN"></s:param></s:url>"><s:property value="#book.title"/></a></td>
		<td><s:property value="#book.authorID"/></td>
		<td><s:property value="#book.publisher"/></td>
		<td><s:property value="#book.publishDate"/></td>
		<td><s:property value="#book.price"/></td>
		<td><a href="<s:url action="deleteBegin.action"><s:param name="target" value="#book.ISBN"></s:param></s:url>">Delete</a></td>
  	 </tr>
	</s:iterator>
	</table>
	<s:form align="CENTER" action="returnMyJsp.action" ><s:submit value="Return"/></s:form>
  </body>
</html>
