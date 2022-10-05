package Duck;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallDuck = new MallardDuck();
        mallDuck.performQuack();
        mallDuck.performFly();
        Duck modal = new ModalDuck();
        modal.performFly();
        modal.setFlyBehaviour(new FlyRocketPowered());
        modal.performFly();
        DuckCall manMade = new ManMadeDuck();
        manMade.setQuackBehaviour(new CustomQuacks("speak"));
        manMade.performQuack();
    }
}
