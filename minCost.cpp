//{ Driver Code Starts
#include <vector>
#include <queue>
#include <iostream>
#include <algorithm>
using namespace std;

// } Driver Code Ends

class Solution
{
public:
    // Function to return the minimum cost to react at bottom
    // right cell from top left cell.
    void clear(priority_queue<pair<int, pair<int, int> >, vector<pair<int, pair<int, int> > >, greater<pair<int, pair<int, int> > > > &pq)
    {
        while (!pq.empty())
            pq.pop();
    }

    int minimumCostPath(vector<vector<int> > &grid)
    {
        int dir[2][2] = {{0, 1}, {1, 0}};
        int n = grid.size(), m = grid[0].size();
        vector<vector<bool> > vis(n, vector<bool>(m));
        priority_queue<pair<int, pair<int, int> >, vector<pair<int, pair<int, int> > >, greater<pair<int, pair<int, int> > > > pq;

        pq.push(make_pair(grid[0][0], make_pair(0, 0)));
        int dis = 0;

        while (!pq.empty())
        {
            auto node = pq.top();
            clear(pq);
            dis += node.first;
            cout << "mine algorithm" << endl;
            cout << node.second.first << "-" << node.second.second << "->" << node.first << endl;

            for (auto d : dir)
            {
                int dx = d[0] + node.second.first;
                int dy = d[1] + node.second.second;

                if (dx >= 0 && dx < n && dy >= 0 && dy < m && !vis[dx][dy])
                {
                    vis[dx][dy] = true;
                    pq.push(make_pair(grid[dx][dy], make_pair(dx, dy)));
                }
            }
        }

        return dis;
    }

    int minimumCostPath1(vector<vector<int> > &grid)
    {
        int dir1[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int n = grid.size(), m = grid[0].size();
        vector<vector<bool> > vis(n, vector<bool>(m));
        priority_queue<pair<int, pair<int, int> >, vector<pair<int, pair<int, int> > >, greater<pair<int, pair<int, int> > > > pq;
        vector<vector<int> > distTo(n, vector<int>(m, INT_MAX));

        pq.push(make_pair(grid[0][0], make_pair(0, 0)));

        while (!pq.empty())
        {
            auto node = pq.top();
            pq.pop();

            cout << "djkastra algorithm" << endl;
            cout << node.second.first << "-" << node.second.second << "->" << node.first << endl;

            for (auto d : dir1)
            {
                int dx = d[0] + node.second.first;
                int dy = d[1] + node.second.second;

                if (dx >= 0 && dx < n && dy >= 0 && dy < m && !vis[dx][dy] && node.first + grid[dx][dy] < distTo[dx][dy])
                {
                    distTo[dx][dy] = node.first + grid[dx][dy];
                    vis[dx][dy] = true;
                    pq.push(make_pair(distTo[dx][dy], make_pair(dx, dy)));
                }
            }
        }

        return distTo[n - 1][m - 1];
    }
};

//{ Driver Code Starts.
int main()
{
    int tc;
    cin >> tc;
    while (tc--)
    {
        int n;
        cin >> n;
        vector<vector<int> > grid(n, vector<int>(n, -1));
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                cin >> grid[i][j];
            }
        }
        Solution obj;
        int ans = obj.minimumCostPath(grid);
        int ans1 = obj.minimumCostPath1(grid);
        cout << ans << endl;
        cout << ans1 << endl;
    }
    return 0;
}
// } Driver Code Ends

// 9
// 2 9 6 6 6 2 10 1 9
// 7 10 10 8 3 3 4 7 9
// 9 9 9 8 6 2 5 7 2
// 7 9 3 10 10 8 6 6 10
// 8 9 9 6 9 5 10 6 10
// 10 5 9 3 9 10 1 8 4
// 9 8 9 2 5 3 5 4 5
// 5 3 2 5 1 1 5 2 4
// 7 9 6 1 9 9 2 7 2