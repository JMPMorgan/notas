/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.HashSet;
import jakarta.servlet.RequestDispatcher;
import models.User;
import org.json.JSONObject;

/**
 *
 * @author Morgan
 */
@WebServlet(name = "profileController", urlPatterns = {"/profileController"})
public class profileController extends HttpServlet {

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
            out.println("<title>Servlet profileController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet profileController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        int iduser = (int) session.getAttribute("ID User");
        User result = UserDAO.getInfoUsuario(iduser);
        if (result != null) {
            JSONObject json = new JSONObject();
            json.put("nombre", result.getName());
            json.put("apellido", result.getLastname());
            json.put("fecha", result.getFecha());
            json.put("email", result.getEmail());
            json.put("password", result.getPassword());
            json.put("imagen", result.getImagen());
            json.put("user",result.getUsername());
            out.print(json);
            
        }
        
    }

    

}
