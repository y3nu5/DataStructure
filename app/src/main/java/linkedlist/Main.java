package linkedlist;
import java.util.EmptyStackException;

class Node {
    private Node next;
    private int value;

    public Node(int value){
        this.next = null;
        this.value = value;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
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

    public void push(int value) {
        Node newnode = new Node(value);
        newnode.setNext(this.top);
        this.top = newnode;
        this.size++;
    }

    public int pop(){
        if(this.top == null){
            throw new EmptyStackException();
        }
        int value = this.top.getValue();
        this.top = this.top.getNext();
        this.size--;
        return value;
    }

    public int peek(){
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

        // Pop the top two elements
        int first = pop();
        int second = pop();

        // Push them back in reversed order
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
        stack.push(8);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println("Original stack: " + stack);
        stack.swap();
        System.out.println("After swap: " + stack);
        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element after pop: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
    }
}
