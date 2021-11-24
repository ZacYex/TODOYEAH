package leetcode.recall;

import leetcode.array.Solution643;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zacyex
 * @Lever 简单
 * @Question
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * String[] button = {
 *             "","","abc","def",
 *             "ghi","jkl","mno",
 *             "pqrs","tuv","wxyz"
 *     };
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/2/22 19:23
 */
public class Solution17 {
    private String[] button = {
            "","","abc","def",
            "ghi","jkl","mno",
            "pqrs","tuv","wxyz"
    };

    private List<String> results = new ArrayList<>();

    private int[] digits;

    public List<String> letterCombinations(String digits) {
        this.digits = new int[digits.length()];
        for(int i = 0; i < digits.length(); i++){
            this.digits[i] = Integer.parseInt(digits.substring(i, i+1));
        }
        dfs(0, "");
        return this.results;
    }

    private void dfs(int index, String current) {

        if(index == digits.length){
            results.add(current);
            return;
        }

        for(int i=0; i<button[digits[index]].length(); i++){
            current += button[digits[index]].substring(i, i+1);
            dfs(index+1, current);
            current = current.substring(0, current.length()-1);
        }
    }

    public static void main(String[] args) {
        Solution17 Solution17 = new Solution17();
        System.out.println(Solution17.letterCombinations("2"));
    }
}
