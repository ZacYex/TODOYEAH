package leetcode.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * @Question
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * 提示：
 *
 * 输入的字符串长度不会超过 1000 。
 * 通过次数82,625提交次数127,028
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zacyex
 * @date 2021/3/8 20:01
 */
public class Solution647 {

    public int countSubstrings(String s) {
        // 记录x到y的字符串是不是回文串
        boolean dp[][] = new boolean[s.length()][s.length()];

        int num = 0;

        // 字符串i到i的一定是回文串
        for(int k=0; k<s.length(); k++){
            dp[k][k] = true;
            num++;
        }

        // j:当前字符串末尾
        for(int j=0; j<s.length(); j++){
            // i:当前字符串开始
            for(int i=0; i<j; i++){
                // 字符串长度为2时，比较s[i]是否等于s[j]
                if(j-i == 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                    // 字符串大于2时，比较s[i]是否等于s[j]且dp[i+1][j-1]是否为true
                }else{
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                }

                if(dp[i][j]){
                    num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Solution647 solution647 = new Solution647();
        System.out.println(solution647.countSubstrings(""));
    }
}
