<%--
  Created by IntelliJ IDEA.
  User: oussama.elbouzi
  Date: 09/06/2015
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC>

<html>
<head>
  <meta content="text/html; charset=UTF-8">
  <title>Login</title>
  <link type="text/css"rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="barre-login">
  <div class="container">
    <%-- Vérification de la présence d'un objet utilisateur en session --%>

  </div>
</div>


<header>
 <div>
   <a href="/index.html"><img src="img/logo-white.png" alt="Boxify Logo"></a>
 </div>
</header>

<div>

  <div class="wrapper" >

    <div class="container">
      <h1>Welcome</h1>

      <form method="post" class="form" action="Login">
        <input type="email" id="email" name="email" value="<c:out value="${param.email}"/>" maxlength="60" placeholder="Email"/>
        <span class="erreur">${form.erreurs['email']}</span>
        <br />
        <input type="password" id="password" name="password" maxlength="20" placeholder="Password" />
        <span class="erreur">${form.erreurs['password']}</span>
        <br />
        <button type="submit" name="Valider" >Login</button>
        <!-- id="login-button" -->

        <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>

        <c:if test="${!empty sessionScope.sessionUtilisateur}">
          <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
          <a class="succes">You are connected with the address: ${sessionScope.sessionUtilisateur.email}</a>
        </c:if>

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
</div>
<!-- Scripts -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="js/index.js"></script>
</body>
</html>