<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.uttara.GroupBasedTaskManager.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div>
<%ArrayList<TaskBean> lb=(ArrayList<TaskBean> )session.getAttribute("listOftask"); %>
	<table border="1" cellpadding="3" cellspacing="1">
	<tr>
		<th>project_sl_no </th>
		<th>projectName </th>
		<th>proj_CreatedDate</th>
		<th>Verifier_Password</th>
		<th>description </th>
		<th>typeOfProject </th>
	</tr>
	 <% for(int i=0;i<lb.size();i++) { %>
	<tr>
	<td><%=lb.get(i).getTask_sl_no() %></td>
	<td><%=lb.get(i).getTaskDesc() %></td>
	<td><%=lb.get(i).getTaskName() %></td>
<%-- 	<td><%=	lb.get(i).getDescription() %></td>
	<td><%=	lb.get(i).getTypeOfProject() %></td> --%>
	
	<td align="center"><a href="editTask?task_sl_no=<%=lb.get(i).getTask_sl_no()%> ">Edit</a></td>
	<td align="center"><a href="deleteTask?task_sl_no=<%=lb.get(i).getTask_sl_no()%>">Delete</a></td>
	</tr> 
	<% } %>
	
	</table>

</div>



</body>
</html>