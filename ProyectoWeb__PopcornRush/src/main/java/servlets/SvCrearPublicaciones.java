/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import entidades.PostComun;
import entidades.Usuario;
import excepciones.ExcepcionAT;
import fachada.FachadaDominio;
import fachada.IFachadaDominio;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paco
 */
@MultipartConfig
public class SvCrearPublicaciones extends HttpServlet {

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
            out.println("<title>Servlet SvCrearPublicaciones</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvCrearPublicaciones at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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

        // Obtener el usuario de la sesión
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            // Si no hay un usuario logueado, redirigir al login
            response.sendRedirect("login.jsp");
            return;
        }

        // Recuperar datos del formulario
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        String genero = request.getParameter("genero");
        String calificacionStr = request.getParameter("calificacion");

        // Obtener la imagen
        Part filePart = request.getPart("imgPortada");
        String fileName = filePart.getSubmittedFileName();

        // Ruta para guardar la imagen
        String uploadPath = getServletContext().getRealPath("") + File.separator + "postImgs";

        // Crear la carpeta si no existe
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Generar un nombre único para la imagen
        String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;

        // Guardar la imagen en la carpeta
        String filePath = uploadPath + File.separator + uniqueFileName;
        filePart.write(filePath);

        // Guardar la ruta relativa para almacenar en la base de datos
        String imagen = "postImgs/" + uniqueFileName;

        // Obtener la fecha y hora actuales para fechaHoraCreacion y fechaHoraEdicion
        Calendar fechaHoraCreacion = Calendar.getInstance();
        Calendar fechaHoraEdicion = Calendar.getInstance();

        // Parsear calificación
        Integer calificacion = null;
        if (calificacionStr != null && !calificacionStr.isEmpty()) {
            calificacion = Integer.parseInt(calificacionStr);
        }

        // Crear el objeto PostComun
        PostComun postComun = new PostComun(
            usuario,
            fechaHoraCreacion,
            titulo,
            contenido,
            fechaHoraEdicion
        );
        postComun.setGenero(genero);
        postComun.setImagen(imagen);
        postComun.setCalificacion(calificacion);

        try {
            // Registrar la publicación usando la fachada
            fachada.registrarPostComun(postComun);

            // Redirigir a la página de éxito
            session.setAttribute("post", postComun);
            response.sendRedirect("jsp/homeJSP.jsp");
        } catch (ExcepcionAT ex) {
            Logger.getLogger(SvCrearPublicaciones.class.getName()).log(Level.SEVERE, null, ex);
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
