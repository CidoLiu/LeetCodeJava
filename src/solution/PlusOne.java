package solution;

/**
 * @author dongjin
 * @date 2020/10/22 17:38
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len - 1]++;
        for (int i = len - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1]++;
            }
        }
        if (digits[0] != 10) {
            return digits;
        } else {
            int[] newDigits = new int[len + 1];
            newDigits[0] = 1; // 若数组溢出，则只能是999...，溢出为1000...的情况，因此返回{1, 0, 0, ...}即可
            return newDigits;
        }
    }

    public static void main(String[] args) {
        PlusOne temple = new PlusOne();
        System.out.println();
    }
}
