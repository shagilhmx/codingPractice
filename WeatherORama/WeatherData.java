package WeatherORama;

import java.util.HashSet;

public class WeatherData implements Subject {
    private HashSet<Observer> observers; // For holding the observers, and we create it in a constructor.
    private float temprature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new HashSet<>();
    }

    @Override
    public void registerObserver(Observer ob) {
        // when an observer registers we just add him to the end of the list.
        observers.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        // when the observer want to un-register just remove it.
        observers.remove(ob);
    }

    @Override
    public void notifyObserver() {
        // This is the place we tell the observer about the state, as we know they are
        // all observers, we know all implement update(), so we know how to notify them.
        for (Observer observer : observers)
            observer.update(temprature, humidity, pressure);
    }

    public void measurementsChanged() {
        // we will tell observers when we get updated measurments from the weather
        // station.
        notifyObserver();
    }

    public void setMeasurments(float temperatue, float humidity, float pressure) {
        this.temprature = temperatue;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    // other weatherData methods here.
}
