package leetcode.array;

/**
 * @author zacyex
 * @Lever 简单
 * @Question
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 *
 * 提示：
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2021/2/4 9:31
 */
public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = k-1;
        double result;

        int sum = 0;
        for(int i = left; i<= right; i++){
            sum += nums[i];
        }
        result = (double) sum/(double)(right-left+1);
        while(right < nums.length - 1){
            right++;
            sum += nums[right];
            sum -= nums[left];
            if(nums[right] < nums[left]){
                left++;
                continue;
            }
            left++;
            result = (double) sum/(double)(right-left+1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution643 solution643 = new Solution643();
        System.out.println(solution643.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}
