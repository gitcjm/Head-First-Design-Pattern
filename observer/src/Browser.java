/**
 * Created by cjm on 5/10/17.
 */
public class Browser implements Observer {

    public void update(WeatherData data) {
        System.out.println("最新天气情况：");
        System.out.println("温度 " + data.getTemperature());
        System.out.println("湿度 " + data.getHumidity());
        System.out.println("气压 " + data.getPressure());
        System.out.println("风速 " + data.getWindspeed());
    }
}
