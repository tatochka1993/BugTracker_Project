<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<html>

<head>
    <title>Create/edit issue</title>
</head>

<body>
    <h1>Create/edit issue</h1>

    <sf:form method="post" modelAttribute="issue" action="/user/issues?save">
        <sf:hidden path="id"/>

        <label>Title:</label>
        <sf:input path="title"/><br>

        <label>Description</label>
        <sf:input path="description"/><br>

        <label>Type</label>
        <sf:input path="type"/><br>

        <label>Status</label>
        <sf:input path="status"/><br>

        <label>Priority</label>
        <sf:input path="priority"/><br>

        <input type="submit" value="Save"/>
    </sf:form>

    <p>Back to <a href="<c:url value="/user/issues"/>">issues</a>.</p>
</body>

</html>
