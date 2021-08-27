package solution;

/**
 * @id 344
 * @author dongjin
 * @date 2020/11/18 15:40
 */
public class ReverseString344 {

    public void reverseString(char[] s) {
        char temp;
        for (int i = 0; i < s.length / 2; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseString344 temple = new ReverseString344();
        char[] s = {'h','e','l','l','o'};
        temple.reverseString(s);
        System.out.println(s);
    }
}
