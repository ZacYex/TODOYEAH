package leetcode.dynamic_programming;

/**
 * @author zacyex
 * @date 2021/3/17 20:35
 * @Question
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[1,3,1],
 *             [1,5,1],
 *             [4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution64 {
    public int minPathSum(int[][] grid) {
        int down = grid.length;
        int right = grid[0].length;

        // 计算第一行每个位置的最小路径
        // dp[0][i] = dp[0][i-1] + dp[0][i]
        for(int i = 1; i < right; i++){
            grid[0][i] = grid[0][i-1] + grid[0][i];
        }

        // 计算第一列每个位置的最小路径
        for(int j = 1; j < down; j++){
            grid[j][0] = grid[j][0] + grid[j-1][0];
        }

        // 计算到dp[i][j]位置的最小路劲
        // dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + dp[i][j]
        for(int col = 1; col < down; col++){
            for(int row = 1; row < right; row++){
                grid[col][row] = Math.min(grid[col-1][row],grid[col][row-1]) + grid[col][row];
            }
        }

        return grid[down-1][right-1];
    }
}
