package linkedlist;

import java.util.Arrays;

public class Main {
    public static void main (String[] args)
    {
        // ---------------------------------------------------------
        // PRUEBA 1: Yahtzee (dividirLanzamientos)
        // ---------------------------------------------------------
        System.out.println("--- ACTIVIDAD 1: YAHTZEE ---");
        LinkedList<Integer> lanzamientos = new LinkedList<>();
        // Secuencia de entrada: [3, 5, 2, 6, 1, 4, 3, 3, 3]
        int[] tiros = {3, 5, 2, 6, 1, 4, 3, 3, 3};
        for (int tiro : tiros) lanzamientos.addLast(tiro);
        
        LinkedList<Integer>[] resultadoYahtzee = LinkedList.dividirLanzamientos(lanzamientos);
        System.out.println("Entrada: " + Arrays.toString(tiros) + "");
        System.out.println("Jugador 1: [" + resultadoYahtzee[0].toString() + "]");
        System.out.println("Jugador 2: [" + resultadoYahtzee[1].toString() + "]");
        System.out.println("Jugador 3: [" + resultadoYahtzee[2].toString() + "]\n");


        //----------------------------------------------------
        // PRUEBA 2: Tienda en Línea (getPedidosPorCliente)
        // ---------------------------------------------------------
        System.out.println("--- ACTIVIDAD 2: PEDIDOS POR CLIENTE ---");
        LinkedList<Pedido> listaPedidos = new LinkedList<>();
        
        // Creamos las listas de productos usando tu propia LinkedList
        LinkedList<String> prods1 = new LinkedList<>();
        prods1.addLast("P1"); prods1.addLast("P2");
        
        LinkedList<String> prods2 = new LinkedList<>();
        prods2.addLast("P3"); prods2.addLast("P4"); prods2.addLast("P11");
        
        LinkedList<String> prods3 = new LinkedList<>();
        prods3.addLast("P5"); prods3.addLast("P6");
        
        LinkedList<String> prods4 = new LinkedList<>();
        prods4.addLast("P7"); prods4.addLast("P8");
        
        LinkedList<String> prods5 = new LinkedList<>();
        prods5.addLast("P9"); prods5.addLast("P10");

        // Instanciamos los pedidos pasándole tus LinkedList personalizadas
        listaPedidos.addLast(new Pedido(1, "Cliente1", prods1));
        listaPedidos.addLast(new Pedido(2, "Cliente2", prods2));
        listaPedidos.addLast(new Pedido(3, "Cliente1", prods3));
        listaPedidos.addLast(new Pedido(4, "Cliente3", prods4));
        listaPedidos.addLast(new Pedido(5, "Cliente1", prods5));

        List<String> comprasCliente1 = LinkedList.getPedidosPorCliente(listaPedidos, "Cliente1");
        List<String> comprasCliente2 = LinkedList.getPedidosPorCliente(listaPedidos, "Cliente2");
        
        System.out.println("Compras de Cliente1: [" + ((LinkedList<String>) comprasCliente1).toString() + "]");
        System.out.println("Compras de Cliente2: [" + ((LinkedList<String>) comprasCliente2).toString() + "]\n");


        // ---------------------------------------------------------
        // PRUEBA 3: Finanzas (sumarMenores)
        // ---------------------------------------------------------
        System.out.println("--- ACTIVIDAD 3: SUMAR MENORES (INVERSIONES) ---");
        LinkedList<Integer> listaA = new LinkedList<>();
        LinkedList<Integer> listaB = new LinkedList<>();
        
        // Llenamos Lista A: [2] -> [3] -> [8] -> [4] -> [1]
        int[] valsA = {2, 3, 8, 4, 1};
        for (int val : valsA) listaA.addLast(val);
        
        // Llenamos Lista B: [1] -> [1] -> [3] -> [2] -> [5] -> [6]
        int[] valsB = {1, 1, 3, 2, 5, 6};
        for (int val : valsB) listaB.addLast(val);

        LinkedList<Integer> resultadoSuma = LinkedList.sumarMenores(listaA, listaB);
        System.out.println("Lista Resultante:  [" + resultadoSuma.toString() + "]\n");


        // ---------------------------------------------------------
        // PRUEBA 4: Internet of Things (getStringsShorterThan)
        // ---------------------------------------------------------
        System.out.println("--- ACTIVIDAD 4: FILTRADO IoT (RECURSIVO) ---");
        LinkedList<String> inputList1 = new LinkedList<>();
        inputList1.addLast("123"); 
        inputList1.addLast("12"); 
        inputList1.addLast("1234"); 
        inputList1.addLast("1");
        
        List<String> resIoT1 = LinkedList.getStringsShorterThan(inputList1, 3);
        List<String> resIoT2 = LinkedList.getStringsShorterThan(inputList1, 1);
        
        System.out.println("Resultado con k=3: [" + ((LinkedList<String>) resIoT1).toString() + "]");
        System.out.println("Resultado con k=1: [" + ((LinkedList<String>) resIoT2).toString() + "]");
    }
}
