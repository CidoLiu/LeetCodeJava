package solution;

import java.util.Arrays;

/**
 * @id 242
 * @author dongjin
 * @date 2020/11/9 20:08
 */
public class VaildAnagram242 {

    /*
    * 使用一个数组，充当哈希表
    * 也可以使用排序，然后比较 equals
    * 时间复杂度：O(n)
    * 空间复杂度：O(1)
    * */
    public boolean isAnagram(String s, String t) {
        int[] ary = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ary[s.charAt(i) - 'a']++;
        }
//        System.out.println(Arrays.toString(ary));
        for (int i = 0; i < t.length(); i++) {
            ary[t.charAt(i) - 'a']--;
        }
//        System.out.println(Arrays.toString(ary));
        for (int i = 0; i < 26; i++) {
            if (ary[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        VaildAnagram242 temple = new VaildAnagram242();
        System.out.println(temple.isAnagram("a","b"));
    }
}
