<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List news</title>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/button-style.css"/>" />

</head>
<body>

<div id="content">	

		<jsp:include page="fragments/header.jsp"/>
	
		<jsp:include page="fragments/left-menu.jsp"/>
	
	<div id="center">

		<form:form action="viewNews"    >
  

			<c:forEach var="tempNews" items="${newsFormList.newsList}">
			 	<c:out value="${tempNews.id }"/>
			 	<h2><i><spring:message code="newsTitle"/></i> : <c:out value="${tempNews.newsTitle}"/></h2>
			 	<h2><u><fmt:formatDate value="${tempNews.newsDate}" pattern="yyyy/MM/dd"/></u></h2>
			 	<h3><i><spring:message code="content"/></i> : <c:out value="${tempNews.content}"/></h3>
			 
			 	<h4><spring:message code="viewEdit"/> <input type="checkbox" name="viewEdit" value="${tempNews.id}"></h4><br>
				
			</c:forEach>

			<h1><input type="submit" value="<spring:message code="delete"/>" class="delete"></h1>
		 </form:form>
	
	</div>		
</div>

	<jsp:include page="fragments/footer.jsp"/>
</body>
</html>