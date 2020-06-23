<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">
	<H2>Alien Travel Time</H2>

	<c:url value="/alienTravelTime" var="alienTravelTimeResultUrl"/>
	<form method="POST" action="${alienTravelTimeResultUrl}">
		<p>
		<label for="planetName">Select a planet</label>
		<select name="planetName" id="planetName">
			<c:forEach var="planet" items="${planets}">
				<option value="${planet.name()}">${planet.getPlanetName()}</option>
			</c:forEach>
		</select>
		</p>
		<p>
		<p>
		<label for="transportName">Select a planet</label>
		<select name="transportName" id="transportName">
			<c:forEach var="transport" items="${transports}">
				<option value="${transport.name()}">${transport.getTransportName()}</option>
			</c:forEach>
		</select>
		</p>
		<label for="earthAge">Enter you Earth Age</label>
		<input type="text" id="earthAge" name="earthAge"/>
		</p>
		<button>Submit</button>
	</form>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
