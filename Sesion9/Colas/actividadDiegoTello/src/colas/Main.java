package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>(); // Recomendación de implementación en 3er lugar NO USAR
        // s1.get(2); Es una mala implementación por parte de Java, no se puede acceder por posición
        // En un Stack.

        Deque<Integer> s2 = new ArrayDeque<>(); // Recomendación de implementación en 1er lugar
        // s2.getFirst(); sólo es posible usar los extremos; conceptualmente bien.
        // s2.getLast();

        Deque<Integer> s3 = new LinkedList<>(); // Recomendación de implementación en 2do lugar

        // s2.pop();
        // s1.peek();
        // s1.get(1);
        // s2.get(5);

        for (Integer i = 1; i <= 5; i++) {
            s1.push(i);
            s2.push(i);
            s3.push(i);
        }

        // ERROR, Java nos mostrará desde la cima a la base cuando debe ser desde la base hacia la cima
        System.out.println("RECORRER STACK");
        for (Integer e : s1) {
            System.out.println(e);
        }

        // Verificar si la pila no esta vacia -> Sólo con pop veremos su correcto orden
        System.out.println("ELIMINAR ELEMENTOS STACK");
        while (!s1.isEmpty()) {
            Integer e = s1.pop();
            System.out.println(e);
        }

        // Verificar si la pila no esta vacia
        // Sí muestra el orden correcto del Stack
        System.out.println("ARRAYDEQUE");
        while (!s2.isEmpty()) {
            Integer e = s2.pop();
            System.out.println(e);
        }

        System.out.println("LINKEDLIST");
        while (!s3.isEmpty()) {
            Integer e = s3.pop();
            System.out.println(e);
        }

        /* 
        // Paso 8
        System.out.println("ARRAYDEQUE");
        for (Integer e1 : s2){
            System.out.println(e1);
        }

        // Paso 11
        System.out.println("LINKEDLIST");
        for (Integer e3 : s3){
            System.out.println(e3);
        }
        */
    }
}