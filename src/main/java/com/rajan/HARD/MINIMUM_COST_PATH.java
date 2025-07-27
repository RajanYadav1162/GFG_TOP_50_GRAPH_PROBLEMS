package com.rajan.HARD;

/*
problem DESC - Given a square grid of size N, each cell of which contains an integer cost that represents a cost to traverse through that cell,
we need to find a path from the top left cell to the bottom right cell by which the total cost incurred is minimum.
From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j).

Examples :

Input: grid = [[9,4,9,9],
               [6,7,6,4],
               [8,3,3,7],
               [7,4,9,10]]
Output: 43
Explanation: The minimum cost is-
9 + 4 + 7 + 3 + 3 + 7 + 10 = 43.
Input: grid = [[4,4],
               [3,7]]
Output: 14
Explanation: The minimum cost is- 4 + 3 + 7 = 14.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class MINIMUM_COST_PATH {

  public static void main(String[] args) {
    var res = new Solution_1().minimumCostPath(
        new int[][]{{1, 1, 1, 1, 1}, {60, 70, 60, 19, 1}, {1, 1, 1, 1, 1}, {1, 50, 40, 20, 22},
            {1, 1, 1, 1, 1}});
    System.out.println(res);
  }
}

class Solution_1 {

  private final int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public int minimumCostPath(int[][] grid) {

    int m = grid.length, n = grid[0].length;
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
    pq.offer(new int[]{0, 0, grid[0][0]});
    boolean[][] visited = new boolean[m][n];

    while (!pq.isEmpty()) {
      var current = pq.poll();
      int u = current[0], v = current[1], w = current[2];
      if (u == m - 1 && v == n - 1) {
        return w;
      }

      if (visited[u][v]) {
        continue;
      }

      visited[u][v] = true;

      for (int[] D : DIR) {
        int nu = u + D[0], nv = v + D[1];
        if (nu < 0 || nv < 0 || nu >= m || nv >= n) {
          continue;
        }
        if (visited[nu][nv]) {
          continue;
        }
        pq.offer(new int[]{nu, nv, w + grid[nu][nv]});
      }
    }
    return -1;
  }
}