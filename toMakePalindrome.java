import java.util.Scanner;

public class toMakePalindrome {
    public static void main(String[] args) {
        // minimum number of character added at the beginning to make it a palindrome.
        Scanner in = new Scanner(System.in);
        String str = in.next();

        toMakePalindrome ob = new toMakePalindrome();

        System.out.println(ob.getMinCharToAddedToMakeStringPalin(str));

        in.close();
    }

    int getMinCharToAddedToMakeStringPalin(String str) {
        StringBuilder revStr = new StringBuilder();

        revStr.append(str);
        revStr.reverse();

        String concat = str + '$' + revStr;
        int n = concat.length();
        int[] lps = new int[n];

        computeLPSArray(concat, lps);

        return (str.length() - lps[n - 1]);
    }

    static void computeLPSArray(String str, int[] lps) {
        int n = str.length();
        int len = 0;
        lps[0] = 0;

        int i = 1;
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
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
