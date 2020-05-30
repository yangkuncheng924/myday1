package C_Prototype.Protorype_Improve1;

/**
 * @City
 * 克隆羊解决  原型模式
 * 但是存在浅拷贝问题
 * @City
 */
public class Client{
    public static void main(String[] args) {
        Sheep sheep1 = new Sheep("tom", 17, "baise");

        sheep1.friend=new Sheep("jack",2,"黑色");

        Sheep sheep2=(Sheep)sheep1.clone();
        Sheep sheep3=(Sheep)sheep1.clone();

        System.out.println(sheep1+""+sheep1.friend.hashCode());
        System.out.println(sheep2+""+sheep1.friend.hashCode());
        System.out.println(sheep3+""+sheep1.friend.hashCode());






    }
}
