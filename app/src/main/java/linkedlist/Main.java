package linkedlist;
import java.util.EmptyStackException;

class Node {
    private Node next;
    private char value;

    public Node(char value){
        this.next = null;
        this.value = value;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public char getValue(){
        return value;
    }

    public void setValue(char value){
        this.value = value;
    }
}

class Stack {
    private Node top;
    private int size;

    public Stack(){
        this.top = null;
        this.size = 0;
    }

    public void push(char value) {
        Node newnode = new Node(value);
        newnode.setNext(this.top);
        this.top = newnode;
        this.size++;
    }

    public char pop(){
        if(this.top == null){
            throw new EmptyStackException();
        }
        char value = this.top.getValue();
        this.top = this.top.getNext();
        this.size--;
        return value;
    }

    public char peek(){
        if(this.top == null){
            throw new EmptyStackException();
        }
        return this.top.getValue();
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }

    public void swap() {
        if (this.size < 2) {
            throw new IllegalStateException("Stack must have at least two elements to swap");
        }

        char first = pop();
        char second = pop();

        push(first);
        push(second);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = top;
        while (current != null) {
            sb.append(current.getValue()).append(" ");
            current = current.getNext();
        }
        return sb.toString().trim();
    }
}

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');
        stack.push('e');
        System.out.println("Original stack: " + stack);
        stack.swap();
        System.out.println("After swap: " + stack);
        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element after pop: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
    }
}
