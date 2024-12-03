/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.io.BufferedReader;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
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
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write("{\"status\": \"success\"}");
        out.flush();;

        try {
            // Verificar que el usuario esté logueado
            UsuarioNormal usuario = (UsuarioNormal) request.getSession().getAttribute("usuario");
            if (usuario == null) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.getWriter().write("{\"error\": \"Debe estar logueado para comentar.\"}");
                return;
            }

            // Leer el cuerpo de la solicitud (JSON)
            StringBuilder sb = new StringBuilder();
            String line;
            try ( BufferedReader reader = request.getReader()) {
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            }

            // Convertir el JSON a un objeto Java
            String requestBody = sb.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> data = objectMapper.readValue(requestBody, Map.class);

            String contenido = data.get("contenido");
            String postIdParam = data.get("postId");

            if (contenido == null || contenido.trim().isEmpty() || postIdParam == null) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\": \"Contenido o ID del post inválido.\"}");
                return;
            }

            Long postId = Long.parseLong(postIdParam);

            // Buscar el post
            PostComun post = fachada.obtenerPostComunPorId(postId);

            // Crear el nuevo comentario
            Comentario comentario = new Comentario(Calendar.getInstance(), contenido, post, usuario);
            fachada.registrarComentario(comentario);

            // Responder con un JSON que confirme el éxito
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("{\"message\": \"Comentario registrado exitosamente.\"}");

        } catch (Exception ex) {
            Logger.getLogger(SvComentar.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Ocurrió un error al registrar el comentario.\"}");
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
