package wordSearch;

public class TrieOperations {
    Node root;

    public TrieOperations() {
        root = new Node();
    }

    void insert(String s) {
        Node temp = root;

        for (char ch : s.toCharArray()) {
            if (!temp.containsKey(ch))
                temp.put(ch, new Node());
            temp = temp.get(ch);
        }
        temp.setEnd();
    }

    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    boolean search(char[][] board, int i, int j, Node temp) {
        System.out.println(board[i][j]);
        if (temp.isEnd() == true)
            return true;

        char ch = board[i][j];
        board[i][j] = '*';
        for (int[] d : dir) {
            int dx = d[0] + i;
            int dy = d[1] + j;

            if (dx >= 0 && dy >= 0 && dx < board.length && dy < board[0].length && board[dx][dy] != '*'
                    && temp.containsKey(board[dx][dy]))
                if (search(board, dx, dy, temp.get(board[dx][dy])))
                    return true;
        }
        board[i][j] = ch;

        return false;
    }
}
