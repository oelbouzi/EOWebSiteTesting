package com.eowebtesting;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 * Created by oussama.elbouzi on 22/05/2015.
 */
@WebServlet("/Gegogo")
public class Gegogo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Gegogo(){
        super();
    }
    // post information on a web page
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
    // Get a web page
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

// On récupère le nom passé en paramètre dans l'URL
        String nomSaisi = request.getParameter("nom");
        out.println("");

        if (nomSaisi == null)
            out.println("Il manque le paramètre nom!");
        else
            out.println("Bonjour " + nomSaisi + "!");

        out.println("");

     }
}
