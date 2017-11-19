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
        <c:forEach items="${requestScope.list.entity}" var="item">
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
    <c:choose>
        <c:when test="${requestScope.list.numberOfPages lt 4}">
            <c:forEach begin="1" end="${requestScope.list.numberOfPages}" varStatus="loop">
                <a href="${pageContext.request.contextPath}/controller?page=${loop.index}&parser=${requestScope.parser}">${loop.index}</a>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/controller?page=1&parser=${requestScope.parser}">1</a>
            <c:choose>
                <c:when test="${requestScope.list.currentPage eq 1}">
                    <a href="${pageContext.request.contextPath}/controller?page=2&parser=${requestScope.parser}">2</a>...
                </c:when>
                <c:when test="${requestScope.list.currentPage eq 2}">
                    <a href="${pageContext.request.contextPath}/controller?page=2&parser=${requestScope.parser}">2</a>
                    <a href="${pageContext.request.contextPath}/controller?page=3&parser=${requestScope.parser}">3</a>
                    <c:if test="${(requestScope.list.numberOfPages - requestScope.list.currentPage) gt 2}">...</c:if>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${requestScope.list.currentPage eq requestScope.list.numberOfPages}">
                            <c:if test="${requestScope.list.numberOfPages gt 4}">...</c:if>
                            <a href="${pageContext.request.contextPath}/controller?page=${requestScope.list.currentPage-1}&parser=${requestScope.parser}">
                            ${requestScope.list.currentPage-1}</a>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${requestScope.list.currentPage eq (requestScope.list.numberOfPages-1)}">
                                    <c:if test="${requestScope.list.currentPage gt 3}">...</c:if>
                                    <a href="${pageContext.request.contextPath}/controller?page=${requestScope.list.currentPage-1}&parser=${requestScope.parser}">
                                    ${requestScope.list.currentPage-1}</a>
                                    <a href="${pageContext.request.contextPath}/controller?page=${requestScope.list.currentPage}&parser=${requestScope.parser}">
                                            ${requestScope.list.currentPage}</a>
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${requestScope.list.currentPage gt 3}">...</c:if>
                                    <a href="${pageContext.request.contextPath}/controller?page=${requestScope.list.currentPage-1}&parser=${requestScope.parser}">
                                    ${requestScope.list.currentPage-1}</a>
                                    <a href="${pageContext.request.contextPath}/controller?page=${requestScope.list.currentPage}&parser=${requestScope.parser}">
                                            ${requestScope.list.currentPage}</a>
                                    <a href="${pageContext.request.contextPath}/controller?page=${requestScope.list.currentPage+1}&parser=${requestScope.parser}">
                                            ${requestScope.list.currentPage+1}</a>
                                    <c:if test="${(requestScope.list.numberOfPages - requestScope.list.currentPage)gt 2}">...</c:if>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>
            <a href="${pageContext.request.contextPath}/controller?page=${requestScope.list.numberOfPages}&parser=${requestScope.parser}">${requestScope.list.numberOfPages}</a>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
