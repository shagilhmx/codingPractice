#include <iostream>
#include <vector>
using namespace std;
#define endl "\n"

class Solution
{
public:
    int solve(int index, vector<int> &arr, int target, vector<int> &dp, vector<int> &ans)
    {
        if (index >= arr.size())
            return dp[index];

        if (target == 0)
        {
            // cout<<target<<"-"<<endl;
            return dp[index];
        }

        if (dp[index] != -1)
            return dp[index];

        ans.push_back(index);
        // cout<<arr[index]<<"-"<<index<<":target:"<<target<<endl;
        // ans.push_back(index);
        return dp[index] = solve(index + 1, arr, target - arr[index], dp, ans) + solve(index + 1, arr, target - arr[index], dp, ans);
        // ans.pop_back();
        // cout<<arr[index]<<"-"<<index<<":target:"<<target<<endl;
        // dp[index] = solve(index + 1, arr, target - arr[index], dp);
    }
};

int main()
{
    vector<int> arr{1, 2, 3, 2, 1};
    int desiredOp = 6;
    vector<int> dp(arr.size(), -1);
    vector<int> ans;

    Solution obj;
    obj.solve(0, arr, desiredOp, dp, ans);

    for (int el : ans)
        cout << el << endl;
}