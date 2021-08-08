package leetcode.sliding_window;

/**
 * @author zacyex
 * @Lever 中等
 * @Qustion
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * 注意：字符串长度 和 k 不会超过 104。
 *
 * 示例 1：
 *
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 *
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Solution 滑动窗口
 * @date 2021/2/2 17:02
 */
public class Solution424 {
    public int characterReplacement(String s, int k) {
        // 起始窗口宽度为1
        int slideLeft = 0;
        int slideRight = 1;
        // 当前窗口各字符个数
        int lettetNum[] = new int[26];
        // 最多字符所占个数
        int maxLetter = 0;

        // 窗口内的字符
        String letter = "";

        // 窗口右侧未到达末尾
        while(slideRight <= s.length()){
            s.substring(slideLeft,slideRight);
            // 记录新进入窗口的字符占当前窗口字符个数
            lettetNum[s.charAt(slideRight-1)-'A']++;
            maxLetter = Math.max(maxLetter, lettetNum[s.charAt(slideRight-1)-'A']);
            if(slideRight <= s.length() && slideRight - slideLeft - maxLetter >k){
                // 被移除的字符对应个数-1
                lettetNum[s.charAt(slideLeft)-'A']--;
                // 窗口滑动
                slideLeft++;
                slideRight++;
            }else{
                // 窗口扩展
                slideRight++;
            }
        }
        return slideRight-slideLeft-1;
    }

    public static void main(String[] args) {
        Solution424 solution424 = new Solution424();
        System.out.println(solution424.characterReplacement("AABBB", 2));
    }
}
