package api;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vulcan
 */
@WebServlet(name = "ServerServlet", urlPatterns = {"/api/server/*"})
public class ServerServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getRequestURI().endsWith("/api/server/date.html")){
            processHtmlRequest(request, response);
            
        } else if(request.getRequestURI().endsWith("/api/server/date.xml")){
            processXmlRequest(request, response);
            
        } else if(request.getRequestURI().endsWith("/api/server/date.json")) {
            processJsonRequest(request, response);
            
        } else {
            response.setStatus(404);
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().println("URL inválida!");
        }
    }

    
    protected void processHtmlRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;character=UTF-8");
        response.getWriter().println("<html>");
        response.getWriter().println("<header>");
        response.getWriter().println("<title>Date - Server API</title>");
        response.getWriter().println("</header>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Server API</h1>");
        response.getWriter().println("<h2>Date</h2>");
        response.getWriter().println("<h3>"+new java.util.Date()+"</h3>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
    
    protected void processJsonRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;character=UTF-8");
        response.getWriter().println("{");
        response.getWriter().println("\"server\": {");
        response.getWriter().println("\"date\": \""+new java.util.Date()+"\"");
        response.getWriter().println("}");
        response.getWriter().println("}");
    }
    
    
    protected void processXmlRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/xml;charset=UTF-8");
        response.getWriter().println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
        response.getWriter().println("<server>");
        response.getWriter().println("<date>");
        response.getWriter().println(new java.util.Date());
        response.getWriter().println("</date>");
        response.getWriter().println("</server>");
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
