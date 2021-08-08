package leetcode.dynamic_programming;

/**
 * @author zacyex
 * @Question
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * 示例 2：
 *
 *
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/15 20:34
 */
public class Solution221 {
    //深度优先
//    public int maximalSquare(char[][] matrix) {
//
//        int maxlength = 0;
//        // 以每个单元格为左上角，记录最大边长的正方形
//        for(int i=0; i<matrix.length; i++){
//            for(int j=0; j<matrix[0].length; j++){
//                if(matrix[i][j] == '1'){
//                    dfs(matrix,i,j,1);
//                    maxlength = Math.max(maxlength, matrix[i][j]-'0');
//                }
//            }
//        }
//
//        return maxlength;
//    }
//
//    private void dfs(char[][] matrix, int i, int j, int length) {
//
//        // 扩充的一列是否全为1
//        for(int k = i; k <= i + length && k < matrix.length; k++){
//            if((j + length) >= matrix[0].length || matrix[k][j + length] == '0'){
//                // 当前值不改变，退出
//                return;
//            }
//        }
//
//        // 扩充的一行是否全为1
//        for(int m = j; m <= j + length && m < matrix[0].length; m++){
//            if((i + length) >= matrix.length || matrix[i + length][m] == '0'){
//                // 当前值不改变，退出
//                return;
//            }
//        }
//
//        matrix[i][j]++;
//        dfs(matrix,i,j,length+1);
//    }
    // 动态规划
    public int maximalSquare(char[][] matrix) {
        // 每一个格子记录以当前格子为右下角的正方形的边长
        // dp[i][j] == 1
        // {dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1}
        // dp[i][j] == 0
        // {dp[i][j] = dp[i][j]}
        char max = '0';
        for(int m = 0; m<matrix[0].length; m++){
            if(matrix[0][m] == '1'){
                max = '1';
            }
        }
        for(int n = 0; n<matrix.length; n++){
            if(matrix[n][0] == '1'){
                max = '1';
            }
        }
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    matrix[i][j] = (char)(Math.min(Math.min(matrix[i-1][j-1],matrix[i-1][j]), matrix[i][j-1])+1);
                    max = (char)Math.max(max, matrix[i][j]);
                }
            }
        }
        return (max-'0')*(max-'0');
    }

    public static void main(String[] args) {
        Solution221 solution221 = new Solution221();
        System.out.println(solution221.maximalSquare(new char[][]
                {       {'0', '0', '0', '1', '1', '1', '1', '1'},
                        {'0', '1', '1', '0', '1', '1', '1', '1'},
                        {'1', '0', '1', '1', '1', '1', '1', '1'},
                        {'0', '0', '0', '1', '1', '1', '1', '1'},
                        {'0', '0', '1', '0', '0', '0', '1', '0'},
                        {'1', '1', '1', '0', '0', '1', '1', '1'},
                        {'1', '0', '0', '1', '1', '0', '0', '1'},
                        {'0', '1', '0', '0', '1', '1', '0', '0'},
                        {'1', '0', '0', '1', '0', '0', '0', '0'}}
        ));
    }
}
