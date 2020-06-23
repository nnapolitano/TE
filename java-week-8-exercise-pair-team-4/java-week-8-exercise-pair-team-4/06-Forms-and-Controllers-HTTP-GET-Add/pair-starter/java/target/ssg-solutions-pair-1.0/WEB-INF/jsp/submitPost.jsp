<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Submit Post</title>
</head>
<body>

<div id="main-content">
    <h2>Submit Post</h2>

    <c:url value="/savePost" var="savePostURL"/>
    <form method="POST" action="${savePostURL}">
        <p>
            <label for="userName">Username</label>
            <input type="text" name="userName" id="userName"/>

        </p>

        <p>
            <label for="subject">Subject</label>
            <input type="text" name="subject" id="subject"/>
        </p>

        <p>
            <label for="message">Message</label>
            <textarea id="message" name="message"
                      rows="5" cols="33">
            </textarea>
        </p>
        <input type="submit" value="Submit"/>
    </form>
</div>

</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
