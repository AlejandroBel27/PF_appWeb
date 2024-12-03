/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import entidades.Administrador;
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
import java.util.stream.Collectors;
import org.json.JSONObject;

/**
 *
 * @author PERSONAL
 */
public class SvFijarPost extends HttpServlet {

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

        // Lee el JSON del cuerpo de la solicitud
        String jsonBody = request.getReader().lines().collect(Collectors.joining());
        JSONObject json = new JSONObject(jsonBody);
        int postId = json.getInt("postId");

        // Aquí manejas la lógica de fijar la publicación (ej. actualizar DB)
        boolean success = false;
        try {
            PostComun pc = fachada.obtenerPostComunPorId(postId);
            PostAnclado anclado = new PostAnclado(pc.getFechaHoraCreacion(),
                    pc.getTitulo(), pc.getContenido(), pc.getFechaHoraEdicion(),
                    pc.getGenero(), pc.getImagen(), pc.getCalificacion());
            // Obtener el objeto Administrador desde la sesión
            Administrador administrador = (Administrador) request.getSession().getAttribute("usuario");

            if (administrador != null) {
                // Asignar el objeto Administrador al post anclado
                anclado.setAdministrador(administrador); // Asignamos el objeto Administrador
            }
            fachada.registrarPostAnclado(anclado); // Actualiza en la base de datos
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Responde con JSON indicando el resultado
        response.setContentType("application/json");
        response.getWriter().write("{\"success\":" + success + "}");
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
