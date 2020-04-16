package B_FactoryPattern1;

/**
 * @City
 * 那披萨做例子 工厂模式
 * @City
 *  将plant类做成抽象
 */
public  abstract  class plant{
    protected  String name;

    public  abstract  void prepare();

    public  void bake(){
        System.out.println(name+"baking");
    }

    public void cut(){
        System.out.println(name+"cutting");
    }
    public  void box(){
        System.out.println(name+"boxing");
    }
    public  void setName(String name){
        this.name=name;
    }
}


