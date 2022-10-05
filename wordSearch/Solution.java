package wordSearch;

public class Solution {
    public boolean isWordExist(char[][] board, String word) {
        TrieOperations trie = new TrieOperations();
        trie.insert(word);

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == word.charAt(0))
                    if (trie.search(board, i, j, trie.root.get(word.charAt(0))))
                        return true;

        return false;
    }
}
