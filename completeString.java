import java.util.ArrayList;
import java.util.Scanner;

class Node {
    Node[] link = new Node[26];
    boolean flag = false;

    public Node() {
    }

    boolean containsKey(char ch) {
        return (link[ch - 'a'] != null);
    }

    void put(char ch, Node node) {
        link[ch - 'a'] = node;
    }

    Node get(char ch) {
        return link[ch - 'a'];
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
};

class TrieOperations {
    private static Node root;

    public TrieOperations() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!(node.containsKey(word.charAt(i))))
                node.put(word.charAt(i), new Node());
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean checkIfPrefixExists(String word) {
        boolean fl = true;
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                fl = fl & node.isEnd();
            } else
                return false;
        }
        return fl;
    }
};

public class completeString {
    public completeString() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < n; i++)
            words.add(in.next());

        completeString obj = new completeString();
        String ans = obj.solve(n, words);

        System.out.println(ans);
        in.close();
    }

    String solve(int n, ArrayList<String> words) {
        TrieOperations trie = new TrieOperations();

        for (String it : words) {
            trie.insert(it);
        }

        String longest = "";

        for (String it : words) {
            if (trie.checkIfPrefixExists(it)) {
                if (it.length() > longest.length())
                    longest = it;
                else if ((it.length() == longest.length()) && (it.compareToIgnoreCase(longest) < 0))
                    longest = it;
            }
        }

        return longest == "" ? "None" : longest;
    }
}
