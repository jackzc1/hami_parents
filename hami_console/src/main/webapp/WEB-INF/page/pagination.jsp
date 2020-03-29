<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/25
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="fanye" class="clearfix text-right">
    <ul class="pagination no-margin">
        <input type="hidden" id="totalPage" name="totalPage" value="${page.totalPage}"/>
        <input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo}"/>
        <li id="pre" class="disabled"><a href="#">Prev</a></li>
        <c:forEach var="starts" begin="1" end="${page.totalPage}">
            <c:if test="${starts == page.pageNo}">
                <li class="active"><a href="#">${starts}</a></li>
            </c:if>
            <c:if test="${starts != page.pageNo}">
                <li id="toNum" ><a href="#">${starts}</a></li>
            </c:if>
        </c:forEach>


        <li id="next"><a href="#">Next</a></li>
    </ul>
</div>
</body>
</html>
