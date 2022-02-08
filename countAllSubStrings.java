import java.util.Scanner;

/*
using tire to improve time complexity.
The idea is to insert the character that are not already present in the trie.
And when such addition happens we know that the string  is occuring for the 
first time and thus we print it.
And if some character of the string is already present we just move on the next
node without reading them which helps in reducing or saving space.
T.C : O(n^2)
S.C : O(n) * 26.
 */
public class countAllSubStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        countAllSubStrings obj = new countAllSubStrings();
        int cnt = obj.distinctSubStringCount(s);
        System.out.println(cnt);
    }

    static class TrieNode {
        TrieNode children[];
        boolean isEnd;

        TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }

    static TrieNode root = new TrieNode();

    static void insert(String s) {
        TrieNode cur = root;
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';

            if (cur.children[idx] == null)
                cur.children[idx] = new TrieNode();
            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    public int distinctSubStringCount(String s) {
        int cnt = 0;

        for (int i = 0; i <= s.length(); i++) {
            TrieNode temp = root;
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);

                if (temp.children[ch - 'a'] == null) {
                    temp.children[ch - 'a'] = new TrieNode();
                    temp.isEnd = true;
                    cnt++;
                }
                temp = temp.children[ch - 'a'];
            }
        }
        return cnt;
    }
}
