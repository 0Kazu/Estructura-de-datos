package Ayudantia1;

import java.util.Iterator;
// import java.util.List;
import java.util.ListIterator;

public class ArrayList<E> implements List<E>{
    private E[] elements = null;
    private int capacity = 100;
    private int effectiveSize;

    public void addCapacity(){
        if (effectiveSize == capacity){
            E[] newElements = (E[]) new Object[capacity*2];

            for (i = 0; i < capacity; i++){
                newElements[i] = elements[i];
            }

            elements = newElements;

            capacity *= 2;
        }
    }

    @Override
    public boolean isFull(){
        return capacity == effectiveSize;
    }

    @Override
    public int size(){
        return effectiveSize;
    }

    @Override
    public boolean isEmpty(){
        return effectiveSize == 0;
    }

    @Override
    public boolean addFirst(E element){
        if (element == null || isEmpty()) return false;

        if (isFull()) addCapacity();

        // De todas formas harás...
        E[] tmp = (E[]) new Object[capacity];

        for (i = effectiveSize; i > 0; i--){
            elements[i] = elements[i - 1]; // Bit shifting
        }   

        // Desplazar
        for (int i = effectiveSize - 1; i >= 0; i--){
            elements[i+1] = elements[i]; // Siguiente = Anterior (Bit shifting)
        }

        elements[0] = element;
        effectiveSize++;
        return true;
    }

    @Override
    public boolean addLast(E element){
        if (e == null){
            return false;
        }
        if (isFull()){
            addCapacity();
        }
        
        elements[effectiveSize] = element;
        effectiveSize++;
        // o también: elements[effectiveSize++] = e;
        
        return true;
    }

    @Override
    public E get(int index){
        if (!isEmpty() && index >= 0 && index < effectiveSize){
            return elements[index];
        }
        return null;
    }

    public E set(int index, E element){
        if (isEmpty() && index < 0 && index > effectiveSize){
            throw new IndexOutOfBoundsException("Error de índice");
        }
        E oldElement = elements[index]; 
        elements[index] = element;
        return oldElement;
    }

    public E remove(int index){
        if (!isEmpty() && index >= 0 && index < effectiveSize && isEmpty()){
            throw new IndexOutOfBoundsException("Error de índice");
        }
        else if (index == 0) return removeFirst();
        else if (index == effectiveSize - 1) return removeLast();
        else {
            eRemove = elements[index];

            for (int i = index; i < effectiveSize - 1; i++) {
                elements[i] = elements[i + 1];
            }

            elements[effectiveSize - 1] = null;
            effectiveSize--;
        }

        return eRemove;
    }

    @Override
    public E removeFirst(){
        if (isEmpty()) return null;

        E eRemove = elements[0];

        for (int i = 0; i < effectiveSize - 1; i++){
            elements[i] = elements[i + 1];
        }

        elements[effectiveSize - 1] = null;
        effectiveSize--;

        return eRemove;
    }

    @Override
    public E removeLast(){
        if (isEmpty()) return null;

        E eRemove = elements[effectiveSize - 1];

        elements[effectiveSize - 1] = null;
        effectiveSize--;

        return eRemove;
    }

    public ArrayList<El[]> runLengthEncodeConsecutive(){
        ArrayList<El[]> respuesta = new ArrayList<>();

        if (isEmpty()) return respuesta;

        E current = elements[0];
        int count = 0;

        for (int i = 0; i < effectiveSize; i++){
            if (primero.equals(elements[i])){
                count++;
            }
            else{
                respuesta.addLast(new Object[] {current, count});

                count = 1;
            }
        }

        respuesta.addLast(new Object[] {current, count});
    }
}


