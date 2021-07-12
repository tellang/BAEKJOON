package Class2.N11650;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Map<Integer, ArrayList<Integer>> map = new TreeMap();
        for (int i = 0; i < N; i++) {
             int left = scanner.nextInt();
             int right = scanner.nextInt();
             if (!map.containsKey(left))
                 map.put(left, new ArrayList<>());
             map.get(left).add(right);
        }

        for (var left:map.keySet()
        ) {
            Collections.sort(map.get(left));
            for (var right:map.get(left)
            ) {
                System.out.println(left+" "+right);
            }
        }
    }
}
