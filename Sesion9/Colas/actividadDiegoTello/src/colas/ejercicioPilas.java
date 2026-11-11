package colas;

import java.util.*;


public class ejercicioPilas {

    public static void main(String[] args){
        ArrayList<Integer> bloquesD = new ArrayList<>();
        bloquesD.addLast(3);
        bloquesD.addLast(2);
        bloquesD.addLast(5);
        bloquesD.addLast(4);
        bloquesD.addLast(1);

        simularApilamiento(bloquesD);
    }
    
    public static int simularApilamiento(ArrayList<Integer> bloquesDiponibles){
        Random random = new Random();
        Deque<Integer> torre = new LinkedList<>();
        int puntaje = 0;

        while (!bloquesDiponibles.isEmpty()){
            System.out.println("bloques disponibles: " + bloquesDiponibles);
            System.out.println("Torre actual: " + torre);

            int indiceAleatorio = random.nextInt(bloquesDiponibles.size());
            Integer bloqueElegido = bloquesDiponibles.get(indiceAleatorio);

            System.out.println("Bloque seleccionado: " + bloqueElegido);

            if (torre.peek() != null){
                if (bloqueElegido < torre.peek()){
                    torre.push(bloqueElegido);
                    puntaje += bloqueElegido;
                    bloquesDiponibles.remove(indiceAleatorio);
                }
                else {
                    System.out.println("El juego termina porque " + bloqueElegido + " es mayor que " + torre.peek());
                    return puntaje;
                }
            }
            // Sólo primera vez
            else if (torre.peek() == null){
                torre.push(bloqueElegido);
                puntaje += bloqueElegido;
                bloquesDiponibles.remove(indiceAleatorio);
            }
            else {
                System.out.println("El juego termina");
            }
        }

        return puntaje;        
    }
}
