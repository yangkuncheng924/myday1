package src.BinarySortTree.A_BinarySortTreeDemo;

/**
 * @parameter
 * @effect
 * @return
 * @date 2020/4/29 19:19
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int []arr={7,3,12,5,1,9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        //中序遍历二叉树
        binarySortTree.infixOrdex();

        //测试删除结点
        binarySortTree.delNode(1);
        System.out.println("删除后：");
        //中序遍历二叉树
        binarySortTree.infixOrdex();

        //测试删除子树
        binarySortTree.delNode(7);
        System.out.println("测试删除子树");
        binarySortTree.infixOrdex();
    }
}
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //添加结点的方法
    //递归的形式添加结点，注意需要满足二叉排序树的要求
    public void add(Node node){
        if(node==null){
            return;
        }
        //判断传入的结点的值和当前
        if(node.value<this.value){
            if(this.left==null){
                this.left=node;
            }else {
                this.left.add(node);
            }
        }else {
            if(this.right==null){
                this.right=node;
            }else {
                this.right.add(node);
            }
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.left!=null){
         this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    //查找要删除的结点
    public Node search(int value){
        if(value==this.value){
            return this;
        }else if(value<this.value){
            if(this.left==null){
                return null;
            }
            return this.left.search(value);
        }else {
            if(this.right==null){
                return null;
            }
            return this.right.search(value);
        }
    }
    //查找要删除的节点父结点
    public Node searchParent(int value){
        //如果当前节点就是要删除的结点的父节点就返回
        if((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)){
            return this;
        }else {
            //如果查找的值小于当前结点的值，并且当前结点的左子结点不为空
            if(value<this.value&&this.left!=null){
                return this.left.searchParent(value);
            }else if(value>=this.value&&this.right!=null){
                return this.right.searchParent(value);
            }else {
                return null;        //没有找到父节点
            }

        }
    }
}
//创建二叉排序树
class BinarySortTree{
    private Node root;
    public void add(Node node){
        if(root==null){
         root=node;
        }else {
            root.add(node);
        }
    }
    //创建中序遍历
    public void infixOrdex(){
        if(root!=null){
            root.infixOrder();
        }else {
            System.out.println("树为空");
        }
    }

    //查找要删除的节点
    public Node search(int value){
        if(root==null){
            return null;
        }else {
            return root.search(value);
        }
    }

    //查找父结点
    public Node searchParent(int value){
        if(root==null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    //删除结点
    public void delNode(int value){
        if(root==null){
            return;
        }else {
            //1.需求先去找到要删除的结点
            Node targetNode=search(value);
            //如果没有找到要删除的结点
            if(targetNode==null){
                return;
            }
            //如果我们发现当前这颗二叉排序树只有一个结点
            if(root.left==null&&root.right==null){
                root=null;
                return;
            }
            //去找targetNode的父结点
            Node parent=searchParent(value);
            //如果要删除的结点是叶子结点
            if(targetNode.left==null&&targetNode.right==null){
                //判断targetNode 是父节点的左子结点还是右子结点
                if(parent.left!=null&&parent.left.value==value){
                    parent.left=null;
                }else if(parent.right!=null&&parent.right.value==value){
                    parent.right=null;
                }
            }else if(targetNode.left!=null&&targetNode.right!=null){//删除有两颗子树的结点
                int minVal = delrightTreeMin(targetNode.right);
                targetNode.value=minVal;
            }else {//删除只有一颗字数的结点
                //如果要删除的结点有左子结点
                if(targetNode.left!=null){
                    //如果targetNode是parent的左子结点
                    if(parent.left.value==value){
                    parent.left=targetNode.left;
                }else {//targetNodesparent的右子结点
                        parent.right=targetNode.left;
                    }
                }else { //如果要删除的结点有右子结点
                    //如果targetNode是parent的左子结点
                    if(parent.left.value==value){
                        parent.left=targetNode.right;
                    }else {//如果targetNode是parent的右子结点
                        parent.right=targetNode.right;
                    }
                }
            }
        }
    }

    //编写方法：
    //1.返回以node为根节点的二叉排序树的最小结点的值
    //2.删除node为根结点的二叉排序树的最小结点
    /**
     *
     * @param node  传入的结点（当做二叉排序树的根结点）
     * @return  返回以node为根结点的二叉排序树的最小结点的值
     */
    public int delrightTreeMin(Node node){
        Node target=node;
        while (target.left!=null){
            target=target.left;
        }
        delNode(target.value);
        return target.value;
    }


}
