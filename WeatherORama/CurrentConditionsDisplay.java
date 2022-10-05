package WeatherORama;

public class CurrentConditionsDisplay implements Observer, Display {
    // this display implements observer so it gets changes from the weatherData
    // object.
    // it also implements Display because our api is going to require all display
    // elements to implement this interface.
    private float temperatue;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        // this constructor is passed the weatherData object(the subject) and we use it
        // to register the display as an observer.
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        // print outs the most recent temperature and humidity.
        System.out.println("Current Conditions: " + temperatue + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temperatue, float humidity, float pressure) {
        // when update() is called we save the temp and humidity and call display();
        this.temperatue = temperatue;
        this.humidity = humidity;
        display();
    }

}
