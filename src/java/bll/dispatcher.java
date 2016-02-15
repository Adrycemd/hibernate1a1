package bll;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.HibernateUtil;
import org.hibernate.SessionFactory;

public class dispatcher extends HttpServlet {

    private SessionFactory conexion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String boton = request.getParameter("boton").trim();
        ServletContext sc = getServletContext();
        RequestDispatcher rd;

        switch (boton) {
            case "Alta":
                response.sendRedirect("vista/alta.jsp");
                break;
            case "Baja":
                response.sendRedirect("vista/baja.jsp");
                break;
            case "Modificar":
                response.sendRedirect("vista/modificar.jsp");
                break;
            case "Eliminar":
                response.sendRedirect("vista/eliminar.jsp");
                break;
            case "AltaPersona":
                rd = sc.getRequestDispatcher("/controladorAltaPersona");
                rd.forward(request, response);
                break;
            case "BajaPersona":
                rd = sc.getRequestDispatcher("/controladorBajaPersona");
                rd.forward(request, response);
                break;
            case "ModificarPersona":
                rd = sc.getRequestDispatcher("/controladorModificarPersona");
                rd.forward(request, response);
                break;
            case "EliminarPersona":
                rd = sc.getRequestDispatcher("/controladorEliminarPersona");
                rd.forward(request, response);
                break;
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
        return "Encargado de redirigir al controlador adecuado.";
    }

}