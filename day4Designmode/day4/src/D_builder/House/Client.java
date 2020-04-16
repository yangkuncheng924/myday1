package D_builder.House;

/**
 * @City
 * @City
 */
public class Client {
    public static void main(String[] args) {
        //创建普通房子
        CommonHouse commonHouse=new CommonHouse();
        //创建房子的指挥者
       HouseDirector houseDirector=new HouseDirector(commonHouse);
       //完成盖房子 接收
        Hose houseBuilder=houseDirector.constructHose();

        //创建高楼
        HighBuilding highBuilding=new HighBuilding();
        HouseDirector houseDirector1 = new HouseDirector(highBuilding);
        Hose hose = houseDirector1.constructHose();

    }

}
