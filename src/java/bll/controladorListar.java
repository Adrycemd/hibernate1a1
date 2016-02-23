package bll;

import dao.HibernateUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.Operacion;
import java.util.ArrayList;
import org.hibernate.SessionFactory;
import pojo.Persona;

public class controladorListar extends HttpServlet {

    private SessionFactory conexion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession();
        Operacion operacion = new Operacion();
        ArrayList<Persona> personas;

        personas = operacion.damePersonas(conexion);
        if (personas.size() > 0) {
            sesion.setAttribute("personas", personas);
            response.sendRedirect("vista/listar.jsp");
        }else{
            sesion.setAttribute("mensaje", "No hay Personas almacenadas en el sistema.");
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
        return "Encargado de recuperar las personas y mandarlas a la vista.";
    }

}
