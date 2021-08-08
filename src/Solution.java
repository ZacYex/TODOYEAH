import java.util.ArrayList;
import java.util.List;

class Solution {
    private String[] button = {
            "","","abc","def",
            "ghi","jkl","mno",
            "pqrs","tuv","wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<String>();
        int digit[] = new int[digits.length()];
        for(int i=0; i<digits.length(); i++){
            digit[i] = Integer.parseInt(digits.substring(i, i+1));
        }
        dfs(results, digit, 0, "");
        return results;
    }
    private void dfs(List<String> results,int[] digit, int index, String curStr){

        if(curStr.length() == digit.length){
            
            results.add(curStr);
            return;
        }

        for(int i=0; i<button[digit[index]].length(); i++){
            curStr += button[digit[index]].substring(i, i+1);
            dfs(results, digit, index+1, curStr);
            curStr = curStr.substring(0, curStr.length()-1);
        }
    }
}
