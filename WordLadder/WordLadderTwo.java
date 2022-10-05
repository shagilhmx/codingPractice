package WordLadder;

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class WordLadderTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for (int i = 0; i < n; i++) {
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            SolutionTwo obj = new SolutionTwo();
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if (ans.size() == 0)
                System.out.println(-1);
            else {
                Collections.sort(ans, new Comparator<ArrayList<String>>() {
                    public int compare(ArrayList<String> a, ArrayList<String> b) {
                    String x = "";
                    String y = "";
                    for (int i = 0; i < a.size(); i++)
                        x += a.get(i);
                    for (int i = 0; i < b.size(); i++)
                        y += b.get(i);
                    return x.compareTo(y);                    
                }});
                for (int i = 0; i < ans.size(); i++) {
                    for (int j = 0; j < ans.get(i).size(); j++) {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}