package linkedlist;
package com.example;


class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext(){
        return next;
    }

    public T getValue() {
        return value;
    }
}

class Stack<T> {
    private Node<T> first;

    public Stack(){
        this.first = null;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(first); // Set node baru untuk menunjuk ke node teratas saat ini
        first = newNode; // Update 'top' untuk menjadi node baru
    }

    public boolean hasPop() {
        if (first != null) {
            System.out.println("Stack tidak kosong!");
            return true;
        } else {
            System.out.println("Stack Kosong!");
            return false;
        }
    }

    public T pop() {
        if(first == null) {
            System.out.println("Stack Kosong Tidak Dapat Menghapus Elemen");
            return null; // Mengembalikan null untuk tipe generik
        } else {
            Node<T> currentNode = first;
            T poppedValue = currentNode.getValue();
            first = currentNode.getNext();
            return poppedValue;
        }
    }

    public void printList() {
        Node<T> currentNode = first;
        
        while (currentNode != null) {
            System.out.print(" <- " + currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();
        System.out.println("-------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Stack<Integer> dataInt = new Stack<>();
        Stack<Character> dataChar = new Stack<>();

        dataInt.pop(); // Seharusnya menggunakan stackInt, bukan list
        dataInt.hasPop();
        dataInt.printList();

        dataInt.push(1);
        dataInt.push(2);
        dataInt.push(3);
        dataInt.hasPop();
        dataInt.printList(); 

        dataInt.pop();
        dataInt.printList();
    }
}
