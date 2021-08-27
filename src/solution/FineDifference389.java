package solution;

/**
 * @id 389
 * @author dongjin
 * @date 2020/11/19 12:51
 */
public class FineDifference389 {

    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        count[t.charAt(t.length() - 1) - 'a']--;
        for (int i = 0; i < 26; ++i) {
            if (count[i] == -1) {
                return (char) (i + 'a');
            }
        }
        return '-';
    }

    public static void main(String[] args) {
        FineDifference389 temple = new FineDifference389();
        System.out.println(temple.findTheDifference("", "a"));
    }
}
