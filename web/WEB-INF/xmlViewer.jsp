<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>People</title>
</head>
<body>
<c:forEach items="${requestScope.list}" var="item">
    ${item.name}  ${item.surname}  ${item.telephone} ${item.email}<br>
</c:forEach>
</body>
</html>
