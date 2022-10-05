package WeatherORama;

public interface Observer {
    public void update(float temperatue, float humidity, float pressure);
}

// All our weather components implements the observer interface.
// This gives the subject a common interface to talk to when it comes time to
// update the observer.