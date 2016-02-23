package bll;

import dao.HibernateUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.Operacion;
import java.io.PrintWriter;
import pojo.Persona;
import pojo.Direccion;
import org.hibernate.SessionFactory;

public class controladorModificarPersona2 extends HttpServlet {

    private SessionFactory conexion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession();
        Operacion operacion = new Operacion();
        Persona persona = (Persona) sesion.getAttribute("persona");
        String nombre = request.getParameter("nombre").toUpperCase().trim();
        String apellidos = request.getParameter("apellidos").toUpperCase().trim();
        String telefono = request.getParameter("telefono").toUpperCase().trim();
        String calle = request.getParameter("calle").toUpperCase().trim();
        int numero = Integer.parseInt(request.getParameter("numero").trim());
        int piso = Integer.parseInt(request.getParameter("piso").trim());
        char letra = request.getParameter("letra").toUpperCase().trim().toCharArray()[0];
        String mensaje;

        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        persona.setTelefono(telefono);
        persona.getDireccion().setCalle(calle);
        persona.getDireccion().setNumero(numero);
        persona.getDireccion().setPiso(piso);
        persona.getDireccion().setLetra(letra);
        mensaje = operacion.modificarPersona(conexion, persona);
        sesion.setAttribute("mensaje", mensaje);
        response.sendRedirect("vista/mensaje.jsp");
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
