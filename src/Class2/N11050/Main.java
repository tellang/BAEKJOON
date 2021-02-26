package Class2.N11050;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),
            k = scanner.nextInt();

        long result = factorial(n) / (factorial(n - k) * factorial(k));
        System.out.println(result);
    }

    public static long factorial(int n){
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
