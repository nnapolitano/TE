<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alien Travel Time</title>
</head>
<body>

<div id="main-content">
    <h2>Alien Travel Time</h2>

    <c:url value="/alienTravel" var="alienTravelResultURL"/>
    <form method="POST" action="${alienTravelResultURL}">
        <p>
            <label for="planetName">Select a Planet</label>
            <select name="planetName" id="planetName">
                <c:forEach var="planet" items="${planets}">
                    <option value="${planet.name()}">${planet.getPlanetName()}</option>
                </c:forEach>
            </select>
        </p>
        <p>
            <label for="transportName">Select a mode of transport</label>
            <select name="transportName" id="transportName">
                <c:forEach var="transport" items="${transports}">
                    <option value="${transport.name()}">${transport.getTransportName()}</option>
                </c:forEach>
            </select>
        </p>

        <p>
            <label for="earthAge">Enter your Earth Age</label>
            <input type="text" name="earthAge" id="earthAge"/>
        </p>
        <input type="submit" value="Calculate Travel Time"/>
    </form>
</div>

</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
