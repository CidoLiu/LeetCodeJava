package solution;

/**
 * @author dongjin
 * @date 2020/10/13 13:18
 */
public class PalindromeNumber {

    /**
     * 判断一个整数是否满足回文，思路是对于所有正整数进行翻转，然后比较.
     * 弊端：如果反转后的数字大于 \text{int.MAX}int.MAX，我们将遇到整数溢出问题.
     * @param x 待判断的整数
     * @return boolean
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int reverse = 0;
        int copy = x;
        while (copy > 0) {
            reverse = reverse * 10 + copy % 10;
            copy /= 10;
        }
        if (reverse == x) {
            return true;
        }else{
            return false;
        }
    }

    /**
     * 只考虑翻转一半的数组，并与剩下的一半进行比较，考虑数位为奇数和偶数两种情况。
     * 加快了程序的运行时间，并避免了溢出情况。
     */
    public boolean isPalindromeHalf(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int reverseHalf = 0;
        while (x > reverseHalf){
            reverseHalf = reverseHalf * 10 + x % 10;
            x /= 10;
        }
        if (x == reverseHalf){
            return true;
        }else{
            if (x == reverseHalf / 10){
                return true;
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        PalindromeNumber temple = new PalindromeNumber();
        System.out.println(temple.isPalindromeHalf(121));
    }


}
