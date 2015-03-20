<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Employee Registration</title>
<style>
.error {
	color: #FF0000;
	font-style: italic;
	font-weight: bold;
}

.heading {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>

</head>
<body>

<!-- <div>{$Status}</div> -->
<div>
		<c:if test="${not empty Status}">
			<h4> ${Status}</h4>
			<br />
		</c:if>
</div>
<div>
		<c:if test="${not empty result}">
			<h1>Error</h1>
			<h4>Message ${result}</h4>
			<br />
		</c:if>
</div>
<div style="margin-left: 10%;padding-top: 10px;border:2px;border-color:#BDECFB; ">		
		<h2><font color="#000099">Enter  Details</font></h2>
		<s:form action="registerEmployee" method="get" modelAttribute="eBean">
		<div style="position: absolute;">First Name</div>
		<div style="position: absolute;margin-left: 120px;"><s:input path="firstName" /><s:errors path="firstName" cssClass="error" /></div>
		<br/><br/>
		<div style="position: absolute;">Last Name</div>
		<div style="position: absolute;margin-left: 120px;"><s:input path="lastName" /><s:errors path="lastName" cssClass="error"></s:errors></div>
		<br/><br/>
		<div style="position: absolute;">EmailId</div>
		<div style="position: absolute;margin-left: 120px;"><s:input path="email" /><s:errors path="email" cssClass="error"></s:errors></div>
		<br/><br/>
		<div style="position: absolute;">Phone Number</div>
		<div style="position: absolute;margin-left: 120px;"><s:input path="phoneNumber" /><s:errors path="phoneNumber" cssClass="error"></s:errors></div>
		<br/><br/>
		<div style="position: absolute;">Create Password</div>
		<div style="position: absolute;margin-left: 120px;"><s:input path="password" /><s:errors path="password" cssClass="error"></s:errors></div>
		<br/><br/>
		<div style="position: absolute;">Repeat Password</div>
		<div style="position: absolute;margin-left: 120px;"><s:input path="repeatPassword" /><s:errors path="repeatPassword" cssClass="error"></s:errors></div>
		<br/><br/>
		<span style="padding-left: 120px;"><input type="submit"></span>
		</s:form>


</div>


</body>
</html>