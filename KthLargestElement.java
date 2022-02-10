import java.util.Scanner;

public class KthLargestElement {
    public static void main(String[] args) {
        int m, n, k, ans;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[] num1 = new int[m];
        int[] num2 = new int[n];

        for (int i = 0; i < m; i++)
            num1[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
            num2[i] = sc.nextInt();

        k = sc.nextInt();
        k = num1.length + num2.length - k;

        KthLargestElement obj = new KthLargestElement();
        ans = obj.solve(num1, num2, m, n, k);
        System.out.println("Kth Largest element-" + ans);
        sc.close();
    }

    int solve(int num1[], int num2[], int m, int n, int k) {
        if (n > m)
            return solve(num2, num1, n, m, k);

        int low = Math.max(0, k - m), high = Math.min(k, n);

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;

            int left1 = cut1 == 0 ? Integer.MIN_VALUE : num1[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : num2[cut2 - 1];
            int right1 = cut1 == n ? Integer.MAX_VALUE : num1[cut1];
            int right2 = cut2 == n ? Integer.MAX_VALUE : num2[cut2];

            if (left1 <= right2 && left2 <= right1)
                return Math.max(left1, left2);
            if (left1 > right2)
                high = cut1 - 1;
            else
                low = cut1 + 1;
        }
        return 1;
    }
}
