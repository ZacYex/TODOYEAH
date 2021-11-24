package leetcode.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class Solution787_dijkstra {

    // 代表i到j的价格, 0代表无法到达
    private int fromTo[][];

    // isMin[n] 代表当前点是否划为最短节点
    private int isOptimal[];

    // dijkstra[n][0] 代表目标到当前节点最短距离
    // dijkstra[n][1] 到当前节点的前一个节点
    private int dijkstra[][];

    private int aim;

    // 转站上限
    private int maxTurn;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        if(src == dst){
            return 0;
        }

        this.fromTo = new int[n][n];
        this.aim = dst;
        this.maxTurn = k+1;

        for(int i=0; i < flights.length; i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];

            fromTo[from][to] = price;
        }

        isOptimal = new int[n];
        dijkstra = new int[n][2];
        for(int i=0; i<dijkstra.length; i++){
            isOptimal[i] = 0;
            dijkstra[i][0] = 10000;
        }
        dijkstra[src][0] = 0;

        // 将src作为最优节点,寻找能到达的节点
        findWay(1, src);

        return dijkstra[dst][0] == 10000 ? -1 : dijkstra[dst][0];
    }

    private void findWay(int times, int src) {
        if(times > maxTurn){
            // 超过最大转站次数
            return;
        }
        // 当前节点划为已探索节点
        isOptimal[src] = 1;

        // 将能到达的节点距离比较并赋值
        for(int i=0; i<fromTo[src].length; i++){
            // 到达i的距离 > (到达src自己的距离 + src到i的距离)
            if(fromTo[src][i] > 0 && (dijkstra[i][0] > (fromTo[src][i] + dijkstra[src][0]))){
                // 更新i的最短路径，和到达i的前一节点
                dijkstra[i][0] = fromTo[src][i] + dijkstra[src][0];
                dijkstra[i][1] = src;
            }
        }

        // 下一个起点应当是目前距离i最短的，且未被标记的
        // 寻找未被标记节点集合
        List<Integer> isNotOptimal = new ArrayList<>();
        int nextSrc = 0;
        int minSrc = 10000;
        for(int i=0; i<isOptimal.length; i++){
            if(0 == isOptimal[i]){
                isNotOptimal.add(i);
            }
        }
        if(isNotOptimal.size() == 0) return;
        for(Integer i : isNotOptimal){
            if(dijkstra[i][0] < minSrc && dijkstra[i][0] > 0) {
                nextSrc = i;
                minSrc = dijkstra[i][0];
            }
        }

        findWay(times+1, nextSrc);
    }

    public static void main(String[] args) {
        Solution787_dijkstra solution787 = new Solution787_dijkstra();
        int a[][] = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        System.out.println(solution787.findCheapestPrice(4, a, 0, 3, 1));
    }
}



