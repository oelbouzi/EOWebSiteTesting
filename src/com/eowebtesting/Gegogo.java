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

        request.setAttribute("heure", "jour");
        this.getServletContext().getRequestDispatcher("/Gegogo.jsp").forward(request, response);



        //response.setContentType("text/html");
        //String var = "Mok ya mok";
        //request.setAttribute("mouuk",var);

        //this.getServletContext().getRequestDispatcher("/Gegogo.jsp").forward(request, response);


    }
}
