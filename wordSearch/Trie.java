package wordSearch;

public interface Trie {
    boolean containsKey(char ch);

    void put(char ch, Trie node);

    Trie get(char ch);

}
