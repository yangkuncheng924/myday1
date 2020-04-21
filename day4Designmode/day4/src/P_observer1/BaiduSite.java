package P_observer1;

/**
 * @City
 * @City
 */
public class BaiduSite implements Observer {
    private float temperature;//温度
    private float pressure;    //气压
    private float humidity;   //湿度

    public  void display(){
        System.out.println("百度网盘");
        System.out.println("百度气温:"+temperature+"***");
        System.out.println("百度气压e:"+pressure+"***");
        System.out.println("百度湿度:"+humidity+"***");
    }


    @Override
    public void ubdate(float temperature, float pressure, float humidity) {

        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        display();
    }
}
