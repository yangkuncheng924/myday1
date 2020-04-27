package src.Tree.A_BinaryTree;
/**
 *
 * @parameter
 * @effect 二叉树
 * @return  添加 查找 删除
 * @date 2020/4/27 15:34
 */
public class BinaryTree {
    public static void main(String[] args) {
        //创建一颗二叉树
        BinaryTree1 binaryTree = new BinaryTree1();
        //创建 节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode hernode1 = new HeroNode(2, "吴用");
        HeroNode hernode2 = new HeroNode(3, "卢俊义");
        HeroNode hernode3 = new HeroNode(4, "林冲");
        HeroNode hernode4 = new HeroNode(5, "关胜");

        //手动创建二叉树 后面使用递归方式
        root.setLeft(hernode1);
        root.setRight(hernode2);
        hernode2.setRight(hernode3);
        hernode2.setLeft(hernode4);
        binaryTree.setRoot(root);
        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println("中序遍历");
        binaryTree.inffixOrder();

        System.out.println("后序遍历");
        binaryTree.rightOrder1();
        System.out.println();

        //前序查找：
        System.out.println("前序查找：");
        HeroNode resNode = binaryTree.preOrderSearch(5);
        if(resNode!=null){
            System.out.printf("已找到 信息为:%d号，名字：%s\n",resNode.getNo(),resNode.getName());
        }else{
            System.out.printf("没有找到为%d号的人\n",5);
        }

        //中序查找：
        System.out.println("中序查找：");
        HeroNode resNode1 = binaryTree.infixOrderSearch(4);
        if(resNode1!=null){
            System.out.printf("已找到 信息为:%d号，名字：%s\n",resNode1.getNo(),resNode1.getName());
        }else{
            System.out.printf("没有找到为%d号的人\n",4);
        }

        //后序查找：
        System.out.println("后序查找：");
        HeroNode resNode2 = binaryTree.rightOrderSearch(3);
        if(resNode2!=null){
            System.out.printf("已找到 信息为:%d号，名字：%s\n",resNode2.getNo(),resNode2.getName());
        }else{
            System.out.printf("没有找到为%d号的人\n",3);
        }
        System.out.println();

        //删除节点
        System.out.println("删除前：");
        binaryTree.preOrder();
        System.out.println("删除");
        binaryTree.deletNode(3);
        System.out.println("删除后");
        binaryTree.preOrder();
    }

    private void setRoot(HeroNode root) {
    }
}

//定义一个根 root
class BinaryTree1{
    private HeroNode Root;

    public void setRoot(HeroNode root) {
        Root = root;
    }
    //前序遍历
    public void preOrder(){
        if(this.Root!=null){
            this.Root.preOder();
        }else {
            System.out.println("二叉树为空 无法遍历");
        }
    }
    //中序遍历
    public void inffixOrder(){
        if(this.Root!=null){
            this.Root.infixOder();
        }else {
            System.out.println("二叉树为空 无法遍历");
        }
    }
    //后序遍历
    public void rightOrder1(){
        if(this.Root!=null){
            this.Root.rightOder();
        }else {
            System.out.println("二叉树为空 无法遍历");
        }
    }

    //前序查找遍历
    public HeroNode preOrderSearch(int no){
        if(Root!=null){
            return Root.preOrdersearch(no);
        }else {
            return null;
        }
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no){
        if(Root!=null){
            return Root.infixOrderSearch(no);
        }else{
            return null;
        }
    }

    //后序遍历查找
    public HeroNode rightOrderSearch(int no){
        if(Root!=null){
            return Root.postOrderSearch(no);
        }else {
            return null;
        }
    }

    //删除节点
    public void deletNode(int no){
        if(Root!=null){
            if(Root.getNo()==no){
                Root=null;
            }else {
                Root.delete(no);
            }
        }else {
            System.out.println("空树 无法删除");
        }
    }
}
//创建HeroNode 结点
class HeroNode{
    private int no;
    private String name;
    private HeroNode  left;
    private HeroNode  right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOder(){
        System.out.println(this);   //先输出父节点
        //递归向左遍历
        if(this.left!=null){
            this.left.preOder();
        }
        //递归向右遍历
        if(this.right!=null){
            this.right.preOder();
        }
    }
    //中序遍历
    public void infixOder(){
        if(this.left!=null){
            this.left.infixOder();
        }
        System.out.println(this);

        if(this.right!=null){
            this.right.infixOder();
        }
    }
    //后序遍历
    public void rightOder(){
        if(this.left!=null){
            this.left.rightOder();
        }

        if(this.right!=null){
            this.right.rightOder();
        }

        System.out.println(this);
    }

    //前序遍历查找
    public HeroNode preOrdersearch(int no){
        //比较当前节点
        if(this.no==no){
            return this;
        }
        //判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        //如果左递归前序查找，找到节点，返回
        HeroNode resNode=null;
        if(this.left!=null){
            resNode=this.left.preOrdersearch(no);
        }
        if(resNode!=null){  //说明已经找到
            return resNode;
        }
        //1.左递归前序查找 找到节点 则返回 否则继续判断
        //2.当前的节点右子节点是否为空 如果不空，向右递归前序查找
        if(this.right!=null){
            resNode=this.right.preOrdersearch(no);
        }
               return resNode;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no){
        HeroNode resNode=null;

        if(this.left!=null){
            resNode=this.left.infixOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }

        if(this.no==no){
            return this;
        }

        if(this.right!=null){
            resNode=this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no){
        HeroNode resNode=null;
        //左查找
        if(this.left!=null){
         resNode=this.left.postOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        //右查找
        if(this.right!=null){
            resNode=this.right.postOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        //root根查找
        if(this.no==no) {
            return this;
        }
        return resNode;
    }

    //递归删除节点
    /*如果删除的节点是叶子节点则删除该节点
    如果删除的节点是非叶子节点则删除该子树
    * */
    public void delete(int no){
        //判断左递归
        if(this.left!=null&&this.left.no==no){
            this.left=null;
            return;
        }
        //判断右递归
        if(this.right!=null&&this.right.no==no){
            this.right=null;
            return;
        }
        //左递归删除
        if(this.left!=null){
            this.left.delete(no);
        }
        //右递归删除
        if(this.right!=null){
            this.right.delete(no);
        }
    }
}
