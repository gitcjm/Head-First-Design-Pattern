/**
 * Created by cjm on 5/10/17.
 */
public class Simulator {

    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();

        ws.registerObserver(new Browser());
        ws.registerObserver(new Browser());

        ws.measurementsChanged(20, 80, 101, 3);
        ws.notifyObserver();

        ws.measurementsChanged(22, 69, 103, 4);
        ws.notifyObserver();
    }
}
