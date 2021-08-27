package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @id 228
 * @author dongjin
 * @date 2020/11/9 10:34
 */
public class SummaryRanges {

    /*
    * 将最后一个组的情况单独处理
    * 时间复杂度：O(n)
    * */
    public List<String> summaryRanges(int[] nums) {
        int i = 0;
        int j = 1;
        List<String> ans = new ArrayList<>();
        while (i < nums.length && j < nums.length) {
            if (nums[j] - nums[j - 1] == 1) {
                j++;
            } else {
                if (j - i > 1) {
                    ans.add(nums[i] + "->" + nums[j - 1]);
                } else {
                    ans.add(Integer.toString(nums[j - 1]));
                }
                i = j;
                j++;
            }
        }
//        System.out.println(j);
        // 处理最后的一个String
        if (i == nums.length - 1) {
            ans.add(Integer.toString(nums[i]));
        } else if (i < nums.length - 1) {
            ans.add(nums[i] + "->" + nums[j - 1]);
        }
        return ans;
    }

    /*
    * 时间复杂度：O(n)
    * */
    public List<String> summaryRangesLeetcode(int[] nums) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (j + 1 < nums.length && nums[j] == nums[j + 1] - 1) {
                j++;
                continue;
            }
            if (i == j) {
                ans.add(Integer.toString(nums[i]));
            } else {
                ans.add(Integer.toString(nums[i]) + "->" + Integer.toString(nums[j]));
            }
            i = j + 1;
            j = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        SummaryRanges temple = new SummaryRanges();
        System.out.println(temple.summaryRangesLeetcode(new int[] {0,1,2,4,5,7})); // [0->2, 4->5, 7]
        System.out.println(temple.summaryRangesLeetcode(new int[] {0,2,3,4,6,8,9})); // [0, 2->4, 6, 8->9]
    }
}
