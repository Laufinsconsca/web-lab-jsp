package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CutStringResponse;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.PrintWriter;

@WebServlet("/result.xml")
public class XmlServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/xml;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            CutStringResponse request = (CutStringResponse) req.getSession().getAttribute("cutStringResponse");
            if (request != null) {
                Marshaller marshaller = JAXBContext.newInstance(CutStringResponse.class).createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(request, out);
            } else {
                out.println("<error>error XML</error>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

