package C_Inversion;

/**
 * @City
 * 1.底层模块尽量都要有抽象类或接口 或者两者都有，程序稳定性更好
 * 2.变量的声明类型尽量是抽象类或者接口 这样我们的变量引用和实际对象间，就纯在一个缓冲层，利用程序扩展和优化
 * 3.继承时遵循里氏替换原则
 * @City
 */
public class DependecyInversion2
{
        public static void main(String[] args){
            //客户端无需改进
        Person1 peerson1 = new Person1();
        peerson1.receive(new Email1());
        peerson1.receive(new WeiXin());
}
}
//造成一个接口
interface Irceiver{
    public String  getinfo();
}
//完成一个Person接受消息的功能
class Person1{
    public void receive(Irceiver recciver){
        System.out.println(recciver.getinfo());
    }
}

class Email1 implements Irceiver{
    public String getinfo(){
        return "邮箱";
    }
}

class WeiXin implements Irceiver{
    public String getinfo(){
        return "微信";
    }
}

