<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Parser</title>
</head>

<body>
<div style="text-align: center;">
    <form action="${pageContext.request.contextPath}/controller">
        <input type="submit" name="parser" value="SAX"><br> <br>
        <input type="submit" name="parser" value="StAX"><br><br>
        <input type="submit" name="parser" value="DOM">
    </form>
</div>
</body>
</html>
