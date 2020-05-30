package CommonlyUsedAlgorithm.H_KruskalAlgorithm;

import java.util.Arrays;

/**
 * @parameter
 * @effect
 * @return
 * @date 2020/5/8 18:19
 */
public class KruskalAlgorithm {
    private int edgeNum;     //边的个数
    private char[] vertexs;    //顶点数组
    private int[][] matrix;     //邻接矩阵
    //使用INF表示两个顶点不能联通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};

        //创建对象
        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm(vertexs, matrix);
        //输出
        kruskalAlgorithm.print();
        kruskalAlgorithm.kruskal();
//        EData[] edges = kruskalAlgorithm.getEdges();
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(edges));
//        System.out.println("排序后：");
//        kruskalAlgorithm.sortEdges(edges);
//        System.out.println(Arrays.toString(edges));
    }

    public KruskalAlgorithm(char[] vertexs, int[][] matrix) {
        //初始化顶点数和变的个数
        int vlen = vertexs.length;

        //初始化顶点，复制拷贝的方式
        this.vertexs = new char[vlen];
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }

        //初始化边，使用复制拷贝的方式
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        //统计边
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    //打印邻接矩阵
    public void print() {
        System.out.println("邻接矩阵为：\n");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private void sortEdges(EData[] eDges) {
        for (int i = 0; i < eDges.length - 1; i++) {
            for (int j = 0; j < eDges.length - 1 - i; j++) {
                if (eDges[j].weight > eDges[j + 1].weight) {
                    EData tmp = eDges[j];
                    eDges[j] = eDges[j + 1];
                    eDges[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * @param ch ch顶点的值比如 ’A‘ ，’B‘
     * @return 返回ch顶点对应的下标如果找不到返回-1
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取图中边放到EData[]数组中，后面我们需要遍历该数组
     * 是通过matrix 邻接矩阵来获取
     * Edata[]形式 [[ ’A','B',12],['B','F',7],...]
     *
     * @return
     */
    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标为i的顶点的终点（），用于后面判断两个顶点的终点是否相同
     *
     * @param ends 数组就是记录了各个顶点对应的终点是哪个，ends数组是在遍历过程中 逐步形成
     * @param i    表示传入的顶点对应的下标
     * @return 返回的就是下标为i的这个顶点对应的终点的下标
     */
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    public void kruskal() {
        int index = 0;    //表示最后结果数组的索引
        int[] ends = new int[edgeNum];    //用于保存“已有最小生成树”中的每个顶点的在最小生成树中的终点
        //创建结果数组，保存最后的最小生成树
        EData[] rets = new EData[edgeNum];

        //获取图中所有的边的集合，一共有12边
        EData[] edges = getEdges();

        //按照边的权值大小进行排序
        sortEdges(edges);

        //遍历edges数组，将边添加到最小生成树中时，判断是准备加入的边否形成了回路，如果没有就加入rets，否则不能加入
        for (int i = 0; i < edgeNum; i++) {
            //获取到第i条边的第一个顶点（起点）
            int p1 = getPosition(edges[i].start);
            //获取到第i条边的第二个顶点
            int p2 = getPosition(edges[i].end);

            //获取p1这个顶点在已有最小生成树中的终点
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            //是否个构成回路
            if (m != n) {
                //没有构成回路
                ends[m] = n;  //设置m 在"已有生成树"中的终点<E,F>
                rets[index++] = edges[i]; //有一条边加入到rets数组
            }
        }
        System.out.println("最小生成树=" + Arrays.toString(rets));
    }
}

//创建一个类EData，它的对象实例就表示一条边
class EData {
    char start; //边的一个点
    char end;   //边的另外一个点
    int weight;//边的权值

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}