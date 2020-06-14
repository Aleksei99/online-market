<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.04.2020
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>online-market</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
    body {font-family: Arial, Helvetica, sans-serif;}
    form {border: 3px solid #f1f1f1;}

    input[type=text], input[type=password] {
      width: 100%;
      padding: 12px 20px;
      margin: 8px 0;
      display: inline-block;
      border: 1px solid #ccc;
      box-sizing: border-box;
    }
    p{
      color: #4CAF50;
    }
    h1{
      color: orange;
    }

    button {
      background-color: #4CAF50;
      color: white;
      padding: 14px 20px;
      margin: 8px 0;
      border: none;
      cursor: pointer;
      width: 100%;
    }

    button:hover {
      opacity: 0.8;
    }


    /* Change styles for span and cancel button on extra small screens */
    @media screen and (max-width: 300px) {
      span.psw {
        display: block;
        float: none;
      }

    }
  </style>
</head>
<body>
<h1>Welcome</h1>
<form action="${pageContext.request.contextPath}/login">
  <button>Log in</button>
</form>
<p>Not registered yet?</p>
<form action="${pageContext.request.contextPath}/registration">
  <button>Registration</button>
</form>

</body>
</html>
