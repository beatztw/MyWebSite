package com.itis.servletsapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class AutoSchoolIntroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("name", "Some special name");
        getServletContext().getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
    }
}
