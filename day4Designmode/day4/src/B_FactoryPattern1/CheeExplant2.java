package B_FactoryPattern1;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * @City
 * @City
 */
public class CheeExplant2 {


          CheeExplant2(){
        plant plant1=null;
        String orderType;  //订购披萨的类型
        do{
            orderType=getType();
            System.out.println("您没有输入 已退出");
            if(orderType.equals("greek")){
                plant1=new CheeExPlant();
                plant1.setName("希腊披萨");
            }else if (orderType.equals("cheek")) {
                plant1 = new CheeExplant1();
                plant1.setName("奶酪披萨");
            }else {
                break;
            }
            //输出披萨制作过程
            plant1.prepare();
            plant1.bake();
            plant1.cut();
            plant1.box();
            break;
        } while(true);
    }
    //写一个方法 ，可以获取客户希望订购的披萨种类
    private  String getType() {
        String inl=null;
        BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("input pizza type");
            inl=strin.readLine();
            if(inl.equals(null)){
                return inl;
            }
                return  inl;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
