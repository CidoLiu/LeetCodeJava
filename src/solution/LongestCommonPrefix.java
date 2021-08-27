package solution;

import java.util.Arrays;
import java.util.Map;

/**
 * @author dongjin
 * @date 2020/10/14 14:24
 */
public class LongestCommonPrefix {

    /*
    * 横向扫描
    * 时间复杂度为O(mn)，其中m是字符串数组中的字符串的平均长度，n是字符串的数量。
    * 空间复杂度为O(1)
    * */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            ans = longestCommonPrefix(ans, strs[i]);
            if (ans == "") {
                break;
            }
        }
        return ans.toString();
    }

    /** 计算两个字符串的最长公共起始序列
     * @param str1
     * @param str2
     * @return
     */
    public String longestCommonPrefix(String str1, String str2) {
        int length = Integer.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            ++index;
        }
        return str1.substring(0, index);
    }

    /*
    * 纵向扫描
    * 时间复杂度为O(mn)，其中m是字符串数组中的字符串的平均长度，n是字符串的数量。
    * 空间复杂度为O(1)
    * */
    public String longestCommonPrefixByLengthways(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
//        if (strs.length == 1) {
//            return strs[0];
//        }
        StringBuilder ans = new StringBuilder();
        int index = 0;
        char index_char = 'O';
        boolean add = true;
        while (true) {
            if (strs[0].length() <= ans.length()) {
                break;
            }
            index_char = strs[0].charAt(ans.length());
            index = ans.length();
//            System.out.println(index_char);
            add = true;
            for (int i = 0; i < strs.length; ++i) {
                if (index >= strs[i].length()) {
                    add = false;
                    break;
                }
                if (index_char != strs[i].charAt(index)) {
                    add = false;
                    break;
                }
            }
            if (add) {
                ans.append(index_char);
            }else{
                break;
            }
        }
        return ans.toString();
    }

    /*
     * 纵向扫描，官方题解版
     * 时间复杂度为O(mn)，其中m是字符串数组中的字符串的平均长度，n是字符串的数量。
     * 空间复杂度为O(1)
     * */
    public String longestCommonPrefixByLengthwaysLeetcode(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); ++i) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /*
    * 分治算法
    * 时间复杂度为O(mn)，其中m是字符串数组中的字符串的平均长度，n是字符串的数量。
    * 空间复杂度为O(mlogn)
    * */
    public String longestCommonPrefixDivideAndConquer(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefixDivideAndConquer(strs, 0, strs.length - 1);
    }

    public String longestCommonPrefixDivideAndConquer(String[] strs, int start, int end){
        if (start == end){
            return strs[start];
        }else{
            int middle = (end -start) / 2 + start;
            String lcpLeft = longestCommonPrefixDivideAndConquer(strs, start, middle);
            String lcpRight = longestCommonPrefixDivideAndConquer(strs, middle + 1, end);
            return longestCommonPrefix(lcpLeft, lcpRight);
        }
    }

    /*
    * 二分查找
    * 时间复杂度O(mnlogm)
    * 空间复杂度O(1)
    * */
    public String longestCommonPrefixBinarySearch(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(str.length(), minLength);
        }
        int low = 0;
        int high = minLength;
        while (low < high) {
            int middle = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, middle)) {
                low = middle;
            }else{
                high = middle - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    /**检查字符串数组的前length位是否为公共前序列
     * @param strs
     * @param length
     * @return
     */
    public boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        for (String str : strs) {
            for (int j = 0; j < length; ++j) {
                if (str.charAt(j) != str0.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
    * 排序
    * 时间复杂度取决于排序算法，Arrays.sort是经过调优的快速排序法，快排时间复杂度O(nlogn)
    * */
    public String longestCommonPrefixBySort(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length - 1];
        return longestCommonPrefix(start, end);
    }

    public static void main(String[] args) {
        LongestCommonPrefix temple = new LongestCommonPrefix();
        System.out.println(temple.longestCommonPrefixDivideAndConquer(new String[] {"ab", "a"}));
    }


}
