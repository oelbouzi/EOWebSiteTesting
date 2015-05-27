<%--
  Created by IntelliJ IDEA.
  User: oussama.elbouzi
  Date: 27/05/2015
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">


  <title>Home Page</title>
  <link rel="stylesheet" href="css/style.css">

</head>
<body>
<%
  String login = (String) request.getAttribute("login");
  String password = (String) request.getAttribute("password");
%>


<h2>Bonjour  !</h2>
<p>  Vous avez tapé le mot de passe : ${password}</p>
</body>
</html>
