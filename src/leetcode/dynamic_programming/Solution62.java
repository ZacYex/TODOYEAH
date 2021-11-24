package leetcode.dynamic_programming;

/**
 * @author zacyex
 * @Question
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 示例 1：
 *
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 *
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 *
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 *
 * 输入：m = 3, n = 3
 * 输出：6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/15 20:34
 */
public class Solution62 {
    // 动态规划
    public int uniquePaths(int m, int n) {
        // dp[i][j]代表到达i行j列的所有方式
        int dp[][] = new int[m][n];
        // 第一束的所有点位方式都是1种
        for(int i=0; i < dp.length; i++){
            dp[i][0] = 1;
        }
        // 第一行的所有点位方式都是1种
        for(int j=0; j < dp[0].length; j++){
            dp[0][j] = 1;
        }

        // 到达某个点，只能通过它左边的点和上边的点到达
        // 得到公式:dp[i][j] == dp[i-1][j] + dp[i][j-1]
        for(int row = 1; row < m ; row++){
            for(int col = 1; col < n; col++){
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }

        return dp[m-1][n-1];
    }

    // 深度优先（超时）
    int result = 0;
    public int uniquePathsDeap(int m, int n) {
        dfs(m-1 ,n-1);
        return result;
    }

    private void dfs(int down, int right){
        if(down == 0 && right == 0){
           result++;
           return;
        }

        if(down > 0){
            dfs(down-1,right);
        }

        if(right > 0){
            dfs(down,right-1);
        }
    }

    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        System.out.println(solution62.uniquePathsDeap(3, 7));
    }
}
