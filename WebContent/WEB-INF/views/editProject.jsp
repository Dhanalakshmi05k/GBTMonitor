<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="width: 100%;height: 400px;background-color: #BDECFB">
<div style="margin-left: 35%;padding-top: 25px;">
<s:form action="editProjectData" method="post" modelAttribute="pBean">
<div style="position: absolute;">project_sl_no</div>
<div style="position: absolute;margin-left: 120px;"><s:input path="project_sl_no" readonly="true"/><s:errors path="project_sl_no" cssClass="error" /></div>
		<br/><br/>
<div style="position: absolute;">projectName</div>
<div style="position: absolute;margin-left: 120px;"><s:input path="projectName"/><s:errors path="projectName" cssClass="error" /></div>
		<br/><br/>
<div style="position: absolute;">proj_CreatedDate</div>
<div style="position: absolute;margin-left: 120px;"><s:input path="proj_CreatedDate" /><s:errors path="proj_CreatedDate" cssClass="error" /></div>
<br/><br/>
<div style="position: absolute;">description</div>
<div style="position: absolute;margin-left: 120px;"><s:input path="description"  /><s:errors path="description" cssClass="error" /></div>
		<br/><br/>
<div style="position: absolute;">typeOfProject</div>
<div style="position: absolute;margin-left: 120px;"><s:input path="typeOfProject"  /><s:errors path="typeOfProject" cssClass="error" /></div>
		<br/><br/>
<span style="padding-left: 120px;"><input type="submit"></span>
</s:form>
</div>
</div>

</body>
</html>