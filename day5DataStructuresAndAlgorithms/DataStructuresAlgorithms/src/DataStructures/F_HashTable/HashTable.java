package DataStructures.F_HashTable;

import java.util.Scanner;

/**
 * @parameter
 *  数组加链表  哈希
 * @effect
 * @return
 * @date 2020/4/26 17:27
 */
public class HashTable {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(3);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        boolean flag=true;
        while (true) {
            System.out.println("a:添加雇员");
            System.out.println("l:显示雇员");
            System.out.println("f:查找雇员");
            //删除代码目前来看有点问题
            System.out.println("d:删除雇员");
            System.out.println("e:退出程序");
            key=scanner.next();
            switch (key){
                case "a":
                    System.out.println("输入id");
                    int id=scanner.nextInt();
                    System.out.println("输入名字");
                    String name=scanner.next();
                    //创建雇员
                    Emp emp=new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "l":
                    hashTab.list();
                    break;
                case "f":
                    System.out.println("请输入要查找的id号码");
                    int ID=scanner.nextInt();
                    hashTab.findEmpbyId(ID);
                    break;
                case"d":
                    System.out.println("请输入要删除的id号码");
                    ID=scanner.nextInt();
                    hashTab.delet(ID);
                    break;
                case "e":
                    scanner.close();
                    System.exit(0);
                default:
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }
}

//创建HashTab 管理多条链表
class HashTab{
    private EmplLinkedList[] emplLinkedLists;
    private int size;   //表示有多少条链表

    public HashTab(int size) {
        this.size = size;
        emplLinkedLists=new EmplLinkedList[size];
        for (int i = 0; i <size ; i++) {
            emplLinkedLists[i]=new EmplLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp){
        //根据员工的id，得到该员工应当添加到那条链表
        int empLinkedListNo=hashfun(emp.id);
        //将emp添加到对应的链表中
        emplLinkedLists[empLinkedListNo].add(emp);
    }

    //遍历所有的链表 遍历hashtab
    public void list(){
        for (int i = 0; i <size ; i++) {
            emplLinkedLists[i].list(i);
        }

    }

    //查找雇员根据id号
    public void findEmpbyId(int id){
        //使用散列函数确定到那条链表查找
        int empLinkedListNo=hashfun(id);
        Emp emp=emplLinkedLists[empLinkedListNo].findEmpById(id);
        if(emp!=null){
            System.out.printf("在第%d条链表找到雇员id=%d\n",(empLinkedListNo+1),id);
        }else {
            System.out.println("在哈希表中 没有找到");
        }
    }

    //删除代码目前来看有点问题
    //删除雇员
    public void delet(int id){
        int emplinkdelete=id;
        emplLinkedLists[emplinkdelete].ded(id);
    }

    //编写散列函数，使用一个简单取模法
    public int hashfun(int id){
        return id%size;
    }
}
class Emp{
    public int id;
    public String name;
    public Emp  next;   //next默认为空

    public Emp(int id, String name){
        this.id = id;
        this.name = name;
    }
}

//创建EmplLinkedList 表示链表
class EmplLinkedList{
    //头指针，执行第一个Emp，因此这个链表head是直接指向第一个Emp
    private Emp head;

    //添加雇员到链表
    //说明
    //1假定，添加雇员时，id是自增长，即id的分配是从小到大
    //因此我们将该雇员直接加入到本链表最后即可
    public void add(Emp emp){
        //如果是添加第一个雇员
        if(head==null){
            head=emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助指针，帮助定位
        Emp curEmp=head;
        while (true){
            if(curEmp.next==null){
                //说明到链表最后
                break;
            }
            //后移
            curEmp=curEmp.next;
        }
        //退出时直接将emp加入链表
        curEmp.next=emp;
    }

    //遍历当前链表
    public void list(int mo){
        if(head==null){
            System.out.println("链表"+mo+"为空！");
            return;
        }
        System.out.println("第"+mo+"链表的信息为");
        Emp cur=head;
        while (true){
            System.out.printf("id=%d,name=%s\t",cur.id,cur.name);
            if(cur.next==null){
                System.out.println("遍历完成");
                break;
            }
            cur=cur.next;       //后移遍历

        }
        System.out.println();
    }

    //根据id查找雇员
    //如果查找到就返回Emp，如果没有找到就返回null
    public Emp findEmpById(int id){
        //判断链表是否为空
        if(head==null){
            System.out.println("链表为空");
            return null;
        }
        Emp curemp=head;
        while (true){
            if(curemp.id==id){
                //已经找到
                break;
            }
            //退出
            if(curemp.next==null){
                //没有找到
                curemp=null;
                break;
            }
            curemp=curemp.next;
        }
        return curemp;
    }


    //删除代码目前来看有点问题
    public void ded(int id){
        if(head==null){
            System.out.println("链表为空");
            return;
        }
        Emp curemp=head;
        boolean flag=false;
        while (true){
            if(curemp==null){
                return;
            }else if(curemp.id==id){
                flag=true;
                break;
            }
            curemp=curemp.next;
        }
        //判断flag
        if(flag){
//            if(curemp.next!=null){
//                curemp.next.next=curemp.next;
//            }
        }
        if(curemp.id==id){
            System.out.println("无法删除");
        }

    }
}
