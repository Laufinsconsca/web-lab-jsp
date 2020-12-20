package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
import model.CutStringRequest;
import model.CutStringResponse;
import service.StringService;
import service.impl.CutStringServiceImpl;

import java.io.IOException;

@WebServlet(name = "СutServlet", urlPatterns = "/result.html")
public class CutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringService stringService = new CutStringServiceImpl();
        CutStringRequest cutStringRequest = (CutStringRequest) req.getSession().getAttribute("stringRequest");
        CutStringResponse cutStringResponse = stringService.performCutString(cutStringRequest);
        req.getSession().setAttribute("cutStringResponse", cutStringResponse);
        getServletContext().getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
