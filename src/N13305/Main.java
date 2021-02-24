package N13305;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxCity = scanner.nextInt();
        int[] road = new int[--maxCity];
        int[] cities = new int[maxCity];

        for (int i = 0; i < maxCity; i++) {
            road[i] = scanner.nextInt();
        }
        for (int i = 0; i < maxCity; i++) {
            cities[i] = scanner.nextInt();
        }

        int presentOilPrice = Integer.MAX_VALUE;
        Long result = 0L;
        for (int i = 0; i < maxCity; i++) {
            if(presentOilPrice > cities[i])
                presentOilPrice = cities[i];
            result += ((long) road[i] * presentOilPrice);
        }
        System.out.println(result);
    }
}
