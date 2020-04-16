package D_builder.House;

/**
 * @City
 * @City
 */
public class HouseDirector {
    HouseBuilder houseBuilder=null;

    //构造器传入 对象
    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //通过set传入对象

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //如何建造房子流程交给指挥者
    public Hose constructHose(){
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return  houseBuilder.builHose();
    }
}
