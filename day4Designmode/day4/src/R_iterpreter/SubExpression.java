package R_iterpreter;

import java.util.HashMap;

/**
 * @City
 * @City
 */
public class SubExpression extends SymbolExpression {
    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }
    //相减：
    public int interpreter(HashMap<String,Integer>var){
        return super.left.interpreter(var)-super.right.interpreter(var);
    }
}
