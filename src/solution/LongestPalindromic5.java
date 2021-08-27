package solution;

/**
 * @id 5
 * @author dongjin
 * @date 2020/11/19 15:38
 */
public class LongestPalindromic5 {

    /**
     * 暴力解法
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLenth = 1;
        int begin = 0;
        char[] ary = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLenth && isPalindrome(ary, i, j)) {
                    maxLenth = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLenth);
    }

    /**
     * 判断以left和right为端点的串（包含）是否为回文串
     * @param s
     * @param left
     * @param right
     * @return
     */
    private boolean isPalindrome(char[] s, int left, int right) {
        while (left < right) {
            if (s[left] != s[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 中心扩展法，依次以每个点作为中心点，向两端扩展寻找最长的长度
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public String longestPalindromeMiddle(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLenth = 1;
        int begin = 0;
        char[] ary = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {
            int oddLength = longestPalindromeMiddle(ary, i, i);
            int evenLength = longestPalindromeMiddle(ary, i , i + 1);
            int tempLength = Math.max(oddLength, evenLength);
            if (tempLength > maxLenth) {
                maxLenth = tempLength;
                begin = i - (maxLenth - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLenth);
    }

    /**
     * 返回以left和right为中心的最长回文长度
     * @param s
     * @param left
     * @param right
     * @return
     */
    public int longestPalindromeMiddle(char[] s, int left, int right) {
        while (left >=0 && right < s.length && s[left] == s[right]) {
            left--;
            right++;
        }
        return right - left -1; // 退出while时，right和left已经不满足回文条件，因此返回的长度为(right - 1) - (left + 1) + 1 = right - left -1
    }

    /**
     * 动态规划
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     * @param s
     * @return
     */
    public String longestPalindromeDP(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        // 状态dp[i][j]表示子串s[i...j]是否为回文子串
        // 状态转移方程dp[i][j] = s[i] == s[j] && dp[i + 1][j - 1]
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int begin = 0;
        int maxLenth = 1;
        // 计算dp[i][j]之前需要计算出dp[i+1][j-1]（左下角），因此一列一列的填表
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                //新的状态不够成区间（长度小于2），dp[i + 1][j - 1]没有意义， j - 1 - (i + 1) + 1 < 2 = j - i < 3 = j - i + 1 < 4，即不用判断长度小于4的字符串（2或3）的子串是否为回文串
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLenth) {
                        maxLenth = j - i + 1;
                        begin = i;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(begin, begin + maxLenth);
    }

    public static void main(String[] args) {
        LongestPalindromic5 temple = new LongestPalindromic5();
        System.out.println(temple.longestPalindromeDP("babad"));
    }
}
