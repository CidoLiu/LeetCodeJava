package solution;

import java.util.Arrays;

/**
 * @id 169
 * @author dongjin
 * @date 2020/11/7 20:39
 */
public class MajorityElement {

    /*
    * 时间复杂度：O(nlogn)
    * 空间复杂度：O(logn)
    * */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /*
    * 官方题解：投票法
    * 时间复杂度：O(n)
    * 空间复杂度：O(1)
    * */
    public int majorityElementByVote(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num: nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement temple = new MajorityElement();
        System.out.println();
    }
}
