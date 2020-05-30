package src.BinarySortTree.B_BalancedBinaryTree;

/**
 * @parameter
 * @effect
 * @return
 * @date 2020/5/3 15:34
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        int arr[]={4,3,6,5,7,8};
        //创建一个AVLTree对象
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i <arr.length ; i++) {
            avlTree.add(new Node(arr[i]));
        }
        //遍历
        System.out.println("中序遍历");
        avlTree.infixOrdex();

        System.out.println("左旋转平衡处理：");
        System.out.println("数的高度="+avlTree.getRoot().height());
        System.out.println("树的左子树高度="+avlTree.getRoot().leftHeight());
        System.out.println("树的右子树高度="+avlTree.getRoot().rightHeight());

        System.out.println("************************************************");
        //右旋转
        int arr2[]={10,12,8,9,7,6};
        //创建一个AVLTree对象
        AVLTree avlTree1 = new AVLTree();
        for (int i = 0; i <arr2.length ; i++) {
            avlTree1.add(new Node(arr2[i]));
        }
        //遍历
        System.out.println("中序遍历");
        avlTree1.infixOrdex();

        System.out.println("右旋转平衡处理：");
        System.out.println("数的高度="+avlTree1.getRoot().height());
        System.out.println("树的左子树高度="+avlTree1.getRoot().leftHeight());
        System.out.println("树的右子树高度="+avlTree1.getRoot().rightHeight());
    }
}

class AVLTree{
    private Node root;

    public Node getRoot() {
        return root;
    }

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
                    if(parent!=null) {
                        //如果targetNode是parent的左子结点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {//targetNodesparent的右子结点
                            parent.right = targetNode.left;
                        }
                    }else {
                        root=targetNode.left;
                    }
                }else { //如果要删除的结点有右子结点
                    if(parent!=null) {
                        //如果targetNode是parent的左子结点
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {//如果targetNode是parent的右子结点
                            parent.right = targetNode.right;
                        }
                    }else {
                        root=targetNode.right;
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

    //返回以该结点为根结点的树的高度
    public int height(){
        return Math.max(left==null ? 0 : left.height(), right==null ? 0 : right.height())+1;
    }

    //返回左子树的高度
    public int leftHeight(){
        if(left==null){
            return 0;
        }
        return left.height();
    }

    //返回右子树的高度
    public int rightHeight(){
        if(right==null){
            return 0;
        }
        return right.height();
    }

    //左旋转方法
    private void leftRotate() {
        //创建新的结点，以当前根结点的值
        Node newNode = new Node(value);
        //把新的结点的左子树设置成当前结点的左子树
        newNode.left = left;
        //把新的结点的右子树设置成当前结点的右子树的左子树
        newNode.right=right.left;
        //把当前结点的值替换成右子结点的值
        value=right.value;
        //把当前结点的右子树设置成当前结点右子树的右子树
        right=right.right;
        //把当前结点的左子树设置新的结点
        left=newNode;
    }

    //右旋转
    private void rightRotate(){
        Node newNode=new Node(value);
        newNode.right=right;
        newNode.left=left.right;
        value=left.value;
        left=left.left;
        right=newNode;
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

        //当添加完一个结点后，如果：（右子树的高度-左子树的高度）>1，左旋转
        if(rightHeight()-leftHeight()>1) {
            //如果它的右子树的左子树的高度大于它的右子树的右子树的高度
            if (right != null && right.leftHeight() > right.rightHeight()) {
                //先对右子结点进行右旋转
                right.rightRotate();
                //然后在对当前结点进行左旋转
                leftRotate();
            } else {
                leftRotate();   //左旋转
            }
            return;
        }

        //当添加完一个结点后，如果（左子树的 高度-右子树的高度）>1，右旋转
        if(leftHeight()-rightHeight()>1){
            //如果它的左子树的右子树高度大于它的左子树的高度
            if(left!=null&&left.rightHeight()>leftHeight()){
                //先对当前结点的左结点（左子树）->左旋转
                left.leftRotate();
                //在对当前结点进行右旋转
                rightRotate();
            }else {
                //直接进行右旋转
                rightRotate();
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

