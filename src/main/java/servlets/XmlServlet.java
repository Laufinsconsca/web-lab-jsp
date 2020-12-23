package servlets;

import model.CutStringResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
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

