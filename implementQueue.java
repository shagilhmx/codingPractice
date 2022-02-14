import java.util.Scanner;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
};

public class implementQueue {
    Node qfront, qrear;

    public static void main(String[] args) {
        implementQueue obj = new implementQueue();
        Scanner in = new Scanner(System.in);
        int choice = 99;
        while (choice != 4) {
            choice = in.nextInt();
            switch (choice) {
                case 0:
                    if (obj.isEmpty() == true)
                        System.out.println("Empty");
                    else
                        obj.display();
                    break;
                case 1:
                    int data = in.nextInt();
                    obj.enqueue(data);
                    obj.display();
                    break;
                case 2:
                    int delData = obj.dequeue();
                    System.out.println("Deleted Element from Queue: " + delData);
                    obj.display();
                    break;
                case 3:
                    int f = obj.front();
                    System.out.println("Front element in queue: " + f);
                    break;
                default:
                    obj.display();
            }
        }
        in.close();
    }

    implementQueue() {
        qfront = null;
        qrear = null;
    }

    boolean isEmpty() {
        return qfront == null;
    }

    void enqueue(int data) {
        Node temp = new Node(data);
        if (qfront == null)
            qfront = qrear = temp;
        else {
            qrear.next = temp;
            qrear = temp;
        }
        return;
    }

    int dequeue() {
        if (qfront == null)
            return -1;
        int ans = qfront.val;
        qfront = qfront.next;

        if (qfront == null)
            qrear = null;

        return ans;
    }

    int front() {
        if (qfront == null)
            return -1;
        return qfront.val;
    }

    void display() {
        Node temp = qfront;
        System.out.println("Data in Queue");
        if (temp == null)
            System.out.println("Queue is Empty");
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
