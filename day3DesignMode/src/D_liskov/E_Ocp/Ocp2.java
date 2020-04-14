package D_liskov.E_Ocp;

/**
 * @City
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
