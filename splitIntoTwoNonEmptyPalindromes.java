import java.util.ArrayList;
import java.util.Scanner;

public class splitIntoTwoNonEmptyPalindromes {
    public static final int MOD = (int) 1e9 + 9;

    public static final int P = 37;

    public static final int MAXN = (int) 1e5;

    ArrayList<Integer> suffixHash = new ArrayList<>(MAXN);
    ArrayList<Integer> prefixHash = new ArrayList<>(MAXN);
    ArrayList<Integer> inversePerfix = new ArrayList<>(MAXN);
    ArrayList<Integer> inverseSuffix = new ArrayList<>(MAXN);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String S = in.next();

        splitIntoTwoNonEmptyPalindromes obj = new splitIntoTwoNonEmptyPalindromes();
        int ans = obj.rabinKarp(S);
        System.out.println(ans);
        in.close();
    }

    /*
     * The algorithm can be optimised by using Hashing and Rabin-Karp Algorithm, to
     * store
     * Prefix and Suffix Hashes of stirng.
     * 
     * algorithm:
     * 1. Compute the prefix and suffex hash of the given string.
     * 2. For every index i in the range (1, n-1), check if two subStrings are [0,
     * i-1] and [i, n-1]
     * are palindrome or not.
     * 3. To check if its palindrome or not, just check prefixHash[l-r] =
     * suffixHash[l-r].
     * 4. For every index i for which the two subStrings are found to be
     * palindromic, increase the count.
     * 5. return the final count value.
     * 
     * TC : O(N^2)
     */
    int rabinKarp(String S) {
        int cnt = 0;
        int n = S.length();

        // compute prefix and suffix hashes.
        preCompute(S);

        for (int i = 0; i < n; i++) {
            int preHash = getPrefixHash(0, i);
            int sufHash = getSuffixHash(0, i);

            // if not palindrome.
            if (preHash != sufHash)
                continue;

            preHash = getPrefixHash(i + 1, n - 1);
            sufHash = getSuffixHash(i + 1, n - 1);

            if (preHash != sufHash)
                continue;

            cnt++;
        }
        return cnt;
    }

    void preCompute(String S) {

    }

    // Naive approch worst case will run to O(N^2);
    int solve(String S) {
        int cnt = 0;
        int n = S.length();

        for (int i = 0; i < n - 1; i++) {
            if (isPossible(0, i, S) && isPossible(i + 1, n - 1, S))
                cnt++;
        }

        return cnt;
    }

    boolean isPossible(int start, int end, String s) {

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }
        return true;
    }
}
