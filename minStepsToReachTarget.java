
//{ Driver Code Starts
import java.util.*;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for (int i = 0; i < 2; i++) {
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    Pair[] dir = { new Pair<Integer, Integer>(-2, -1), new Pair<Integer, Integer>(-2, 1),
            new Pair<Integer, Integer>(2, -1), new Pair<Integer, Integer>(2, 1), new Pair<Integer, Integer>(1, -2),
            new Pair<Integer, Integer>(1, 2),
            new Pair<Integer, Integer>(-1, -2), new Pair<Integer, Integer>(-1, 2) };

    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        if (KnightPos[0] == TargetPos[0] && KnightPos[1] == TargetPos[1])
            return 0;

        boolean[][] vis = new boolean[N + 1][N + 1];
        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new ConcurrentLinkedQueue<>();
        q.add(new Pair<Pair<Integer, Integer>, Integer>(new Pair<Integer, Integer>(KnightPos[0], KnightPos[1]), 0));
        vis[KnightPos[0]][KnightPos[1]] = true;

        while (!q.isEmpty()) {
            Pair<Pair<Integer, Integer>, Integer> top = q.poll();

            if (top.first.first == TargetPos[0] && top.first.second == TargetPos[1])
                return top.second;

            for (Pair<Integer, Integer> d : dir) {
                int dx = d.first + top.first.first;
                int dy = d.second + top.first.second;

                if (dx > 0 && dx <= N && dy > 0 && dy <= N && vis[dx][dy] == false) {
                    vis[dx][dy] = true;
                    q.add(new Pair<Pair<Integer, Integer>, Integer>(new Pair<Integer, Integer>(dx, dy),
                            top.second + 1));
                }
            }
        }

        return -1;
    }
}