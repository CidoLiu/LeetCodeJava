package solution;

/**
 * @id 190
 * @author dongjin
 * @date 2020/11/8 14:00
 */
public class ReverseBits {

    /*
    * 时间复杂度：O(logn)
    * */
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // 开头的0需要考虑，固定32位长度。
//        int ans = 0;
//        while (n != 0) {
//            ans += n % 2;
//            n /= 2;
//        }
//        return n;
        int ans = 0;
        for (int i = 0; i < 32; i++) { // 考虑到前置0，因此固定循环32次
            ans = (ans << 1) | (n & 1); // 左移一位相当于乘2，与1相当于取最低为，或运算在这里等价于相加，因为前一个的最低位为0，后一个除了最低位都为0
            n >>=1; // 右移一位相当于除2
        }
        return ans;
    }

    public static void main(String[] args) {
        ReverseBits temple = new ReverseBits();
        System.out.println(temple.reverseBits(43261596));
    }
}
