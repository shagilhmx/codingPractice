package WeatherORama;

import java.util.ArrayList;

public class StatisticsDisplay implements Observer, Display {
    private float temperatue;
    private float humidity;
    private float pressure;
    private Subject weatherData;
    private ArrayList<Float> tempArr;
    private ArrayList<Float> humidArr;
    private ArrayList<Float> pressArr;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
        tempArr = new ArrayList<>();
        humidArr = new ArrayList<>();
        pressArr = new ArrayList<>();
    }

    @Override
    public void display() {
        // For displaying the avg, min and max.
        ArrayList<Float> tempData = calculate(tempArr);
        ArrayList<Float> humidData = calculate(humidArr);
        ArrayList<Float> pressData = calculate(pressArr);

        System.out.println("Average temperatue: " + tempData.get(0) + "F Minimum temprature: " + tempData.get(1)
                + "F Maximum temperature: " + tempData.get(2) + "F");
        System.out.println("Average humidity: " + humidData.get(0) + "% Minimum humidity: " + humidData.get(1)
                + "% Maximum humidity: " + humidData.get(2) + "%");
        System.out.println("Average pressure: " + pressData.get(0) + " Minimum pressure: " + pressData.get(1)
                + " Maximum pressure: " + pressData.get(2));
    }

    @Override
    public void update(float temperatue, float humidity, float pressure) {
        // For setting the current data and calling the display method.
        this.temperatue = temperatue;
        this.humidity = humidity;
        this.pressure = pressure;
        tempArr.add(temperatue);
        humidArr.add(humidity);
        pressArr.add(humidity);
        display();
    }

    public ArrayList<Float> calculate(ArrayList<Float> data) {
        ArrayList<Float> ans = new ArrayList<>();
        float sum = 0, minElem = Integer.MAX_VALUE, maxElem = Integer.MIN_VALUE;

        for (float each : data) {
            sum += each;
            minElem = Math.min(minElem, each);
            maxElem = Math.max(maxElem, each);
        }

        ans.add(0, (float) (sum / data.size()));
        ans.add(1, maxElem);
        ans.add(2, minElem);

        return ans;
    }
}
