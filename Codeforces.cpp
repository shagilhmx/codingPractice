// Codeforces #782 - D
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main()
{
    int t;
    scanf("%d", &t);
    while (t--)
    {
        int n;
        scanf("%d", &n);
        vector<int> v(n);
        ll sum = 0;
        for (auto &x : v)
        {
            scanf("%d", &x);
            sum += x;
        }
        int ones = sum / n;
        vector<int> rem(n);
        int cur = 0;
        vector<int> sol(n);
        for (int i = n - 1; i >= 0; --i)
        {
            cur -= rem[i];
            if (ones)
            {
                ++cur;
                if (i - ones >= 0)
                    ++rem[i - ones];
            }
            v[i] -= cur;
            if (v[i] == i && ones)
            {
                sol[i] = 1;
                --ones;
            }
        }
        for (int i = 0; i < n; ++i)
            printf("%d ", sol[i]);
        puts("");
    }
    return 0;
}