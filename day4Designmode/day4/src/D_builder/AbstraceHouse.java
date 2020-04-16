package D_builder;

/**
 * @City
 * 建造者模式
 * @City
 */
public abstract class AbstraceHouse {
        //打地基
    public  abstract  void  buildBasic();
        //砌墙
    public  abstract  void  buildWalls();
        //封顶
    public  abstract  void  roofed();

    public  void build(){
        buildBasic();
        buildWalls();
        roofed();
    }
}
