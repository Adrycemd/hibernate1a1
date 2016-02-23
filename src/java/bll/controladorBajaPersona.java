package bll;

import dao.HibernateUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.Operacion;
import pojo.Persona;
import pojo.Direccion;
import org.hibernate.SessionFactory;

public class controladorBajaPersona extends HttpServlet {

    private SessionFactory conexion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession();
        Operacion operacion = new Operacion();
        String dni = request.getParameter("dni").toUpperCase().trim();
        Persona persona = new Persona(dni);
        String mensaje;

        if (!operacion.existePersona(conexion, persona)) {
            mensaje = "La persona no existe en el sistema.";
            sesion.setAttribute("mensaje", mensaje);
            response.sendRedirect("vista/mensaje.jsp");
        } else {
            mensaje = operacion.bajaPersona(conexion, persona);
            sesion.setAttribute("mensaje", mensaje);
            response.sendRedirect("vista/mensaje.jsp");
        }
    }

    @Override
    public void init() throws ServletException {
        conexion = HibernateUtil.getSessionFactory();
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
    }

    @Override
    public String getServletInfo() {
        return "Encargado de dar de alta a la persona si no existe.";
    }

}