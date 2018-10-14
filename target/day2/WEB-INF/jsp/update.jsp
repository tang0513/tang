<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

$(function(){
	$("[name='sname']").val("${roll.sname}");
	/* $("[name='cname']").val("${roll.cname}"); */
	$("[name='cname']").append("<option value='"+"${roll.cname}"+"'>" + "${roll.cname}" + "</option>");
})

//失焦事件
function xingming() {
 	var stuname=$("#stuname").val();
 	var sname=$("#sname").val();
 	var cname=$("#cpxh").val();
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

//二级联动
function getData(obj) {
	var opt = obj.options[obj.selectedIndex]
	//alert("The option you select is:"+opt.text+"("+opt.value+")");
	$.ajax({
	url : "<%=request.getContextPath()%>/findSessOneBySname.do",
	type : "Post",
	data : 'sname='+opt.value,
	success : function(data) {
		/* for (var i = 0; i < data.length; i++) { */
			$("#cpxh").append("<option value='"+data.cname+"'>" + data.cname + "</option>");
		/* } */
	}
	});

}
</script>
<body>
<form action="<%=request.getContextPath()%>/update.do" method="post">
	<table>
		<tr>
			<td>届别</td>
			<td>
				<select name="sname" onchange="getData(this)" id="sname">
					<c:forEach items="${list }" var="sess">
						<option value="${sess.sname }">${sess.sname }</option>
					</c:forEach>
				</select>　
			</td>
		</tr>
		<tr>
			<td>班级名称</td>
			<td>
				<select name="cname" id="cpxh"></select>　
			</td>
		</tr>
		<tr>
			<td>学号</td>
			<td>
				<input type="text" name="rnum" value="${roll.rnum }">
				<input type="hidden" name="rid" value="${roll.rid }">
			</td>
		</tr>
		<tr>
			<td>姓名</td>
			<td>
				<input type="text" name="stuname" id="stuname" onchange="xingming()" value="${roll.stuname }">
			</td>
		</tr>
		<tr>
			<td>出生日期</td>
			<td>
				<input type="text" name="stuborn" value="${roll.stuborn }">
			</td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
				<input type="text" name="stusex" value="${roll.stusex }">
			</td>
		</tr>
		<tr>
			<td>状态</td>
			<td>
				<input type="text" name="states" value="${roll.states }">
			</td>
		</tr>
		<tr>
			<td>民族</td>
			<td>
				<input type="text" name="stunation" value="${roll.stunation }">
			</td>
		</tr>
		<tr>
			<td>电话</td>
			<td>
				<input type="text" name="stuphone" value="${roll.stuphone }">
			</td>
		</tr>
		<tr>
			<td>届别</td>
			<td>
				<input type="text" name="rdate" value="${roll.rdate }">
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