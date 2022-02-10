import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class chessTournament {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for (int i = 0; i < n; i++)
            nums.add(in.nextInt());

        int noOfPlayers = in.nextInt();

        chessTournament obj = new chessTournament();
        System.out.println(obj.solve(nums, n, noOfPlayers));
        in.close();
    }

    int solve(ArrayList<Integer> nums, int n, int c) {
        int ans = 1; // as distance of 1 can be mintained in any way or not.

        Collections.sort(nums);

        int low = 1, high = nums.get(n - 1) - nums.get(0);

        while (low <= high) {
            int mid = (low + high) >> 1;

            if (isPossible(nums, mid, c, n)) {
                ans = Math.max(ans, mid);
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }

    boolean isPossible(ArrayList<Integer> nums, int target, int defaultPlayerCount, int n) {
        int lastPlayerCordinate = nums.get(0), playerCount = 1;

        for (int i = 1; i < n; i++) {
            if ((nums.get(i) - lastPlayerCordinate) >= target) {
                playerCount++;
                lastPlayerCordinate = nums.get(i);
            }
        }

        if (playerCount >= defaultPlayerCount)
            return true;
        return false;
    }
}
