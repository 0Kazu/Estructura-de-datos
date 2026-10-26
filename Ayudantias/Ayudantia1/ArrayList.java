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
        E eRemove = null;

        
    }
}


