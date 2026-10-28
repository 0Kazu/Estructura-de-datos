package colas;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author adi
 */
public class Colas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Crear e instanciar una Cola usando LinkedList
        Queue<String> dynamicQueue = new LinkedList<>();        
        
        // Queue<String> staticQueue = new ArrayDeque<>();
        
        // Instancia de una Pila
        // Deque<String> staticStack = new ArrayDeque<>();
        
        // Encolar
        /*
        dynamicQueue.offer("Maroon5");
        dynamicQueue.offer("Celin Dion");
        dynamicQueue.offer("Reik");
        dynamicQueue.offer("Chayanne");
        dynamicQueue.offer("Bacilos");
        dynamicQueue.offer("Adele");
        dynamicQueue.offer("The Beatles");
        dynamicQueue.offer("Maroon 5");
        dynamicQueue.offer("Bruno Mars");
        dynamicQueue.offer("Luis Fonsi");
        */

        // Ejemplo 
        dynamicQueue.offer("Chaewon");
        dynamicQueue.offer("Cha ewon");
        dynamicQueue.offer("Kazuha");
        dynamicQueue.offer("Eunchae");
        dynamicQueue.offer("Yunjin");
        dynamicQueue.offer("Candy");
        dynamicQueue.offer("Lifehouse");
        dynamicQueue.offer("Stromae");
        
        // Remover elementos
        System.out.println("");
        System.out.println("************");
        System.out.println("DynamicQueue");
        while (!dynamicQueue.isEmpty()) {
            System.out.println(dynamicQueue.poll());
        }
        
        
        // Crear e instanciar colas de prioridad en el Constructor
        Queue<String> pq1=new PriorityQueue();
        
        pq1.offer("Primer capítulo");
        pq1.offer("Segundo capítulo");
        pq1.offer("Tercer capítulo");
        pq1.offer("Cuarto capítulo");
        pq1.offer("Quinto capítulo");
        pq1.offer("Sexto capítulo");
        
        // Remover elementos
        System.out.println("");
        System.out.println("**********************");
        System.out.println("Priority Queue1 String");
        while (!pq1.isEmpty()) {
            System.out.println(pq1.poll());
        }
       
        // Crear e instancia colas de prioridad
        Queue<Integer> pq2 = new PriorityQueue();
       
        pq2.offer(18);
        pq2.offer(91);
        pq2.offer(-63);
        pq2.offer(40);
        pq2.offer(540);
        pq2.offer(20);
        pq2.offer(1);
        
        // Remover elementos
        
        System.out.println("");
        System.out.println("***********************");
        System.out.println("Priority Queue2 Integer");
        while (!pq2.isEmpty()) {
            System.out.println(pq2.poll());
        }
        

        
        Queue<Book> pq3 = new PriorityQueue();
        
        pq3.offer(new Book("Algorithms", 2014, "978-1-118-77133-4"));
        pq3.offer(new Book("Estructuras de Datos", 2022, "130369977"));
        pq3.offer(new Book("Data Structures and Algorithms in Java", 2002, "978-0672324536"));
        
        // Remover elementos
        System.out.println("");
        System.out.println("*****************************************");
        System.out.println("Libros por título usando el orden natural");
        while (!pq3.isEmpty()) {
            System.out.println(pq3.poll());
        }
        

        Comparator<Book> cmp = new Comparator<Book>(){
            @Override
            public int compare(Book b1, Book b2) {
                return b2.getYear() - b1.getYear();
            }
        
        };
      
        // Queue<Book> pq4=new PriorityQueue(cmp);

        /* 
        Queue<Book> pq4 = new PriorityQueue<Book>((b1, b2) -> {
            return b1.getYear() - b2.getYear();
        });
        */

        // Comparador que muestre de manera descendente los títulos de los libros (Actividad)
        Queue<Book> pq4 = new PriorityQueue<>((b1, b2) -> {
            return b2.getTitle().compareTo(b1.getTitle());
        });
        
        pq4.offer(new Book("Algorithms", 2014, "978-1-118-77133-4"));
        pq4.offer(new Book("Estructuras de Datos", 2022, "130369977"));
        pq4.offer(new Book("Data Structures and Algorithms in Java", 2002, "978-0672324536"));
        
        // Remover elementos
        
        System.out.println("");
        System.out.println("**************");
        System.out.println("Libros por año usando Comparator");
        
        while (!pq4.isEmpty()) {
            System.out.println(pq4.poll());
        }
        
        
        

        
        /*
        // Actividad 1: Presentar los elementos de pq5 ordenados por el 
        // tamaño más grande (mayor prioridad) de forma descendente. 
        // Usar una expresión Lambda.
        
        pq5.offer("Primera unidad");
        pq5.offer("Segundo capítulo");
        pq5.offer("Tercera");
        pq5.offer("Cuarto elemento con mayor amplitud");
        pq5.offer("Quint");
        pq5.offer("Sext");
        
        // Actividad 2: Presentar los elementos de números enteros de pq6 ordenados primero 
        // los números pares y luego los números impares. Usar una expresión Lambda.
        
        pq6.offer(5);
        pq6.offer(745);
        pq6.offer(15);
        pq6.offer(7);
        pq6.offer(8);
        pq6.offer(6);
        pq6.offer(75);
        pq6.offer(73);
        pq6.offer(74);
        pq6.offer(20);
        
        // Actividad 3: Presentar los libros ordenados por año, en el caso de libros repetidos 
        // por año que adicionalmente se ordenen alfabéticamente. Usar una expresión Lambda.
        
        LinkedList<Book> books= new LinkedList<>();
        books.add(new Book("In Search of Lost Time",1913,"001001"));
        books.add(new Book("Don Quijote",1605,"002002"));
        books.add(new Book("Ulysses",1904,"003003"));
        books.add(new Book("The Great Gatsy",1920,"004004"));
        books.add(new Book("Moby Dick",1851,"005005"));
        books.add(new Book("Aaaaa",1599,"006006"));
        books.add(new Book("CCCC",1599,"006006"));
        books.add(new Book("First Folio",1623,"007007"));
        books.add(new Book("King Lear2",1603,"008008"));
        books.add(new Book("BBB",1599,"006006"));
        books.add(new Book("YYY",1599,"006006"));
        books.add(new Book("Second Folio",1623,"007007"));
        books.add(new Book("King Learl",1603,"008008"));
        books.add(new Book("The Great Gatsy",1920,"004004"));
        books.add(new Book("Moby Dick",1851,"005005"));
        */
        
        
        
        
        
        
        
        
        
        
        
        
        // Actividad 1: Presentar los elementos de pq1 ordenados por el tamaño de forma descendente 
        // usando una expresión Lambda.
        
        Queue<String> pq5=new PriorityQueue<>((s1, s2) -> {
            return s2.length() - s1.length();
        });
        
        pq5.offer("Primera unidad");
        pq5.offer("Segundo capítulo");
        pq5.offer("Tercera");
        pq5.offer("Cuarta");
        pq5.offer("Quint");
        pq5.offer("Sext");
        
        System.out.println("");
        System.out.println("**********************");
        System.out.println("Priority Queue5 String");
        while (!pq5.isEmpty()) {
            System.out.println(pq5.poll());
        }
        
        
        
        // Actividad 2: Presentar los elementos de números enteros de pq6 ordenados primero los números pares
        // y luego los números impares usando una expresión Lambda.
        
        Queue<Integer> pq6=new PriorityQueue<>((i1, i2) -> {
            return i1 % 2 == 0 ? -1 : 1;
        });
       
        pq6.offer(5);
        pq6.offer(745);
        pq6.offer(15);
        pq6.offer(7);
        pq6.offer(8);
        pq6.offer(6);
        pq6.offer(75);
        pq6.offer(73);
        pq6.offer(74);
        pq6.offer(20);
        
        System.out.println("");
        System.out.println("***********************");
        System.out.println("Priority Queue6 Integer");
        while (!pq6.isEmpty()) {
            System.out.println(pq6.poll());
        }
        
        
        // Actividad 3: Presentar los libros ordenados por año, en el caso de libros repetidos por año que
        // ordenen alfabéticamente usando una expresión Lambda.
        
        LinkedList<Book> books= new LinkedList<>();
        books.add(new Book("In Search of Lost Time",1913,"001001"));
        books.add(new Book("Don Quijote",1605,"002002"));
        books.add(new Book("Ulysses",1904,"003003"));
        books.add(new Book("The Great Gatsy",1920,"004004"));
        books.add(new Book("Moby Dick",1851,"005005"));
        books.add(new Book("Aaaaa",1599,"006006"));
        books.add(new Book("CCCC",1599,"006006"));
        books.add(new Book("First Folio",1623,"007007"));
        books.add(new Book("King Lear2",1603,"008008"));
        books.add(new Book("BBB",1599,"006006"));
        books.add(new Book("YYY",1599,"006006"));
        books.add(new Book("Second Folio",1623,"007007"));
        books.add(new Book("King Lear1",1603,"008008"));
        books.add(new Book("The Great Gatsy",1920,"004004"));
        books.add(new Book("Moby Dick",1851,"005005"));
        
        PriorityQueue<Book> pqLibros = new PriorityQueue<>((b1, b2) -> {
            int subtraction = b1.getYear() - b2.getYear();
            
            if (subtraction == 0){
                return b1.getTitle().compareTo(b2.getTitle());
            }
            return subtraction;
        });
        
        for(Book b : books){
            pqLibros.offer(b);
        }
        
        while (!pqLibros.isEmpty()){
            System.out.println(pqLibros.poll());
        }
        
        System.exit(85);
        
    }

}
