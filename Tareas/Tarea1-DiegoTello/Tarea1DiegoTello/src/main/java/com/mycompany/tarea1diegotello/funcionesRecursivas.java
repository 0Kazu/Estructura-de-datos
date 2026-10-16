/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tarea1diegotello;



/**
 *
 * @author Diego Tello
 */
public class funcionesRecursivas {
    
    // Ejercicio 1: Retorna el máximo presente en el arreglo a partir del indice dado.
    public static int buscarMaximo(int arr[], int indice) { 
        // Validaciones
        if (arr == null || arr.length == 0 || indice < 0 || indice >= arr.length){  // O(1)
            return Integer.MIN_VALUE;                                               // O(1)
        }
        
        // Caso base o caso de salida -> Si llegamos al último elemento del arreglo
        if (indice == (arr.length - 1)){                                            // O(1)
            return arr[indice];                                                     // O(1)
        }
        
        // Recursividad
        int numeroCandidato = buscarMaximo(arr, indice + 1);                        // O(n)
        
        // Comprobar si el número candidato es mayor o no
        if (arr[indice] > numeroCandidato){                                         // O(1)
            return arr[indice];                                                     // O(1)
        } else {                                                                    // O(1)
            return numeroCandidato;                                                 // O(1)
        }
    } 
    // Resulta evidente que, en el peor de los casos, estaremos presenciando una
    // complejidad O(n). las condicionales y las asignaciones cuentan con complejidad O(1)
    // Mientras que, recorrer la lista de forma secuencial consta con complejidad O(n).
    
    // Ejercicio 2: Retornar la cantidad de dígitos que componen el número entero ingresado.
    public static int contarDigitos(int n){
        n = Math.abs(n);                                                            // O(1)
        
        // Si el numero es menor que 10 entonces sólo tiene un dígito
        if (n < 10){                                                                // O(1)
            return 1;                                                               // O(1)
        }
        
        // Si n > 10, lo hacemos pequeño dividiendo por 10 (dividir por 10 "recorta" el último número)
        return 1 + contarDigitos(n / 10);                                           // O(log(n))
    }
    // La complejidad de la función es O(log(n)). Las asignaciones y la condicional se reducen
    // a una complejidad de O(1). Por otro lado, cuando hacemos la llamada recursiva, podemos
    // evidenciar un "achicamiento" de n, es decir, en cada iteración n se reduce más. Por tanto
    // notamos una complejidad O(log(n)).
    
    // Ejercicio 3: Retornar una nueva cadena donde todos los caracteres alfabéticos se encuentren en mayúscula.
    public static String aMayusculas(String s){
        // Validaciones
        if (s == null || s.isEmpty()){                                              // O(1)
            return "";                                                              // O(1)
        }
        
        // A mayúscula
        String primerCaracter = s.substring(0, 1).toUpperCase();                    // O(1)
        
        // Recortando para el paso recursivo
        String restoCadena = s.substring(1);                                        // O(1)
        
        // Recursividad
        return primerCaracter + aMayusculas(restoCadena);                           // O(n)
    }
    // La complejidad de la función es O(n). Como ya se ha dicho, la condicional y asignaciones
    // son de complejidad constante. Ahora bien, el paso recursivo implica una complejidad
    // O(n) ya que estamos recorriendo letra por letra (Secuencial).

    public static void main(String[] args) {
        // Pruebas ejercicio 1
        System.out.println("Ejercicio 1");
        int[] arr1 = {3, 9, 1, 7, 4};
        System.out.println("El valor maximo del arreglo {3,9,1,7,4} desde el índice 0 es => " + buscarMaximo(arr1, 0));
        int[] arr2 = {15, 8, 23, 4, 16, 2};
        System.out.println("El valor maximo del arreglo {15,8,23,4,16,2} desde el índice 2 es => " + buscarMaximo(arr2, 2));
        int[] arr3 = {2};
        System.out.println("El valor maximo del arreglo {2} desde el índice 0 es => " + buscarMaximo(arr3, 0));
        
        // Pruebas ejercicio 2
        System.out.println("\nEjercicio 2");
        System.out.println("La cantidad de digitos del número 345 es => " + contarDigitos(345));
        System.out.println("La cantidad de digitos del número 7 es => " + contarDigitos(7));
        System.out.println("La cantidad de digitos del número -12048 es => " + contarDigitos(-12048));
        
        // Pruebas ejercicio 3
        System.out.println("\nEjercicio 3");
        System.out.println("La palabra \"Estructura\" en mayusculas es => " + aMayusculas("Estructura"));
        System.out.println("La palabra \"recursividad\" en mayusculas es => " + aMayusculas("recursividad"));
        System.out.println("La palabra \"Hola Mundo 123\" en mayusculas es => " + aMayusculas("Hola Mundo 123"));
    }
}
