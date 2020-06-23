<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alien Weight</title>
</head>
<body>

<div id="main-content">
    <h2>Alien Weight</h2>

    <c:url value="/alienWeight" var="alienWeightResultURL"/>
    <form method="POST" action="${alienWeightResultURL}">
        <p>
            <label for="planetName">Select a Planet</label>
            <select name="planetName" id="planetName">
                <c:forEach var="planet" items="${planets}">
                    <option value="${planet.name()}">${planet.getPlanetName()}</option>
                </c:forEach>
            </select>
        </p>

        <p>
            <label for="earthWeight">Enter your Earth Weight</label>
            <input type="text" name="earthWeight" id="earthWeight"/>
        </p>
        <input type="submit" value="Calculate Weight"/>
    </form>
</div>

</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
