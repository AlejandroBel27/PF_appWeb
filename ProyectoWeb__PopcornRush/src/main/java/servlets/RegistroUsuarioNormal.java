/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

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
public class RegistroUsuarioNormal extends HttpServlet {

    // Método para comprimir la imagen (ajustar tamaño)
    private BufferedImage compressImage(BufferedImage originalImage, int width, int height) {
        // Redimensionar la imagen manteniendo la relación de aspecto
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();
        return resizedImage;
    }

    // Método para convertir la imagen comprimida a Base64
    private String convertToBase64(BufferedImage image, String format) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // Convertir la imagen comprimida a JPEG (o el formato que desees)
        ImageIO.write(image, format, byteArrayOutputStream);
        byte[] imageBytes = byteArrayOutputStream.toByteArray();

        // Convertir a Base64
        return Base64.getEncoder().encodeToString(imageBytes);
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
        String avatar = "userImgs/" + uniqueFileName;

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
                avatar,
                ciudad,
                fechaNacimiento,
                genero,
                municipio
        );

        try {
            fD.registrarUsuarioNormal(usuarioNormal); // Persiste el usuario
        } catch (ExcepcionAT ex) {
            Logger.getLogger(RegistroUsuarioNormal.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Redirigir a una página de éxito
        System.out.println("registrado en base de datos");
        HttpSession session = request.getSession();
        session.setAttribute("usuario", usuarioNormal);
        response.sendRedirect("jsp/homeJSP.jsp");
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
