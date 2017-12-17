<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Start page</title>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />


</head>
<body>



<div id="content">

	<jsp:include page="fragments/header.jsp"/>

	<jsp:include page="fragments/left-menu.jsp"/>

	<div id="center">
 		<img src="${pageContext.request.contextPath}/resources/images/news11.jpg" />
	</div>
			
</div>

	<jsp:include page="fragments/footer.jsp"/>

</body>
</html>