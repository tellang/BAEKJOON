package Class2.N10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<Integer, List<String>> map = new TreeMap<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            if (!map.containsKey(age))
                map.put(age, new ArrayList<>());
            map.get(age).add(name);
        }

        for (var age: map.keySet()
        ) {
            for (var name: map.get(age)
            ) {
                sb.append(age).append(' ').append(name).append('\n');
            }
        }
        System.out.println(sb);
    }
}
