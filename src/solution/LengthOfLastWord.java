package solution;

/**
 * @author dongjin
 * @date 2020/10/22 17:00
 */
public class LengthOfLastWord {

    /*
    * 此题有坑，当测试用例为"a "时，需要返回1，而不是0
    * */
    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) != ' ') {
                len++;
            } else if (len > 0){ // len = 0，可能是尾部空格
                break;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        LengthOfLastWord temple = new LengthOfLastWord();
        System.out.println(temple.lengthOfLastWord("a "));
    }
}
