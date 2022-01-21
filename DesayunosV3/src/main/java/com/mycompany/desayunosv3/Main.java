package com.mycompany.desayunosv3;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Main {

    public static void main(String[] args) {
        
        FuncionCarta funcionC = new FuncionCarta();
        FuncionPedido funcionP = new FuncionPedido();

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
                    funcionP.crearPedido();
                    break;
                case 3:
                    funcionP.marcarPedido();
                    break;
                case 4:
                    funcionP.borrarPedido();
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

}
