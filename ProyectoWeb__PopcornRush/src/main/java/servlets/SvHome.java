/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import entidades.Post;
import entidades.PostAnclado;
import entidades.PostComun;
import fachada.FachadaDominio;
import fachada.IFachadaDominio;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.util.List;

/**
 *
 * @author gilbert
 */
@WebServlet(name = "SvHome", urlPatterns = {"/SvHome"})
public class SvHome extends HttpServlet {

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
        
         try {
            IFachadaDominio fachada = new FachadaDominio();
            List<PostComun> postsComunes = fachada.obtenerPostsComunes();
            List<PostAnclado> postsAnclados = fachada.obtenerPostsAnclados();
            
            System.out.println("Number of common posts retrieved: " + postsComunes.size());
            System.out.println("Number of pinned posts retrieved: " + postsAnclados.size());
                
            request.setAttribute("postsComunes", postsComunes);
            request.setAttribute("postsAnclados", postsAnclados);
            request.getRequestDispatcher("jsp/homeJSP.jsp").forward(request, response);
        
         } catch (Exception e) {
            System.out.println("Tronó el asunto");
            throw new Error(e   );
        }
        
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
