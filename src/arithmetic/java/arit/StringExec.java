package arit;


import java.util.ArrayList;
import java.util.List;

public class StringExec {
    /**
     * 获取两个字符串的最大相同子串
     *
     * @param str1
     * @param str2
     * @return
     */
    List<String> longestSameSubString(String str1,String str2){
        String str;
        List<String> list = new ArrayList<>();
        String maxStr = (str1.length() > str2.length()) ? str1 : str2;
        String minStr = maxStr.equals(str1) ? str2 : str1;
        /*
         * 因为取的是最长子串，每一轮外层循环结束后就要把被匹配的长度-1(即i),i 是逐级递加的
         */
        for (int i = minStr.length(); i > 0; i--) {
            for (int j = 0; j + i <= minStr.length(); j++) {//j是初始位置，j+i是要取得的子串长度，不能超过最短的那个串
                str = minStr.substring(j, j + i);  //取的是j+1,j+i位置的子串，j是索引，取后面的一位
                int x = j + i;                    //i 是要取的子串的长度
                System.out.println("i=" + i + "   " + "j=" + j + "   " + x + "   " + str);
                if (maxStr.contains(str)) {
                    list.add(str);
                }
            }
            if (!list.isEmpty())//判断集合是否是空的
                return list;//如果没有此判断条件，所有循环取出来的字符都会添加到集合里
        }
        return list;
    }

    /**
     * 找到已知字符串中出现最多次的子串
     * 首先找到字符串中出现最多次的1、2位的子串,
     * 判断这些子串的2、3位是否和1、2位出现次数一样多,以此类推
     *
     * @param str 已知字符串
     */
    void mostSubString(String str) {
        String mostStr = "";
        //求子串最大的也不会超过原串的一半
        int[] p1 = new int[str.length() / 2 + 1];
        //最大次数
        int max = 1;
        //取子串
        for (int j = 0; j < str.length() - 1; j++) {
            int p2[] = new int[str.length() / 2 + 1];//p2记录每一次子串出现的位置
            int k = 0;
            p2[k++] = j;//记录子串开始时的位置
            String sub = str.substring(j, j + 2);//前闭后开的区间
            int count = 1;//出现的次数
            for (int i = j + 2; i < str.length() - 1; i++) {// 从j+2往后找相同子串 并且记录次数
                String sub2 = str.substring(i,sub.length()+i);
                if (sub.equals(sub2)) {
                    //记录子串出现的次数
                    count += count;
                    p2[k++] = i;//记录子串第一次出现的位置
                    i++;
                }
            }

            if (max < count) {
                max = count;
                int i = 0;
                while (i < count) {
                    p1[i] = p2[i];//告诉p1 第一个相同子串出现的位置
                    i++;
                }

                mostStr = sub;
            } else if (max == count) {
                boolean isMost = true;
                for (int i = 0; i < count; i++)
                    if (!(p1[i] == (p2[i] - mostStr.length() + 1))) isMost = false;
                if (isMost) {
                    //每次取的是俩子串，挨着的俩相同，如果是abc情况的话 ab,bc是连着的 取记录在p2数组里的位置的子串
                    mostStr = str.substring(p1[0], p1[0] + mostStr.length() + 1);
                }
            }
        }
        System.out.println(mostStr + "*" + max);

    }

}
