<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.04.2020
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User info</title>
</head>
<body>
<p>User id: ${requestScope.user.id}</p>
<p>User name: ${requestScope.user.name}</p>
<p>User surname: ${requestScope.user.surname}</p>
</body>
</html>
