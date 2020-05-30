package R_iterpreter;

import java.util.HashMap;

/**
 * @City
 * 抽象运算符解析器 这里 每个运算符合都只和自己左右两个数字有关系
 * 但左右两个数字有可能也是一个解析的结果，无论何种类型，都是Expression类的实现类
 * @City
 */
public class SymbolExpression extends Expression{

    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    //因为symbolExpression是让其子类来实现，因此interpreter是一个默认实现
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return 0;
    }
}
