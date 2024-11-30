/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import entidades.Administrador;
import entidades.Estado;
import entidades.Municipio;
import static entidades.PostComun_.usuario;
import entidades.UsuarioNormal;
import excepciones.ExcepcionAT;
import fachada.FachadaDominio;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author PERSONAL
 */
@MultipartConfig // Habilitar la carga de archivos
public class IniciarSesion extends HttpServlet {

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
        // Instanciar la fachada para interactuar con la capa de dominio
        FachadaDominio fD = new FachadaDominio();

        // Recuperar datos del formulario
        String correo = request.getParameter("email");
        String contrasenia = request.getParameter("password");

        try {
            // Verificar si es un UsuarioNormal
            UsuarioNormal usuarioNormal = fD.obtenerUsuarioNormal(correo, contrasenia);

            if (usuarioNormal != null) {
                // UsuarioNormal encontrado
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuarioNormal);
                session.setAttribute("tipoUsuario", "UsuarioNormal");
                System.out.println("UsuarioNormal encontrado: " + usuarioNormal.getNombreCompleto());

                // Redirigir a la página de inicio para usuarios normales
                response.sendRedirect("${pageContext.request.contextPath}/Home");
                return;
            }

            // Si no es UsuarioNormal, verificar si es un Administrador
            Administrador administrador = fD.obtenerAdministrador(correo, contrasenia);

            if (administrador != null) {
                // Administrador encontrado
                HttpSession session = request.getSession();
                session.setAttribute("usuario", administrador);
                session.setAttribute("tipoUsuario", "Administrador");
                System.out.println("Administrador encontrado: " + administrador.getNombreCompleto());

                // Redirigir a la página de inicio para administradores
                response.sendRedirect("${pageContext.request.contextPath}/Home");
                return;
            }

            // Si no es ninguno de los dos, mostrar mensaje de error en login
            System.out.println("Usuario no encontrado en la base de datos.");
            request.setAttribute("error", "Correo o contraseña incorrectos.");
            request.getRequestDispatcher("jsp/loginJSP.jsp").forward(request, response);

        } catch (ExcepcionAT ex) {
            // Manejar errores en la base de datos u otras excepciones
            Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("errores/JavaError.jsp").forward(request, response);
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
