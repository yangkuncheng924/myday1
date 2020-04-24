package DataStructuresAlgorithms.src.DataStructures.D_Stack;

import java.util.Scanner;

/**
 * @City
 * 栈实现综合计算器
 * @City
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String expression=" ";
        System.out.println("输入数字 本程序为计算机");
        expression=scanner.next();

        //创建两个栈 数栈和符号栈
        ArrayStack1 numStack=new ArrayStack1(10);
        ArrayStack1 operStack=new ArrayStack1(10);
        //定义需要相关变量
        int index=0;    //用于扫描
        int num1=0;
        int num2=0;
        int oper=0;
        int res=0;
        char ch=' ';//将每次扫描得到char保存到ch
        String keepNum="";//用于拼接多位数
        //开始while循环的扫描expression
        while (true){
            //依次得到expression的每一个字符
            ch=expression.substring(index, index+1).charAt(0);
            //判断ch是什么，然后做相应的处理
            if(operStack.isOper(ch)){//如果是运算符
                //判断当前的符号栈为空
                if(!operStack.isEmpty()){
                    //如果符号栈有操作符，就进行比较，
                    // 如果当前的操作符的优先级小于或者等于栈中的操作符就需要从数栈中pop出两个数，
                    //在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
                    if(operStack.priority(ch)<=operStack.priority(operStack.peek())){
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=operStack.pop();
                        res=numStack.cal(num1, num2, oper);
                        //把运算的结果入数栈
                        numStack.push(res);
                        //然后将当前的操作符入符号栈
                        operStack.push(ch);
                    }else{
                        //如果当前操作符的优先级别大于栈中的操作符，就直接入符号栈。
                        operStack.push(ch);
                    }
                }else {
                    //如果为空直接入符号栈。。
                    operStack.push(ch);
                }
            }else {//如果是数，则直接入数栈
                //numStack.push(ch-48);
                //分析思路
                //1.当处理多位数时，不能发现是一个数就立即入栈，因为它可能是多位数
                //2.在处理数，需要向expression的表达式index后再看一位，如果是数就进行扫描，如果符号入栈
                //3.因此我们需要定义一个变量字符串，用于拼接
                // */

                //处理多位数
                keepNum += ch;

                //若果ch已经是expression的最后一位，就直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是不是数字，如果是数字，就继续扫描 如果是运算符，则入栈
                    //注意是看后一位，不是index++
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，则入栈keepNum=“1”或者“123”
                        numStack.push(Integer.parseInt(keepNum));
                        //注意！！！ keepNum清空
                        keepNum = "";
                    }
                }
            }
            //让index+1，并判断是否扫描到expression最后
            index++;
            if(index>=expression.length()){
                break;
            }
        }
        //当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
        while (true){
            //如果符号栈为空，则计算到最后的结果，数栈中只有一个数字[结果]
            if(operStack.isEmpty()){
                break;
            }
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res=numStack.cal(num1, num2, oper);
            numStack.push(res);//入栈
        }
        //将数栈中最后数，pop出，就是结果
        int res2=numStack.pop();
        System.out.printf("表达式%s=%d",expression,res2);
    }
}
//定义一个ArrayStack 表示栈
class ArrayStack1{
    private int maxSize;//栈的大小
    private int[] stacke; //数组，数组模拟栈，数据就放在该数组
    private int top=-1; //top表示栈顶，初始化为-1;

    //构造器
    public ArrayStack1(int maxSize){
        this.maxSize=maxSize;
        stacke=new int[this.maxSize];
    }

    //增加一个方法，可以返回当前栈顶的值，但是不是真正的pop
    public int peek(){
        return  stacke[top];
    }

    //栈满
    public boolean isFull(){
        return  top==maxSize-1;
    }

    //栈空
    public boolean isEmpty(){
        return top==-1;
    }

    //入栈
    public void  push(int value){
        if(isFull()){
            System.out.println("栈满 无法添加");
            return;
        }
        top++;
        stacke[top]=value;
    }
    //出栈
    public int pop(){
        if(isEmpty()){
            System.out.println("栈空 无法出栈");
            return 0;
        }
        int value=stacke[top];
        top--;
        return value;
    }
    //遍历栈
    public void list(){
        if(isEmpty()){
            System.out.println("栈空 无法遍历");
            return;
        }
        for(int i=top;i>=0;i--){
            //i等于 top这里push数字top会++ i=top 1,2,3 top＝3
            // 假设 i=3；
            // i>=0；i这里肯定大于0；
            // i--；每遍历一次i-1，直到见到0；
            //所以遍历结果是 3，2,1
            System.out.printf("stacke[%d]\n",stacke[i]);
        }
    }
    //返回运算符的优先级 优先级是程序员来确定，优先级使用数字来表示
    //数字越大，则优先级越高
    public int  priority(int oper){
        if(oper=='*'||oper=='/'){
            return 1;
        }else if(oper=='+'||oper=='-'){
            return 0;
        }else {
            return -1;//假设目前表达式只有+ -* /
        }
    }

    //判断是不是运算符
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }

    //计算方法
    public int cal(int num1,int num2,int oper){
        int res=0;  //res用于存放计算的结果

        switch (oper){
            case  '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
                break;
            default:
                break;
        }
        return res;
    }
}
