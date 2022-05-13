/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import dao.NotasDAO;
import dao.UserDAO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.HashSet;
import jakarta.servlet.RequestDispatcher;
import java.util.List;
import models.Notas;

/**
 *
 * @author Morgan
 */
@WebServlet(name = "menuController", urlPatterns = {"/menuController"})
public class menuController extends HttpServlet {

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
            out.println("<title>Servlet menuController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet menuController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String tituloNota = req.getParameter("titulo");
        String hastagNota = req.getParameter("hastag");
        String textoNota= req.getParameter("textonota");
        int iduser=Integer.parseInt(req.getParameter("id-user"));
        //int ID= (int)req.getAttribute("ID User");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String fecha=dtf.format(LocalDateTime.now());
        int notaborrada=0;
        Notas nota = new Notas(hastagNota, tituloNota, fecha, notaborrada, textoNota, iduser,0);
        if(NotasDAO.insertNota(nota)==1){
             NotasDAO.getNotas(iduser);
             List<Notas> notas = NotasDAO.sendNotas();
             req.setAttribute("notas", notas);
             req.getRequestDispatcher​("menu.jsp").forward(req, resp);
            
        }
        else{
            
        }
 //To change body of generated methods, choose Tools | Templates.
    }
    

}
