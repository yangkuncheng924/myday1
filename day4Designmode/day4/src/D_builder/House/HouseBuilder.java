package D_builder.House;

/**
 * @City
 * 指挥者 这里会指定制作流程 返回一个产品
 * @City
 */
public abstract class HouseBuilder {
    private Hose hose=new Hose();

    //将建造的流程写好，抽象的方法
    public  abstract  void buildBasic();
    public  abstract  void buildWalls();
    public  abstract  void roofed();

    //建造方子好，将产品返回
    public Hose builHose(){
        return hose;
    }
}
