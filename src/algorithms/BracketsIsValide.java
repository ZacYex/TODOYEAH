package algorithms;

import dataStruct.Stack;
import dataStruct.imp.LinkStack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zacyex
 * @date 2020/8/11 21:45
 */
public class BracketsIsValide {

    public boolean isValid(String s) {
        LinkedList<Character> leftBrackets  = new LinkedList<>();
        char[] brecketsChars = s.toCharArray();
        boolean isValide = true;
        for(int i=0; i<brecketsChars.length && isValide; i++){
            if(brecketsChars[i] == '(' || brecketsChars[i]  ==  '[' || brecketsChars[i] == '{'){
                leftBrackets.add(brecketsChars[i]);
            }else if(leftBrackets.size()>0) {
                char leftBracket = leftBrackets.remove(leftBrackets.size()-1);
                switch (brecketsChars[i]){
                    case ')': isValide = leftBracket=='('? true : false;
                        break;
                    case ']': isValide = leftBracket=='['? true : false;
                        break;
                    case '}': isValide = leftBracket=='{'? true : false;
                        break;
                    default:
                        break;
                }
            }else {
                isValide = false;
            }
        }
        if(leftBrackets.size() > 0){
            isValide = false;
        }
        return isValide;
    }
}
