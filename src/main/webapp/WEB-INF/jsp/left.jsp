<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/Ztreedemo/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/Ztreedemo/css/demo.css" type="text/css"></link>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/Ztreedemo/js/jquery.ztree.all.js"></script></head>
<script type="text/javascript">
		var setting = {
		
			view: {
				dblClickExpand: false
			},
			data: {
				key: {
					name: "name"
				},
				simpleData: {
					enable: true,
					idKey: "zid",
					pIdKey: "pid",
					rootPId: null
				}
			}
		};

		$(document).ready(function(){
			$.fn.zTree.init($("#aa"), setting,${string});
		});
</script>
<body>
	
	<ul id="aa" class="ztree" style="width:480px;height:700px"></ul>
</body>
</html>