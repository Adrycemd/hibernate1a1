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

public class controladorAltaPersona extends HttpServlet {

    private SessionFactory conexion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession();
        Operacion operacion = new Operacion();
        String dni = request.getParameter("dni").toUpperCase().trim();
        String nombre = request.getParameter("nombre").toUpperCase().trim();
        String apellidos = request.getParameter("apellidos").toUpperCase().trim();
        String telefono = request.getParameter("telefono").toUpperCase().trim();
        String calle = request.getParameter("calle").toUpperCase().trim();
        int numero = Integer.parseInt(request.getParameter("numero").trim());
        int piso = Integer.parseInt(request.getParameter("piso").trim());
        char letra = request.getParameter("letra").toUpperCase().trim().toCharArray()[0];
        Persona persona = new Persona(new Direccion(calle, numero, piso, letra), dni, nombre, apellidos, telefono);
        String mensaje;

//        if (operacion.existePersona(conexion, persona)) {
//            mensaje = "La persona ya existe en el sistema.";
//            sesion.setAttribute("mensaje", mensaje);
//            response.sendRedirect("vista/mensaje.jsp");
//        } else {
//            mensaje = operacion.altaPersona(conexion, persona);
//            sesion.setAttribute("mensaje", mensaje);
//            response.sendRedirect("vista/mensaje.jsp");
//        }
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