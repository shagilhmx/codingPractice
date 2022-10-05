package WeatherORama;

public class HeatIndex implements Observer, Display {
    private float temperatue;
    private float humidity;
    private Subject weatherData;

    public HeatIndex(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        // To display the heat map.
        double heatIndex = 16.923 + 1.85212 * Math.pow(10, -1) * temperatue + 5.37941 * humidity
                - 1.00254 * Math.pow(10, -1) * temperatue * humidity
                + 9.41695 * Math.pow(10, -3) * Math.pow(temperatue, 2)
                + 7.28898 * Math.pow(10, -3) * Math.pow(humidity, 2)
                + 3.45372 * Math.pow(10, -4) * Math.pow(temperatue, 2) * humidity
                - 8.14971 * Math.pow(10, -4) * temperatue * Math.pow(humidity, 2)
                + 1.02102 * Math.pow(10, -5) * Math.pow(temperatue, 2) * Math.pow(humidity, 2)
                - 3.8646 * Math.pow(10, -5) * Math.pow(temperatue, 3)
                + 2.91583 * Math.min(10, -5) * Math.pow(humidity, 3)
                + 1.42721 * Math.pow(10, -6) * Math.pow(temperatue, 3) * humidity
                + 1.97483 * Math.pow(10, -7) * temperatue * Math.pow(humidity, 3)
                - 2.18429 * Math.pow(10, -8) * Math.pow(temperatue, 3) * Math.pow(humidity, 2)
                + 8.4326 * Math.pow(10, -10) * Math.pow(temperatue, 2) + Math.pow(humidity, 3)
                - 4.81975 * Math.pow(10, -11) * Math.pow(temperatue, 3) * Math.pow(humidity, 3);
        System.out.println("heat index: " + heatIndex);
    }

    @Override
    public void update(float temperatue, float humidity, float pressure) {
        // to update with the recent data chanegs.
        this.temperatue = temperatue;
        this.humidity = humidity;
        display();
    }

}
