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
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.Part;
import java.util.HashSet;
import models.User;
import org.json.JSONArray;
import org.json.JSONObject;
import utilis.FileUtilis;

/**
 *
 * @author Morgan
 */
@MultipartConfig(maxFileSize = 1000 * 1000 * 5, maxRequestSize = 1000 * 1000 * 25, fileSizeThreshold = 1000 * 1000)
@WebServlet(name = "editarUsuarioController", urlPatterns = {"/editarUsuarioController"})
public class editarUsuarioController extends HttpServlet {

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
            out.println("<title>Servlet editarUsuarioController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editarUsuarioController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
       HttpSession session = req.getSession();
       int iduser=(int)session.getAttribute("ID User");
       String nombre=req.getParameter("nombre");
       String apellido=req.getParameter("apellido");
       String email=req.getParameter("email");
       String password=req.getParameter("password");
       String fecha=req.getParameter("fecha");
       Part file = req.getPart("foto");
       String pathBase=null;
        String fullPath=null;
       if(file.getContentType()!=null){
           String nameImage = file.getName() + System.currentTimeMillis() + FileUtilis.GetExtension(file.getContentType());
           String path = req.getServletContext().getRealPath("");
           fullPath = path + FileUtilis.RUTE_USER_IMAGE + "/" + nameImage;
           pathBase = FileUtilis.RUTE_USER_IMAGE + "/" + nameImage;
       }
       //pathBase =(String)session.getAttribute("profile-pic");
       User user = new User(iduser, nombre, apellido, email, password, pathBase, fecha);
       if(UserDAO.updateUser(user)==1){
            file.write(fullPath);
            resp.setContentType("text/html");
            PrintWriter hola = resp.getWriter();
            hola.print("Se consiguio updatear"); 
            req.getRequestDispatcher​("profile.jsp").forward(req, resp);
       }
       else{
       
       }
       
       
    }
}
