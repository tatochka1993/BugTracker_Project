<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<head>
    <title>Login</title>
</head>

<body>
    <h1>Please sign in</h1>

    <c:if test="${isError}">
        <h5>Username or password is incorrect, try again.</h5>
    </c:if>
    <c:if test="${isLogout}">
        <h5>You successfully logout.</h5>
    </c:if>

    <form method="post" action="<c:url value="/j_spring_security_check"/>">
        <label>User name:</label>
        <input type="text" name="login" title="User name"/><br>

        <label>Password:</label>
        <input type="password" name="password" title="Password"/><br>

        <input type="submit" value="Sign in"/>
    </form>

    <p>If you don't have an account, please <a href="<c:url value="/register"/>">register</a></p>
</body>

</html>
