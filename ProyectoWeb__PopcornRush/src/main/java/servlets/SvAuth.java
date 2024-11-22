/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cocob
 */
@WebServlet(name = "SvAuth", urlPatterns = {"/SvAuth"})
public class SvAuth extends HttpServlet {
    
    // Simula datos de autenticación para prueba
    private final String USER_EMAIL = "usuario@example.com";
    private final String USER_PASSWORD = "123456";
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        // Obtén los datos del formulario
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if (email.equals(USER_EMAIL) && password.equals(USER_PASSWORD)) {
            // Redirige al usuario a la página principal si las credenciales son correctas
            response.sendRedirect("home.html");
        } else {
            // Si las credenciales son incorrectas, muestra un mensaje de error
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head><title>Error de autenticación</title></head>");
            out.println("<body>");
            out.println("<h1>Usuario o contraseña incorrectos</h1>");
            out.println("<a href=\"login.html\">Intentar de nuevo</a>");
            out.println("</body>");
            out.println("</html>");
        }
    
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
