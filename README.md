# Top 50 Graph Coding Problems - Study Notes

This repository contains study notes and solutions for the [Top 50 Graph Coding Problems](https://www.geeksforgeeks.org/dsa/top-50-graph-coding-problems-for-interviews/) from GeeksforGeeks, aimed at coding interview preparation.

## Problem Categories

### Easy
- Coming soon

### Medium
- Coming soon

### Hard

## Bridge in Graph

- Practice Union Find (can also be done using simple DFS).
- Learn how to count components in a connected graph.
- Understand what a bridge in a graph is and its significance (e.g., identifying vulnerable points in a network).

## Minimum Cost Path

- I was stuck for a long time. Reason: why can't we use DP here?
- For shortest or longest path problems, remember the relevant algorithms: DP, BFS, or binary search.
- Here, we need to track visited nodes (except when movement is restricted to right and down), so DP is not efficient.

## Strongly Connected Components - Tarjan's Algorithm

- Used to find a list of SCCs (in an SCC, any node can reach every other node in the group).
- The idea is to use the low-link value (LLV).
- The LLV of a node is the smallest discovery time of a node reachable from the current node.
- We observe that nodes in the same SCC share the same root via low-link values.
- Steps to remember:
  - Use a time variable (to record when a node is first visited).
  - Maintain arrays for ids and low-link values, and a boolean array `onStack`.
  - In DFS, for each node:
    - Initialize `id` and `low` values, mark the node as on stack, and push it onto the stack.
  - After the DFS of neighbors (in post-recursion):
    - Update the current node’s `low` value from its children (neighbors).
    - Also handle the case of a back edge (a circular edge to an already visited node on the stack).
