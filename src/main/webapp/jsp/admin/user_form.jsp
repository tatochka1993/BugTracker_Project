<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<html>

<head>
    <title>Edit user</title>
</head>

<body>
    <h1>Editing user: ${user.login}</h1>

    <sf:form method="post" modelAttribute="user" action="/admin/users?id=${user.id}">
        <sf:hidden path="id"/>

        <sf:select path="role.id">
            <c:forEach var="roleItem" items="${roles}">
                <sf:option value="${roleItem.id}">${roleItem.name}</sf:option>
            </c:forEach>
        </sf:select>

        <input type="submit" value="Save"/>
    </sf:form>

    <p>Back to <a href="<c:url value="/admin/users"/>">users</a>.</p>
</body>

</html>
