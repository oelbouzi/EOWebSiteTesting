<%--
  Created by IntelliJ IDEA.
  User: oussama.elbouzi
  Date: 27/05/2015
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html"
        pageEncoding="UTF-8" language="java" %>

<!DOCTYPE HTML PUBLIC>

<html >
  <head>
    <meta content="text/html; charset=UTF-8">
    <title>login </title>
    <link rel="stylesheet" href="css/style.css">
  </head>

  <body>
    <div>
      <div>
        <div class="col-md-6 col-sm-6 col-xs-6 text-left">
          <a href="index.html"><img src="img/logo-white.png" alt="Boxify Logo" id="logo"></a>
        </div>
      </div>
      <div class="wrapper" >

        <div class="container">
          <h1>Welcome</h1>
          <%
            // Récupération du message d'erreur
            String erreur = (String) request.getAttribute("erreur");
            // Affichage du message s'il existe
            if (erreur != null) { %>
          <strong>Erreur : </strong>
          <%
            } %>
          <form method="post" class="form" action="connexion">
            <input name="login" type="text" placeholder="Username">
            <input name="password" type="password" placeholder="Password">
            <button type="submit" name="Valider" >Login</button>
            <!-- id="login-button" -->
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

