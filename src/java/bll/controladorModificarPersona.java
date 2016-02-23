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
import org.hibernate.SessionFactory;

public class controladorModificarPersona extends HttpServlet {

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
            persona = operacion.damePersona(conexion, persona);
            sesion.setAttribute("persona", persona);
            response.sendRedirect("vista/modificar2.jsp");
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
        return "Encargado de subir los datos de la persona a sesión para su modificación posterior.";
    }

}
