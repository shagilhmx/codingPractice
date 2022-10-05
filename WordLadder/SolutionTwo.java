package WordLadder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import DataStructure.Queue;

public class SolutionTwo {
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        Queue<String> q = new Queue<>();
        HashSet<String> hash = new HashSet<>(Arrays.asList(wordList));
        HashSet<String> vis = new HashSet<>(Arrays.asList(startWord));

        q.push(startWord);

        while (!q.empty()) {

        }

        return arr;
    }
}
