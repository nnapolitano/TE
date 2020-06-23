<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Detail Page</title>
</head>
<body>
<section>
    <c:url var="imageOfItem" value="/img/${fn:toLowerCase(productDetails.food-items)}.jpg"/>
    <img src="${imageOfItem}" alt="Image of food">
</section>


</body>
</html>
