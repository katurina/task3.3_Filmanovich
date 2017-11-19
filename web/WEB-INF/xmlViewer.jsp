<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>People</title>
</head>
<body>
<div style="text-align: center;">
    <table border="1">
        <c:forEach items="${requestScope.list}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.surname}</td>
                <td>${item.telephone}</td>
                <td>${item.email}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <br>
    <form method="get" action="${pageContext.request.contextPath}/controller">
        <a href="${pageContext.request.contextPath}/controller?page=1">1</a>
        <c:choose>
            <c:when test="${requestScope.currentPage eq 1}">
                <a href="${pageContext.request.contextPath}/controller?page=2">2</a>...
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${requestScope.currentPage eq 2}">
                        <a href="${pageContext.request.contextPath}/controller?page=2">2</a>
                        <a href="${pageContext.request.contextPath}/controller?page=3">3</a>...
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${requestScope.currentPage eq requestScope.numberOfPages}">
                                ...<a href="${pageContext.request.contextPath}/controller?page=${requestScope.currentPage-1}">
                                ${requestScope.currentPage-1}</a>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${requestScope.currentPage eq (requestScope.numberOfPages-1)}">
                                        ...<a href="${pageContext.request.contextPath}/controller?page=${requestScope.currentPage-1}">
                                        ${requestScope.currentPage-1}</a>
                                        <a href="${pageContext.request.contextPath}/controller?page=${requestScope.currentPage}">
                                                ${requestScope.currentPage}</a>
                                    </c:when>
                                    <c:otherwise>
                                        ...<a href="${pageContext.request.contextPath}/controller?page=${requestScope.currentPage-1}">
                                        ${requestScope.currentPage-1}</a>
                                        <a href="${pageContext.request.contextPath}/controller?page=${requestScope.currentPage}">
                                                ${requestScope.currentPage}</a>
                                        <a href="${pageContext.request.contextPath}/controller?page=${requestScope.currentPage+1}">
                                                ${requestScope.currentPage+1}</a>...
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
        <a href="${pageContext.request.contextPath}/controller?page=${requestScope.numberOfPages}">${requestScope.numberOfPages}</a>
    </form>
</div>
</body>
</html>
