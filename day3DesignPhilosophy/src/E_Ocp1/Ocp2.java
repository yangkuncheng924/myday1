package E_Ocp1;

/**
 * @City
 * 1.开闭原则 是编程中 最基础最重要的设计原则
 * 2.一个软件实体如类，模块和函数应该对扩展开放，对修改关闭。用抽象构建框架，用实现扩展细节
 * 3.当软件需要变化时，尽量通过扩展软件实体的行为来实现变化，而不是通过修改已用的代码来实现变化。
 * 4.编程中遵循其它原则，以及使用设计模式的目的就是遵循开闭 原则
 * @City
 */
public class Ocp2 {
    public static void main(String[] args) {
        GraphicEditor1 graphicEditor = new GraphicEditor1();
        graphicEditor.drawShape1(new Rectangle1());
        graphicEditor.drawShape1(new Circle1());
        graphicEditor.drawShape1(new Taiangle());
    }
}
class  GraphicEditor1 {
    public void drawShape1(Shape1 s) {
        s.draw();
    }
}
// Shape 基类
abstract class Shape1 {
    int m_type1;
    public abstract  void draw(); //抽象方法
}

class Rectangle1 extends  Shape1{
    Rectangle1(){
        this.m_type1=1;
    }
    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}

class Circle1 extends  Shape1{
    Circle1() {
        this.m_type1= 2;
    }
    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}
class Taiangle extends  Shape1 {
    Taiangle() {
        this.m_type1 = 3;
        System.out.println("Nihao");
    }

    @Override
    public void draw() {
        System.out.println("绘制三角形");
    }

}
