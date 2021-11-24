package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zacyex
 * @date 2020/10/20 22:35
 */
public class Combination {

    private List<ArrayList<Integer>> result;

    private int[] array;

    public Combination(int array[]){
        this.array =  array;
        this.result = new ArrayList<ArrayList<Integer>>();
        List<Integer> temp = new ArrayList<>();
        this.dfs(temp, 0);
    }

    private void dfs(List<Integer> temp, int current) {
        if(temp.size() == array.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<array.length; i++){
            temp.add(array[i]);
            dfs(temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public void sout(){
        System.out.print(result);
    }
}
