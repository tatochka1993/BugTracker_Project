<%@ taglib prefix="spring" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>

<head>
    <title>Users</title>
    <link href="<c:url value='/resources/css/styles.css'/>" rel="stylesheet" type="text/css"/>
</head>

<body>
    <h1>All users</h1>

    <c:if test="${not empty users}">
        <table>
            <thead>
                <tr>
                    <th>Login</th>
                    <th>Role</th>
                    <th>#</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.login}</td>
                        <td>${user.role.name}</td>
                        <td><a href="<c:url value="/admin/users?id=${user.id}"/>">edit</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <p>Back to <a href="<c:url value="/user/issues"/>">issues</a>.</p>
</body>

</html>
