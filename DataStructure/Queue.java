package DataStructure;

public class Queue<T> implements DataStructure<T> {

    private class Node {
        T key;
        Node next;

        Node(T key) {
            this.key = key;
            this.next = null;
        }
    };

    private Node front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    @Override
    public void push(T key) {
        Node temp = new Node(key);

        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        this.rear.next = temp;
        this.rear = temp;
    }

    @Override
    public void pop() {
        if (empty())
            return;

        this.front = this.front.next;

        if (this.front == null)
            this.rear = null;
    }

    @Override
    public T front() {
        if (empty())
            return null;

        return this.front.key;
    }

    @Override
    public boolean empty() {
        if (this.front == null && this.rear == null)
            return true;
        return false;
    }

}
