package com.mycompany.desayunosv3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import models.Pedidos;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * * * @author USUARIO
 */
public class FuncionPedido {

    //Creamos pedido
    public void guardarPedido(Pedidos p) {

        EntityManager em = ObjectdbUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();

    }

    //Marca como entregado los pedidos pendientes
    public void marcar(Integer id) {

        EntityManager em = ObjectdbUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Pedidos p = em.find(Pedidos.class, id);
        p.setEstado("ENTREGADO");
        em.getTransaction().commit();
        em.close();
    }

    //Borra los pedidos
    public void borrar(Integer id) {

        EntityManager em = ObjectdbUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Pedidos p = em.find(Pedidos.class, id);
        em.remove(p);
        em.getTransaction().commit();
        System.out.println("El pedido ha sido eliminado con éxito");
        em.close();

    }

    //Lista la comandas pendientes
    public void listaComandas() {
        var t = new ArrayList<Pedidos>();

        EntityManager em = ObjectdbUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Pedidos> tq = em.createQuery("SELECT p FROM Pedidos p WHERE p.estado='PENDIENTE'", Pedidos.class);
        ArrayList<Pedidos> res = (ArrayList<Pedidos>) tq.getResultList();
        tq.setParameter("estado", "PENDIENTE");
        em.close();

        if (res.size() > 0) {
            System.out.println("\n\nPEDIDOS PENDIENTES:");
            res.forEach((p) -> System.out.println(p));
        } else {
            System.out.println("No hay pedidos pendientes");
        }
    }
}
