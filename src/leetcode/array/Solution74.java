package leetcode.array;

/**
 * @author zacyex
 * @Question
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2021/3/30 20:25
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {

        // 确定哪一行
        int start = 0, end = matrix.length - 1;
        while(end - 1 > start){
            int compareRe =target - matrix[(start + end)/2][0];
            if(compareRe == 0){
                return true;
            }else if(compareRe > 0){
                start = (start + end)/2;
            }else{
                end = (start + end)/2;
            }
        }
        int row = matrix[end][0] > target ? start : end;

        // 确定位置
        int left = 0, right = matrix[row].length;
        while(right - 1 > left){
            int compareRe = target - matrix[row][(left + right)/2];
            if(compareRe == 0){
                return true;
            }else if(compareRe > 0){
                left = (left + right)/2;
            }else{
                right = (left + right)/2;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution74 solution74 = new Solution74();
        System.out.println(solution74.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 60));
    }
}
