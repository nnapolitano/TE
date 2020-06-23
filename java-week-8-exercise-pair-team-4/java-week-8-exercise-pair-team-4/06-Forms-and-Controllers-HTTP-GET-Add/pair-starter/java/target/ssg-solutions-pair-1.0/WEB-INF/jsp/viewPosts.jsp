<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Solar System Geek Forum</title>
</head>
<body>

<div id="main-content">
    <h2>Solar System Geek Forum</h2>

        <table>
            <c:forEach var="post" items="${allPosts}">
            <tr>
                <td>
                    <p>
                        ${post.subject}
                        by ${post.userName} on ${post.datePosted}
                        ${post.message}
                    </p>
                </td>
            </tr>
            </c:forEach>
        </table>
 </div>
</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
