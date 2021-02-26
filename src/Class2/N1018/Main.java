package Class2.N1018;

import java.util.Scanner;

public class Main {

    static char[][] board;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),
            m = scanner.nextInt();
        board = new char[n][m];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String temp = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        int result = checker(0, 0);
        for (int i = 0; i <= n-8; i++) {
            for (int j = 0; j <= m-8; j++) {
                int newResult = checker(i, j);
                if(result > newResult)
                    result = newResult;
            }
        }
        System.out.println(result);
    }
    public static int checker(int nOffset, int mOffset) {

        char[][] w = {
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        };
        int r1 = 0, r2 = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i + nOffset][j + mOffset] != w[i][j])
                    r1++;
                else
                    r2++;
            }
        }
        return Math.min(r1, r2);
    }
}
