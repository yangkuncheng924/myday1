package C_Prototype;

/**
 * @City
 * 克隆羊的问题
 * @City
 */
public class Client {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("tom", 17, "baise");

        Sheep sheep1=new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
        Sheep sheep2=new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
        Sheep sheep3=new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
        Sheep sheep4=new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
        Sheep sheep5=new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
        System.out.println(sheep5);
        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
    }
}
