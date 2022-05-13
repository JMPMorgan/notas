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
@WebServlet(name = "editarnotaController", urlPatterns = {"/editarnotaController"})
public class editarnotaController extends HttpServlet {

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
            out.println("<title>Servlet editarnotaController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editarnotaController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
          PrintWriter out = resp.getWriter();
        int idUser = Integer.parseInt(req.getParameter("iduser"));
        int idNotas = Integer.parseInt(req.getParameter("idnota"));
        String titulo = req.getParameter("te");
        String hastag = req.getParameter("he");
        String texto = req.getParameter("tex");
        int i = NotasDAO.updateNota(idUser, idNotas, titulo, hastag, texto);
        if (i == 1) {
            resp.setContentType("text/html");
            PrintWriter hola = resp.getWriter();
            hola.print("Se consiguio editr");
            NotasDAO.getNotas(idUser);
            List<Notas> notas= NotasDAO.sendNotas();
            req.setAttribute("notas",notas);
            req.getRequestDispatcher("menu.jsp").forward(req, resp);
        } else {

        }
          // String operacion = req.getParameter("op");
          // if(operacion!=null){
              // if(operacion.equals("editar")){
              //     editar(req, resp);
                //   operacion=null;
               
              // }
             //  else if(operacion.equals("eliminar")){
             //      eliminar(req, resp);
               //    operacion=null;

              // }
              // else if(operacion.equals("refrescar")){
                //    refrescar(req,resp);
                 //   operacion=null;
              // }
               
           }
    

    private void editar(HttpServletRequest req, HttpServletResponse resp) 
        throws ServletException, IOException{
               int idUser=Integer.parseInt(req.getParameter("id"));
        int idNotas=Integer.parseInt(req.getParameter("idnotas"));
        String titulo = req.getParameter("t");
        String hastag=req.getParameter("h");
        String texto=req.getParameter("te");
        int i=NotasDAO.updateNota(idUser, idNotas, titulo, hastag, texto);
        if(i==1){
            resp.setContentType("text/html");
            PrintWriter hola = resp.getWriter();
            hola.print("Se consiguio editr");
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
    
       private void eliminar(HttpServletRequest req, HttpServletResponse resp) 
        throws ServletException, IOException{
       int idUser=Integer.parseInt(req.getParameter("id"));
        int idNotas=Integer.parseInt(req.getParameter("idnotas"));
        if(NotasDAO.deleteNota(idUser, idNotas)==1){
             resp.setContentType("text/html");
            PrintWriter hola = resp.getWriter();
            hola.print("Se consiguio eliminar");

        }
        else{
            
        }
    }
    

}
