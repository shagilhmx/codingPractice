import java.util.ArrayList;
import java.util.Scanner;

public class RabinKarp {
    final static int p = 31, N = (int) (1e5 + 7), m = (int) (1e9 + 7);

    public static void main(String[] args) {
        long[] powers = new long[N];

        ArrayList<Integer> ans = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        String str = in.next();
        String pat = in.next();

        RabinKarp rb = new RabinKarp();
        rb.solve(str, pat, str.length(), pat.length(), powers, ans);

        for (int i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + " ");
    }

    void solve(String str, String pat, int T, int S, long[] powers, ArrayList<Integer> ans) {
        long[] hash = new long[T + 1];

        powers[0] = 1;
        for (int i = 1; i < N; i++)
            powers[i] = (powers[i - 1] * p) % m;

        for (int i = 0; i < T; i++)
            hash[i + 1] = (hash[i] + (str.charAt(i) - 'A' + 1) * powers[i]) % m;

        long patter_hash = 0;
        for (int i = 0; i < S; i++)
            patter_hash = (patter_hash + (pat.charAt(i) - 'A' + 1) * powers[i]) % m;

        for (int i = 0; i + S - 1 < T; i++) {
            long curr_hash = (hash[i + S] - hash[i] + m) % m;
            if (curr_hash == (patter_hash * powers[i]) % m)
                ans.add(i);
        }
        return;
    }
}
