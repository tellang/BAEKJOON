package Class2.N10250;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (; t > 0; t--) {
            int h = scanner.nextInt(),
                w = scanner.nextInt(),
                n = scanner.nextInt() - 1,
                result = n%h*100 + n/h + 101;
            list.add(result);
        }
        for (int arr : list) {
            System.out.println(arr);
        }
    }
}
