package C_linkedlist.DoubleList;
/**
 * @City
 * @City
 */
public class DoubleListTest {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");

        //进行测试 创建节点
        HeroNode1 heroNode1 = new HeroNode1(1, "张飞", "黑旋风");
        HeroNode1 heroNode2 = new HeroNode1(2, "宋江", "及时雨");
        HeroNode1 heroNode3 = new HeroNode1(3, "卢俊义", "玉麒麟");
        HeroNode1 heroNode4 = new HeroNode1(4, "鲁智深", "花和尚");

        //创建一个双向链表
        ADoublelist aDoublelist = new ADoublelist();
        aDoublelist.add(heroNode1);
        aDoublelist.add(heroNode2);
        aDoublelist.add(heroNode3);
        aDoublelist.add(heroNode4);
        aDoublelist.list();

        //修改
        HeroNode1 newHernNode=new HeroNode1(3, "公孙胜", "入云龙");
        System.out.println("修改双向链表后的情况：");
        aDoublelist.updata(newHernNode);
        aDoublelist.list();

        //删除
        aDoublelist.del(4);
        System.out.println("删除后");
        aDoublelist.list();
    }
}

class ADoublelist{
    //先初始一个头结点 头结点不要动
    private HeroNode1 heroNode3=new HeroNode1(0," "," ");
    public HeroNode1 getHeroNode1() {
        return heroNode3;
    }

    //遍历链表
    public void list(){
        //判断链表是否为空
        if(heroNode3.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头结点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode1 tmp=heroNode3.next;
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

    //添加一个双向链表到最后
    public void add(HeroNode1 heroNode){
        //因为head的节点不能动 因此我们需要一个辅助遍历temp
        HeroNode1 temp1=heroNode3;
        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if(temp1.next==null){
                break;
            }
            //如果没有找到最后 将temp后移
            temp1=temp1.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //形成一个双向链表
        temp1.next=heroNode;
        heroNode.pre=temp1;
    }

    //修改一个节点的内容     可以看到修改节点和单向一样
    public void updata(HeroNode1 newHeroNode){
        //判断链表是否为空
        if(heroNode3.next==null){
            System.out.println("链表为空");
            return;
        }

        HeroNode1 temp=heroNode3.next;
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

    //从双向链表删除一个节点
    //说明：
    //1.对于双向链表，我们可以直接找到要删除的这个节点
    //2.找到后，自我删除可以
    public void del(int on){
        if(heroNode3==null){
            System.out.println("链表为空不能删除");
            return;
        }
        HeroNode1 tmp=heroNode3.next;    //辅助指针
        boolean flag=false;         //标志
        while (true){
            if(tmp==null){
                break;
            }if(tmp.on==on){
                //找到待删除节点的前一个节点tmp
                flag=true;
                break;
            }
            tmp=tmp.next; //tmp后移 遍历
        }
        //判断flag
        if(flag) {
            //可以删除
            //tmp.next = tmp.next.next; [单向链表]
            tmp.pre.next=tmp.next;
            //如果是最后一个节点，就不需要执行下面这句话 否则出现空指针
            if(tmp.next!=null){
                tmp.next.pre=tmp.pre;
            }
        } else {
            System.out.println("要删除的节点不纯在"+on);
        }
    }
}

//定义HeroNode，每个HeroNode 对象就是一个节点
class HeroNode1 {
    public int on;
    public String name;
    public String nickname;
    public HeroNode1 next;//指向下一个节点
    public HeroNode1 pre;//指向前一个节点

    public HeroNode1(int on, String name, String nickname) {
        this.on = on;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法 重写toString
    @Override
    public String toString() {
        return "HeroNode1{" +
                "on=" + on +
                ", name='" + name + '\'' +
                ", nickname=" + nickname +
                '}';
    }
}

