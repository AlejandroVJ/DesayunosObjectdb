package com.mycompany.desayunosv3;

import java.util.Date;
import java.util.Scanner;
import models.Pedidos;

/**
 *
 * @author USUARIO
 */
public class Main {

    static FuncionCarta funcionC = new FuncionCarta();
    static FuncionPedido funcionP = new FuncionPedido();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opciones = 0;
        //Menú selector
        do {
            System.out.println("\n\nElige una opción:\n\n"
                    + "[1] La carta:\n"
                    + "[2] Crear tu pedido\n"
                    + "[3] Marca tu pedido como recogido\n"
                    + "[4] Eliminar tu pedido\n"
                    + "[5] Todas las comandas pendientes\n"
                    + "[6] Salir\n");
            opciones = sc.nextInt();
            switch (opciones) {
                case 1:
                    funcionC.listaCarta();
                    break;
                case 2:
                    crearPedido();
                    break;
                case 3:
                    marcarPedido();
                    break;
                case 4:
                    borrarPedido();
                    break;
                case 5:
                    funcionP.listaComandas();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    opciones = 0;
                    System.out.println("Selecciona una opción");

            }
        } while (opciones != 6);

    }

    public static void crearPedido() {
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
        
        funcionP.guardarPedido(p);
        
    }
    
    public static void borrarPedido() {

        Integer pedido;

        Scanner sc = new Scanner(System.in);
        System.out.println("Inserta el id del pedido que quieres eliminar: ");
        pedido = sc.nextInt();

        Integer id = pedido;

        funcionP.borrar(id);
    }
    
    public static void marcarPedido() {

        Integer pedidoId;
        Scanner sc = new Scanner(System.in);
        funcionP.listaComandas();

        System.out.println("Inserta el id del pedido que se va a recoger: ");
        pedidoId = sc.nextInt();
        Integer id = pedidoId;

        funcionP.marcar(id);
    }

}
