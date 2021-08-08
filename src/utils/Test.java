package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zacyex
 * @date 2020/10/20 19:53
 */
public class Test {

    private List<ArrayList<Integer>> result;

    private int[] array;

    private boolean[] isUsed ;

    public Test(int array[]){
        this.array =  array;
        this.isUsed = new boolean[5];
        this.result = new ArrayList<ArrayList<Integer>>();
        List<Integer> temp = new ArrayList<>();
        this.dfs(temp, 0);
    }

    private void dfs(List<Integer> temp, int current) {

        if(current == array.length){
            if(isValid(temp)) {
                this.result.add(new ArrayList<>(temp));
            }
            return;
        }

        for(int i=0; i<array.length; i++){
            if(!isUsed[i]) {
                temp.add(array[i]);
                isUsed[i] = true;
                dfs(temp, current + 1);
                temp.remove(temp.size() - 1);
                isUsed[i] = false;
            }
        }
    }

    private boolean isValid(List<Integer> temp) {


        int twoAddr = temp.indexOf(2);
        int leftAddr = twoAddr -1;
        int rightAddr = twoAddr + 1;

        if(leftAddr > 0 && temp.get(leftAddr) == 4){
            return false;
        }


        if( rightAddr < array.length && temp.get(rightAddr) == 4){
            return false;
        }

        if(temp.get(temp.size()/2) == 3){
            return false;
        }

        return true;
    }

    public void sout(){
        System.out.print(result);
    }

}
