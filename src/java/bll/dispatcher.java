package bll;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.HibernateUtil;
import dao.Operacion;
import java.io.PrintWriter;
import org.hibernate.SessionFactory;

public class dispatcher extends HttpServlet {

    private SessionFactory conexion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession();
        String boton = request.getParameter("boton").trim();
        Operacion operacion = new Operacion();

        ServletContext sc = getServletContext();
        RequestDispatcher rd;

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("<p>Pulsado botón " + boton + "</p>");
            out.println("</body>");
            out.println("</html>");
        }

        switch (boton) {
            case "Alta":
                rd = sc.getRequestDispatcher("/controladorAlta");
                rd.forward(request, response);
                break;
            case "Baja":
                rd = sc.getRequestDispatcher("/controladorBaja");
                rd.forward(request, response);
                break;
            case "Modificar":
                rd = sc.getRequestDispatcher("/controladorModificar");
                rd.forward(request, response);
                break;
            case "Eliminar":
                rd = sc.getRequestDispatcher("/controladorEliminar");
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
        return "Encargado de redirigir request y response al controlador adecuado.";
    }

}
