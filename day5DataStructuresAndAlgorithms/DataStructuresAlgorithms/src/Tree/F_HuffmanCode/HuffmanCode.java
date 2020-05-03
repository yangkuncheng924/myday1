package src.Tree.F_HuffmanCode;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @parameter
 * @effect
 * @return
 * @date 2020/4/28 13:23
 */
public class HuffmanCode {
    public static void main(String[] args) {
//        String content="i like like like java do you like a java";
//        byte[] bytes = content.getBytes();
//        byte[] huffmanCodesBytes=huffmanZip(bytes);
//
//        byte[] huffmanCodeBytes=huffmanZip(bytes);
//
//        System.out.println("生成的霍夫曼编码表"+huffmanCodes);
//
//        byte[] sourceBytes=decode(huffmanCodes,huffmanCodeBytes);
//        System.out.println(new String(sourceBytes));



        
//        //测试压缩文件
//       String srcFile="C:\\JAVAIDEA\\day5DataStructuresAndAlgorithms\\DataStructuresAlgorithms\\src\\Tree\\F_HuffmanCode\\3bc696b649f74704a1541d2d9318b9f9.gif";
//        String dstFile="C:\\JAVAIDEA\\day5DataStructuresAndAlgorithms\\DataStructuresAlgorithms\\src\\Tree\\F_HuffmanCode\\des.zip";
//
//        zipFile(srcFile, dstFile);
//        System.out.println("压缩文件成功");

        //测试解压文件
        String zipFile="C:\\JAVAIDEA\\day5DataStructuresAndAlgorithms\\DataStructuresAlgorithms\\src\\Tree\\F_HuffmanCode\\des.zip";
        String dstFile="C:\\JAVAIDEA\\day5DataStructuresAndAlgorithms\\DataStructuresAlgorithms\\src\\Tree\\F_HuffmanCode\\src2.gif";
        upZipFile(zipFile, dstFile);
        System.out.println("解压文件成功");
    }

    //编写一个方法 将一个文件进行压缩

    /**
     *
     * @param srcFile   你传入的希望压缩的文件的全路径
     * @param dstFile   我们压缩后将压缩文件放到哪个目录
     */
    public static void zipFile(String srcFile,String dstFile){
        //创建文件的输入流
        FileInputStream fileInputStream = null;
        //创建文件的输出流
        OutputStream    outputStream=null;
        ObjectOutputStream objectOutputStream=null;
        try {
            fileInputStream = new FileInputStream(srcFile);
            //创建一个和源文件大小一样的byte[]
            byte[] bytes = new byte[fileInputStream.available()];
            //读取文件
            fileInputStream.read(bytes);
            //对文件进行压缩
            byte[] huffmanCodeBytes=huffmanZip(bytes);
            //创建文件的输出流 存放压缩文件
            outputStream=new FileOutputStream(dstFile);
            //创建一个和文件输出流关联的ObjcetOutputStream
            objectOutputStream= new ObjectOutputStream(outputStream);
            //把霍夫曼编码后的字节数组写入压缩文件
            objectOutputStream.writeObject(huffmanCodeBytes);

            //这里以对象流的方式写入 哈夫曼编码 是为了以后我们恢复源文件使用
            //注意一定要把霍夫曼编码写入压缩文件
            objectOutputStream.writeObject(huffmanCodes);


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(objectOutputStream!=null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //编写一个方法 完成对压缩文件的解压
    public static void upZipFile(String zipFile,String dstFile){
        //定义文件输入流
         InputStream inputStream =null;
        //定义对象输入流
        ObjectInputStream objectInputStream = null;
        //定义文件的输出流
        OutputStream outputStream = null;
        try{
            //创建文件输入流
            inputStream=new FileInputStream(zipFile);
            //创建一个和 inputStream关联对象输入流
            objectInputStream=new ObjectInputStream(inputStream);
            //读取byte数组 huffmanBytes
            byte[]huffmanBytes = (byte[]) objectInputStream.readObject();
            //读取赫夫曼编码表
            Map<Byte,String>huffmanCodes=(Map<Byte,String>)objectInputStream.readObject();
            //解码
            byte[] bytes=decode(huffmanCodes, huffmanBytes);
            //将bytes数组写入目标文件
           outputStream=new FileOutputStream(dstFile);
           outputStream.write(bytes);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(objectInputStream!=null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //解压
    private static byte[]huffmanZip(byte[] bytes){
        List<Node>nodes=getNodes(bytes);
        Node huffmanTreeRoot=createHuffmanTree(nodes);
        Map<Byte,String>huffmanCodes=getCodes(huffmanTreeRoot, "",stringBuilder);
        byte[] huffmanCodeBytes=zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }

    private static byte[] decode(Map<Byte,String>huffmanCodes,byte[] huffmanBytes){
        //1.先得到huffmanBytes对应的二进制字符串，形式1010100010111
        StringBuilder stringBuilder=new StringBuilder();
        //将byte数组转成二进制的字符串
        for (int i = 0; i <huffmanBytes.length;i++) {
            byte b=huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag=(i==huffmanBytes.length-1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
         //把字符串安装指定的霍夫曼编码进行解码
        //把霍夫曼编码表进行调换，因为反向查询a->100 100->a
        Map<String,Byte>map=new HashMap<String, Byte>();
        for (Map.Entry<Byte,String>entry:huffmanCodes.entrySet()){
            map.put(entry.getValue(), entry.getKey());
        }
        //创建要给集合 存放byte
        List<Byte>list=new ArrayList<>();
        //i可以理解成就是索引，扫描stringBuilder
        for (int i = 0; i <stringBuilder.length();) {
            int count=1;
            boolean flag=true;
            Byte b=null;

            while (flag){
                String  key=stringBuilder.substring(i,i+count);
               //i 不动，让count移动，指定匹配到一个字符
                b=map.get(key);
                if(b==null){
                    count++; //说明没有找到
                }else {
                    //匹配到
                    flag=false;
                }
            }
            list.add(b);
            i+=count;   //i直接移动到count
        }
        //把list中的数据放入到byte[] 并返回
        byte []b=new byte[list.size()];
        for (int i = 0; i <b.length ; i++) {
            b[i]=list.get(i);
        }
        return b;
    }
        /*
        完成数据额的解压
        */
        private static String byteToBitString(boolean flag,byte b){
            //使用变量保存b
            int temp=b;//将b转换成int
            //如果是整数我们还存在补高位
            if(flag){
                temp|=256;
            }
            String str=Integer.toBinaryString(temp);
            if(flag){
                return  str.substring(str.length()-8 );
            }else {
                return  str;
            }
        }

    private static byte[] zip(byte[] bytes,Map<Byte,String>huffmanCodes){
        //利用huffmanCodes将bytes转成 霍夫曼编码对应的字符串
        StringBuilder stringBuilder=new StringBuilder();
        //遍历bytes 数组
        for(byte b:bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        //统计返回byte[] huffmanCodeBytes 长度
        int len;
        if(stringBuilder.length()%8==0){
            len=stringBuilder.length()/8;
        }else {
            len=stringBuilder.length()/8+1;
        }
        //创建 存储压缩后的byte数组
        byte[] huffmanCodeBytes=new byte[len];
        int index=0;    //记录是第几个byte
        for (int i = 0; i <stringBuilder.length(); i+=8) {//因为是每8位对应byte 所以步长+8
            String strByte;
            if(i+8>stringBuilder.length()){
                //不够8位
                strByte=stringBuilder.substring(i);
            }else {
                strByte=stringBuilder.substring(i,i+8);
            }
            //将strByte 转成一个byte 放入到huffmanCodeBytes
            huffmanCodeBytes[index]=(byte)Integer.parseInt(strByte,2);
            index++;
        }
        return huffmanCodeBytes;
    }


    //生成霍夫曼树对应的霍夫曼编码
    /*
        思路：
           1.将霍夫曼编码存放在Map<Byte，Strubg>形式
           32->01 97>100 100>11000等等[形式]
     */
    static Map<Byte,String>huffmanCodes=new HashMap<Byte,String>();
    //2.在生成霍夫曼编码表示 需要去拼接路径，定义一个StringBuilder 储存某个叶子结点路径
    static StringBuilder stringBuilder=new StringBuilder();

    /**
     * 功能：将传入的node结点的所有叶子结点的赫夫曼编码得到 并放入到huffmanCodes集合
     * @param node  传入结点
     * @param code  路径：左子结点是0，右子结点1
     * @param stringBuilder stringBuilder 用于拼接路径
     */
    private static  Map<Byte,String> getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2=new StringBuilder(stringBuilder);
        //将code加入到stringBuildeer2
        stringBuilder2.append(code);
        if(node!=null){
            //如果node==null不处理
            //判断当前node是叶子结点还是非叶子结点
            if(node.data==null){
                //非叶子结点
                //递归处理
                //向左
                getCodes(node.left, "0", stringBuilder2);
                //向右递归
                getCodes(node.right, "1", stringBuilder2);
            }else {
                //说明是一个叶子结点 表示找到某个叶子结点的最后
                huffmanCodes.put(node.data,stringBuilder2.toString() );
            }
        }
        return huffmanCodes;
    }

    //前序遍历方法
    private static void preOrder(Node root){
        if(root!=null){
            root.preOrder();
        }else {
            System.out.println("赫夫曼树为空");
        }
    }

    private static List<Node> getNodes(byte[] bytes){

        ArrayList<Node> nodes = new ArrayList<>();
        //遍历bytes,统计每一个byte出现的次数->map[key,value]
        Map<Byte,Integer>counts=new HashMap<>();
        for(byte b:bytes){
            Integer count=counts.get(b);
            if(count==null){
                //Map还没有这个字符数据，第一次
                counts.put(b, 1);
            }else {
                counts.put(b, count+1);
            }
        }
        //把每一个键值对转成一个Node对象，并加入到nodes集合
        //遍历Map
        for(Map.Entry<Byte,Integer>entry:counts.entrySet()){
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    //通过List创建对应的赫夫曼树
    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size()>1){
            //排序，从小到大
            Collections.sort(nodes);
            //取出第一颗最小的二叉树
            Node leftNode=nodes.get(0);

            Node rightNode=nodes.get(1);

            //创建一颗新的二叉树，它的根节点 没有data 只有权值
            Node prent=new Node(null,leftNode.weight+rightNode.weight);
            prent.left=leftNode;
            prent.right=rightNode;

            //将已经处理的两颗二叉树从nodes删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //新的二叉树 加入到nodes
            nodes.add(prent);
        }
        //nodes 最后的节点 就是赫夫曼树的根节点
        return nodes.get(0);
    }
}

//创建Node 待数据和权值
class Node implements Comparable<Node>{
    Byte data;  //存放数据额字符本身
    int weight; //权值，表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }

}
