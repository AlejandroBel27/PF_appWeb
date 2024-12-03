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
public class SvEliminarPost extends HttpServlet {

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
            PostComun comun = fachada.obtenerPostComunPorId(postId);
            PostAnclado anclado = fachada.obtenerPostAnclado(comun.getTitulo());
            fachada.eliminarPostComun(comun); // Actualiza en la base de datos
            fachada.eliminarPostAnclado(anclado);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Ocurrió un problema con la fachada.\"}");
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
