import java.util.Scanner;

public class KthRootOfNumber {
    public static void main(String[] args) {
        int number, exponential;

        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        exponential = sc.nextInt();

        KthRootOfNumber obj = new KthRootOfNumber();
        System.out.println(obj.solve(number, exponential));
        sc.close();
    }

    int solve(int no, int e) {
        return NthRootSearch(0, no, no, e);
    }

    int NthRootSearch(int low, int high, int number, int exponential) {
        if (low <= high) {
            int mid = (low + high) / 2;

            // Base Case
            if ((power(mid, exponential, number) <= number) && (power(mid, exponential, number) > number)) {
                return mid;
            }

            else if (power(mid, exponential, number) < number)
                return NthRootSearch(low + 1, high, number, exponential);
            else
                return NthRootSearch(low, high - 1, number, exponential);
        }
        return low;
    }

    int power(int x, int y, int number) {
        int ans = 1;

        if (y == 0)
            return 1;

        for (int i = 1; i <= y; i++) {
            ans *= x;
            if (ans > number)
                return number + 2;
        }
        return ans;
    }
}
