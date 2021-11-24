package leetcode.dynamic_programming;

/**
 * @author zacyex
 * @date 2021/3/16 21:18
 * @Question
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 示例 1：
 *
 *
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int down = obstacleGrid.length;
        int right = obstacleGrid[0].length;

        int dp[][] = new int[down][right];

        for(int i=0; i<down; i++){
            if(obstacleGrid[i][0] == 0){
                dp[i][0] = 1;
            }else{
                break;
            }
        }

        for(int j=0; j<right; j++){
            if(obstacleGrid[0][j] == 0){
                dp[0][j] = 1;
            }else{
                break;
            }
        }

        // dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for(int row=1; row < down; row++){
            for(int col=1; col < right; col++){
                if(obstacleGrid[row][col] != 1){
                    dp[row][col] = dp[row-1][col] + dp[row][col-1];
                }
            }
        }

        return dp[down-1][right-1];
    }

    // 回溯算法 超时
    int result = 0;
    public int uniquePathsWithObstaclesDeap(int[][] obstacleGrid) {
        int down = obstacleGrid.length;
        int right = obstacleGrid[0].length;

        dfs(down-1, right-1, obstacleGrid);
        if(obstacleGrid[down-1][right-1] == 1){ return 0;}
        return result;
    }

    private void dfs(int down, int right, int[][] obstacleGrid) {
        if(down == 0 && right == 0){
            result++;
            return;
        }

        if(down > 0 && obstacleGrid[down-1][right] == 0){
            dfs(down-1, right, obstacleGrid);
        }

        if(right > 0 && obstacleGrid[down][right-1] == 0){
            dfs(down, right-1, obstacleGrid);
        }
    }
}
