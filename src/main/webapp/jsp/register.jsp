<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<head>
    <title>Registration</title>
</head>

<body>
    <h1>Registration form</h1>

    <c:choose>
        <c:when test="${code eq 'SUCCESS'}">
            <h5>Register successful.</h5>
        </c:when>

        <c:when test="${code eq 'ERROR'}">
            <h5>Check your register form for errors and try again.</h5>
        </c:when>
    </c:choose>

    <form method="post" action="<c:url value="/register"/>">
        <label>User name:</label>
        <input type="text" name="login" title="User name"/><br>

        <label>Password:</label>
        <input type="password" name="password" title="Password"/><br>

        <label>Confirm password:</label>
        <input type="password" name="confirmPassword" title="Confirm password"/><br>

        <input type="submit" value="Sign up"/>
    </form>

    <p>Back to <a href="<c:url value="/login"/>">login</a></p>
</body>

</html>
