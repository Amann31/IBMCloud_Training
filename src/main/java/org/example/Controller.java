package org.example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Controller", value = "/controller.do")
public class Controller extends HttpServlet {

    private String leagueName;
    private int leagueYear;
    private String leagueSeason;
    private List<String> errors;
    private RequestDispatcher requestDispatcher;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        errors = new ArrayList<String>();
        response.setContentType("text/html");

        PrintWriter out=response.getWriter();
        leagueName=request.getParameter("lName").toString();
        if(leagueName.length()<=0)
        {
            errors.add("Field name cannot be blank.");
        }
        try {
            leagueYear=Integer.parseInt(request.getParameter("lYear"));
        }
        catch (Exception e)
        {
            errors.add("year field must be numeric.");
        }
        leagueSeason=request.getParameter("lSeason");
        if(leagueSeason.equals("Unknown"))
        {
            errors.add("Select a season.");
        }

        if(!errors.isEmpty())
        {
            request.setAttribute("ERROR",errors);
            requestDispatcher = request.getRequestDispatcher("error.jsp");
        }
        else
        {
            request.setAttribute("LEAGUE", new League(leagueName,leagueYear,leagueSeason));
            requestDispatcher = request.getRequestDispatcher("success.jsp");
        }

        requestDispatcher.forward(request,response);
    }

}