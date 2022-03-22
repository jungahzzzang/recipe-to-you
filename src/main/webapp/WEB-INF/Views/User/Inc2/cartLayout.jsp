<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" ignore="true"/></title>
<link href="/recipetoyou/Resources/User/Css/remote.css" rel="stylesheet"  type="text/css">
</head>
<body>
 <div class="wrap">
		<tiles:insertAttribute name="header"  ignore="true"/>
		<tiles:insertAttribute name="mypageInfo"  ignore="true"/>
		<div class="main">
			<tiles:insertAttribute name="side"  ignore="true"/>
			<tiles:insertAttribute name="body"  ignore="true"/>
		</div>
		<tiles:insertAttribute name="footer"  ignore="true"/>
	</div> 
</body>
</html>