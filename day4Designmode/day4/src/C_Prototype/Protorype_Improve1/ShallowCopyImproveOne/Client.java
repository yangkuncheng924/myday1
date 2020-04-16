package C_Prototype.Protorype_Improve1.ShallowCopyImproveOne;

/**
 * @City
 * 克隆羊解决  原型模式
 * 解决浅拷贝问题
 * @City
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Client client1=new Client();
        client1.run1();
        client1.run2();
    }

       //方式一完成深拷贝****************************
       public void run1() {
        DeepProtoType deepProtoType = new DeepProtoType();
        deepProtoType.name = "张三";
        deepProtoType.deepCloneableTarget = new DeepCloneableTarget("李四", "李思");

        DeepProtoType deepProtoType1 = null;
        try {
            deepProtoType1 = (DeepProtoType) deepProtoType.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(deepProtoType.name + "" + deepProtoType.hashCode());
        System.out.println(deepProtoType1.name + "" + deepProtoType1.hashCode());
    }

        //第二种方法 虽然复杂 但是推荐使用*****************
       public void run2 () throws CloneNotSupportedException {
        //方式2完成深拷贝
        DeepProtoType p1 = new DeepProtoType();
        p1.name = "杨一";
        p1.deepCloneableTarget = new DeepCloneableTarget("杨二", "杨三");
        DeepProtoType p2 = (DeepProtoType) p1.clone();
        System.out.println(p1.name + "" + p1.hashCode());
        System.out.println(p2.name + "" + p2.hashCode());

    }
}

