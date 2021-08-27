package solution;

/**
 * @id 268
 * @author dongjin
 * @date 2020/11/18 12:46
 */
public class MissingNumber268 {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int[] count = new int[nums.length + 1];
        for (int i:nums) {
            count[i]++;
        }
        for (int j = 0; j < count.length; j++) {
            if (count[j] == 0) {
                return j;
            }
        }
        return 0;
    }

    /**
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param nums
     * @return
     */
    public int missingNumberBySum(int[] nums) {
        int sum = 0;
        for (int i:nums) {
            sum += i;
        }
        int allSum = 0;
        for (int j = 0; j < nums.length + 1; j++) {
            allSum += j;
        }
        return allSum - sum;
    }

    public static void main(String[] args) {
        MissingNumber268 temple = new MissingNumber268();
        System.out.println();
    }
}
