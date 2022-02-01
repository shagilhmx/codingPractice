import java.util.*;

/*The above approach may not work for all denominations. 
For example, it doesn’t work for denominations {9, 6, 5, 1} and V = 11. The above approach would print 9, 1 and 1. 
But we can use 2 denominations 5 and 6. */

class Coins {
    public static void main(String[] args) {

        int V, res = 0;

        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();

        Coins obj = new Coins();
        res = obj.compute(V);

        System.out.println(res);
    }

    int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

    int compute(int totalMoney) {
        int ans = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            while (totalMoney >= coins[i]) {
                totalMoney -= coins[i];
                ans++;
            }
        }
        return ans;
    }
}