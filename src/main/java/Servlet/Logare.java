package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "Servlet", urlPatterns = "/logare")

public class Logare extends HttpServlet {
    int dan = 11;
    int az123 = 11;
    private String name ;
    private String parola ;

    private String mockedUsername ="Dragos";
    private String mockedUsername2 ="ion";
    private String mockedPassword ="1";


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String name = request.getParameter("name");
        this.name = name;
        String parola = request.getParameter("parola");
        this.parola = parola;


        if(name.equals(mockedUsername) && parola.equals(mockedPassword)) {
            request.setAttribute("name", name);
            request.setAttribute("parola", parola);
            request.getRequestDispatcher
                    ("/Rezult.jsp").forward(request, response);
        } else {
            String message =  "username or password invalid";
            request.setAttribute("message", message);
            request.getRequestDispatcher
                    ("/index.jsp").forward(request, response);
        }

    }
}
