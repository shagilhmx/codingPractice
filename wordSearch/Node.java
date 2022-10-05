package wordSearch;

public class Node implements Trie {
    private Node links[] = new Node[26];
    private boolean flag = false;

    @Override
    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    @Override
    public void put(char ch, Trie node) {
        links[ch - 'a'] = (Node) node;
    }

    @Override
    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
}
