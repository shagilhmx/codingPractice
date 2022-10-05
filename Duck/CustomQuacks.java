package Duck;

public class CustomQuacks implements QuackBehaviour {
    private String x;

    public CustomQuacks(String x) {
        this.x = x;
    }

    public void quack() {
        System.out.println(x);
    }
}
