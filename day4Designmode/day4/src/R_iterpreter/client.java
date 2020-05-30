package R_iterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @City
 * @City
 */
public class client {
    public static void main(String[] args) throws IOException {
        String expStr=getExpStr();//a+b
        HashMap<String,Integer>var=getValue(expStr);

        Calculator calculator=new Calculator(expStr);
        System.out.println("运算结果："+expStr+"="+calculator.run(var));

    }
    //获取表达式
    public static String getExpStr() throws IOException {
        System.out.println("请输入表达式");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }
    //获得值映射
    public static HashMap<String,Integer>getValue(String  expStr) {
        HashMap<String, Integer> map = new HashMap<>();
        for (char ch : expStr.toCharArray()) {
            if (ch != '+' && ch != '-') {
                System.out.println("请输入a的值");

                return null;
            }
        }
        return getValue(expStr);
    }

}
