<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" href="<%=path %>/css/index1.css" type="text/css"></link>
  
  <script type="text/javascript" src="<%=path %>/js/jquery-1.7.js"></script>
  
  </head>
  
  <script type="text/javascript">
  	
  	function nolog(){
  		top.location.href="<%=path%>user/nolog.do";
  	}
  	
  </script>
  
<body>
	<table>
		<tr>
			<td>${sessionScope.user.username }您好！！！</td>
		</tr>
		<tr>
			<td>
				<a href="#" onclick="nolog()" target="_top">我要退出</a>
			</td>
		</tr>
	</table>
</body>
</html>