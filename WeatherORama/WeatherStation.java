package WeatherORama;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        // create the three displays and pass them the weatherData object.
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statDisplay = new StatisticsDisplay(weatherData);
        ForcastDisplay forcastedDisplay = new ForcastDisplay(weatherData);
        HeatIndex heatIndex = new HeatIndex(weatherData);

        // to simulate new weather measurment.
        weatherData.setMeasurments(80, 65, 30.4f);
        weatherData.setMeasurments(105, 72, 29.4f);
        weatherData.setMeasurments(115, 82, 28.4f);
    }
}
