package src.Tree.C_ThreadedBinaryTree;

/**
 * @parameter
 * @effect
 * 线索化二叉树
 * @return
 * @date 2020/4/27 19:36
 */
public class ThreadedBinaryTree {
    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //二叉树，后面我们要递归创建，现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试线索化
        BinaryTree1 binaryTree1 = new BinaryTree1();
        binaryTree1.setRoot(root);
        binaryTree1.threadedNodes();

        HeroNode leftNode=node5.getLeft();
        HeroNode rightNode=node5.getRight();
        System.out.println("十号结点的前驱结点是="+leftNode);
        System.out.println("十号结点的后驱结点是="+rightNode);

        System.out.println("使用线索化的方式遍历线索化二叉树");
        binaryTree1.threadedList();
    }
}

//定义一个根 root
class BinaryTree1 {
    private HeroNode Root;

    //为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化时，pre保留前一个结点
    private HeroNode pre=null;

    public void setRoot(HeroNode root) {
        Root = root;
    }

    //重载一把threadedNodes方法
    public void threadedNodes(){
        this.threadedNodes(Root);
    }
    //遍历线索化二叉树的方法
    public void threadedList(){
        //定义一个变量 储存当前遍历的节点 从root开始
        HeroNode node=Root;
        while (node!=null){
            /*
            循环的找到leftType==1的节点，第一个找到就是8结点
            后面随着遍历而变化，因为当leftType==1时，说明该节点是按照线索化
            处理后的有效结点
             */
            while(node.getLeftType()==0){
                node=node.getLeft();
            }
            //打印当前这个节点
            System.out.println(node);
            //如果当前节点的右指针指向的是后继结点，就一直输出
            while (node.getRightType()==1){
                //获取当前节点的后继结点
                node=node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的节点
            node=node.getRight();
        }
    }
    /**
     * @param node 当前需要线索化的结点
     */
    //编写对二叉树进行中线索化的方法
    public void threadedNodes(HeroNode node) {

        //如果node==null ，不能线索化
        if(node==null){
            return;
        }
        // 1.线索化左子树
        threadedNodes(node.getLeft());
        // 2.线索化当前结点
        //处理当前结点的前驱结点
        //8结点来理解
        //8结点的.left=null，8结点的.leftType=1
        if(node.getLeft()==null){
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型，指向前驱结点
            node.setLeftType(1);
        }

        //处理后继结点
        if(pre!=null&&pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre=node;
        // 3.在线索化右子树
        threadedNodes(node.getRight());
    }

    //前序遍历
    public void preOrder() {
        if (this.Root != null) {
            this.Root.preOder();
        } else {
            System.out.println("二叉树为空 无法遍历");
        }
    }

    //中序遍历
    public void inffixOrder() {
        if (this.Root != null) {
            this.Root.infixOder();
        } else {
            System.out.println("二叉树为空 无法遍历");
        }
    }

    //后序遍历
    public void rightOrder1() {
        if (this.Root != null) {
            this.Root.rightOder();
        } else {
            System.out.println("二叉树为空 无法遍历");
        }
    }

    //前序查找遍历
    public HeroNode preOrderSearch(int no) {
        if (Root != null) {
            return Root.preOrdersearch(no);
        } else {
            return null;
        }
    }
}

    class HeroNode {
        private int no;
        private String name;
        private HeroNode left;
        private HeroNode right;
        //说明：
        //1.如果leftType==0表示指向的是左子树，如果是1则表示指向前驱结点
        //2.如果rightType==0表示指向是右子树，如果是1表示指向后继结点
        private int leftType;
        private int rightType;

        public int getLeftType() {
            return leftType;
        }

        public void setLeftType(int leftType) {
            this.leftType = leftType;
        }

        public int getRightType() {
            return rightType;
        }

        public void setRightType(int rightType) {
            this.rightType = rightType;
        }

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
        public void preOder() {
            System.out.println(this);   //先输出父节点
            //递归向左遍历
            if (this.left != null) {
                this.left.preOder();
            }
            //递归向右遍历
            if (this.right != null) {
                this.right.preOder();
            }
        }

        //中序遍历
        public void infixOder() {
            if (this.left != null) {
                this.left.infixOder();
            }
            System.out.println(this);

            if (this.right != null) {
                this.right.infixOder();
            }
        }

        //后序遍历
        public void rightOder() {
            if (this.left != null) {
                this.left.rightOder();
            }

            if (this.right != null) {
                this.right.rightOder();
            }

            System.out.println(this);
        }

        //前序遍历查找
        public HeroNode preOrdersearch(int no) {
            //比较当前节点
            if (this.no == no) {
                return this;
            }
            //判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
            //如果左递归前序查找，找到节点，返回
            HeroNode resNode = null;
            if (this.left != null) {
                resNode = this.left.preOrdersearch(no);
            }
            if (resNode != null) {  //说明已经找到
                return resNode;
            }
            //1.左递归前序查找 找到节点 则返回 否则继续判断
            //2.当前的节点右子节点是否为空 如果不空，向右递归前序查找
            if (this.right != null) {
                resNode = this.right.preOrdersearch(no);
            }
            return resNode;
        }

        //中序遍历查找
        public HeroNode infixOrderSearch(int no) {
            HeroNode resNode = null;

            if (this.left != null) {
                resNode = this.left.infixOrderSearch(no);
            }
            if (resNode != null) {
                return resNode;
            }

            if (this.no == no) {
                return this;
            }

            if (this.right != null) {
                resNode = this.right.infixOrderSearch(no);
            }
            return resNode;
        }

        //后序遍历查找
        public HeroNode postOrderSearch(int no) {
            HeroNode resNode = null;
            //左查找
            if (this.left != null) {
                resNode = this.left.postOrderSearch(no);
            }
            if (resNode != null) {
                return resNode;
            }
            //右查找
            if (this.right != null) {
                resNode = this.right.postOrderSearch(no);
            }
            if (resNode != null) {
                return resNode;
            }
            //root根查找
            if (this.no == no) {
                return this;
            }
            return resNode;
        }

        //递归删除节点
    /*如果删除的节点是叶子节点则删除该节点
    如果删除的节点是非叶子节点则删除该子树
    * */
        public void delete(int no) {
            //判断左递归
            if (this.left != null && this.left.no == no) {
                this.left = null;
                return;
            }
            //判断右递归
            if (this.right != null && this.right.no == no) {
                this.right = null;
                return;
            }
            //左递归删除
            if (this.left != null) {
                this.left.delete(no);
            }
            //右递归删除
            if (this.right != null) {
                this.right.delete(no);
            }
        }
    }
