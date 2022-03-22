<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>
<link href="/recipetoyou/Resources/User/Css/remote.css" rel="stylesheet"  type="text/css">
</head>
<body>
	<div class="wrap">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="mypageInfo" />
		<div class="main">
			<tiles:insertAttribute name="side" />
			<tiles:insertAttribute name="body" />
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>