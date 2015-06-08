
<%--
  Created by IntelliJ IDEA.
  User: oussama.elbouzi
  Date: 07/06/2015
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Inscription</title>
  <link type="text/css" rel="stylesheet" href="css/signupstyle.css" />
</head>
<body>
<div class="wrapper" >
<form method="post" action="Signup">
  <div class="container">
    <h1>Sign up</h1>

    <input type="email" id="email" name="email" value="<c:out value="${param.email}"/>" maxlength="60" placeholder="Email"/>
    <span class="erreur">${erreurs['email']}</span>
    <br />


    <input type="password" id="password" name="password" maxlength="20" placeholder="Password" />
    <span class="erreur">${erreurs['password']}</span>
    <br />


    <input type="password" id="confirmation" name="confirmation" maxlength="20" placeholder="Password confirmation"/>
    <span class="erreur">${erreurs['confirmation']}</span>
    <br />


    <input type="text" id="name" name="name"  value="<c:out value="${param.name}"/>" maxlength="20" placeholder="Username"/>

    <span class="erreur">${erreurs['name']}</span>
    <br />

    <button type="submit" value="Inscription" class="sansLabel" name="Valider">Inscription</button>

    <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>

    <br />
    </div>
</form>
  </div>
</body>
</html>