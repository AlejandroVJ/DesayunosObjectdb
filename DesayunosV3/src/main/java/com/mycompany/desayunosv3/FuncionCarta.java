package com.mycompany.desayunosv3;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import models.Carta;
import models.Pedidos;

/**
 *
 * @author USUARIO
 */
public class FuncionCarta {


    // Muestra la carta
    public void listaCarta() {

        System.out.println("Todos los menús disponibles: ");
        var todo = new ArrayList<Carta>();

        EntityManager em = ObjectdbUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Carta> tq = em.createQuery("SELECT c FROM Carta c", Carta.class);
//      ArrayList<Carta> res = (ArrayList<Carta>) tq.getResultList();
        todo = (ArrayList<Carta>) tq.getResultList();
        em.close();
        System.out.println("\n\nCONTENIDO DE LA CARTA:");
        todo.forEach((p) -> System.out.println(p));
        
    }

}
