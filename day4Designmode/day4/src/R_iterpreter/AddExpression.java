package R_iterpreter;

import java.util.HashMap;

/**
 * @City
 * 加法解释器
 * @City
 */
public class AddExpression extends  SymbolExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }
    //var就是{a=10,b=20}
    //处理相加
    public int interpreter(HashMap<String,Integer>var){
        //super.left.interpreter(var):返回left表达式对应的值a=10；
        //super.right.interpreter(var)：返回right 表达式对应值b=10；
        return  super.left.interpreter(var)+super.right.interpreter(var);
    }
}
