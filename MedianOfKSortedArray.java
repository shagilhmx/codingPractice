import java.util.Scanner;

public class MedianOfKSortedArray {
    public static void main(String[] args) {
        int k, n;
        double ans = 0;

        Scanner in = new Scanner(System.in);

        k = in.nextInt();
        n = in.nextInt();

        int[][] matrix = new int[k][n];

        for (int i = 0; i < k; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = in.nextInt();

        ans = getMedian(matrix, k, n);
        System.out.println(ans);
        in.close();
    }

    public static int getMedian(int[][] matrix, int rows, int cols) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        double eps = 1e-6;

        // get the least value and largest value from the array.
        for (int i = 0; i < cols; i++) {
            low = Math.min(low, matrix[0][i]);
            high = Math.max(high, matrix[rows - 1][i]);
        }

        // binary search
        while ((high - low) > eps) {
            int mid = (low + high) >>> 1;

            if (possible(matrix, mid, (rows * cols + 1) / 2))
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    private static boolean possible(int[][] matrix, int median, int half) {
        int smallerElemet = 0;
        // count the smaller element;
        for (int[] row : matrix)
            smallerElemet += countSmallerElements(row, median);

        return smallerElemet >= half;
    }

    private static int countSmallerElements(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int upperBound = -1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] == target) {
                upperBound = mid;
                low = mid + 1;
            } else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return upperBound != -1 ? upperBound + 1 : low;
    }
}
