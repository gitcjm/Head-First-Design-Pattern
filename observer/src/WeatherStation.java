import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by cjm on 5/10/17.
 */
public class WeatherStation implements Subject {
    private ArrayList observers;
    private WeatherData weatherData;

    public WeatherStation() {
        observers = new ArrayList();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObserver() {
        Iterator iterator = observers.iterator();
        while( iterator.hasNext() ) {
            Observer o = (Observer)iterator.next();
            o.update(weatherData);
        }
    }

    public void measurementsChanged(float temperature, float humidity, float pressure, float windspeed) {
        weatherData = new WeatherData(temperature, humidity, pressure, windspeed);
    }
}
