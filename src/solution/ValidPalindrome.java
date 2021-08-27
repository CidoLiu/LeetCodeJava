package solution;

/**
 * @id 125
 * @author dongjin
 * @date 2020/10/26 17:42
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        StringBuffer sgood = new StringBuffer();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(ch);
            }
        }
        System.out.println(sgood);
        if (sgood.length() == 0) {
            return true;
        }
        int n = sgood.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (sgood.charAt(left) == sgood.charAt(right)) {
                left++;
                right--;
            } else {
                break;
            }
        }
        if (left >= right){
            return true;
        } else {
            return false;
        }
    }



    public static void main(String[] args) {
        ValidPalindrome temple = new ValidPalindrome();
        System.out.println(temple.isPalindrome("aa"));
    }
}
