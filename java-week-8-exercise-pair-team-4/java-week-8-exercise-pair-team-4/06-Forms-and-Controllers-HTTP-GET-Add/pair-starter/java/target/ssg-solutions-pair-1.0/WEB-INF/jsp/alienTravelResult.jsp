<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alien Travel Time Result</title>
</head>
<body>
<c:url var="imageOfPlanet" value="/img/${fn:toLowerCase(planetName)}.jpg"/>

<section id="calculatorResult">
    <img src="${imageOfPlanet}" alt="Image of Planet">

    <h2>
        Travelling by ${transportName}, you will reach ${planetName} in ${alienTravel}.  You will be ${earthAge + alienTravel} years old.
    </h2>
</section>


</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
