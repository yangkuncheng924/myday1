package src.Tree.E_HuffmanTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @parameter
 * @effect
 * @return
 * @date 2020/4/28 11:34
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[]={13,7,8,3,29,6,1};
        Node root=createHuffmanTree(arr);
        preOrde(root);
    }


    //创建一个前序遍历的方法
    public static void preOrde(Node node){
        if(node!=null){
            node.oreOrder();
        }else {
            System.out.println("树空");
        }
    }
    //创建霍夫曼树的方法
    public static Node createHuffmanTree(int[] arr){
        /*第一步为了操作方便
           1.遍历arr数组
           2.将arr的每个元素构成一个node
           3.将node放入到ArrayList中
        */
        List<Node>nodes=new ArrayList<Node>();
        for(int value:arr){
            nodes.add(new Node(value));
        }
        while (nodes.size()>1) {
            //排序
            Collections.sort(nodes);
            System.out.println("nodes="+nodes);

            //取出根节点权值最小的两颗二叉树
            //1 取出权值最小的节点
            Node leftNode=nodes.get(0);
            //2 取出权值第二小的节点二叉树
            Node rightNode=nodes.get(1);

            //创建一颗新的二叉树
            Node parent=new Node(leftNode.value+rightNode.value);
            parent.left=leftNode;
            parent.right=rightNode;

            //处从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将parent加入到nodes
            nodes.add(parent);
        }
        return nodes.get(0);

    }
}
class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;
    public Node(int value){
        this.value=value;
    }

    //前序遍历
    public void oreOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.oreOrder();
        }
        if(this.right!=null){
            this.right.oreOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.value-o.value;
    }
}
