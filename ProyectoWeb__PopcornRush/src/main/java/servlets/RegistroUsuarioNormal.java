/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import entidades.Estado;
import entidades.Municipio;
import entidades.UsuarioNormal;
import excepciones.ExcepcionAT;
import fachada.FachadaDominio;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PERSONAL
 */
public class RegistroUsuarioNormal extends HttpServlet {

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
            out.println("<title>Servlet RegistroUsuarioNormal</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistroUsuarioNormal at " + request.getContextPath() + "</h1>");
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
        FachadaDominio fD = new FachadaDominio();
        // Recuperar datos del formulario
        String nombreCompleto = request.getParameter("name");
        String correo = request.getParameter("email");
        String contrasenia = request.getParameter("password");
        String telefono = request.getParameter("phone");
        String ciudad = request.getParameter("city");
        String fechaNacimientoStr = request.getParameter("birthdate");
        String genero = request.getParameter("gender");
        String nombreEstado = request.getParameter("state");
        String nombreMunicipio = request.getParameter("municipality");

        // Obtener la imagen (archivo subido)
        Part filePart = request.getPart("avatar");
        String fileName = filePart.getSubmittedFileName();

        // Ruta para guardar la imagen
        String uploadPath = getServletContext().getRealPath("") + File.separator + "userImgs";

        // Crear la carpeta si no existe
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Generar un nombre único para evitar sobrescribir archivos
        String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;

        // Guardar la imagen en la carpeta
        String filePath = uploadPath + File.separator + uniqueFileName;
        filePart.write(filePath);

        // Guardar la ruta relativa (para almacenar en el atributo avatar)
        String relativePath = "userImgs/" + uniqueFileName;

        // Parsear fecha de nacimiento
        Calendar fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.setTime(java.sql.Date.valueOf(fechaNacimientoStr)); // Convertir a tipo Date

        // Crear el objeto Estado
        Estado estado = new Estado(nombreEstado);

        // Crear el objeto Municipio y asociarlo con el estado
        Municipio municipio = new Municipio();
        municipio.setNombre(nombreMunicipio);
        municipio.setEstado(estado);

        // Añadir el municipio al estado
        estado.añadirMunicipios(municipio);

        // Crear el objeto UsuarioNormal
        UsuarioNormal usuarioNormal = new UsuarioNormal(
                nombreCompleto,
                correo,
                contrasenia,
                telefono,
                relativePath,
                ciudad,
                fechaNacimiento,
                genero,
                municipio
        );

        try {
            // Registrar al usuario normal (junto con estado y municipio)
            fD.registrarEstado(estado); // Persiste el estado con los municipios asociados
        } catch (ExcepcionAT ex) {
            Logger.getLogger(RegistroUsuarioNormal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fD.registrarUsuarioNormal(usuarioNormal); // Persiste el usuario
        } catch (ExcepcionAT ex) {
            Logger.getLogger(RegistroUsuarioNormal.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Redirigir a una página de éxito
        response.sendRedirect("home.html");
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
