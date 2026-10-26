package linkedlist;

import java.util.Iterator;

/**
 *
 * Profesora: Adriana Collaguazo Jaramillo
 */

public class LinkedList<E> implements List<E>{
    private NodeList<E> header;
    private NodeList<E> last;
    //private int size = 0;
    
    public LinkedList(){
        this.header=null;
        this.last=null;
    }
    public NodeList<E> getHeader() {
        return header;
    }

    public void setHeader(NodeList<E> header) {
        this.header = header;
    }

    public NodeList<E> getLast() {
        return last;
    }

    public void setLast(NodeList<E> last) {
        this.last = last;
    }

    @Override
    public boolean addFirst(E e) { //dado un elemento generico
        //size++;
        if(e!=null) {
            NodeList<E> newNode=new NodeList<>(e); // constructor crea un nodo aislado
            newNode.setNext(header); //El siguiente de ese nuevo nodo es Header
            this.setHeader(newNode); //actualizar el header de la lista

            if (last == null) {
                last = newNode;
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addLast(E e) {
        //size++;
        if(e!=null){
            NodeList<E> newNode = new NodeList<>(e);
            if(last !=null){
                last.setNext(newNode);
            }
            last=newNode;
            
            if(header == null){
                header = newNode;
            }
            return true;
        } else {
            return false;
        }  
    }
    
    private NodeList<E> getPrevious(NodeList<E> node){
        NodeList<E> previous = null;
        NodeList<E> n;
        
        for(n = header; n!=node; n= n.getNext()){
            previous = n;
        }
        return previous;
    }
    
    private void recorrerHaciAtras(){
        NodeList<E> n;
        
        for (n = last; n != header; n = this.getPrevious(n)){
            System.out.println(n);
        }
    }
    
    @Override
    public E removeFirst() {
        //size--;
        if (header == null){
            return null;
        }

        // Guardando el header
        NodeList<E> n = header;
        E content = header.getContent();

        // Nuevo header es el segundo nodo
        setHeader(n.getNext());

        // el anterior header ahora apunta a null
        n.setNext(null);


        // Si la lista queda vacía
        if (header == null){
            last = null;
        }

        return content;
    }

    @Override
    public E removeLast() {
        // Lista vacía
        if (header == null) {
            return null; 
        }
        
        E content = last.getContent();
        
        // Si solo hay un elemento
        if (header == last) {
            header = null;
            last = null;
            return content;
        }
        
        // Si hay más de un elemento, usamos getPrevious()
        NodeList<E> previous = getPrevious(last);
        previous.setNext(null); // rompemos conexiones del último nodo
        last = previous;        // Actualizamos el puntero last
        
        return content;
    }

    @Override
    public int size() {
        // return size; // O(1)
        // primera parte declaro variables a iterar
        // segunda parte condicion logica
        // tercera parte instrucciones
        //for (int i=0, j=0; i < 10 && j >8; i++){
        //for (NodeList<E> n = header; n ! = null ; n = n.getNext()){
        
        // Complejidad lineal O(n) a pesar de que no es tan buena como O(1) evita que tenga que darle mantenimiento a size
        int size = 0;
        NodeList<E> n; //declaro un nodo viajero
        //declaro un nodo viajero, mientras sea diferente de null, se mueve al siguiente nodo
        
        for (n = header ; n!= null ; n = n.getNext( )) {
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return header == null;
    }

    @Override
    public void clear() {
        header = null;
        last = null;
    }

    @Override
    public boolean add(int index, E e) {
        // Validaciones
        if (index < 0 || e == null) return false;
        
        // Insertar al principio
        if (index == 0) {
            return addFirst(e);
        }
        
        // Buscamos el nodo anterior a la posición donde queremos insertar
        NodeList<E> current = header;

        // No podemos usar getPrevious porque no conocemos el nodo
        for (int i = 0; i < index - 1; i++) {
            // Índice fuera de límites
            if (current == null) return false;

            current = current.getNext();
        }

        // Evitar errores
        if (current == null) return false;
        
        // Caso: Insertar después del último
        if (current == last) {
            return addLast(e);
        }

        // Inserción en el medio
        NodeList<E> newNode = new NodeList<>(e);
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        return true;
    }

    @Override
    public E remove(int index) {
        // Validaciones
        if (index < 0 || header == null) return null;
        
        // Remover el primero
        if (index == 0) {
            return removeFirst();
        }
        
        NodeList<E> current = header;
        NodeList<E> prev = null;
        
        // Buscando nodo a eliminar y su anterior
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.getNext();
            
            // Índice fuera de límites
            if (current == null) return null; 
        }
        
        // Caso: Remover el último
        if (current == last) {
            return removeLast();
        }
        
        // Remover en el medio: el anterior ahora apunta al siguiente del actual
        prev.setNext(current.getNext());
        
        // Actual (eliminado) ahora apunta a nulo
        current.setNext(null);
        
        return current.getContent();
    }

    @Override
    public E get(int index) {
        // Validaciones
        if (index < 0 || header == null) return null;
        
        NodeList<E> current = header;
        for (int i = 0; i < index; i++) {
            current = current.getNext();

            if (current == null) return null; // El índice era mayor al tamaño
        }

        return current.getContent();
    }

    @Override
    public E set(int index, E element) {
        // Validaciones
        if (index < 0 || element == null || header == null) return null;
        
        NodeList<E> current = header;

        for (int i = 0; i < index; i++) {
            current = current.getNext();

            // índice fuera de rango (Como en get())
            if (current == null) return null; 
        }
        
        E oldContent = current.getContent();
        current.setContent(element); // Pisamos el dato viejo
        return oldContent;           // Retornamos el que estaba antes
    }
    
    public Iterator<E> iterator(){
        Iterator<E> it=new Iterator<E>() {
                NodeList<E> cursor = header;
                
            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public E next() {
                E e = cursor.getContent();
                cursor = cursor.getNext();
                return e;
            }
        };
        
        
        return it;
    }
    
    // Ejercicios del taller
    // 1. Método para dividir los lanzamientos de Yahtzee
    public static LinkedList<Integer>[] dividirLanzamientos(List<Integer> lista) {
        // Creamos el arreglo estático de tamaño 3 para los jugadores
        LinkedList<Integer>[] resultado = new LinkedList[3];
        
        // Inicializamos cada posición del arreglo con una nueva LinkedList
        for (int i = 0; i < 3; i++) {
            resultado[i] = new LinkedList<Integer>();
        }
        
        int turno = 0; // 0 = Jugador 1, 1 = Jugador 2, 2 = Jugador 3
        
        // Recorremos la lista usando un foreach
        for (Integer lanzamiento : lista) {
            // addLast --> O(1)
            resultado[turno].addLast(lanzamiento); 
            
            // La clave del ejercicio es avanzar la variable turno
            // Avanzamos el turno usando aritmética modular (0, 1, 2, 0, 1, 2...)
            turno = (turno + 1) % 3;
        }
        
        return resultado;
    }
    // De dividirLanzamientos se puede evidenciar una complejidad O(n). No contamos
    // con complejidad cuadrática ya que no tenemos for anidados.


    // 2. Método para obtener el historial de pedidos de un cliente
    public static List<String> getPedidosPorCliente(List<Pedido> listaPedidos, String cliente) {
        // Lista de pedidos general por retornar
        LinkedList<String> historialProductos = new LinkedList<>();
        
        // Validaciones
        if (listaPedidos == null || cliente == null) {
            // Lista vacia 
            return historialProductos;
        }

        // Recorremos listaPedidos con un foreach
        for (Pedido pedido : listaPedidos) {
            // Verificamos si este pedido le pertenece al cliente que buscamos
            // En Java equals() compara directamente el contenido (no el puntero)
            if (cliente.equals(pedido.getCliente())) {
                // Sacamos la lista de productos de este pedido en particular
                List<String> productosDelPedido = pedido.getProductos();
                
                // Recorremos los productos y los agregamos al historial general
                if (productosDelPedido != null) {
                    for (String producto : productosDelPedido) {
                        historialProductos.addLast(producto);
                    }
                }
            }
        }
        
        return historialProductos;
    }
    // Por cierto, la complejidad de getPedidosPorCliente es O(n^2)


    // 3. Método para comparar carteras de inversión y sumar menores
    public static LinkedList<Integer> sumarMenores(LinkedList<Integer> listaA, LinkedList<Integer> listaB) {
        LinkedList<Integer> resultado = new LinkedList<>();
        
        // Validaciones
        if (listaA == null || listaB == null) {
            return resultado;
        }

        // Iteramos con foreach la lista A
        for (Integer umbral : listaA) {
            int suma = 0;

            // Verificamos con CADA valor de B
            for (Integer valorB : listaB) {
                // Identificar transacciones menor a "umbral"
                if (valorB != null && valorB < umbral) {
                    suma += valorB;
                }
            }
            
            // Añadimos
            resultado.addLast(suma);
        }

        return resultado;
    }
    // Este método implica una complejidad de O(n^2)


    // 4. Método principal para IoT (IoT)
    public static List<String> getStringsShorterThan(List<String> inputList, int k) {
        LinkedList<String> resultado = new LinkedList<>();
        
        // Validación
        if (inputList == null && k > 0) {
            return resultado;
        }
        
        // Casting
        LinkedList<String> miLista = (LinkedList<String>) inputList;

        // Método recursivo
        filtrarRecursivo(miLista.getHeader(), k, resultado);
        
        return resultado;
    }

    private static void filtrarRecursivo(NodeList<String> actual, int k, LinkedList<String> resultado) {
        // Caso de salida o base: Si el nodo es null, llegamos al final de la lista
        if (actual == null) {
            return;
        }
        
        // Procesamos el nodo en el que estamos parados
        String texto = actual.getContent();
        
        // Si el texto cumple la condición, lo metemos a la lista resultado
        if (texto != null && texto.length() < k) {
            resultado.addLast(texto);
        }
        
        // Recursión: lo mismo pero con el siguiente nodo
        filtrarRecursivo(actual.getNext(), k, resultado);
    }

    @Override
    public String toString() {
        if (header == null) return "";

        String s="";
        for (NodeList<E> n=header; n!=null; n=n.getNext()) {
            s+=n.getContent();

            if (n.getNext() != null) {
                s += ", ";
            }
        }
        return s;
    }
}