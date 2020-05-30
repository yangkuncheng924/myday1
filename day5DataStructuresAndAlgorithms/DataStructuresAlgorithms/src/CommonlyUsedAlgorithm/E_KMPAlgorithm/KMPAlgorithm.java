package CommonlyUsedAlgorithm.E_KMPAlgorithm;

import java.util.Arrays;

/**
 * @parameter
 * @effect
 * @return
 * @date 2020/5/8 10:39
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = kmpnext("ABCDABD");
        System.out.println(Arrays.toString(next));

        int index = kmpSearch(str1, str2, next);
        System.out.println("index" + index);
    }

    //获取到一个字符串（子串）的部分匹配值表
    public static int[] kmpnext(String dese) {
        //创建一个next保存部分匹配值
        int[] next = new int[dese.length()];
        next[0] = 0;  //如果字符串是长度为1部分匹配值就是0
        for (int i = 1, j = 0; i < dese.length(); i++) {
            while (j > 0 && dese.charAt(i) != dese.charAt(j)) {
                j = next[j - 1];
            }
            if (dese.charAt(i) == dese.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    //KMP搜索算法

    /**
     * @param str1 str1源字符串
     * @param str2 str2子串
     * @param next next部分匹配表，是子串对应的部分匹配表
     * @return 如果是-1就是没有匹配到，否则返回第一个匹配的位置
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            //需要处理str1.charAt(i)!=str2.charAt(j),去调整j的大小
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                //找到了
                return i - j + 1;
            }
        }
        return -1;
    }
}
