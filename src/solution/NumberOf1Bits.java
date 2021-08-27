package solution;

/**
 * @id 191
 * @author dongjin
 * @date 2020/11/8 14:16
 */
public class NumberOf1Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits temple = new NumberOf1Bits();
        System.out.println(temple.hammingWeight(11));
    }
}
