package filtros;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FiltroAutenticacion implements Filter {

    private FilterConfig filterConfig = null;

    // Lista de rutas privadas (corregidas)
    private static final String[] urlPrivadas = {
        "/jsp/crearPublicacionJSP.jsp"};

    // Constructor
    public FiltroAutenticacion() {
    }

    // Método para verificar si el usuario está logueado
    private boolean estaLogueado(HttpServletRequest httpRequest) {
        HttpSession sesion = httpRequest.getSession(false);
        return sesion != null && sesion.getAttribute("usuario") != null;
    }

    // Método para verificar si la URL solicitada es pública
    private boolean esUrlPublica(String ruta) {
        // Se consideran privadas las URLs dentro de la lista
        for (String url : urlPrivadas) {
            if (ruta.equals(url)) {
                return false; // Coincide con una ruta privada
            }
        }
        return true; // Si no coincide con ninguna ruta privada, es pública
    }

    // Método para obtener la ruta solicitada
    private String getRutaSolicitada(HttpServletRequest httpRequest) {
        String uriSolicitada = httpRequest.getRequestURI();
        return uriSolicitada.substring(httpRequest.getContextPath().length());
    }

    // Método para identificar recursos estáticos
    private boolean esRecursoEstatico(String ruta) {
        return ruta.startsWith("/styles/") || ruta.startsWith("/img/") || ruta.endsWith(".css") || ruta.endsWith(".js");
    }

    private boolean esPaginaDeError(String ruta) {
        return ruta.contains("/errores/NoAutorizado.jsp") || ruta.contains("/errores/JavaError.jsp");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String ruta = this.getRutaSolicitada(httpRequest);

        // Ignorar recursos estáticos
        if (esRecursoEstatico(ruta)) {
            chain.doFilter(request, response);
            return;
        }

        // Si la página solicitada es una página de error, no hacemos más redirecciones
        if (esPaginaDeError(ruta)) {
            chain.doFilter(request, response);
            return;
        }

        boolean urlPublica = this.esUrlPublica(ruta);
        boolean logueado = this.estaLogueado(httpRequest);

        if (!logueado && !urlPublica) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/errores/NoAutorizado.jsp");
        } else {
            chain.doFilter(request, response); // Continuar con la cadena de filtros
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }
}
