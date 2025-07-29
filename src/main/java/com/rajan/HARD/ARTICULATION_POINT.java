package com.rajan.HARD;

/*
problem desc - You are given an undirected graph with V vertices and E edges.
The graph is represented as a 2D array edges[][], where each element edges[i] = [u, v] indicates an undirected edge between vertices u and v.
Your task is to return all the articulation points (or cut vertices) in the graph.
An articulation point is a vertex whose removal, along with all its connected edges,
increases the number of connected components in the graph.

Note: The graph may be disconnected, i.e., it may consist of more than one connected component.
If no such point exists, return {-1}.

Examples :

Input: V = 5, edges[][] = [[0, 1], [1, 4], [4, 3], [4, 2], [2, 3]]

Output: [1, 4]
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ARTICULATION_POINT {

  public static void main(String[] args) {

    var res = Solution_5.articulationPoints(4, new int[][]{{0, 1}, {0, 2}});
    System.out.println(res);
  }
}
class Solution_5 {

  static int time = 0;
  static int[] ids, low;
  static List<List<Integer>> list;
  static boolean[] ap;
  static int rootEdgeCount;

  static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
    ids = new int[V];
    low = new int[V];
    ap = new boolean[V];
    list = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      list.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      int u = edge[0], v = edge[1];
      list.get(u).add(v);
      list.get(v).add(u);
    }
    Arrays.fill(ids, -1);

    for (int i = 0; i < V; i++) {
      if (ids[i] == -1) {
        rootEdgeCount = 0;
        dfs(i, -1);
        if (rootEdgeCount > 1) {
          ap[i] = true;
        }

      }
    }
    ArrayList<Integer> ans = new ArrayList<>();
    boolean nap = true;
    for (int i = 0; i < V; i++) {
      if (ap[i]) {
        ans.add(i);
        nap = false;
      }
    }
    if(nap) ans.add(-1);
    return ans;
  }

  public static void dfs(int u, int parent) {

    ids[u] = low[u] = time++;
    for (int v : list.get(u)) {
      if (ids[v] == -1) {
        if (parent == -1) {
          rootEdgeCount++;
        }
        dfs(v, u);
        low[u] = Math.min(low[u], low[v]);

        if (parent != -1 && low[v] >= ids[u]) {
          ap[u] = true;
        }
      } else {
        low[u] = Math.min(low[u], ids[v]);
      }
    }
  }
}