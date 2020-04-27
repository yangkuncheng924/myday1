package DataStructures.B_queue;

import java.util.Scanner;

/**
 * @City
 * 队列是一个有序列表 可以用数组或是链表来实现
 * 遵循先入先出的原则 即：先存入队列的数据 要先取出，后存入的要后取出
 * @City
 */
public class ArrayQueue {
    public static void main(String[] args) {
        //测试
        //创建一个队列
        ArrayQueue1 arrayQueue1 = new ArrayQueue1(3);
        char key=' '; //接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        //输出一个菜单
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            System.out.println();

            key=scanner.next().charAt(0);//接受一个字符
            switch (key){
                case 's':
                    arrayQueue1.Iterator();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value=scanner.nextInt();
                    arrayQueue1.addQueue(value);
                    break;
                case 'e':
                    loop=false;
                    break;
                case 'g':
                    try {
                        int res=arrayQueue1.getQueue();
                        System.out.println("取出的数据是"+res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res=arrayQueue1.HeadQueue();
                        System.out.println("头数据是："+res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    loop=false;
            }

        }
        System.out.println("程序退出");

    }
}
//使用数组模拟队列 编写一个ArrayQueue1类
class ArrayQueue1{
    private int maxSize; //表示数组最大容量
    private int front;  //队列头
    private int rear;   //队列尾
    private int[] arr;  //该数据用于存放数据，模拟队列

    //创建对象的构造器
    public  ArrayQueue1(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        front=-1;   //指向队列头部，分析出front是指向队列头的前一个位置
        rear=-1;    //指向队列尾，指向队列尾的数据（即就是队列最后一个数据）
    }

    //判断队列是否满
    public  boolean isFull(){
        return rear==maxSize-1;
    }

    //判断队列是否为空
    public  boolean isEmpty(){
        return  rear==front;
    }

    //添加数据到队列
    public void addQueue(int e){
        //判断队列是否已满
        if(isFull()){
            System.out.println("队列已满");
        }
        //后移
        rear++;
        arr[rear]=e;
    }

    //弹出数据 出队列
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列空 不能取出数据");
        }
        front++;
        return arr[front];
    }

    //遍历
    public void Iterator(){
        //判断队列是否为空
        if(isEmpty()){
            System.out.println("队列是空，没有数据");
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示头数据
    public int HeadQueue(){

        if(isEmpty()){
            System.out.println("错误~~~~~~~~~~~~~头数据");
            throw new RuntimeException("队列是空，没有数据");
        }
        return arr[front+1];
    }
}
