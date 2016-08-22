<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method = "post" action="${pageContext.request.contextPath}/docreate" commandName="offer">

<table class="formtable">
<tr><td> <form:label path="name">Name: </form:label></td><td><form:input path="name"/><br/><form:errors path="name" cssClass="error"></form:errors></td></tr>
<tr><td> <form:label path="email">Email: </form:label></td><td><form:input path="email"/><br/><form:errors path="email" cssClass="error"></form:errors></td></tr>
<tr><td> <form:label path="text">Your Offer: </form:label></td><td><form:textarea path="text" rows="10" cols="10"/><br/><form:errors path="text" cssClass="error"></form:errors></td></tr>

<tr><td class="label"></td><td><input class="control" value="create advert" type="submit" /></td></tr>
</table>
</form:form>




</body>
</html>