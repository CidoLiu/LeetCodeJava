package solution;

/**
 * @id
 * @author dongjin
 * @date 2020/11/18 12:00
 */
public class NumArray303 {

//    private int[] nums;
    private int[] sum;

    public NumArray303(int[] nums) {
//        this.nums = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            this.nums[i] = nums[i];
//        }
        this.sum = new int[nums.length + 1];
        this.sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            this.sum[i + 1] = this.sum[i] + nums[i];
         }
    }

    /**
     * 时间复杂度很过分，由于可能多次调用sumRange方法，可以考虑使用缓存来加快速度
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
//        int sum = 0;
//        for (int k = i; k <= j; k++) {
//            sum += this.nums[k];
//        }
//        return sum;
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {
//        NumArray303 temple = new NumArray303();
        System.out.println();
    }
}
