/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import dao.NotasDAO;
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
@WebServlet(name = "eliminarnotaController", urlPatterns = {"/eliminarnotaController"})
public class eliminarnotaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int idUser = Integer.parseInt(req.getParameter("id"));
        int idNotas = Integer.parseInt(req.getParameter("idnotas"));
        if (NotasDAO.deleteNota(idUser, idNotas) == 1) {
            resp.setContentType("text/html");
            PrintWriter hola = resp.getWriter();
            hola.print("Se consiguio eliminar");
            req.getRequestDispatcher​("menu.jsp").forward(req, resp);

        } else {

        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
         HttpSession session = req.getSession();
        int idUser = Integer.parseInt(req.getParameter("iduser"));;
        int idNotas = Integer.parseInt(req.getParameter("idnote"));
        if (NotasDAO.deleteNota(idUser, idNotas) == 1) {
            resp.setContentType("text/html");
            PrintWriter hola = resp.getWriter();
            hola.print("Se consiguio eliminar");
             NotasDAO.getNotas(idUser);
             List<Notas> notas = NotasDAO.sendNotas();
             req.setAttribute("notas", notas);
            req.getRequestDispatcher​("menu.jsp").forward(req, resp);

        } else {
            
        }
    }

    private void eliminar(HttpServletRequest req, HttpServletResponse resp) 
        throws ServletException, IOException{
               int idUser=Integer.parseInt(req.getParameter("id"));
        int idNotas=Integer.parseInt(req.getParameter("idnotas"));
        if(NotasDAO.deleteNota(idUser, idNotas)==1){
             resp.setContentType("text/html");
            PrintWriter hola = resp.getWriter();
            hola.print("Se consiguio eliminar");
            req.getRequestDispatcher​("menu.jsp").forward(req, resp);
            
        }
        else{
            
        }
    }

    private void refrescar(HttpServletRequest req, HttpServletResponse resp) 
        throws ServletException, IOException{
        int idUser=Integer.parseInt(req.getParameter("id"));
        NotasDAO.getNotas(idUser);
        List<Notas> notas = NotasDAO.sendNotas();
        req.setAttribute("notas", notas);
        req.getRequestDispatcher​("menu.jsp").forward(req, resp);
        
    }

}
