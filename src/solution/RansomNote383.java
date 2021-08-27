package solution;

/**
 * @id 383
 * @author dongjin
 * @date 2020/11/19 12:20
 */
public class RansomNote383 {

    /**
     * 时间复杂度：O(n)
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countMagazine = countCharacter(magazine);
        for (int i = 0; i < ransomNote.length(); ++i) {
            countMagazine[ransomNote.charAt(i) - 'a']--;
            if (countMagazine[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    private int[] countCharacter(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }

    public static void main(String[] args) {
        RansomNote383 temple = new RansomNote383();
        System.out.println(temple.canConstruct("aa", "ab"));
    }
}
