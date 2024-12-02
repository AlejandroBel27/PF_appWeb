/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import entidades.Comentario;
import entidades.PostComun;
import entidades.UsuarioNormal;
import excepciones.ExcepcionAT;
import fachada.FachadaDominio;
import fachada.IFachadaDominio;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PERSONAL
 */
public class SvComentar extends HttpServlet {

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
        IFachadaDominio fachada = new FachadaDominio();
        try {
            // Obtener el ID del post desde los parámetros
            String postIdParam = request.getParameter("postId");
            if (postIdParam == null) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El ID del post es requerido.");
                return;
            }

            try {
                // Obtener el post desde la fachada (o directamente desde el parámetro)
                Long postId = Long.parseLong(request.getParameter("postId"));
                PostComun post = fachada.obtenerPostComunPorId(postId);

                // Obtener los comentarios relacionados al post
                List<Comentario> comentarios = fachada.obtenerComentariosPorPost(post);

                // Pasar datos al JSP
                request.setAttribute("post", post);
                request.setAttribute("comentarios", comentarios);
                request.getRequestDispatcher("/jsp/postJSP.jsp").forward(request, response);
            } catch (ExcepcionAT e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener los comentarios del post.");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El ID del post debe ser un número válido.");
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
        IFachadaDominio fachada = new FachadaDominio();
        try {
            // Verificar que el usuario esté logueado
            UsuarioNormal usuario = (UsuarioNormal) request.getSession().getAttribute("usuario");
            if (usuario == null) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Debe estar logueado para comentar.");
                return;
            }

            // Obtener datos del formulario
            String contenido = request.getParameter("contenido");
            String postIdParam = request.getParameter("postId");

            if (contenido == null || contenido.trim().isEmpty() || postIdParam == null) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Contenido o ID del post inválido.");
                return;
            }

            Long postId = Long.parseLong(postIdParam);

            // Buscar el post
            PostComun post = null;
            try {
                post = fachada.obtenerPostComunPorId(postId);
            } catch (ExcepcionAT ex) {
                Logger.getLogger(SvComentar.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Crear el nuevo comentario
            Comentario comentario = new Comentario(Calendar.getInstance(), contenido, post, usuario);
            try {
                fachada.registrarComentario(comentario);
            } catch (ExcepcionAT ex) {
                Logger.getLogger(SvComentar.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Redirigir de nuevo al detalle del post
            response.sendRedirect(request.getContextPath() + "/DetallesPost?id=" + postId);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El ID del post debe ser un número válido.");
        }
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
