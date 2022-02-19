import java.util.Scanner;
import java.util.Stack;

public class celebrityProblem {
    public static void main(String[] args) {
        /*
         * celeb_id -> (0, 1, 2, 3, 4).
         * 
         * 0 1 2 3 4
         * 0 0 1 1 1 1
         * 1 1 0 0 1 0
         * 2 1 0 0 1 0
         * 3 0 0 0 0 0
         * 4 0 1 0 1 0
         * 
         * celebrity is the person who's known by everyone but knows no one.
         * 3 -> is celeb here.
         */
        int n;

        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        findCelebrity(arr, n);

        in.close();
    }

    public static void findCelebrity(int[][] arr, int n) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++)
            st.push(i);

        while (st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();

            if (arr[i][j] == 1) {
                // if i knows j -> i is not a celebrity.
                st.push(j);
            } else {
                // if i doesn’t know j -> j is not a celebrity.
                st.push(i);
            }
        }
        int potential = st.pop();
        for (int i = 0; i < n; i++) {
            if (i != potential) {
                // if i doesn’t knows potential or potentail knows i, the there is none.
                if (arr[i][potential] == 0 || arr[potential][i] == 1) {
                    System.out.println("none");
                    return;
                }
            }
        }

        System.out.println(potential);
    }
}
