package linkedlist;

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

    public Stack() {
        this.first = null;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(first); 
        first = newNode; 
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
        if (first == null) {
            System.out.println("Stack Kosong Tidak Dapat Menghapus Elemen");
            return null; 
        } else {
            Node<T> currentNode = first;
            T poppedValue = currentNode.getValue();
            first = currentNode.getNext();
            return poppedValue;
        }
    }

    public void swap(int index1, int index2) {
        int count = 0;
        Node<T> currentNode = first;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.getNext();
        }

        if (index1 < 0 || index2 < 0 || index1 >= count || index2 >= count) {
            System.out.println("Index tidak valid");
            return;
        }

        if (index1 == index2) {
            return;
        }

        Node<T> prev1 = null, prev2 = null;
        Node<T> node1 = first, node2 = first;

        for (int i = 0; i < count - index1 - 1; i++) {
            prev1 = node1;
            node1 = node1.getNext();
        }

        for (int i = 0; i < count - index2 - 1; i++) {
            prev2 = node2;
            node2 = node2.getNext();
        }

        if (prev1 != null) {
            prev1.setNext(node2);
        } else {
            first = node2;
        }

        if (prev2 != null) {
            prev2.setNext(node1);
        } else {
            first = node1;
        }

        Node<T> temp = node1.getNext();
        node1.setNext(node2.getNext());
        node2.setNext(temp);
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

        dataInt.hasPop(); // Memeriksa apakah stack tidak kosong
        dataInt.printList(); // Menampilkan stack (harus kosong pada awalnya)

        dataInt.push(1); 
        dataInt.push(2);
        dataInt.push(3);
        dataInt.hasPop(); // Memeriksa apakah stack tidak kosong
        dataInt.printList(); // Menampilkan stack setelah push

        dataInt.swap(0, 1); // Menukar elemen pada indeks 0 dan 1
        dataInt.printList(); // Menampilkan stack setelah swap
    }
}
