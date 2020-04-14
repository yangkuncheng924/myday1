package A_Single_Principle_1;

/**
 * @City
 * @City
 */
public class SingleResponsibilty2 {
    public static void main(String[] args) {
         RoadVehicle roadVehicle=new RoadVehicle();
         AirVehicle airVehicle=new AirVehicle();
         WateVehicle wateVehicle=new WateVehicle();
         roadVehicle.run("汽车");
         airVehicle.run("飞机");
         wateVehicle.run("轮船");
        }
}
//方案二：
/*
* 遵守单一职业原则
* 但是改动很大 花销大 将类分解 并且修改客户端
* 改进：直接修改Vehicle类，改动的代码会少 具体方案三
* */
class RoadVehicle{
    public  void run(String vehicle){
        System.out.println(vehicle+"在公路上跑");
    }
}
class AirVehicle{
    public  void run(String vehicle){
        System.out.println(vehicle+"在天空上跑");
    }
}
class WateVehicle{
    public  void run(String vehicle){
        System.out.println(vehicle+"在水上上跑");
    }
}

