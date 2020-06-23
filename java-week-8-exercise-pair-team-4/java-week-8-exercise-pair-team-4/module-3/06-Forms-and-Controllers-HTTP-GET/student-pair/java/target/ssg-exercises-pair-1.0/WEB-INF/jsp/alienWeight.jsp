<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alien Weight</title>
</head>
<body>

<c:url var="formAction" value="/alienWeightResult"/>
<form method="POST" action="${formAction}">
    <div>
        <select name="planet" id="planet">
            <option value="Mercury">Mercury</option>
            <option value="Venus">Venus</option>
            <option value="Earth">Earth</option>
            <option value="Mars">Mars</option>
            <option value="Jupiter">Jupiter</option>
            <option value="Saturn">Mercury</option>
            <option value="Uranus">Uranus</option>
            <option value="Neptune">Neptune</option>
            <option value="Pluto">Pluto</option>
        </select>
    </div>
    <div>
        <label for="earthWeight">Enter Your Earth Weight</label>
        <input type="number" name="earthWeight" id="earthWeight"/>
    </div>
    <input type="submit" value="Calculate Weight"/>

</form>

</body>
</html>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />