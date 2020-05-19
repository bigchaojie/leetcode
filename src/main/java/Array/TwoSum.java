package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组nums和一个目标值target，在数组中找出和为目标值的两个整数，返回数组下标。
 *
 * 方法1，暴力破解，遍历每个元素i,寻找数组中是否有target-i
 * 时间复杂度为O(n²)，空间复杂度为O(1)
 * 方法2，两遍哈希表 先将数组元素放入map，查找target-nums[i]的数是否存在
 * 时间复杂度为O(n),空间复杂度为O(n)
 * 方法3，一遍哈希表，先判断map是否有target-nums[i],有就返回，如果没有直接存入target-nums[i]
 * 时间复杂度为O(n),空间复杂度为O(n)
 */
public class TwoSum {

    public static void main(String[] args) {

    }

    /*********************************************************************************
     * 两遍哈希表
     * @param nums
     * @param target
     * @return
     * @throws IllegalAccessException
     */
//    public int[] twoSum(int[] nums, int target) throws IllegalAccessException {
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put( nums[i], i );
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey( complement ) && map.get( complement ) != i) {
//                return new int[]{i, map.get( complement )};
//            }
//        }
//        throw new IllegalAccessException( "No two Sum solution!" );
//    }

    /******************************************************************************
     * 一遍哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) throws IllegalAccessException {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey( complement )) {
                return new int[]{map.get( complement ), i};
            }
            map.put( nums[i], i );
        }
        throw new IllegalAccessException( "No Two Sum Solution" );
    }

}
