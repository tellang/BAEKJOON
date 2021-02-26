package Class2.N2798;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),
            target = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        int source = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!(i == j || j == k || k == i)){
                        int newCom = list.get(i) + list.get(j) + list.get(k);
                        if (newCom <= target && newCom > source){
                            source = newCom;
                            if (source == target)
                                break;
                        }
                    }
                }
            }
        }
        System.out.println(source);
    }
}
