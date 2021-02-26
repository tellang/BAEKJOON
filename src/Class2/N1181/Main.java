package Class2.N1181;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < count; i++) {
            set.add(scanner.next());
        }
        System.out.flush();
        List<String> list = new ArrayList<>(set);
        list.sort((o1, o2) -> {
            if (o1.length() == o2.length())
                return o1.compareTo(o2);
            else if (o1.length() > o2.length())
                return 1;
            else
                return -1;
        });

        for (String word: list)
            System.out.println(word);
    }
}
