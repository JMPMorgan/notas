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
import models.User;

/**
 *
 * @author Morgan
 */
@WebServlet(name = "signInController", urlPatterns = {"/signInController"})
public class signInController extends HttpServlet {
    protected void processRequest(HttpServletRequest req,HttpServletResponse resp)
        throws ServletException,IOException{
       //req.getRequestDispatcher("index.jsp").forward(req,resp);
               try (PrintWriter out = resp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + req.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String name = req.getParameter("nombre");
        String password = req.getParameter("password");
        String cpassword=req.getParameter("cpassword");
        String email=req.getParameter("email");
        String username= req.getParameter("username");
        User user = new User(name, password, cpassword, email, username);
        if(UserDAO.insertUser(user)==1){
            resp.sendRedirect("index.jsp"); 
        }
        else{
            resp.sendRedirect("registro.jsp");
        }
    }
    
}
