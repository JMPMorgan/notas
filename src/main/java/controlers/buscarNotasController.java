/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import dao.NotasDAO;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.Part;
import java.util.List;
import models.Notas;

/**
 *
 * @author Morgan
 */
@WebServlet(name = "buscarNotasController", urlPatterns = {"/buscarNotasController"})
public class buscarNotasController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet buscarNotasController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet buscarNotasController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("notas-busqueda.jsp");
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
                HttpSession session = req.getSession();
        int idUser=(int) session.getAttribute("ID User");
        String texto = req.getParameter("texto");
        NotasDAO.busquedaNota(idUser, texto);
        List<Notas> nota= NotasDAO.sendNotaBuscador();
        session.setAttribute("nota-busqueda",nota);
        req.getRequestDispatcher("notas-busqueda.jsp").forward(req, resp);
      
    }
    

    

}
