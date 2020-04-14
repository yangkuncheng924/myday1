package A_Single_Principle_1;

/**
 * @City
 * @City
 */
public class SingleRespronsibilty3 {
    public static void main(String[] args) {
        RoadVehicle1 roadVehicle1 = new RoadVehicle1();
        roadVehicle1.run("汽车");
        RoadVehicle1 roadVehicle = new RoadVehicle1();
        roadVehicle.runAir("飞机");
        RoadVehicle1 roadVehicle11 = new RoadVehicle1();
        roadVehicle11.runWater("轮船");
    }
}
/*
* 方式3的分析
* 这里修改方法没有对原来的类做出过大的修改 只是增加方法
* 这里虽然没有在类这个级别上遵守单一原则 但是在方法级别上 依然是遵守单一的职责
* */

class RoadVehicle1{
    public  void run(String vehicle){
        System.out.println(vehicle+"在公路上跑");
    }
    public  void runAir(String vehicle){
        System.out.println(vehicle+"在天上跑");
    }
    public  void runWater(String vehicle){
        System.out.println(vehicle+"在水上跑");
    }
}
