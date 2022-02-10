import java.util.Scanner;

public class ratInTheMazeMultipleJumpsAllowed {
    public static void main(String[] args) {
        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[][] maze = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        ratInTheMazeMultipleJumpsAllowed.solveMaze(maze, n);
        sc.close();
    }

    static boolean solveMaze(int maze[][], int n) {

        int visited[][] = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };
        if (helper(maze, n, 0, 0, visited))
            return false;
        return true;
    }

    static boolean helper(int maze[][], int n, int x, int y, int visited[][]) {
        if (x == n - 1 && y == n - 1) {
            visited[x][y] = 1;
            return true;
        }

        if (isVisited(maze, x, y, n)) {
            visited[x][y] = 1;

            for (int i = 1; i <= maze[x][y] && i < n; i++) {
                if (helper(maze, n, x + i, y, visited))
                    return true;
                if (helper(maze, n, x, y + i, visited))
                    return true;
            }

            visited[x][y] = 0;
            return false;
        }
        return false;
    }

    static boolean isVisited(int maze[][], int x, int y, int n) {
        if (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] != 0)
            return true;
        return false;
    }
}
