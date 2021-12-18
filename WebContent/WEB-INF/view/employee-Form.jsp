 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<h2>Save Employee</h2>
<hr><br>
<form:form action="saveEmployee" modelAttribute="emp"   method="POST">
<form:hidden path="id"/>

Name:<form:input path="name"/><br>
Company:<form:input  path="company"/><br>
Email:<form:input  path="email"/><br><br>
<input type="submit"  value="submit"/>

</form:form>

<p><a href="${pageContext.request.contextPath}/employee/emplist">back  to  list</a></p>
</body>
</html>