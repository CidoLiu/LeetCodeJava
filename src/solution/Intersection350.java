package solution;


import java.util.*;

/**
 * @id 350
 * @author dongjin
 * @date 2020/11/18 16:02
 */
public class Intersection350 {

    /**
     * 时间复杂度：O(nlogn + mlogm)
     * 空间复杂度：O(n)
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // 排序复杂度：O(nlogn)
        Arrays.sort(nums2);
//        System.out.println(Arrays.toString(nums1));
        List<Integer> list = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) { // 双指针时间复杂度：O(m + n)
            if(nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] ans = new int[list.size()];
        int index = 0;
        for (int num: list) {
            ans[index++] = num;
        }
        return ans;
    }

    /**
     * 使用HashMap来存储数据出现的次数，应对nums2很大，无法一次性读入内存进行排序的情况
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectHashMap(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num: nums1) {
            if (map.containsKey(num)) {
                int oldValue = map.get(num);
                map.replace(num, oldValue + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num:nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                int oldValue = map.get(num);
                map.replace(num, oldValue - 1);
            }
        }
        int[] ans = new int[list.size()];
        int index = 0;
        for (int num: list) {
            ans[index++] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Intersection350 temple = new Intersection350();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(temple.intersectHashMap(nums1, nums2)));
    }
}
