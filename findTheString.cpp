// ### Problem :

// There was a string of length n made up of lowercase English letters. The string was used to create a 2-dimensional array, lcp[n][n], such that lcp[i][j] is equal to the length of the longest common prefix between the substrings s[i, ..,n] and s[j, ...,n], for every 1 <= i, j <= n. It is possible that lcp has been corrupted, though, and the string has been lost. Given lcp[n][n], return the alphabetically smallest string of length n that conforms to lcp. If there is no such string return the string Impossible.

// ### Example :

// 1.

// ```
// lcp = [[3, 0, 0],
//         [0, 2, 1],
//         [0, 1, 1]]
// ```

// In the above example, we have to find a string of length 3 that conforms to the given lcp array.

// The String "baa" is one string that conforms to lcp.

// ```
// i   j   substring length    common prefix   common prefix length

// 1   1      baa, baa             baa                 3
// 1   2      baa, aa              ---                 0
// 1   3      baa, a               ---                 0
// 2   1      aa, baa              ---                 0
// 2   2      aa, aa               aa                  2
// 2   3      aa, a                a                   1
// 3   1      a, baa               ---                 0
// 3   2      a, aa                a                   1
// 3   3      a, a                 a                   1
// ```

// The lexicographically smallest string that gives the same lcp array is "abb"

#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <utility>
#include <unordered_map>
using namespace std;

class Solution
{
public:
    string findTheString(vector<vector<int> > lcp)
    {
        string s(n, 'a');

        int n = lcp.size();
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (lcp[i][j] != commonPrefix(s.substr(i, n), s.substr(j, n)))
            }
        }
    }
}

int
main()
{
    int n;
    cin >> n;
    vector < vector<int> lcp(n, vector<int>(n));

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            cin >> lcp[i][j];

    Solution obj;
    string ans = obj.findTheString(lcp);
    cout << ans << endl;
    return 0;
}

// a = 'aaa' , b = 'aa'