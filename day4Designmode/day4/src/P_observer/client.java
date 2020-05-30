package P_observer;

/**
 * @City
 * @City
 */
public class client {
    public static void main(String[] args) {
        CurrentConditions currentConditions = new CurrentConditions();
        WeatherData weatherData = new WeatherData(currentConditions);
        weatherData.setData(20, 30,50 );

        System.out.println("天气变化情况");
        weatherData.setData(80, 130,40 );
    }
}
