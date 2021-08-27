package solution;

import java.util.HashSet;

/**
 * @id 3
 * @author dongjin
 * @date 2020/11/19 14:53
 */
public class LongestSubString3 {

    /**
     * 滑动窗口
     * 时间复杂度：O(N)，所有指针分别遍历一遍字符串
     * 空间复杂度：O(字符集大小)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int n = s.length();
        int right = -1;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) { // 当 i ==0 时，set集合为空，不需要删除
                set.remove(s.charAt(i - 1));
            }
            while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubString3 temple = new LongestSubString3();
        System.out.println();
    }
}
