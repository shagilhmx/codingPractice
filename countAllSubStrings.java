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
        int cnt = distinctSubStringCount(s);
        System.out.println(cnt);
        in.close();
    }

    static class TrieNode {
        TrieNode children[];
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }

        boolean containsKey(char ch) {
            return (children[ch - 'a'] != null);
        }

        TrieNode get(char ch) {
            return children[ch - 'a'];
        }

        void put(char ch, TrieNode node) {
            children[ch - 'a'] = node;
        }

        void setEnd() {
            isEnd = true;
        }

        boolean isEnd() {
            return isEnd;
        }
    }

    public static int distinctSubStringCount(String s) {
        TrieNode root = new TrieNode();

        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            TrieNode temp = root;
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);

                if (!temp.containsKey(ch)) {
                    temp.put(ch, new TrieNode());
                    temp.isEnd = true;
                    cnt++;
                }
                temp = temp.get(ch);
            }
        }
        return cnt + 1;
    }
}
