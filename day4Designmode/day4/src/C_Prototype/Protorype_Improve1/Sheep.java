package C_Prototype.Protorype_Improve1;

/**
 * @City
 * @City
 */
public class Sheep  implements Cloneable{
   public    String name;
   public    int    age;
   public    String color;
   public    Sheep  friend;

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    //克隆该实例，使用默认colone方法来完成
    @Override
    protected Object clone(){
        Sheep sheep=null;
        try {
            sheep = (Sheep)super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return sheep;
    }
}
