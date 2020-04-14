package A_Single_Principle_1;

/**
 * @City
 * 单一职责原则
 * 1 降低类的复杂度 一个类只维护一个职责
 * 2 提高类的可读性 可维护性
 * 3 降低变更引起的风险
 * 4 通常情况下 我们应当遵守单一职责原则 只有逻辑足够简单 才可以在代码及违反单一职责
 * 只有类中方法数量足够少 可以在方法界别保持单一职责原则
 * @City
 */
public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehiccle vehiccle = new Vehiccle();
        vehiccle.run("公交车");
        vehiccle.run("电动车");
        vehiccle.run("摩托车");
    }
}
//交通工具类
//方案一：
//在run的方法中，违反了单一职责的原则
//解决方法的问题很简单 只需多创建几个类即可
class Vehiccle{
    public  void run(String vehiccle){
        System.out.println(vehiccle+"在公路上跑");
    }
        }