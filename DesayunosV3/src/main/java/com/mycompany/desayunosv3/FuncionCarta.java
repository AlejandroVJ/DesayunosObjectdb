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


    public void listaCarta() {

        System.out.println("Lista carta");
        var todo = new ArrayList<Carta>();

        EntityManager em = ObjectdbUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Carta> tq = em.createQuery("SELECT c FROM Carta c", Carta.class);
//      ArrayList<Carta> res = (ArrayList<Carta>) tq.getResultList();
        todo = (ArrayList<Carta>) tq.getResultList();
        em.close();
        System.out.println("\n\nCONTENIDO DE LA CARTA:");
        todo.forEach((p) -> System.out.println(p));
        
        
//        todo.forEach(
//                (l) -> {
//                    System.out.println(l);
//                });
//        em.close();

//        Query q = s.createQuery("FROM carta", Carta.class);
//        ArrayList<Carta> res = (ArrayList<Carta>)q.getResultList();
//        System.out.println("\n\nCONTENIDO DE LA CARTA:");
//        res.forEach( (p)->System.out.println(p) );
    }

}
