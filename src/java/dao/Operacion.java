package dao;

import java.util.ArrayList;
import java.util.Iterator;
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
            List lista;

            transaccion = sesion.beginTransaction();
            consulta = sesion.createQuery("FROM Persona WHERE DNI = :persona_dni");
            consulta.setParameter("persona_dni", persona.getDni());
            lista = consulta.list();
            transaccion.commit();
            return lista.iterator().hasNext();
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
            return e.getMessage();
        }
    }

    public String bajaPersona(SessionFactory conexion, Persona persona) {
        Session sesion = conexion.openSession();
        Transaction transaccion = null;

        try {
            Query consulta;
            List lista;

            transaccion = sesion.beginTransaction();
            consulta = sesion.createQuery("FROM Persona WHERE DNI = :persona_dni");
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
            return e.getMessage();
        }
    }

    public Persona damePersona(SessionFactory conexion, Persona persona) {
        Session sesion = conexion.openSession();
        Transaction transaccion = null;

        try {
            Query consulta;
            List lista;

            transaccion = sesion.beginTransaction();
            consulta = sesion.createQuery("FROM Persona WHERE DNI = :persona_dni");
            consulta.setParameter("persona_dni", persona.getDni());
            lista = consulta.list();
            transaccion.commit();
            
            Persona personaRetornable = (Persona) lista.iterator().next();
            
            return personaRetornable;
        } catch (HibernateException e) {
            if (transaccion != null) {
                transaccion.rollback();
            }
            return null;
        }
    }
    
    public String modificarPersona (SessionFactory conexion, Persona persona) {
        Session sesion = conexion.openSession();
        Transaction transaccion = null;
        Persona personaModificable = (Persona) sesion.merge(persona);
        
        try {
            transaccion = sesion.beginTransaction();
            sesion.update(personaModificable);
            transaccion.commit();
            return "Persona modificada con éxito";
        } catch (HibernateException e) {
            if (transaccion != null) {
                transaccion.rollback();
            }
            return e.getMessage();
        }
    }
    
    public ArrayList<Persona> damePersonas (SessionFactory conexion) {
        Session sesion = conexion.openSession();
        Transaction transaccion = null;
        ArrayList<Persona> personas = new ArrayList<>();
                
        try {
            Query consulta;
            List lista;

            transaccion = sesion.beginTransaction();
            consulta = sesion.createQuery("FROM Persona");
            lista = consulta.list();
            
            Iterator iterador = lista.iterator();
            
            while(iterador.hasNext()){
                personas.add((Persona) iterador.next());
            }
            transaccion.commit();
        } catch (HibernateException e) {
            if (transaccion != null) {
                transaccion.rollback();
            }
        }
        return personas;
    }

}
