package solution;

/**
 * @id 387
 * @author dongjin
 * @date 2020/11/19 12:39
 */
public class UniqueCharacter387 {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] count = countCharacter(s);
        for (int i = 0; i < s.length(); ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    private int[] countCharacter(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }

    public static void main(String[] args) {
        UniqueCharacter387 temple = new UniqueCharacter387();
        System.out.println(temple.firstUniqChar("loveleetcode"));
    }
}
