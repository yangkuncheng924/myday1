package E_Ocp1;

/**
 * @City
 * @City
 */
public class Ocp {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawCircle(new Circle());
    }
}
class  GraphicEditor{
    public  void drawShape(Shape s){
        if(s.m_type==1){
            drawRectangle(1);}
            else if(s.m_type==2){
                drawCircle(s);
            }
        }
        public void drawRectangle(int r){
            System.out.println("矩形");
        }
        public void drawCircle(Shape r){
            System.out.println("圆形");
        }
    }
// Shape 基类
class Shape{
    int m_type;
}

class Rectangle extends  Shape{
    Rectangle(){
        super.m_type=1;
    }
}

class Circle extends  Shape{
    Circle(){
        super.m_type=2;
    }
}