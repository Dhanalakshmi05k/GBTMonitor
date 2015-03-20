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
		<s:form action="addProject" method="get" modelAttribute="pBean">
		<div style="position: absolute;">Project Name</div>
		<div style="position: absolute;margin-left: 120px;"><s:input path="projectName" /><s:errors path="projectName" cssClass="error" /></div>
		<br/><br/>
		<%-- <div style="position: absolute;">Project Created Date</div>
		<div style="position: absolute;margin-left: 120px;"><s:input path="proj_CreatedDate" /><s:errors path="proj_CreatedDate" cssClass="error"></s:errors></div>
		<br/><br/> --%>
		<div style="position: absolute;">Description</div>
		<div style="position: absolute;margin-left: 120px;"><s:input path="description" /><s:errors path="description" cssClass="error"></s:errors></div>
		<br/><br/>
		<div style="position: absolute;">Type Of Project</div>
		<div style="position: absolute;margin-left: 120px;"><s:input path="typeOfProject" /><s:errors path="typeOfProject" cssClass="error"></s:errors></div>
		<br/><br/>
		<%-- <div style="position: absolute;">taskName</div>
		<div style="position: absolute;margin-left: 120px;"><s:input path="taskName" /><s:errors path="taskName" cssClass="error"></s:errors></div>
		<br/><br/>
		<div style="position: absolute;">taskDesc</div>
		<div style="position: absolute;margin-left: 120px;"><s:input path="taskDesc" /><s:errors path="taskDesc" cssClass="error"></s:errors></div>
		<br/><br/>
		<div style="position: absolute;">taskCompletionDate</div>
		<div style="position: absolute;margin-left: 120px;"><s:input path="taskCompletionDate" /><s:errors path="taskCompletionDate" cssClass="error"></s:errors></div>
		<br/><br/>	
		<div style="position: absolute;">priority</div>
		<div style="position: absolute;margin-left: 120px;"><s:input path="priority" /><s:errors path="priority" cssClass="error"></s:errors></div>
		<br/><br/>	
		<div style="position: absolute;">employees</div>
		<div style="position: absolute;margin-left: 120px;"><s:input path="priority" /><s:errors path="priority" cssClass="error"></s:errors></div>
		<br/><br/>	 --%>
		<span style="padding-left: 120px;"><input type="submit"></span>
		</s:form>


</div>


</body>
</html>