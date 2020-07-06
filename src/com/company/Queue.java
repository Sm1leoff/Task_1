package com.company;

import java.util.NoSuchElementException;


class QueueMy<E> {

    private Node head;
    private Node tail;
    private int size;

    public QueueMy() {
        size = 0;
    }

    /**
     * this class keeps track of each element information
     *
     * @author java2novice
     */
    public class Node {
        E element;
        Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public E seeLast() {
        return tail.element;
    }

    public E seeFirst() {
        return head.element;
    }

    public void addLast(E element) {
        Node tmp = new Node(element, null);
        if (tail != null) {
            tail.next = tmp;
        }
        tail = tmp;
        if (head == null) {
            head = tmp;
        }
        size++;
    }

    public E removeAndReturnFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = head;
        if (size != 1) {
            head = head.next;
        } else {
            head = null;
            tail = null;
        }
        size--;
        return tmp.element;
    }

    public E removeAndReturnLast() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = tail;
        if (size==1){
            head = null;
            tail = null;
        } else {
            Node help = head;
            while (help.next!=tail){
                help = help.next;
            }
            tail = help;
            help.next = null;
        }
        size--;
        return tmp.element;
    }
}