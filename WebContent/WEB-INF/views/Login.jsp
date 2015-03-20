<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
	<h4>${data}</h4>
		<%-- <c:if test="${not empty data}">
			
			<br />
		</c:if> --%>
	</div>
	<div style="margin-left: 35%; padding-top: 25px;">
		<s:form action="Employeeweblogin" modelAttribute="lBean">
			<div style="position: absolute;">Enter Email</div>
			<div style="position: absolute; margin-left: 120px;">
				<s:input path="emailId" />
				<s:errors path="emailId" cssClass="error" />
			</div>
			<br />
			<br />
			<div style="position: absolute;">Enter Password</div>
			<div style="position: absolute; margin-left: 120px;">
				<s:password path="password" />
				<s:errors path="password" cssClass="error" />
			</div>
			<br />
			<br />
			<span style="padding-left: 120px;"><input type="submit"></span>
		</s:form>
	</div>



</body>
</html>