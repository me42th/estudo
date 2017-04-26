/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go_johnny;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(asyncSupported = false, name = "GO JOHNNY", urlPatterns = {"/me42th"},
initParams = {@WebInitParam(name="webInitParam1", value="ME"), @WebInitParam(name="webInitParam2", value="42TH")})
public class web_johnny extends HttpServlet {
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>"
                        + " <h:head>"
                            + "<title>"
                                + "MyServlet"
                            + "</title>"
                        + "</h:head>"
                        + "<h:body>"
                        +"Valor:#{testaNumero.numero}");
            out.write(getServletConfig().getInitParameter("webInitParam1"));
            out.write(getServletConfig().getInitParameter("webInitParam2"));
            out.println("</h:body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
