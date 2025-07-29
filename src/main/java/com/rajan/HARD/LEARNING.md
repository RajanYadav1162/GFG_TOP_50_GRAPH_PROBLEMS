`## Bridge in graph problem

- Practice Union Find(can be done using simple dfs too).
- How to count components in connected graph
- what is bridge in graph what is its significance(vulnerable network)

## MINIMUM COST PATH
- I stuck for so long, reason, why we can't use DP here?
- For shortest/longest kind of problem remember your algo-dp, bfs, binary search
- since here we also need to track visited(not in case when movement is restricted to right and down) dp will not be efficient.


## STRONGLY CONNECTED COMPONENTS - TARJAN's ALGO
- to find list of SCC(in group of SCC, we can reach any one node to every other node)
- idea is to use low link value.
- llv for a node is shorted id node that is reachable from current node.
- we observe that for same llv nodes for the SCC.
- steps to remember
  - use time(will take care of the time  when node is visited for first time)
  - we need array of ids and llv and one boolean array onStack
  - we go to each node in dfs, initialize llv, ids for this node mark it on stack and add to stack
  - after completion of dfs, in post recursion 
    - update current node llv from its parent(nbh already been take care of , how we update our self)
    - also remember the condition in case of back-edge(circular edge).

## ARTICULATION POINT FINDING IN GRAPH
- AP(cut vertices) is node in graph, by removing that we increases number of components.
- Main algo is - A node is AP if and only if 
  - its parent node and it has more than 1 child.
    - it is not a parent node and low[v] >= ids[u], where low - lowest discovery time, and ids is first discovery time. and v is parent and u is child.
`