<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alien Weight Result</title>
</head>
<body>
<section id="calculatorResult">

    <c:url var="imageOfPlanet" value="/img/${fn:toLowerCase(alienWeight.planet)}.jpg"/>
    <img src="${imageOfPlanet}" alt="Image of Planet">

    <h2>If you are ${alienWeight.earthWeight} pounds on planet Earth, you would weigh ${alienWeight.alienWeight} pounds
        on ${alienWeight.planet}</h2>

</section>

</body>

</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
