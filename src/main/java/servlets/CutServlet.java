package servlets;

import model.CutStringRequest;
import model.CutStringResponse;
import service.StringService;
import service.impl.CutStringServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "СutServlet", urlPatterns = "/result.html")
public class CutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StringService stringService = new CutStringServiceImpl();
        CutStringRequest cutStringRequest = (CutStringRequest) req.getSession().getAttribute("stringRequest");
        CutStringResponse cutStringResponse = stringService.performCutString(cutStringRequest);
        req.getSession().setAttribute("cutStringResponse", cutStringResponse);
        resp.sendRedirect("result.jsp");
    }
}
