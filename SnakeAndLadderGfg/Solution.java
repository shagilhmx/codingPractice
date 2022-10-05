package SnakeAndLadderGfg;

import java.util.HashMap;

import DataStructure.Pair;
import DataStructure.Queue;

public class Solution {
    int minThrow(int N, int arr[]) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        Queue<Pair<Integer, Integer>> q = new Queue<>();

        for (int i = 0; i < 2 * N; i += 2)
            hmap.put(arr[i], arr[i + 1]);

        q.push(new Pair<Integer, Integer>(1, 0));

        while (!q.empty()) {
            Pair<Integer, Integer> node = q.front();
            q.pop();
            int currPos = node.first;
            int steps = node.second;

            if (currPos == 30)
                return steps;

            for (int i = 1; i <= 6; i++) {
                int nextPos = currPos + i;
                if (nextPos <= 30) {
                    if (hmap.containsKey(nextPos))
                        q.push(new Pair<Integer, Integer>(hmap.get(nextPos), steps + 1));
                    else
                        q.push(new Pair<Integer, Integer>(nextPos, steps + 1));
                }
            }
        }

        return -1;
    }
}
