package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojo.Persona;

public class Operacion {

    public boolean existePersona(SessionFactory conexion, Persona persona) {
        Session sesion = conexion.openSession();
        Transaction transaccion = null;

        try {
            Query consulta;
            List listaVotantes;

            transaccion = sesion.beginTransaction();
            consulta = sesion.createQuery("FROM Persona WHERE DNI = :persona_dni");
            consulta.setParameter("persona_dni", persona.getDni());
            listaVotantes = consulta.list();
            transaccion.commit();
            return listaVotantes.iterator().hasNext();
        } catch (HibernateException e) {
            if (transaccion != null) {
                transaccion.rollback();
            }
            return false;
        }
    }

    public String altaPersona(SessionFactory conexion, Persona persona) {
        Session sesion = conexion.openSession();
        Transaction transaccion = null;

        try {
            transaccion = sesion.beginTransaction();
            sesion.save(persona);
            transaccion.commit();
            return "Persona dada de alta con éxito";
        } catch (HibernateException e) {
            if (transaccion != null) {
                transaccion.rollback();
            }
            return "Error al dar de alta a la persona";
        }
    }

    public String bajaPersona(SessionFactory conexion, Persona persona) {
        Session sesion = conexion.openSession();
        Transaction transaccion = null;
        try {
            Query consulta;
            List lista;

            transaccion = sesion.beginTransaction();
            consulta = sesion.createQuery("FROM persona WHERE DNI = :persona_dni");
            consulta.setParameter("persona_dni", persona.getDni());
            lista = consulta.list();

            Persona personaBorrable = (Persona) lista.iterator().next();

            sesion.delete(personaBorrable);
            transaccion.commit();
            return "Persona borrada del sistema con éxito.";

        } catch (HibernateException e) {
            if (transaccion != null) {
                transaccion.rollback();
            }
            return "Error al dar de baja a la persona.";
        }
    }

}
