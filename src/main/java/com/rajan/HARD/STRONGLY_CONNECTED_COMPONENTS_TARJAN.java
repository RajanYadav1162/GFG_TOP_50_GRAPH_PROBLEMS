package com.rajan.HARD;

/*
Given a Directed Graph with V vertices and E edges, Find the members of strongly connected components in the graph.
Note - Sort both the individual components and array of the components.

Example 1:
Input:

Output: 0 1 2 3 4
Explanation:

We can clearly see that there are 3 Strongly
Connected Components in the Graph as mentioned
in the Output.
Input:

Output: 0 1 2
Explanation:
All of the nodes are connected to each other.
So, there's only one SCC as shown.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class STRONGLY_CONNECTED_COMPONENTS_TARJAN {

  public static void main(String[] args) {

    ArrayList<Integer> a = new ArrayList<>(List.of(2, 3));
    ArrayList<Integer> b = new ArrayList<>(List.of(0));
    ArrayList<Integer> c = new ArrayList<>(List.of(1));
    ArrayList<Integer> d = new ArrayList<>(List.of(4));
    ArrayList<Integer> e = new ArrayList<>(List.of());
    ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
    ls.addAll(List.of(a, b, c, d, e));
    var res = new Solution_4().tarjans(5, ls);
    System.out.println(res);
  }
}

class Solution_4 {

  int time = 0;
  int[] ids, low;
  boolean[] onStack;
  Deque<Integer> stack = new LinkedList<>();
  ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

  public ArrayList<ArrayList<Integer>> tarjans(int n, ArrayList<ArrayList<Integer>> list) {
    // System.out.println("list is  "+ list);

    ids = new int[n];
    low = new int[n];
    onStack = new boolean[n];

    //initially no nodes are visited!!
    Arrays.fill(ids, -1);

    for (int i = 0; i < n; i++) {
      if (ids[i] == -1) {
        dfs(i, list);
      }
    }
    ans.sort(Comparator.comparingInt(a -> a.get(0)));
    return ans;
  }

  public void dfs(int at, ArrayList<ArrayList<Integer>> list) {

    ids[at] = low[at] = time++;
    onStack[at] = true;
    stack.push(at);

    for (int to : list.get(at)) {
      if (ids[to] == -1) {
        dfs(to, list);
        low[at] = Math.min(low[at], low[to]);
      } else if (onStack[to]) {
        low[at] = Math.min(low[at], ids[to]);
      }

    }

    if (low[at] == ids[at]) {
      ArrayList<Integer> sccGroup = new ArrayList<>();
      while (stack.size() > 0) {
        int node = stack.pop();
        onStack[node] = false;
        sccGroup.add(node);
        if (node == at) {
          break;
        }
      }
      // System.out.println("group " + sccGroup);
      Collections.sort(sccGroup);
      ans.add(sccGroup);
    }

  }
}