package com.example.domaci5;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "checkTeam", value = "/check-team")
public class CheckTeamServlet extends HttpServlet {

    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getSession().getAttribute("imeTima") != null){
            response.sendRedirect("clanovi.jsp");
            return;
        }
        String teamName = request.getParameter("imeTima");
        String contactEmail = request.getParameter("kontaktMejl");
        String contactPhone = request.getParameter("kontaktTelefon");
        String teamMotto = request.getParameter("motoTima");
        String hackathonInfo = request.getParameter("saznanjeZaHakaton");
        int teamSize = Integer.parseInt(request.getParameter("brojClanova"));

        request.getSession().setAttribute("imeTima", teamName);
        request.getSession().setAttribute("kontaktMejl", contactEmail);
        request.getSession().setAttribute("kontaktTelefon", contactPhone);
        request.getSession().setAttribute("motoTima", teamMotto);
        request.getSession().setAttribute("saznanjeZaHakaton", hackathonInfo);
        request.getSession().setAttribute("brojClanova", teamSize);

        response.sendRedirect("clanovi.jsp");
    }

    public void destroy() {
    }
}