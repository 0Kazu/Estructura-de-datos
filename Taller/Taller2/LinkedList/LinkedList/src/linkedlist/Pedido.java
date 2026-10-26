package linkedlist;

public class Pedido {
    private int numero;
    private String cliente;
    private List<String> productos;

    // Constructores, getters y setters
    public Pedido() {
    }

    // Constructor completo (con todos los parámetros)
    public Pedido(int numero, String cliente, List<String> productos) {
        this.numero = numero;
        this.cliente = cliente;
        this.productos = productos;
    }

    // Constructor opcional (inicializa solo con cliente y número, y la lista vacía)
    public Pedido(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.productos = new LinkedList<>();
    }

    public String getCliente() { return cliente; }
    public List<String> getProductos() { return productos; }
}
