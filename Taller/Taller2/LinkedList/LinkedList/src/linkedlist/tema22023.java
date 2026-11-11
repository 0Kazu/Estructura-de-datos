
import java.util.Iterator;

public class tema22023 {
    private static LinkedList<Integer>[] dividirLanzamientos(List<Integer> lista){
        LinkedList<Integer>[] listas = new LinkedList[3];
        LinkedList<Integer> lista1 = new LinkedList<>();
        LinkedList<Integer> lista2 = new LinkedList<>();
        LinkedList<Integer> lista3 = new LinkedList<>();

        // para rercorrer los elementos
        int count = 0;
        Iterator iterator = lista.iterator();

        while(iterator.hasNext()){
            switch(count%3){
                case 0:
                    lista1.addLast(iterator.next());
                    break;
                case 1:
                    lista2.addLast(iterator.next());
                    break;
                case 2:
                    lista3.addLast(iterator.next());
                    break;
            }

            count++;
        }

        listas[0] = lista1;
        listas[1] = lista2;
        listas[2] = lista3;

        return listas;
    }
    
}
