public class practice {
    public static void main(String[] args) {
        Example ex = new Example();
        ex.display();
        Example2 ex2 = new Example2();
        ex.display();
        ex2.display();
    }
}

class Example {
    int x, y;

    public Example() {
        this(7, 5);

    }

    public Example(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void display() {
        System.out.println(x + " " + y);
    }
}

class Example2 extends Example {
    int x, y;

    public Example2() {
        this.x = super.x;
        this.y = super.y;
    }

    public void display() {
        System.out.println("ans" + (x + y));
    }
}