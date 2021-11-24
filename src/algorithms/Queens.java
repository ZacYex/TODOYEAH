package algorithms;

import java.util.Map;

public class Queens {
    // 皇后旗子的数量
    private  int queensNum;

    // 皇后数组，数组下标表示第几行的皇后，对应值为改行的第几列
    private Integer[] queens;

    public Queens(int queensNum){
        this.queens = new Integer[queensNum];
        this.queensNum = queensNum;
    }

    public boolean valid(int col, int row){
        int i = 0;
        while(this.queens[i] != null && i<queensNum){
            if(col == 0) return true;
            if(queens[i] == row || Math.abs(i-queens[i]) == Math.abs(col - row)){
                return false;
            }
            i++;
        }
        return true;
    }

    public void setQueens(){
        this.setQueens(0);
    }
    /**
     *  设置皇后的位置
     */
    private void setQueens(int k){
       if(k >= queensNum){
           print();
       }else{
           for(int  i=0; i<queensNum; i++){
               queens[k] = i;
               if(valid(k, i)){
                   setQueens(k+1);
               }
           }
       }
    }

    /**
     * 输出排布方式
     */
    public void print(){
        System.out.println("ok");
    }
}
