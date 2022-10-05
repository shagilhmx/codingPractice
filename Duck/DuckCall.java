package Duck;

public abstract class DuckCall {
    QuackBehaviour quackBehaviour;

    public DuckCall() {

    }

    public abstract void display();

    public void setQuackBehaviour(QuackBehaviour qb) {
        quackBehaviour = qb;
    }

    public void performQuack() {
        quackBehaviour.quack();
    }
}
