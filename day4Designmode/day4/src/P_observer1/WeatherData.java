package P_observer1;

import java.util.ArrayList;

/**
 * @City
 * 类是核心  1.包含最新的天气情况信息
 *           2.含有观察者集合，使用ArrayList管理
 * @City    3.当数据有更新时，就主动的调用  ArrayList
 *             通知所有的（（接入方）就看到最新的信息
 */
public class WeatherData implements Subject{
    private float temperature;//温度
    private float pressure;    //气压
    private float humidity;   //湿度
    //观察者模式
    private ArrayList<Observer>observers;

   public WeatherData() {
      observers=new ArrayList<>();
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
        notifyObservers();
    }

    public void setData(float temperature,float pressure,float humidity) {
        this.temperature = temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        dataChange();
    }

    //注册一个观察者
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    //移除一个观察者
    @Override
    public void removeObserver(Observer o) {
        if(observers.contains(o)) {
            observers.remove(o);
        }
    }

    //遍历所有观察者 并通知
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).ubdate(this.temperature, this.pressure, this.humidity);
        }

    }
}
