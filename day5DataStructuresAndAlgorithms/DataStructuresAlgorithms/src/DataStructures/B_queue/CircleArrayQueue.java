package DataStructures.B_queue;

import java.util.Scanner;

/**
 * @City
 * @City
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        //测试
        //创建一个环形队列
        CircleArray circleArrayQueue = new CircleArray(4);//说明设置4，其队列的有效数据最大是3
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
                    circleArrayQueue.Iterator();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value=scanner.nextInt();
                    circleArrayQueue.addQueue(value);
                    break;
                case 'e':
                    loop=false;
                    break;
                case 'g':
                    try {
                        int res=circleArrayQueue.getQueue();
                        System.out.println("取出的数据是"+res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res=circleArrayQueue.HeadQueue();
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


class CircleArray {
    private int maxSize; //表示数组最大容量
    //变量的含义做一个调整：front 就指向队列的第一个元素,也就是说arr[front]
    //front的初始值=0；
    private int front;
    //rear变量的含义做一个调整：rear指向队列最后一个元素的后一个位置。因为希望空出一个空间作为约定
    //rear的初始值=0
    private int rear;   //队列尾
    private int[] arr;  //该数据用于存放数据，模拟队列

    //创建对象的构造器
    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

        //判断队列是否满
        public  boolean isFull(){
            return (rear+1)%maxSize==front;
        }

    //判断队列是否为空
    public  boolean isEmpty(){
        return  rear==front;
    }

    //添加数据到队列
    public void addQueue(int e) {
        //判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满");
        }
        //直接将数据加入
        arr[rear]=e;
        //将rear后移，这里必须考虑取模
        rear=(rear+1)%maxSize;
    }

    //弹出数据 出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列空 不能取出数据");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1.先把front对应的值保留到一个临时变量
        //2.将front后移，考虑取模
        // 3.将临时保存的变量返回
        // *
        int value=arr[front];
        front=(front+1)%maxSize;
        return value;
    }

    //遍历
    public void Iterator(){
        //判断队列是否为空
        if(isEmpty()){
            System.out.println("队列是空，没有数据");
            return;
        }
        //思路：从front开始遍历，遍历多少个元素
        for (int i = 0; i <size(); i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i%maxSize]);
        }
    }
    //求出当前队列有效数据的个数
    public int size(){
        //rear=2    //队列尾
        //front=1   //指向队列第一个元素
        //maxSize=3 //表示数组最大容量
        return (rear+maxSize-front)%maxSize;    //2+3-1= 4%3=1
    }

    //显示头数据
    public int HeadQueue(){

        if(isEmpty()){
            System.out.println("错误~~~~~~~~~~~~~头数据");
            throw new RuntimeException("队列是空，没有数据");
        }
        return arr[front];
    }
}


