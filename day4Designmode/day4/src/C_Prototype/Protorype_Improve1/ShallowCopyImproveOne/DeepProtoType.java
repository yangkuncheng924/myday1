package C_Prototype.Protorype_Improve1.ShallowCopyImproveOne;

import java.io.*;

/**
 * @City
 * @City
 */
public class DeepProtoType implements Serializable,Cloneable{
    public String name;  //String 属性
    public DeepCloneableTarget deepCloneableTarget; //引用类型

    public DeepProtoType() {
        super();
    }
    //深拷贝 方式一 使用clone方法
    @Override
    protected  Object clone() throws CloneNotSupportedException {
        Object deep=null;
        //这里完成对基本数据类型和String的克隆
        deep=super.clone();
        //对引用类型的属性 进行单独处理
        DeepProtoType deepProtoType=(DeepProtoType)deep;
        deepProtoType.deepCloneableTarget=(DeepCloneableTarget)deepCloneableTarget.clone();
        return  super.clone();
    }
    //深拷贝 方式二 通过对象序列化实现     推荐使用
    public  Object deepClone() {
        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);     //当前这个对象以对象流的方式输出

            //反序列化
            bis=new ByteArrayInputStream(bos.toByteArray());
            ois=new ObjectInputStream(bis);
            DeepProtoType copyObj=(DeepProtoType)ois.readObject();

             return copyObj;
            } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            //关闭流
            try {
                bos.close();
                bis.close();
                oos.close();
                ois.close();

            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}








