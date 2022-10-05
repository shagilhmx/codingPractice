package DetectCycle;

import java.util.ArrayList;

import DataStructure.Queue;

public class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        return bfs(V, adj);
        // dfs(V, adj);
    }

    boolean bfs(int V, ArrayList<ArrayList<Integer>> adj) {
        // using indegree if the indegree of any pirticular edge dosn't go to zero than
        // cycle exists.
        ArrayList<Integer> indegree = new ArrayList<>(V);
        boolean ans = false;

        for (int node = 0; node < V; node++)
            for (int u : adj.get(node))
                indegree.add(u, indegree.get(u) + 1);

        Queue<Integer> q = new Queue<>();

        for (int node = 0; node < V; node++) {
            if (indegree.get(node) == 0)
                q.push(node);
        }

        int count = 0;

        while (!q.empty()) {
            int node = q.front();
            q.pop();

            count++;

            for (int u : adj.get(node)) {
                indegree.add(u, indegree.get(u) - 1);
                if (indegree.get(u) == 0)
                    q.push(u);
            }

            if (count == V)
                ans = false;
            else
                ans = true;
        }
        return ans;
    }
}
