package solution;


/**
 * @author dongjin
 * @date 2020/10/14 12:30
 */
public class ContainerWithMostWater {

    /*
    * 暴力解法，时间复杂度O(n2)
    * */
    public int maxArea(int[] height) {
        int max = 0;
//        int max_i = 0;
//        int max_j = 0;
        for (int i = 0; i < height.length - 1; ++i) {
            for (int j = i + 1; j < height.length; ++j){
                int temp_max = (j - i) * Integer.min(height[i], height[j]);
                if (temp_max > max) {
                    max = temp_max;
//                    max_i = i;
//                    max_j = j;
                }
            }
        }
        return max;
    }

    /*
    * 双指针解法，时间复杂度为O(n)
    * */
    public int maxAreaDoublePointer(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int max_temp = (j - i) * Integer.min(height[i], height[j]);
            max = Integer.max(max, max_temp);
            if (height[i] < height[j]){
                ++i;
            }else{
                --j;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater temple = new ContainerWithMostWater();
        System.out.println(temple.maxAreaDoublePointer(new int[] {1,8,6,2,5,4,8,3,7}));
    }


}
