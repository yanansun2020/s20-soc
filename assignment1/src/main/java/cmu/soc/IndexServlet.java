package cmu.soc;

import cmu.soc.service.PublicationService;
import cmu.soc.service.PublicationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/buildIndex")
public class IndexServlet extends HttpServlet {
    private PublicationService publicationService = new PublicationServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Integer result = publicationService.buildLucenceIndex();
        if(result == 0 ){
            out.println("<h3>Exception caught, try again.</h3>");
        }
        if(result == -1 ){
            out.println("<h3>publication is empty, please load your data.</h3>");
        }
        if(result == 1 ){
            out.println("<h3>Index create success.</h3>");
        }
    }
}
