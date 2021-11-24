package algorithms;

/**
 * @author zacyex
 * @date 2020/8/11 22:25
 */
public class SolutionNumber {

    private char[][] sudoku;

    public void solveSudoku(char[][] board) {
        this.sudoku = board;
        dfs(0,0);
    }

    private void dfs(int x,  int y){
        if(x == sudoku.length){
            for(int i=0; i<sudoku.length; i++){
                for (int j=0; j<sudoku[i].length; j++){
                    System.out.print(sudoku[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("----------------------------");
            return;
        }

        if(sudoku[x][y] != '.'){
            if(y < sudoku[x].length-1){
                dfs(x,y+1);
            }else{
                dfs(x+1, 0);
            }
        }

        for(int i=0; i<9; i++){
            sudoku[x][y] = Character.forDigit(i, 10);
            if(isvalide(x, y, sudoku[x][y])){
                if(y < sudoku[x].length-1){
                    dfs(x,y+1);
                }else{
                    dfs(x+1, 0);
                }
            }
        }

    }

    private boolean isvalide(int  x, int y, char setNum) {

        // 判断横排是否有重复
        for(int i=0; i<sudoku[x].length; i++){
            if(i == y) continue;
            if(sudoku[x][i] == setNum){
                return false;
            }
        }

        // 判断竖排是否有重复
        for(int i=0; i<sudoku.length;i++){
            if(i == x) continue;
            if(sudoku[i][y] == setNum){
                return false;
            }
        }

        // 判断所属九格是否有重复
        int nineX = x/3*3;
        int nineY = y/3*3;
        for(int i=nineX; i<nineX+3; i++){
            for(int j=nineY; j<nineY+3; j++){
                if(i == x && j == y) continue;
                if(sudoku[i][j] == setNum){
                    return false;
                }
            }
        }

        return true;
    }
}
