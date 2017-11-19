<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>E-SHOP</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12">
            <h1 class="text-center strong text-info">${welcome}</h1>
        </div>
    </div>
    <br>
    <div class="row content">
        <div class="col-sm-2 sidenav hidden-xs">
            <ul class="list-group">
                <li class="list-group-item-heading h2 text-center">${categories}</li>
                <c:forEach var="category" items="${requestScope.categories}">
                    <li class="list-group-item"><a
                            href="${pageContext.request.contextPath}/index.jsp?cat=${category.name}">${category.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="col-sm-10">
            <div class="row window" style="padding: 0">
                <div class="col-sm-offset-1 col-sm-5">
                    <span class="h2 text-info">${curCategory}</span>
                </div>
                <div class="col-sm-6">
                </div>
            </div>
            <c:set var="counter" value="${0}" scope="page"/>
            <c:forEach var="product" items="${requestScope.products}">
                <c:if test="${(counter%4)==0}"><div class="row"></c:if>
                <div class="col-sm-3">
                    <div class="panel panel-primary">
                        <div class="panel-heading">${product.name}</div>
                        <div class="panel-body"><img src="${product.imgPath}"
                                                     class="img-responsive"
                                                     style="margin: auto; height: 300px;"
                                                     alt="Image"></div>
                        <div class="panel-footer">
                            <div style="overflow: auto; text-align: center;">
                                <c:choose>
                                    <c:when test="${product.discountPrice eq 0}">
                                        <span class="h3">${price}:${product.price}$</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="h4">${price}:<del>${product.price}$</del>${product.discountPrice}$</span>
                                    </c:otherwise>
                                </c:choose>
                                <br>
                                <form action="${pageContext.request.contextPath}/controller" method="post">
                                    <input type="hidden" name="command" value="add-to-cart">
                                    <input type="hidden" name="id" value="${product.id}"/>
                                    <input type="submit" class="btn btn-primary full" value="${cart}"
                                           style="min-width: 100px;">
                                </form>
                                <a href="${pageContext.request.contextPath}/product_page.jsp?id=${product.id}"
                                   style="display:inline-block;min-width: 100px;">
                                    <button type="button" class="btn btn-primary full">${details}</button>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <c:set var="counter" value="${counter+1}" scope="page"/>
                <c:if test="${(counter%4)==0}"></div><br></c:if>
            </c:forEach>
        </div>
    </div>
</div>
</div>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>