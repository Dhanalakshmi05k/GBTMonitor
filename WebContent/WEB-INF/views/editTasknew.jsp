<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<title>Insert title here</title>
</head>
<body>
<s:form action="editTask" method="get" modelAttribute="tBean">
	
		<div style="position: absolute;">taskName</div>
		<div style="position: absolute;margin-left: 120px;"><s:input path="taskName" /><s:errors path="taskName" cssClass="error"></s:errors></div>
		<br/><br/>
		<div style="position: absolute;">taskDesc</div>
		<div style="position: absolute;margin-left: 120px;"><s:input path="taskDesc" /><s:errors path="taskDesc" cssClass="error"></s:errors></div>
		<br/><br/>
		<span style="padding-left: 120px;"><input type="submit"></span>
		</s:form>
</body>
</html>