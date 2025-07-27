package com.rajan.HARD;

/*
problem DESC - Given an undirected graph with V vertices numbered from 0 to V-1 and E edges,
represented by 2d array edges[][], where edges[i]=[u,v] represents the edge between the vertices u and v.
Determine whether a specific edge between two vertices (c, d) is a bridge.

Note:

An edge is called a bridge if removing it increases the number of connected components of the graph.
if there’s only one path between c and d (which is the edge itself), then that edge is a bridge.
Examples :

Input: V = 4, edges[][] = [[0, 1], [1, 2], [2, 3]], c = 1, d = 2

Output: true
Explanation: From the graph, we can clearly see that blocking the edge 1-2 will result in disconnection of the graph.
Hence, it is a Bridge.
Input: V = 5, edges[][] = [[0, 1], [0, 3], [1, 2], [2, 0], [3, 4]], c = 0, d = 2

Output: false
Explanation:

Blocking the edge between nodes 0 and 2 won't affect the connectivity of the graph.
So, it's not a Bridge Edge. All the Bridge Edges in the graph are marked with a green line in the above image.
 */


public class BRIDGE_IN_GRAPH {

  public static void main(String[] args) {
    boolean res = new Solution().isBridge(5, new int[][]{{0, 1}, {1, 2}, {2, 3}}, 1, 2);
    System.out.println(res);
  }
}

class Solution {

  public boolean isBridge(int V, int[][] edges, int c, int d) {

    int componentsCountWithoutRemoval, componentsCountWithRemoval;

    UnionFind uf = new UnionFind(V);
    for (int[] E : edges) {
      int u = E[0], v = E[1];
      uf.union(u, v);
    }
    componentsCountWithoutRemoval = uf.componenets;
    uf = new UnionFind(V);

    for (int[] E : edges) {
      int u = E[0], v = E[1];
      if (Math.min(u, v) == Math.min(c, d) && Math.max(u, v) == Math.max(c, d)) {
        continue;
      }
      uf.union(u, v);
    }
    componentsCountWithRemoval = uf.componenets;

    //  System.out.println(componentsCountWithoutRemoval+"  " + componentsCountWithRemoval);
    return componentsCountWithRemoval > componentsCountWithoutRemoval;
  }
}

class UnionFind {

  int[] parents;
  int componenets;

  public UnionFind(int n) {
    parents = new int[n];
    componenets = n;
    for (int i = 0; i < n; i++) {
      parents[i] = i;
    }
  }

  public int find(int a) {

    if (parents[a] == a) {
      return parents[a];
    }

    return find(parents[a]);
  }

  public void union(int a, int b) {

    int pa = find(a), pb = find(b);
    if (pa == pb) {
      return;
    }
    parents[pb] = parents[pa];
    componenets--;
  }
}