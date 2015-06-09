
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
  <title>Sign Up</title>
  <link type="text/css" rel="stylesheet" href="css/signupstyle.css" />
</head>
<body>
<div class="wrapper" >

  <div class="container">
    <form method="post" action="Signup">

      <h1>Sign up</h1>

      <input type="email" id="email" name="email" value="<c:out value="${param.email}"/>" maxlength="60" placeholder="Email"/>
      <span class="erreur">${form.erreurs['email']}</span>
      <br />


      <input type="password" id="password" name="password" maxlength="20" placeholder="Password" />
      <span class="erreur">${form.erreurs['password']}</span>
      <br />


      <input type="password" id="confirmation" name="confirmation" maxlength="20" placeholder="Password confirmation"/>
      <span class="erreur">${form.erreurs['confirmation']}</span>
      <br />


      <input type="text" id="name" name="name"  value="<c:out value="${param.name}"/>" maxlength="20" placeholder="Username"/>

      <span class="erreur">${form.erreurs['name']}</span>
      <br />

      <button type="submit" value="Inscription" class="sansLabel" name="Valider">Inscription</button>

      <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>

      <br />
    </form>
  </div>

  <ul class="bg-bubbles">
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
  </ul>
</div>
<!-- Scripts -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="js/index.js"></script>
</body>
</html>