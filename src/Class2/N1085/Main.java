package Class2.N1085;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(),
            y = scanner.nextInt(),
            w = scanner.nextInt(),
            h = scanner.nextInt(),
            x0 = w-x,
            y0 = h-y;
        System.out.println(Math.min(Math.min(x, y), Math.min(x0, y0)));
    }
}
