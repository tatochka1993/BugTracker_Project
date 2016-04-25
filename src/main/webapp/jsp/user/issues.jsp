<%@ taglib prefix="spring" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>

<head>
    <title>Issues</title>
    <link href="<c:url value='/resources/css/styles.css'/>" rel="stylesheet" type="text/css"/>
</head>

<body>
    <a href="<c:url value="/j_spring_security_logout"/>">logout</a><br><br>

    <h1>All issues</h1>

    <c:if test="${empty issues}">
        <h5>No one issue, <a href="<c:url value="/user/issues?create"/>">create one</a>.</h5>
    </c:if>

    <c:if test="${not empty issues}">
        <table>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Type</th>
                    <th>Status</th>
                    <th>Priority</th>
                    <th>#</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="issue" items="${issues}">
                    <tr>
                        <td>${issue.title}</td>
                        <td>${issue.description}</td>
                        <td>${issue.type}</td>
                        <td>${issue.status}</td>
                        <td>${issue.priority}</td>
                        <td>
                            <a href="<c:url value="/user/issues?id=${issue.id}"/>">edit</a>
                            <a href="<c:url value="/user/issues?id=${issue.id}&delete"/>">delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="<c:url value="/user/issues?create"/>">Create new issue.</a>
    </c:if>

    <spring:authorize access="hasRole('ROLE_ADMIN')">
        <p>You have admin rights, u can edit <a href="<c:url value="/admin/users"/>">user profiles</a>.</p>
    </spring:authorize>
</body>

</html>
