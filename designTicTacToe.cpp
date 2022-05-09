class Solution
{
    vector<vector<int> > board;

public:
    Solution(int n)
    {
        board.resize(n, vector<int>(n, 0));
    }

    int move(int row, int col, int player)
    {
        int n = board.size();
        board[row][col] = player;

        bool win = true;
        for (int i = 0; i < n; i++)
        {
            if (player != board[i][col])
            {
                win = false;
                break;
            }
        }
        if (win)
            return player;

        win = true;
        for (int j = 0; j < n; j++)
        {
            if (player != board[row][j])
            {
                win = false;
                break;
            }
        }

        if (win)
            return player;

        if (row == col)
        {
            win = true;
            for (int i = 0; i < n; i++)
            {
                if (player != board[i][i])
                {
                    win = false;
                    break;
                }
            }

            if (win)
                return player;
        }

        if (row == n - col - 1)
        {
            win = true;
            for (int i = 0; i < n; i++)
            {
                if (player != board[i][i])
                {
                    win = false;
                    break;
                }
            }

            if (win)
                return player;
        }

        return 0;
    }
};

int main()
{
    int n = 3, querySize = 5;
    vector<vector<int> > query{{0, 0, 1}, {1, 0, 2}, {0, 1, 1}, {1, 1, 2}, {0, 2, 1}};
    Solution *obj = new Solution(n);
    int player = 0;
    for (int i = 0; i < querySize; i++)
    {
        player = obj->move(query[i][0], query[i][1], query[i][2]);
    }

    cout << player << endl;
}