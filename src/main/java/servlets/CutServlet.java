package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CutStringRequest;
import model.CutStringResponse;
import service.StringService;
import service.impl.CutStringServiceImpl;

import java.io.IOException;

@WebServlet("/result.html")
public class CutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringService stringService = new CutStringServiceImpl();
        CutStringRequest cutStringRequest = (CutStringRequest) req.getSession().getAttribute("cutStringRequest");
        cutStringRequest.setInputString(req.getParameter("inputString"));
        cutStringRequest.setCutLength(Integer.parseInt(req.getParameter("cutLength")));
        CutStringResponse cutStringResponse = stringService.performCutString(cutStringRequest);
        req.getSession().setAttribute("cutStringResponse", cutStringResponse);
        getServletContext().getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
