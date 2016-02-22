package dao;

public class Operacion {

    public String altaPersona (SessionFactory conexion, Persona persona){
        String hash= BCrypt.hashpw(persona.getPassword(),BCrypt.gensalt());
        Session sesion= conexion.openSession();
        Transaction transaccion=null;
        
        try {
            transaccion =sesion.beginTransaction();
            persona.setPassword(hash);
            persona.setDadoAlta(Boolean.FALSE);
            sesion.save(persona);
            transaccion.commit();
            return "Persona dada de alta con éxito";
        }
        catch (HibernateException e){
            if(transaccion!=null){
                transaccion.rollback();
            }
            return "Error al dar de alta a la persona";
        }
    }
    
    public String bajaPersona (SessionFactory conexion, Persona persona){
        Session sesion= conexion.openSession();
        Transaction transaccion=null;
        if (loginCorrecto(conexion, persona)){
            try {
                Query consulta;
                List lista;
                
                transaccion=sesion.beginTransaction();
                consulta = sesion.createQuery ("FROM persona WHERE NIF=:persona_nif");
                consulta.setParameter("persona_nif",persona.getNif());
                lista=consulta.list();
                
                Persona personaBorrable=(Persona) lista.iterator().next();
                
                sesion.delete(personaBorrable);
                transaccion.commit();
                return "Persona borrada del sistema con éxito.";
            
            }   catch (HibernateException e){
                if (transaccion!=null){
                  transaccion.rollback();  
                }
                return "Error al dar de baja a la persona.";

            }
        }
        else {
            return "Nombre de usuario y/o contraseña incorrectos."
    }
        
    
}