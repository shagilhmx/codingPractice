package SnakeAndLadderGfg;
//{ Driver Code Starts

// Initial Template for Java

import java.io.*;

public class SnakeAndLadderGfg {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[2 * N];
            for (int i = 0; i < 2 * N; i++)
                arr[i] = Integer.parseInt(a[i]);

            Solution ob = new Solution();
            System.out.println(ob.minThrow(N, arr));
        }
    }
}
// } Driver Code Ends