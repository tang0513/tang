<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/index2.css" type="text/css"></link>
  	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.8.2.min.js"></script>
  	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/My97DatePicker/WdatePicker.js"></script>
</head>
<script type="text/javascript">
//失焦事件
function xingming() {
 	var stuname=$("#stuname").val();
 	var sname=$("#sname").val();
 	var cname=$("#cname").val();
 	if(stuname!=""&&sname!=""&&cname!=""){
 		$.post(
 		 		"<%=request.getContextPath()%>/verStuName.do",
 		 		{stuname:stuname,sname:sname,cname:cname},
 		 		function(msg){
 		 			if(msg>0){
 		 				alert("姓名已存在，请在姓名后面添加数字");
 					}else{
 					}
 		 		}
 		 	);
 	}else{
 		alert("届别，班级，姓名不能为空");
 	}
}


</script>
<body>
<form action="<%=request.getContextPath()%>/add.do" method="post">
	<table>
		<tr>
			<td>届别</td>
			<td>
				<input type="text" name="sname" id="sname" value="${sname }">
			</td>
		</tr>
		<tr>
			<td>班级名称</td>
			<td>
				<input type="text" name="cname" id="cname">
			</td>
		</tr>
		<tr>
			<td>学号</td>
			<td>
				<input type="text" name="rnum">
			</td>
		</tr>
		<tr>
			<td>姓名</td>
			<td>
				<input type="text" name="stuname" id="stuname" onblur="xingming()">
			</td>
		</tr>
		<tr>
			<td>出生日期</td>
			<td>
				<input type="text" name="stuborn">
			</td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
				<input type="text" name="stusex">
			</td>
		</tr>
		<tr>
			<td>状态</td>
			<td>
				<input type="text" name="states">
			</td>
		</tr>
		<tr>
			<td>民族</td>
			<td>
				<input type="text" name="stunation">
			</td>
		</tr>
		<tr>
			<td>电话</td>
			<td>
				<input type="text" name="stuphone">
			</td>
		</tr>
		<tr>
			<td>届别</td>
			<td>
				<input type="text" name="rdate" value="${rdate }">
			</td>
		</tr>
		<tr>
			<td colspan="13">
				<input type="submit" value="保存">
			</td>
		</tr>
	</table>
</form>
</body>
</html>