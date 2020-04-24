package DataStructuresAlgorithms.src.DataStructures.C_linkedlist;

import java.util.Stack;
/**
 * @City
 * 单向链表
 * @City
 */
public class ListTest
{
    public static void main(String[] args) {
        //进行测试 创建节点
        HeroNode heroNode1 = new HeroNode(1, "张飞", "黑旋风");
        HeroNode heroNode2 = new HeroNode(2, "宋江", "及时雨");
        HeroNode heroNode3 = new HeroNode(3, "卢俊义", "玉麒麟");
        HeroNode heroNode4 = new HeroNode(4, "鲁智深", "花和尚");

        //创建链表
        SingleLinkedlist singleLinkedlist=new SingleLinkedlist();
        //加入
//        singleLinkedlist.addlist(heroNode1);
//        singleLinkedlist.addlist(heroNode2);
//        singleLinkedlist.addlist(heroNode3);
//        singleLinkedlist.addlist(heroNode4);

        //加入按照编号的顺序
        singleLinkedlist.addByorder(heroNode1);
        singleLinkedlist.addByorder(heroNode4);
        singleLinkedlist.addByorder(heroNode2);
        singleLinkedlist.addByorder(heroNode3);
        //显示
        singleLinkedlist.list();

        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(3, "卢修改", "玉麒麟修改");
        singleLinkedlist.updata(newHeroNode);
        //显示
        System.out.println("修改链表之后的变化：");
        singleLinkedlist.list();

        //删除一个节点
        singleLinkedlist.del(1);
        singleLinkedlist.del(4);
        //显示
        System.out.println("删除链表之后的变化：");
        singleLinkedlist.list();

        //测试单链表有效节点个数       面试题
        System.out.println("测试单链表有效节点个数");
        System.out.println(getLength(singleLinkedlist.getHeroNode()));

        //测试查找单链表中的倒数第k个节点  面试题
        System.out.println("测试查找单链表中的倒数第k个节点");
        HeroNode res=findLastIndexNode(singleLinkedlist.getHeroNode(), 2);
        System.out.println("res:"+res);

        //清空方便单链表反转操作实验     面试题
        singleLinkedlist.del(2);
        singleLinkedlist.del(3);
        singleLinkedlist.list();
        System.out.println();
        //加入按照编号的顺序 反转链表 面试
        System.out.println("原来链表的情况如下：");
        singleLinkedlist.addByorder(heroNode1);
        singleLinkedlist.addByorder(heroNode4);
        singleLinkedlist.addByorder(heroNode2);
        singleLinkedlist.addByorder(heroNode3);
        singleLinkedlist.list();
        //反转单链表之后的顺序    面试题
        System.out.println("反转链表后的情况如下：");
        reversetList(singleLinkedlist.getHeroNode());
        singleLinkedlist.list();

        //利用数据结构压入栈中
        System.out.println("利用栈数据结构压入栈中");
        reversePrint(singleLinkedlist.getHeroNode());
    }
    //***********************************************************面试题************************************************************************
    //可以利用栈这个数据结构，将各个节点压入栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
    public static void reversePrint(HeroNode head){
        if(head.next==null){
            return;
        }
        //创建一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur=head.next;
        //将链表的所有节点压入栈
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;                       //cur后移 这样就可以下一个节点
        }
        while (stack.size()>0){
            System.out.println(stack.pop());    //stack是先进后出
        }
    }

    //将单链表反转
    public static void reversetList(HeroNode head){
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if(head.next==null||head.next.next==null){
            return;
        }
        HeroNode sur=head.next; //定义一个辅助的指针
        HeroNode next=null;     //指向当前节点【cur】的下一个节点
        HeroNode reverseHed=new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
        while (sur!=null){
            next=sur.next;           //先暂时保存当前节点的下一个节点，因为后面需要使用
            sur.next=reverseHed.next;//将sur的下一个节点指向新的链表的最前端
            reverseHed.next=sur;     //将sur连接到新的链表上
            sur=next;                //让sur后移
        }
        //将head.next指向reverseHead.next,实现单链表反转
        head.next=reverseHed.next;
    }

    //查找单链表中的倒数第k个节点 【新浪面试题】
    /*思路
    * 1.编写一个方法 接受head节点 同时接收一个index
    * 2.index 表示是倒数第index个节点
    * 3.先把链表从头到尾遍历，得到链表的总的长度 getLength
    * 4.得到size后，我们从链表的第一个开始遍历（size-index）个，就可以得到
    * 5.如果找到了，则返回该节点，否则返回null
    * */
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        //如果链表为空 返回
        if(head.next==null){
            return null;
        }
        int length=0;
        HeroNode sur=head.next; //定义一个辅助的指针
        while (sur!=null){
            length++;
            sur=sur.next;
        }

        //第一个遍历得到链表的长度（节点个数）
        int size=length;
        //第二次遍历 size-index位置，就是我们倒数的第k个节点
        //先做一个index的校验
        if(index<=0||index>size){
            return  null;
        }

        // 定义辅助变量,for循环定位倒数的index
        HeroNode cur=head.next;
        for (int i = 0; i < size-index; i++) {
            cur=cur.next;
        }
        return cur;
    }


    //方法：获取到单链表的节点的个数（如果是带头节点的链表，需求不统计头结点）
    /**
     * head链表的头结点
     * return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {    //链表为空直接返回
            return 0;
        }
        int length=0;
        HeroNode cur=head.next; //定义一个辅助的变量
        while (cur!=null){
            length++;
            cur=cur.next;       //遍历
        }
        return length;
    }
    //***********************************************************面试题************************************************************************
}

//定义一个类 管理我们的英雄
class SingleLinkedlist{
    //先初始一个头结点 头结点不要动
    private HeroNode heroNode=new HeroNode(0," "," ");

    public HeroNode getHeroNode() {
        return heroNode;
    }

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next指向新的节点
    public void addlist(HeroNode heroNode1){
        //因为head的节点不能动 因此我们需要一个辅助遍历temp
        HeroNode temp=heroNode;
        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if(temp.next==null){
                break;
            }
            //如果没有找到最后 将temp后移
            temp=temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next指向新的节点
        temp.next=heroNode1;
    }

    //第二种方式在添加英雄时根据排名将英雄插入到指定位置
    //（如果有这个排名 则添加失败 并给出提示）
    public void addByorder(HeroNode heroNode1){
        //因为头结点不能动，因此我们仍然通过一个辅助指针来帮助找到添加的位置
        //因为单链表因此我们找的temp 是位于添加位置的前一个节点 否则插入不了
        HeroNode temp=heroNode;
        boolean flag=false; //flag标志添加的编号是否存在 否则默认为false
        while(true){
            if(temp.next==null){    //说明temp已在链表的最后
                break;
            }
            if(temp.next.on>heroNode1.on){//位置找到 就在temp的后面插入
                break;
            }else if(temp.next.on==heroNode1.on){//说明希望添加的heronode1的编号已经存在
                flag=true;      //说明编号存在
                break;
            }
            temp=temp.next;     //后移 遍历当前链表
        }
        //判断flag的值
        if(flag){//不能添加 说明编号已经存在
            System.out.printf("准备插入的英雄的编号%d已经存在了 ，不能加入\n",heroNode1.on);
        }else {
            //插入到链表中 temp的后面
            heroNode1.next=temp.next;
            temp.next=heroNode1;
        }

    }

    //修改节点的信息，根据no编号来修改，即no编号不能改
    //说明
    //1.根据newheroNode1的no来修改即可
    public void updata(HeroNode newHeroNode){
        //判断链表是否为空
        if(heroNode.next==null){
            System.out.println("链表为空");
            return;
        }

        HeroNode temp=heroNode.next;
        boolean flag=false; //flag标志添加的编号是否存在 否则默认为false
        while(true){
            if(temp.next==null) {    //说明temp已在链表的最后
                break;              //已经遍历完链表
            }
            if(temp.on==newHeroNode.on){
                //找到
                flag=true;
                break;
            }
            temp=temp.next;
        }
        //根据flag 判断是否找到要修改的节点
        if(flag){
            temp.name=newHeroNode.name;
            temp.nickname=newHeroNode.nickname;
        }else {
            //没有找到
            System.out.printf("没有找到编号%d的节点，不能修改\n",newHeroNode.on);
        }

    }

    //删除节点
    //思路
    //1.head不能动 因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2.说明我们在比较时 是temp.next.no和需要删除的节点no比较
    public void del(int on){
        HeroNode tmp=heroNode;
        boolean flag=false;
        while (true){
            if(tmp.next==null){
                break;
            }if(tmp.next.on==on){
                //找到待删除节点的前一个节点tmp
                flag=true;
                break;
            }
            tmp=tmp.next; //tmp后移 遍历
        }
        //判断flag
        if(flag) {
            //可以删除
            tmp.next = tmp.next.next;
        } else {
            System.out.println("要删除的节点不纯在"+on);
        }
    }
    //遍历链表
    public void list(){
        //判断链表是否为空
        if(heroNode.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头结点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode tmp=heroNode.next;
        while (true){
            //判断是否到链表最后
            if(tmp==null){
                break;
            }
            //输出节点信息
            System.out.println(tmp);
            tmp=tmp.next;
        }
    }
}


//定义HeroNode，每个HeroNode 对象就是一个节点
class HeroNode {
    public int on;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    public HeroNode(int on, String name, String nickname) {
        this.on = on;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法 重写toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "on=" + on +
                ", name='" + name + '\'' +
                ", nickname=" + nickname +
                '}';
    }
}
