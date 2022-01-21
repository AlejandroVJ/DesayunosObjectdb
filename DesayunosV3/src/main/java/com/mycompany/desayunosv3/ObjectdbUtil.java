package com.mycompany.desayunosv3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author AlejandroVicenteJarn
 */
public class ObjectdbUtil {

    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("db.odb");
            
        } catch (Exception e) {
            System.out.println("Error la conectar con la base de datos");
            System.out.println(e);
            throw new ExceptionInInitializerError(e);

        }

    }
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

}
