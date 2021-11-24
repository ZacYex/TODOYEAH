package algorithms;

import algorithms.sort.PrimarySort;
import utils.StopWatch;

public class Main {

    public static void main(String[] args) {
//        System.out.print(Expression.experssionValue("(3+((1+2)*(5+3)))"));
        String[] a = {"9","8","7","6","5","4","3","2","1","0"};


        PrimarySort primarySort = new PrimarySort();
        primarySort.bubbleSort(a);

        for (String item : a) {
            System.out.println(item);
        }
//        Queens queens = new Queens(8);
//        queens.setQueens();

//        Solution solution = new Solution();
//        List<String> re = solution.letterCombinations("23");
//        System.out.println(re);

//        BracketsIsValide bracketsIsValide = new BracketsIsValide();
//        System.out.println(bracketsIsValide.isValid("{}{}[()]()(("));

//        SolutionNumber solutionNumber = new SolutionNumber();
//        solutionNumber.solveSudoku(new char[][]{
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}
//        });
//        Test test = new Test(new int[]{1,2,3,4,5});
//        test.sout();

//        Combination combination = new Combination(new int[]{1,2,3,4,5});
//        combination.sout();
    }

    public static void seeClass(int x){
        StopWatch stopWatch = new StopWatch();
        for (int i=0; i<3; i++){
            System.out.println();
        }
        int y = 16;
    }
}
