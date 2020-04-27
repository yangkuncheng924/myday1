package src.Tree.B_SequentialStorageTree;

/**
 * @parameter
 * @effect  顺序存储二叉树
 * @return
 * @date 2020/4/27 18:42
 */
public class ArrBinaryTree {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7};
        //创建
        ArrBinaryTree1 arrBinaryTree1 = new ArrBinaryTree1(arr);
        arrBinaryTree1.preorde();
    }
}
//编写一个ArrBinaryTree 实现顺序存储二叉树的遍历
class ArrBinaryTree1{
    private int []arr;  //存储数据

    public ArrBinaryTree1(int[] arr) {
        this.arr = arr;
    }

    //重载
    public void preorde(){
        this.preorde(0);
    }
    //前序二叉树数组遍历
    public void preorde(int index){
        if(arr==null||arr.length==0){
            System.out.println("数组为空 无法遍历");
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向左递归遍历
        if((index*2+1)<arr.length) {
            preorde(2*index+1);
        }
        //向右递归遍历
        if((index*2+2)<arr.length){
            preorde(2*index+2);
        }
    }
}
