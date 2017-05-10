/**
 * Created by cjm on 5/10/17.
 */
public class WeatherData {

    private float temperature;
    private float humidity;
    private float pressure;
    private float windspeed;

    public WeatherData(float temperature, float humidity, float pressure, float windspeed) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windspeed = windspeed;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public float getWindspeed() {
        return windspeed;
    }
}
