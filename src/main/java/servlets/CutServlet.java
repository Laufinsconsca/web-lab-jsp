package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CutStringResponse;
import service.StringService;
import service.impl.CutStringServiceImpl;

import java.io.IOException;

@WebServlet("/result.html")
public class CutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringService stringService = new CutStringServiceImpl();
        CutStringResponse cutStringResponse = stringService.perform(
                req.getParameter("inputString"),
                Integer.parseInt(req.getParameter("cutLength")));
        req.getSession().setAttribute("cutStringResponse", cutStringResponse);
        getServletContext().getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
