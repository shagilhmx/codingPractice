package Duck;

public class ManMadeDuck extends DuckCall {
    public ManMadeDuck() {
        quackBehaviour = new Quack();
    }

    public void display() {
        System.out.println("I'm a man made duck!");
    }
}
