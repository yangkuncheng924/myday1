package P_observer;

/**
 * @City
 * 类是核心  1.包含最新的天气情况信息
 *           2.含有CurrentConditions对象
 * @City    3.当数据有更新时，就主动的调用 CurrentConditions对象update方法
 *             （含display），这样他们（接入方）就看到最新的信息
 */
public class WeatherData {
    private float temperature;//温度
    private float pressure;    //气压
    private float humidity;   //湿度
    private CurrentConditions currentConditions;

   public WeatherData(CurrentConditions currentConditions) {
      this.currentConditions = currentConditions;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }
    public  void dataChange(){
        currentConditions.update(getTemperature(),getPressure(),getHumidity());
    }

    public void setData(float temperature,float pressure,float humidity) {
        this.temperature = temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        dataChange();
    }
}
