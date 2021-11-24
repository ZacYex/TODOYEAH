package leetcode.dynamic_programming;

/**
 * @author zacyex
 * @date 2021/3/17 21:02
 * @Question
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution70 {
    public int climbStairs(int n) {

        // 台阶顶小于等于2的方式均为1
        if(n <= 1) return 1;

        // n[i]表示第i阶的到达方式
        int method[] = new int[n];
        method[0] = 1;
        method[1] = 2;

        // 由于一次只能走2步及2步以下，所以第i阶的到达方式为到达i-1阶与i-2阶之和
        // dp[i] = dp[i-1]+dp[i-2]
        for(int i=2; i<n; i++){
            method[i] = method[i-1] + method[i-2];
        }

        return method[n-1];
    }

    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
        System.out.println(solution70.climbStairs(2));
    }
}
