package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @id 219
 * @author dongjin
 * @date 2020/11/9 9:34
 */
public class ContainsDuplicateII {

    /*
    * 时间复杂度：O(nk)
    * */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    * HashSet
    * 时间复杂度：O(n)
    * */
    public boolean containsNearbyDuplicateHashSet(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII temple = new ContainsDuplicateII();
        System.out.println(temple.containsNearbyDuplicateHashSet(new int[] {99,99}, 2));
    }
}
