package cmu.soc;

import cmu.soc.dao.entity.Publication;
import cmu.soc.service.PublicationService;
import cmu.soc.service.PublicationServiceImpl;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/spatialSearch")
public class SpatialSearchServlet extends HttpServlet {
    private PublicationService publicationService = new PublicationServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keywords");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if(StringUtils.isEmpty(keyword)){
            out.println("<h3>Please type in keyword</h3>");
            return;
        }
        String yearFrom = request.getParameter("yearFrom");
        if(StringUtils.isEmpty(yearFrom)){
            out.println("<h3>Please type in year from.</h3>");
            return;
        }
        String yearTo = request.getParameter("yearTo");
        if(StringUtils.isEmpty(yearTo)){
            out.println("<h3>Please type in year to.</h3>");
            return;
        }
        String skip = request.getParameter("skip");
        if(StringUtils.isEmpty(skip)){
            out.println("<h3>Please type in skip</h3>");
            return;
        }
        String numReturn = request.getParameter("numReturn");
        if(StringUtils.isEmpty(numReturn)){
            out.println("<h3>Please type in numReturn</h3>");
            return;
        }
        List<Publication> publicationList = publicationService.spacialSearch(keyword, yearFrom, yearTo, Integer.parseInt(skip), Integer.parseInt(numReturn));
        out.println(new Gson().toJson(publicationList));
    }
}
