import java.util.*;

public class allocateBooks {
    public static void main(String[] args) {
        int n, b;

        Scanner in = new Scanner(System.in);

        n = in.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        b = in.nextInt();

        allocateBooks obj = new allocateBooks();
        System.out.println(obj.solve(n, arr, b));
        in.close();
    }

    int solve(int n, int arr[], int b) {
        int ans = -1;

        if (b > n)
            return ans;

        int minValue = arr[0], sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            minValue = Math.min(minValue, arr[i]);
        }

        int low = minValue, high = sum;

        while (low <= high) {
            int mid = (low + high) >> 1;

            if (isPossible(arr, mid, n, b)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return ans;
    }

    boolean isPossible(int arr[], int pages, int n, int students) {
        int cnt = 0;
        int sumAllocated = 0;

        for (int i = 0; i < n; i++) {
            if (sumAllocated + arr[i] > pages) {
                cnt++;
                sumAllocated = arr[i];
                if (sumAllocated > pages)
                    return false;
            } else
                sumAllocated += arr[i];
        }

        if (cnt < students)
            return true;
        return false;
    }
}
