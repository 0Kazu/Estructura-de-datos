package linkedlist;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * Profesora: Adriana Collaguazo Jaramillo
 */

public class Main {
    
    public static void main (String[] args)
    {   
        // Caso 1 
        List<Integer> list1 = new LinkedList<>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        
        List<Integer> list2 = new LinkedList<>();
        list2.addLast(5);
        list2.addLast(9);
        list2.addLast(8);
        list2.addLast(2);
        
        List<Integer> intersection1 = list1.findIntersection(list2);
        
        for(Integer n : intersection1){
            System.out.println(n);
        }
                
        // Caso 2
        List<Person> list3 = new LinkedList<>();
        list3.addLast(new Person("Raquel", "Jaramillo", 24));
        list3.addLast(new Person("Raquel", "Jaramillo", 28));
        list3.addLast(new Person("Raquel", "Jaramillo", 47));
        list3.addLast(new Person("Rafael", "Pesantez", 23));
        list3.addLast(new Person("Felix", "Prado", 38));

        List<Person> list4 = new LinkedList<>();
        list4.addLast(new Person("Raquel", "Jaramillo", 24));
        list4.addLast(new Person("Felix", "Prado", 38));
        list4.addLast(new Person("Emilio", "Doumet", 17));
        list4.addLast(new Person("Alex", "Vaca", 84));
        list4.addLast(new Person("Daniel", "Pesantez", 23));
        
        
        List<Person> intersection2 = list3.findIntersection(list4);
        for (Person p : intersection2) {
            System.out.println(p);
        }
        
         List<Person> intersection3 = list3.findIntersection(list4);
        for (Person p : intersection3) {
            System.out.println(p);
        }
        
        /*
        // Instancia de la Interfaz Comparator con variable cmp1
        Comparator<Person> cmp1 = new Comparator<Person>(){
            @Override
            public int compare(Person p1, Person p2) {
                //Comparar edades
                if (p1.getAge() == p2.getAge()){
                    return 0;
                } else if (p1.getAge() > p2.getAge()){
                    return 1;
                } else {
                    return -1;
                }
                // return p1.getAge() - p2.getAge();
            }
        };
                      
        Comparator<Person> cmp2 = new Comparator<Person>(){
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        };
        
        
        
        List<Person> intersection2 = list3.findIntersection(list4, cmp1);
        System.out.println("*** INTERSECCION 2 ****");
        for (Person p : intersection2) {
            System.out.println(p);
        }
        
        List<Person> intersection3 = list3.findIntersection(list4, cmp2);
        System.out.println("*** INTERSECCION 3 ****");
        for (Person p : intersection3) {
            System.out.println(p);
        }
        
        // Forma simple de Comparar usando expresionales lambdas
        List<Person> intersection4 = list3.findIntersection(list4, (p1, p2)->{
            return p1.getAge() - p2.getAge();
        }); 
        System.out.println("*** INTERSECCION 4 ****");
        for (Person p : intersection4) {
            System.out.println(p);
        }
        */
    }

    
}

/* Istancia de Iteradores        
        List<Integer> l1= new ArrayList<>();
        l1.addFirst(1);
        l1.addFirst(2);
        l1.addFirst(3);
        l1.addFirst(4);
        
        List<Integer> list= new ArrayList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        
        Iterator<Integer> it=list.iterator();
        
        //Equivalencias
        for (Integer n : list){
            System.out.println(n);
        }
        
        Iterator<Integer> it=list.iterator();
        while(it.hasNext()){
            Integer n = it.next();
            System.out.println(n);
        }

        //List<Double> l3 = new LinkedList<>();
        
        // l1.addFirst(10);
        // l1.addFirst(20);
        // l1.addFirst(30);

        //for (int i = 0; i < l1.size(); i++) {
        //    System.out.println(l1.get(i));
        
        // Ejemplo: Estrategia para recorrer los elementos del ArrayList de Java
        java.util.ArrayList<Integer> tmp = new java.util.ArrayList<>();
        
        tmp.add(1);
        tmp.add(2);
        tmp.add(3);
        tmp.add(4);
        
        for (int i=0; i<tmp.size(); i++){
               System.out.println(tmp.get(i));
        }
        
        // Otra estrategia para recorrer los elementos del ArrayList sin usar índices es el método Iterator
        // retorna una variable de tipo Iiterator
        Iterator<Integer> it = tmp.iterator();
        while(it.hasNext()){  
            Integer n=it.next();
            System.out.println(n);
        }
        
        // Simulación de foreach
        for(Integer n : tmp){
            System.out.println(n);
        
        }
        
        Iterator<Integer> it2=l1.iterator();
        while(it2.hasNext()){  
            Integer n=it2.next();
            System.out.println(n);
        }
        
        for(Integer n : l1){
            System.out.println(n);
        }
*/