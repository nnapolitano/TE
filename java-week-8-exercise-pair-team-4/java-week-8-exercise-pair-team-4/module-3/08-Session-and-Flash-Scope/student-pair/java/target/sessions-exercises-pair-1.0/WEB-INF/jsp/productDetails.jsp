<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chase Java
  Date: 3/3/2020
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produce Department</title>
</head>

<body>

<table cellpadding="2" cellspacing="2" border="1">
<tr>
    <th>Id</th>>
    <th>Name</th>
    <th>Price</th>
    <th>Photo</th>
    <th>Buy</th>
</tr>
<c:forEach var="product" items="${products }">
    <tr>
    <td>${product.name}</td>
    <td>${product.price}</td>
    <td> <img src="${pageContext.request.contextPath }/webapp/img/${product.name}.jpg" width="120"></td>
    <td>${product.price}</td>
    </tr>

    </c:forEach>
    </body>
    </html>
