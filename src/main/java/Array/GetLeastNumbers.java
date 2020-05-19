package Array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的k个数
 * 方法1，快排，切分排好的第k小的数，下标为k-1，左边即为比他小的k-1个数
 * 时间复杂度O(N)
 * 方法2，大根堆（前k小）/小根堆（前k大），java中有现成的PriorityQueue
 * 时间复杂度O(NlogK)
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] arr = new int[]{5,7,24,15,2332,234,52,223};
        int k=5;
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        int[] leastNumbers = getLeastNumbers.getLeastNumbers( arr, k );
        for (int i = 0; i < leastNumbers.length; i++) {
            System.out.println(leastNumbers[i]);
        }
    }

    /******************************************************************************************
     *
     * @param arr
     * @param k
     * @return
     */
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if (k == 0 || arr.length == 0) {
//            return new int[0];
//        }
//
//        //最后一个参数表示我们要找的是下标为k-1的数
//        return quickSearch( arr, 0, arr.length - 1, k - 1 );
//    }
//
//    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
//        //每快排切分一次，找到排序后下标为j的元素，如果j恰好等于K就返回
//        int j = partition( nums, lo, hi );
//        if (j == k) {
//            return Arrays.copyOf( nums, j + 1 );
//        }
//
//        //否则根据下标j与k的大小关系来决定继续切分左段还是右段
//        return j > k ? quickSearch( nums, lo, j - 1, k ) : quickSearch( nums, j + 1, hi, k );
//    }
//
//    //快排切分，返回下标，使得比nums[j]小的数都在j的左边，比nums[j]打的数都在j的右边
//    private int partition(int[] nums, int lo, int hi) {
//        int v = nums[lo];
//        int i = lo,j=hi+1;
//        while (true) {
//            while (++i<=hi&&nums[i]<v);
//            while(--j>=lo&&nums[j]>v);
//            if (i >= j) {
//                break;
//            }
//
//            int t = nums[j];
//            nums[j] = nums[i];
//            nums[i]=t;
//        }
//        nums[lo] = nums[j];
//        nums[j]=v;
//        return j;
//    }

    /************************************************************************************************************
     * 大根堆（前k小）/小根堆（前k大），java中有现成的PriorityQueue
     */
    //保持堆的大小为K，然后遍历数组中的数字，遍历的时候加入以下判断
//    1.若当前堆的大小小于K，将当前数字放入堆中
//    2.否则判断当前数字与大根堆顶元素的大小关系，如果当前数字比大根堆大，这个数字直接跳过；
//    反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将数字放入堆中
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        //默认是小根堆，实现大根堆需要重写比较器
        Queue<Integer> pq = new PriorityQueue<>( (v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer( num );
            } else if ((num < pq.peek())) {
                pq.poll();
                pq.offer( num );
            }
        }
        //返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for (int num : pq) {
            res[idx++]=num;
        }
        return res;
    }





}
