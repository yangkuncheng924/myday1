package P_observer1;

/**
 * @City
 * @City
 */
public class client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        //创建观察者
        CurrentConditions currentConditions = new CurrentConditions();
        BaiduSite baiduSite = new BaiduSite();

        //注册到weatherData
        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(baiduSite);

        //测试
        System.out.println("通知各个注册的观察者，看看信息");
        weatherData.setData(20, 30, 100f);
        //移除
        System.out.println();
        weatherData.removeObserver(currentConditions);
        weatherData.setData(202, 301, 50);




    }
}
