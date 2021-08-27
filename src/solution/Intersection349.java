package solution;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @id 349
 * @author dongjin
 * @date 2020/11/18 16:02
 */
public class Intersection349 {

    /**
     * 时间复杂度：O(nlogn + mlogm)
     * 空间复杂度：O(n)
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // 排序复杂度：O(nlogn)
        Arrays.sort(nums2);
//        System.out.println(Arrays.toString(nums1));
        Set<Integer> set = new HashSet<Integer>();
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) { // 双指针时间复杂度：O(m + n)
            if(nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] ans = new int[set.size()];
        int index = 0;
        for (int num: set) {
            ans[index++] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Intersection349 temple = new Intersection349();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(temple.intersection(nums1, nums2)));
    }
}
