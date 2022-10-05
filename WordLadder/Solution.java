package WordLadder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import DataStructure.Queue;

class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

public class Solution {
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Queue<Pair<String, Integer>> q = new Queue<>();
        HashSet<String> hash = new HashSet<>(Arrays.asList(wordList));
        HashSet<String> vis = new HashSet<>(Arrays.asList(startWord));

        // System.out.println("start");

        if (startWord.equalsIgnoreCase(targetWord))
            return 0;

        q.push(new Pair<String, Integer>(startWord, 1));
        vis.add(startWord);

        System.out.println(q.empty());

        while (!q.empty()) {
            Pair<String, Integer> node = q.front();
            q.pop();

            String word = node.first;
            int steps = node.second;

            System.out.println(word + "-" + steps);

            if (word.equalsIgnoreCase(targetWord))
                return steps;

            char[] words = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char ch = words[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    words[i] = c;
                    // word.toCharArray()[word.indexOf(ch)]
                    System.out.println(words);
                    // word.toString();
                    // System.out.println(vis.contains(new String(words)));
                    if (hash.contains(new String(words)) && !vis.contains(new String(words))) {
                        q.push(new Pair<String, Integer>(new String(words), steps + 1));
                        vis.add(new String(words));
                    }
                }
                words[i] = ch;
                word = new String(words);
                // System.out.println("after change: " + q.front().first);
            }
        }

        return 0;
    }

    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        return null;
    }
}