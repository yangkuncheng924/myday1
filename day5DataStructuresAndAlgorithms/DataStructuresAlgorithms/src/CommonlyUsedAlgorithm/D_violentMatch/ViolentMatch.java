package CommonlyUsedAlgorithm.D_violentMatch;

/**
 * @parameter
 * @effect
 * @return
 * @date 2020/5/8 10:11
 */
public class ViolentMatch {
    public static void main(String[] args) {
        String str1 = "你好 你好好不好 你好好好 你好好好好";
        String str2 = "你好好好好";
        int index = violentMatch(str1, str2);
        System.out.println(index);
    }

    public static int violentMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0;    //i索引指向s1
        int j = 0;    //j索引指向s2
        while (i < s1Len && j < s2Len) {//保证匹配 不越界
            if (s1[i] == s2[j]) {
                //匹配
                i++;
                j++;
            } else {
                //没有匹配成功
                i = i - (j - 1);
                j = 0;
            }
        }
        //判断是否匹配成功
        if (j == s2Len) {
            return i - j;
        } else {
            return -1;
        }

    }
}
