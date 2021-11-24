package leetcode.dynamic_programming;

/**
 * @author zacyex
 * @Question
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2021/3/14 20:09
 */
public class Solution5 {

    public String longestPalindrome(String s) {

        // 记录x到y的字符串是不是回文串
        boolean dp[][] = new boolean[s.length()][s.length()];

        int index = 0;

        int maxLength = s.length() > 0 ? 1 : 0;

        int temp = maxLength;

        // 字符串i到i的一定是回文串
        for(int k=0; k<s.length(); k++){
            dp[k][k] = true;
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

                // 当前为最长回文串时，记录起始下标和长度
                if(dp[i][j]){
                    temp = Math.max(maxLength, j-i+1);
                    if(temp != maxLength){
                        index = i;
                        maxLength = temp;
                    }
                }
            }
        }
        return s.substring(index, index + maxLength);
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome("abcd"));
    }
}
