import java.util.*;

public class findPatternInString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String pattern = in.next();
        String mainString = in.next();

        findPatternInString obj = new findPatternInString();

        System.out.println(obj.findPattern(pattern, mainString));
    }

    boolean findPattern(String p, String s) {
        int n = s.length(), m = p.length();
        int[] lps = new int[m];

        computeLPS(p, m, lps);

        int p1 = 0, p2 = 0;

        while (p1 < n) {
            if (s.charAt(p1) == p.charAt(p2)) {
                p1++;
                p2++;
            } else {
                if (p2 != 0)
                    p2 = lps[p2 - 1];
                else
                    p1++;
            }

            if (p2 == m)
                return true;
        }

        return false;
    }

    static void computeLPS(String p, int m, int[] lps) {
        int i = 1, len = 0;

        while (i < m) {
            if (p.charAt(i) == p.charAt(len)) {
                lps[i] = len + 1;
                len++;
                i++;
            } else {
                if (len != 0)
                    len = lps[len - 1];
                else
                    lps[i++] = 0;
            }
        }
    }
}
