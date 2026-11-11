package colas;

import java.util.*;

public class Pedido {
    private int numero;
    private String cliente;
    private List<String> productos;

    public static void main(String[] args){
        List<String> productoDePepito = new ArrayList<>();
        productoDePepito.addLast("P1");
        productoDePepito.addLast("P2");
        productoDePepito.addLast("P3");
        Pedido pedido1 = new Pedido(1, "Pepito", productoDePepito);

        List<String> productoDeJuanito = new ArrayList<>();
        productoDeJuanito.addLast("P8");
        productoDeJuanito.addLast("P7");
        productoDeJuanito.addLast("P9");
        Pedido pedido2 = new Pedido(1, "Juanito", productoDeJuanito);

        List<String> productoDePepito1 = new ArrayList<>();
        productoDePepito1.addLast("P4");
        productoDePepito1.addLast("P5");
        productoDePepito1.addLast("P6");
        Pedido pedido3 = new Pedido(1, "Pepito", productoDePepito1);


        List<String> productoDePepito3 = new ArrayList<>();
        productoDePepito1.addLast("NO");
        productoDePepito1.addLast("JODAS");
        productoDePepito1.addLast("ED");
        Pedido pedido4 = new Pedido(1, "Pepito", productoDePepito3);

        List<Pedido> listaPedidos = new ArrayList<>();
        listaPedidos.addLast(pedido1);
        listaPedidos.addLast(pedido2);
        listaPedidos.addLast(pedido3);
        listaPedidos.addLast(pedido4);

        // System.out.println(listaPedidos);

        System.out.println(getPedidosPorCliente(listaPedidos, "Pepito"));
    }

    // Constructor vacío
    public Pedido() {
    }

    // Constructor con todos los parámetros
    public Pedido(int numero, String cliente, List<String> productos) {
        this.numero = numero;
        this.cliente = cliente;
        this.productos = productos;
    }

    // --- GETTERS Y SETTERS ---

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<String> getProductos() {
        return productos;
    }

    public void setProductos(List<String> productos) {
        this.productos = productos;
    }

    // XD
    // Implementación con ArrayList
    public static List<String> getPedidosPorCliente(List<Pedido> pedidos, String cliente){
        ArrayList<String> productos = new ArrayList();

        // Recorrer pedidos
        for (int i = 0; i < pedidos.size(); i++){
            if (pedidos.get(i).getCliente().equals(cliente)){
                for (int c = 0; c < pedidos.get(i).getProductos().size(); c++){
                    productos.addLast(pedidos.get(i).getProductos().get(c));
                }
            }
        }

        return productos;

        /*
        // PEDIDOS LISTA GLOBAL
        {"cliente1", {P1, P2, P3}} // PEDIDO
        {"cliente2", {P5, P6}}

        {P1, P2, P3} // PEDIDO

        {{"cliente1", {P1, P2, P3}}, {"cliente2", {P5, P6}}}

        {{P1, P2, P3}, {P5, P6}} // 
         */
    }
}
