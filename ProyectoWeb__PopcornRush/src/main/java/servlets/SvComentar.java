/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import apoyo.ComentarioRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
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
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            // Obtener el ID del post desde la solicitud
            String postIdParam = request.getParameter("postId");
            if (postIdParam == null || postIdParam.trim().isEmpty()) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\": \"El ID del post es requerido.\"}");
                return;
            }

            Long postId;
            try {
                postId = Long.parseLong(postIdParam);
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\": \"El ID del post debe ser un número válido.\"}");
                return;
            }

            // Crear la fachada y obtener los comentarios
            IFachadaDominio fachada = new FachadaDominio();
            List<Comentario> comentarios;
            try {
                PostComun post = fachada.obtenerPostComunPorId(postId);
                if (post == null) {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().write("{\"error\": \"Post no encontrado.\"}");
                    return;
                }
                comentarios = post.getComentarios();
            } catch (ExcepcionAT ex) {
                Logger.getLogger(SvComentar.class.getName()).log(Level.SEVERE, null, ex);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("{\"error\": \"Error al obtener los comentarios.\"}");
                return;
            }

            // Convertir los comentarios a JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonComentarios = objectMapper.writeValueAsString(comentarios);

            // Configurar la respuesta
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(jsonComentarios);

        } catch (Exception e) {
            Logger.getLogger(SvComentar.class.getName()).log(Level.SEVERE, null, e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Ocurrió un error inesperado.\"}");
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
            ComentarioRequest data = objectMapper.readValue(requestBody, ComentarioRequest.class);

            String contenido = data.getContenido();
            String postIdParam = data.getPostId();

            if (contenido == null || contenido.trim().isEmpty() || postIdParam == null) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\": \"Contenido o ID del post inválido.\"}");
                return;
            }

            Long postId = null;
            try {
                postId = Long.parseLong(postIdParam);
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\": \"El ID del post debe ser un número válido.\"}");
                return;
            }

            // Buscar el post
            PostComun post = null;
            try {
                post = fachada.obtenerPostComunPorId(postId);
            } catch (ExcepcionAT ex) {
                Logger.getLogger(SvComentar.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (post == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("{\"error\": \"Post no encontrado.\"}");
                return;
            }

            // Crear el nuevo comentario
            Comentario comentario = new Comentario(Calendar.getInstance(), contenido, post, usuario);
            try {
                fachada.registrarComentario(comentario);
            } catch (ExcepcionAT ex) {
                Logger.getLogger(SvComentar.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Responder con un JSON que confirme el éxito
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("{\"message\": \"Comentario registrado exitosamente.\"}");

        } catch (IOException ex) {
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
