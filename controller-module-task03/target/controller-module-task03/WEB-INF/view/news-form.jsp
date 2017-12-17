<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add News</title>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/addnews-style.css"/>" />

</head>

<body>

	<div id="content">

<%-- 		<jsp:include page="fragments/header.jsp" /> --%>
		<div id="header">
			<p><spring:message code="management" /></p>


			<c:url var="ru" value="/news/showFormForAdd">
				<c:param name="id" value="${newsForm.newsMessage.id}" />
				<c:param name="lang" value="ru" />
			</c:url>
			<c:url var="en" value="/news/showFormForAdd">
				<c:param name="id" value="${newsForm.newsMessage.id}" />
				<c:param name="lang" value="en" />
			</c:url>


			<a href="${en}"><spring:message code="english" /></a> 
			<a href="${ru}"><spring:message code="russian" /></a>
		</div>
		
		

		<jsp:include page="fragments/left-menu.jsp" />


		<div id="center">
			<h1><spring:message code="savingNews" /></h1>
			<h5><i><spring:message code="requiredFieldMessage" /></i></h5>

			<form:form action="addNews" modelAttribute="newsForm" method="POST">

				<form:hidden path="newsMessage.id" />
				
				<c:url var="showFormForAdd" value="/news/showFormForAdd">
					<c:param name="id" value="newsForm.newsMessage.id" />
				</c:url>

				<h3><spring:message code="newsTitle" />*</h3>
				<form:input path="newsMessage.newsTitle" required="true" />
				<form:errors path="newsMessage.newsTitle" cssClass="error" />

				<h3><spring:message code="newsDate" />*</h3>
				<form:input path="newsMessage.newsDate" />
				<form:errors path="newsMessage.newsDate" cssClass="error" />

				<h3><spring:message code="brief" />*</h3>
				<form:textarea style="width:500px; height:150px;" path="newsMessage.brief" />
				<form:errors path="newsMessage.brief" cssClass="error" />

				<h3><spring:message code="content" />*</h3>
				<form:textarea style="width:500px; height:250px;" path="newsMessage.content" />
				<form:errors path="newsMessage.content" cssClass="error" />

				<form:hidden path="newsMessage.status" value='Y' />

				<input type="submit" value="<spring:message code="save"/>" class="button" />
				<input type="submit" value="<spring:message code="cancel"/>"
					onclick="window.location.href='listStart'; return false;"
					class="button" />

			</form:form>

		</div>

	</div>

	<jsp:include page="fragments/footer.jsp" />


</body>

</html>
