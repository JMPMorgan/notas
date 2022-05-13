/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import dao.NotasDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.HashSet;
import jakarta.servlet.RequestDispatcher;
import java.util.List;
import models.Notas;
import models.User;
import org.json.JSONObject;

/**
 *
 * @author Morgan
 */
@WebServlet(name = "logInController", urlPatterns = {"/logInController"})
public class logInController extends HttpServlet {

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
        PrintWriter out =response.getWriter();
        try{
            String operacion=request.getParameter("op");
            switch(operacion){
                case "mostrar":
                    mostrar(request,response);
                    break;
            }
        }
        finally{
            out.close();
        }
        
        
    }
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
         PrintWriter out = resp.getWriter();
           String operacion = req.getParameter("op");
           if(operacion!=null){
               if (operacion.equals("editar")) {
                   editar(req, resp);
                   operacion=null;
                   return;
               }
               else if(operacion.equals("refrescar")){
                   refrescar(req,resp);
                    operacion=null;
                   return;
               }
               else if(operacion.equals("eliminar")){
                   eliminar(req,resp);
                   operacion=null;
                   return;
               }
               else if(operacion.equals("notas")){
                   notas(req,resp);
                   operacion=null;
                   return;
               }
               else if(operacion.equals("cerrar")){
                   cerrar(req,resp);
                   operacion=null;
                   return;
               }
           }
           else {
               
               
               
                 String username = req.getParameter("username");
                 String password = req.getParameter("password");
                 User user = new User(username, password);
                 User result = UserDAO.logInUser(user);
                 //loginusuario
                 if (result != null) {
                     HttpSession session = req.getSession();
                     session.setAttribute("Username", result.getUsername());
                     session.setAttribute("ID User", result.getID());
                     //Puse getPassword por que tenia otro constructor que mandaba 
                     //lo mismos 3 parametros y como  me di flojera
                     //cambiarlo o buscar otra forma                     
                     session.setAttribute("profile-pic",result.getPassword());
                     int ID = result.getID();
                     NotasDAO.getNotas(ID);
                     List<Notas> notas = NotasDAO.sendNotas();
                     req.setAttribute("notas", notas);
                
                     req.getRequestDispatcher​("menu.jsp").forward(req, resp);
                 } else {
                     resp.sendRedirect("index.jsp");
                 }
                 
                 
                 
          }

    }
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       PrintWriter out = resp.getWriter();
       String operacion=null;
       try {
           operacion = req.getParameter("op");
           switch (operacion) {
               case "mostrar":
                   mostrar(req, resp);
                   break;
           }

       } finally {

           out.close();
       }
    }

    private void mostrar(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException{
        PrintWriter out =resp.getWriter();
        int idUser=Integer.parseInt(req.getParameter("id"));
        int idNotas=Integer.parseInt(req.getParameter("idnotas"));
        Notas nota=NotasDAO.getNota(idUser, idNotas);
        JSONObject json= new JSONObject();
        json.put("titulo",nota.getTituloNota());
        json.put("hastag", nota.getHastagNota());
        json.put("texto",nota.getTextoNota());
        json.put("fecha_creacion",nota.getFechaCreacion());
        json.put("id_nota",nota.getIdNota());
        json.put("id_usuario",nota.getIdUsuario());
        out.print(json);
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
        //req.getRequestDispatcher​("menu.jsp").forward(req, resp);
          resp.sendRedirect("menu.jsp");
       
    }
    
    private void notas(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        HttpSession session = req.getSession();
        int iduser= (int)session.getAttribute("ID User");
        resp.sendRedirect("notas-busqueda.jsp");
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

    private void cerrar(HttpServletRequest req, HttpServletResponse resp) 
        throws ServletException, IOException{
         HttpSession sesion = req.getSession();
        sesion.setAttribute("ID User", null);
        sesion.setAttribute("Username", null);
        sesion.setAttribute("profile-pic",null);
        sesion.setAttribute("nota-busqueda",null);
        req.setAttribute("notas",null);
        sesion.invalidate();
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    

    

}
