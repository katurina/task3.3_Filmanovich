<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<html>
<head>
    <title>Parser</title>
</head>

<body>
<div style="text-align: center;">
    <form action="${pageContext.request.contextPath}/controller">
        <input type="submit" value="SAX"><br> <br>
        <input type="submit" value="StAX"><br><br>
        <input type="submit" value="DOM">
    </form>
</div>
</body>
</html>
