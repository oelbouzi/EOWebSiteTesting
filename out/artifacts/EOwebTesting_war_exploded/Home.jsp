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
<p>Registering <%= request.getParameter("nom")%> ;
  <%= request.getParameter("prenom") %></p>
<p>Registering <%= request.getAttribute("nom")%> ;
  <%= request.getAttribute("prenom") %></p>


<h2>Bonjour  !</h2>

</body>
</html>
