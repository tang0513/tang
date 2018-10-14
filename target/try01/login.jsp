<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/resources/css/index2.css" type="text/css"></link>
  	<script type="text/javascript" src="/resources/js/jquery-1.8.2.min.js"></script>
  	<script type="text/javascript" src="/resources/My97DatePicker/WdatePicker.js"></script>
</head>
<script type="text/javascript">
//失焦事件
function xingming() {
 	var a=$("#username").val();
 	$.post(
 		"<%=request.getContextPath()%>/verification.do",
 		{username:a},
 		function(msg){
 			if(msg>0){
 				$("#zhengze").html(""); 
			}else{
				$("#zhengze").html("您填写的用户名不存在"); 
			}
 		}
 	)
}
	
</script>
<body>
	<form action="<%=request.getContextPath()%>/login.do" method="post">
		<table>
			<tr>
				<td><h1>教务管理系统</h1></td>
			</tr>
			<tr>
				<td>
					<input onblur="xingming()" type="text" id="username" name="username" placeholder="用户名">
					<p id="zhengze"></p>
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" name="password" placeholder="密码">
				</td>
			</tr>
			<tr>
				<td>
					<input type="checkbox">保持我的登录状态
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="登录">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>