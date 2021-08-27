package solution;

import java.util.Arrays;

/**
 * @id 283
 * @author dongjin
 * @date 2020/11/18 13:03
 */
public class MoveZeroes283 {

    /**
     * 虽然考虑到了双指针，但是并没有发挥双指针的实际用处
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            if (nums[i] == 0) {
                zeroCount++;
                while(j < nums.length && nums[j] == 0) {
                    j++;
                }
                if (j == nums.length) {
                    break;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
//        for(int i = nums.length - zeroCount; i < nums.length; i++) {
//            nums[i] = 0;
//        }
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     */
    public void moveZeroesLeetcode(int[] nums) {
        int lastNoZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNoZeroIndex++] = nums[i];
            }
        }
        for(int i = lastNoZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes283 temple = new MoveZeroes283();
        int[] list = {0,1,0,3,12};
        temple.moveZeroesLeetcode(list);
        System.out.println(Arrays.toString(list));
    }
}
