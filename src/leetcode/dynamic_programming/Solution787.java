package leetcode.dynamic_programming;

/**
 * @author zacyex
 * @date 2021/8/24 23:19
 *
 *有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城
 *市 fromi 开始，以价格 pricei 抵达 toi。
 *
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便
 *宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 *
 *
 *
 * 示例 1：
 *
 *
 *输入:
 *n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 *src = 0, dst = 2, k = 1
 *输出: 200
 *解释:
 *城市航班图如下
 *
 *
 *从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 *
 * 示例 2：
 *
 *
 *输入:
 *n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 *src = 0, dst = 2, k = 0
 *输出: 500
 *解释:
 *城市航班图如下
 *
 *
 *从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 10⁴
 * 航班没有重复，且不存在自环
 * 0 <= src, dst, k < n
 * src != dst
 *
 * Related Topics 深度优先搜索 广度优先搜索 图 动态规划 最短路 堆（优先队列） 👍 381 👎 0
 */
// TODO 超时
public class Solution787 {

    // 代表i到j的价格, 0代表无法到达
    private int fromTo[][];

    // 最低价格
    private int minPrice = -1;

    private int aim;

    // 转站上限
    private int maxTurn;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        this.fromTo = new int[n][n];
        this.aim = dst;
        this.maxTurn = k+1;

        for(int i=0; i < flights.length; i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];

            fromTo[from][to] = price;
        }

        findWay(0, src, 0);
        return this.minPrice;
    }

    private void findWay(int times, int src, int cuprice) {
        if(times > this.maxTurn){
            return;
        }
        if(src == this.aim){
            minPrice = minPrice == -1 ? cuprice :
                    (minPrice > cuprice ? cuprice : minPrice);
            System.out.println(minPrice);
            return;
        }
        // 以当前src为起点寻找可到达的新起点
        for(int i=0; i < fromTo[src].length; i++){
            if(fromTo[src][i] > 0){
                findWay(times+1, i, cuprice+fromTo[src][i]);
            }
        }
    }

    public static void main(String[] args) {
        Solution787 solution787 = new Solution787();
        int a[][] = {{0,12,28},{5,6,39},{8,6,59},{13,15,7},{13,12,38},{10,12,35},{15,3,23},{7,11,26},{9,4,65},{10,2,38},{4,7,7},{14,15,31},{2,12,44},{8,10,34},{13,6,29},{5,14,89},{11,16,13},{7,3,46},{10,15,19},{12,4,58},{13,16,11},{16,4,76},{2,0,12},{15,0,22},{16,12,13},{7,1,29},{7,14,100},{16,1,14},{9,6,74},{11,1,73},{2,11,60},{10,11,85},{2,5,49},{3,4,17},{4,9,77},{16,3,47},{15,6,78},{14,1,90},{10,5,95},{1,11,30},{11,0,37},{10,4,86},{0,8,57},{6,14,68},{16,8,3},{13,0,65},{2,13,6},{5,13,5},{8,11,31},{6,10,20},{6,2,33},{9,1,3},{14,9,58},{12,3,19},{11,2,74},{12,14,48},{16,11,100},{3,12,38},{12,13,77},{10,9,99},{15,13,98},{15,12,71},{1,4,28},{7,0,83},{3,5,100},{8,9,14},{15,11,57},{3,6,65},{1,3,45},{14,7,74},{2,10,39},{4,8,73},{13,5,77},{10,0,43},{12,9,92},{8,2,26},{1,7,7},{9,12,10},{13,11,64},{8,13,80},{6,12,74},{9,7,35},{0,15,48},{3,7,87},{16,9,42},{5,16,64},{4,5,65},{15,14,70},{12,0,13},{16,14,52},{3,10,80},{14,11,85},{15,2,77},{4,11,19},{2,7,49},{10,7,78},{14,6,84},{13,7,50},{11,6,75},{5,10,46},{13,8,43},{9,10,49},{7,12,64},{0,10,76},{5,9,77},{8,3,28},{11,9,28},{12,16,87},{12,6,24},{9,15,94},{5,7,77},{4,10,18},{7,2,11},{9,5,41}};
        System.out.println(solution787.findCheapestPrice(17, a, 13, 4, 13));
    }
}



