package src.Drawing.A_Drawing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @parameter
 * @effect
 * @return
 * @date 2020/5/4 13:24
 */
public class Drawing {
    private ArrayList<String>vertexList;    //存储顶点集合
    private int[][] edges;  //存储图对应的领结矩阵
    private int numOfedes;  //表示边的数目
    //定义给数组boolean[] 记录某个结点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        //测试一把图是否创建成功
        int n=5;    // 结点的个数
        String Vertexs[]={"A","B","C","D","E"};
        //创建图对象
        Drawing drawing = new Drawing(n);
        //循环的添加顶点
        for(String vertex:Vertexs){
            drawing.insertVertes(vertex);
        }

        //添加边
        //A-B A-C B-C B-D B-E
        drawing.insertEdge(0, 1, 1);
        drawing.insertEdge(0, 2, 1);
        drawing.insertEdge(1, 2, 1);
        drawing.insertEdge(1, 3, 1);
        drawing.insertEdge(1, 4, 1);

        //显示一把领结矩阵
        drawing.showGraph();

        //测试 dfs遍历是否成功
        System.out.println("深度遍历！");
        drawing.dfs();
        System.out.println();
        System.out.println("广度优先！");
        drawing.bfs();
    }

    //构造器
    public Drawing(int n){
        //初始化矩阵和vertexList
        edges=new int[n][n];
        vertexList=new ArrayList<>(n);
        numOfedes=0;
    }

    //得到第一个邻接结点下标
    /**
     *
     * @param index
     * @return  如果存在就返回对应的下标，否则换回-1
     */
    public int getFirstNeighbor(int index){
        for (int i = 0; i <vertexList.size() ; i++) {
            if(edges[index][i]>0){
                return i;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2+1; i <vertexList.size() ; i++) {
            if(edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    public void dfs(boolean[] isVisited,int i){
        //首先我们访问该结点，输出
        System.out.print(getValueByIndex(i)+"->");
        //将结点设置成已访问
        isVisited[i]=true;
        //查找结点i的第一个邻接结点w
        int w=getFirstNeighbor(i);
        while (w!=-1){
            //说明有
            if(!isVisited[w]){
                dfs(isVisited, w);
            }
            //如果w结点已经被访问过
            w=getNextNeighbor(i, w);
        }
    }
    //对dfs进行重载，遍历所有的结点，并进行dfs
    public void dfs(){
        isVisited=new boolean[5];
        //遍历所有的结点 进行dfs[回溯]
        for (int i = 0; i <getNumOfVertex() ; i++) {
            if(!isVisited[i]){
                dfs(isVisited, i);
            }
        }
    }

    //对一个结点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited,int i){
        int u;  //表示队列的头结点对应的下标
        int w;  //邻接结点w
        //队列 记录结点访问的顺序
        LinkedList queue = new LinkedList();
        //访问结点 输出结点信息
        System.out.print(getValueByIndex(i)+"=>");
        //标记为已访问
        isVisited[i]=true;
        //将结点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()){
            //取出队列的头结点的下标
            u=(Integer)queue.removeFirst();
            //得到第一个邻接结点的下标
            w=getFirstNeighbor(u);
            while (w!=-1){
                //找到
                //是否被访问过
                if(!isVisited[w]){
                    System.out.print(getValueByIndex(w)+"=>");
                    //标记已经访问
                    isVisited[w]=true;
                    //入队
                    queue.addLast(w);
                }
                //已u为前驱点，找w后面的下一个领结点
                w=getNextNeighbor(u, w);//体现出广度优先
            }
        }
    }

    //遍历所有的结点 进行广度优先搜索
    public void bfs(){
        isVisited=new boolean[5];
        for (int i = 0; i <getNumOfVertex() ; i++) {
            if(!isVisited[i]){
                bfs(isVisited, i);
            }
        }
    }

    //插入结点
    public void insertVertes(String vertex){
        vertexList.add(vertex);
    }
    //添加边
    /**
     * @param v1    表示点的下标即使第几个顶点“A”-"B" "A"->0 "B"->1
     * @param v2     第二个顶点对应的下标
     * @param weight
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfedes++;
    }
    //图中常用的方法
    //返回结点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //得到边的的数目
    public int getNumOfEdes(){
        return numOfedes;
    }
    //返回结点i对应的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    //显示图对应的矩阵
    public void showGraph(){
        for(int[] link:edges){
            System.out.println(Arrays.toString(link));
        }
    }
}
