package com.example.domaci5;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet(name = "checkSubmissionServlet", value = "/check-submission")

public class CheckSubmissionServlet extends HttpServlet {
    public void init() { }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(request.getSession().getAttribute("prijavljen") != null){
            response.sendRedirect("hvala-na-prijavi.jsp");
            return;
        }

        String fileName = "tim_" + request.getSession().getAttribute("imeTima") + ".txt";

        File file = new File(fileName);
        file.createNewFile();

        FileWriter writer = new FileWriter(file);

        writer.write("Ime tima: " + request.getSession().getAttribute("imeTima"));
        writer.write("\n\r");
        writer.write("Kontakt email: " + request.getSession().getAttribute("kontaktMejl"));
        writer.write("\n\r");
        writer.write("Kontakt telefon: " + request.getSession().getAttribute("kontaktTelefon"));
        writer.write("\n\r");
        writer.write("Moto tima: " + request.getSession().getAttribute("motoTima"));
        writer.write("\n\r");
        writer.write("Kako ste saznali za hakaton: " + request.getSession().getAttribute("saznanjeZaHakaton"));
        writer.write("\n\r");
        writer.write("Broj clanova: " + request.getSession().getAttribute("brojClanova"));
        writer.write("\n\r");
        writer.write("*===============================================*");
        writer.write("\n\r");

        for (int i = 0; i < (int)request.getSession().getAttribute("brojClanova"); i++) {
            String imePrezime = request.getParameter("clan-ime-"+(i+1)) + " " + request.getParameter("clan-prezime-"+(i+1));
            writer.write("Clan " + (i + 1) + ": " + imePrezime);
            writer.write("\n\r");
            writer.write("Email clana: " + request.getParameter("clan-email-"+(i+1)));
            writer.write("\n\r");
            writer.write("Uloga: " + request.getParameter("clan-uloga-"+(i+1)));
            writer.write("\n\r");
            writer.write("LinkedIn: " + request.getParameter("clan-linkedin-"+(i+1)));
            writer.write("\n\r");
            writer.write("*===============================================*");
            writer.write("\n\r");
        }

        writer.close();

        request.getSession().removeAttribute("kontaktMejl");
        request.getSession().removeAttribute("kontaktTelefon");
        request.getSession().removeAttribute("motoTima");
        request.getSession().removeAttribute("saznanjeZaHakaton");
        request.getSession().removeAttribute("brojClanova");

        request.getSession().setAttribute("prijavljen", "DA");

        response.sendRedirect("hvala-na-prijavi.jsp");
    }

}
