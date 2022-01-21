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
    public void crearPedido() {
        String nombre;
        String curso;
        String estado;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserta tu nombre: ");
        nombre = sc.next();
        System.out.println("Inserta tu curso: ");
        curso = sc.next();
        System.out.println("Inserta el id del producto que desea: ");
        Integer cartaId = sc.nextInt();

        Pedidos p = new Pedidos();

        java.util.Date fechaAhora = new java.util.Date();
        java.sql.Date fecha = new java.sql.Date(fechaAhora.getTime());

        p.setCliente(nombre);
        p.setCurso(curso);
        p.setEstado("PENDIENTE");
        p.setFecha(new Date());

        EntityManager em = ObjectdbUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();

        //Transaction t = ObjectdbUtil.getEntityManagerFactory().beginTransaction();
        //s.save(p);
        //t.commit();
    }

    public void marcarPedido() {

        Integer pedidoId;

        Scanner sc = new Scanner(System.in);
        listaComandas();

        System.out.println("Inserta el id del pedido que se va a recoger: ");
        pedidoId = sc.nextInt();
        Serializable id = pedidoId;

        EntityManager em = ObjectdbUtil.getEntityManagerFactory().createEntityManager();

        Pedidos p = getPedido(pedidoId, em);

        em.getTransaction().begin();
        p.setEstado("ENTREGADO");
        em.getTransaction().commit();
        em.close();

        //Transaction t = s.beginTransaction();
        //Pedidos p = em.load(Pedidos.class, id);
        //s.update(p);
        //t.commit();
    }

    public void borrarPedido() {

        Integer pedido;
        Integer r = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserta el id del pedido que quieres eliminar: ");
        pedido = sc.nextInt();
        Serializable id = pedido;

        EntityManager em = ObjectdbUtil.getEntityManagerFactory().createEntityManager();
        var p = getPedido(pedido, em);

        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        System.out.println("El pedido ha sido eliminado con éxito");
        em.close();

        //Transaction t = s.beginTransaction();
        //Pedidos p = s.load(Pedidos.class, id);
        //s.remove(p);
        //t.commit();
    }

    public void listaComandas() {
        var t = new ArrayList<Pedidos>();

        EntityManager em = ObjectdbUtil.getEntityManagerFactory().createEntityManager();

//      Query q = s.createQuery("FROM Pedidos p WHERE p.estado='PENDIENTE'", pedidos.class);
        TypedQuery<Pedidos> tq = em.createQuery(" ", Pedidos.class);
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

    public static Pedidos getPedido(Integer id, EntityManager em) {

        TypedQuery<Pedidos> tq = em.createQuery(" ", Pedidos.class);
        tq.setParameter(id, "id");
        var p = tq.getSingleResult();
        return p;

    }
}
