package DataStructures.D_Stack;

import java.util.Scanner;

/**
 * @City
 * @City
 */
public class ArrayStackDemo{
    public static void main(String[] args) {
        //测试栈是否能用
        //定义栈
        ArrayStack stack=new ArrayStack(3);
        String key=" ";
        boolean loop=true;//控制是否退出
        Scanner scanner=new Scanner(System.in);
        while (loop){
            System.out.println("show：显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：表示添加数据入栈");
            System.out.println("pop：表示从栈中取出数据");
            System.out.println("请输入你的选择");
            key=scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value=scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    int res=stack.pop();
                    try {
                        System.out.println("弹出数据是"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":{
                    scanner.close();
                    loop=false;
                   break;}
                default:
                    break;
            }
        }
        System.out.println("程序已退出");
    }
}

//定义一个ArrayStack 表示栈
class ArrayStack{
    private int maxSize;//栈的大小
    private int[] stacke; //数组，数组模拟栈，数据就放在该数组
    private int top=-1; //top表示栈顶，初始化为-1;

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize=maxSize;
        stacke=new int[this.maxSize];
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
}