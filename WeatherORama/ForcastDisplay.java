package WeatherORama;

public class ForcastDisplay implements Observer, Display {
    private float temperatue;
    private float humidity;
    private Subject weatherData;

    public ForcastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        // to display the current conditions.
        if (temperatue > 120 && humidity > 70)
            System.out.println("Hot and Humid Weather");
        else if (temperatue > 110 && humidity > 60)
            System.out.println("Warm and Good Weather");
        else if (temperatue > 100 && humidity > 50)
            System.out.println("Improving weather on the way");
        else if (temperatue <= 100 && humidity <= 50)
            System.out.println("Cool and Dry Weather");
        else
            System.out.println("Hot and Bad Weather");
    }

    @Override
    public void update(float temperatue, float humidity, float pressure) {
        // For updating the display whenever there is change in data.
        this.temperatue = temperatue;
        this.humidity = humidity;
        display();
    }

}
