package linkedlist;

import java.util.LinkedList;

import org.w3c.dom.Node;

public class DoublyLinkedList {
    public void reOrdenar(int n){
        if (isEmpty() || n > 0){
            return;
        }
        if (this.head == this.last) {
            System.out.println(this);
        }
        if (head == null && head.next == null) return;


        reOrdenarHelper(head, size, n);
    }

    public void reOrdenarHelper(Node current, int count, int n){
        if (current == null || count == 0) return;

        Node nextNode = current.next;

        if (current.element > n) {
            if (current == head) {
                head = current.next;
                if (head != null) {
                    head.prev = null;
                }
            } else {
                current.prev.next = current.next;
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
            }

            addLast(current);
        }

        reOrdenarHelper(nextNode, count - 1, n);
    }
    
}
