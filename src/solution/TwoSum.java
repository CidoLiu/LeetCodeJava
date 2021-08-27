package solution;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        /*
        * 时间复杂度为O(N2)
        * 空间复杂度为O(1)
        * */
//        int[] answer = new int[2];
        int n = nums.length;
        for(int i = 0; i < n; ++i){
            for(int j = i + 1; j < n; ++j){
                if(nums[i] + nums[j] == target){
//                    answer[0] = i;
//                    answer[1] = j;
                    return new int[]{i, j};
                }
            }
        }
//        return answer;
        return new int[0]; //返回一个长度为0的数组
    }

    public int[] twoSumByMap(int[] nums, int target){
        /*
        * 时间复杂度为O(N)
        * 空间复杂度为O(N)，建立hashmap需要消耗空间
        * */
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; ++i){
            if(hashtable.containsKey(target - nums[i])){
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        TwoSum tsm = new TwoSum();
        System.out.println(Arrays.toString(tsm.twoSumByMap(nums, target)));
    }
}

