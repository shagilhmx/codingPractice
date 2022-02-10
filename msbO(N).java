import java.util.Scanner;
/*
You are given a positive integer 'N'. 
Your task is to find the greatest integer less than or equal to 'N' which is a power of 2. 
*/

class Msb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double x = Math.log(n) / Math.log(2);

        int ans = 1 << (int) x;
        System.out.println(ans);
        sc.close();
    }
}
