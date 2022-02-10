import java.util.Scanner;

public class squareOfANumberWithoutUsingProduct {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        squareOfANumberWithoutUsingProduct obj = new squareOfANumberWithoutUsingProduct();
        System.out.println(obj.square(n));
        in.close();
    }

    int square(int n) {
        if (n == 0)
            return 0;

        if (n % 2 == 1)
            return (4 * square((int) Math.floor(n / 2)) + 4 * (int) Math.floor(n / 2) + 1);
        return (4 * square(n / 2));
    }
}
