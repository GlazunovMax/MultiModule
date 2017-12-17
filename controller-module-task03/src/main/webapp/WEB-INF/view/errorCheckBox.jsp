<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
.try-button {
	border: 1px solid #666;
	padding: 6px;
	font-size: 12px;
	font-weight: bold;
	width: 150px;
	background: #cccccc;
	border-radius: 5px;
}

#alert-warning {
	padding: 5px;
	background: #f08080;
}
</style>


</head>
<body>
	<div id="alert-warning">
		<strong><spring:message code="forbidden" /></strong>
		<spring:message code="messageErrorCheckBox" />
	</div>
	<br>

	<input type="button" value="<spring:message code="tryAgain"/>" onclick="window.history.back();" class="try-button" />


</body>
</html>