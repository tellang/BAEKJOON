package Class3.N1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append('\n');
        Map<String, Integer> set = new HashMap<>();
        Set<String> DBJSet = new TreeSet<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int counter = 0;
        for (int i = 0; i < N; i++) {
            set.put(br.readLine(), 1);
        }
        for (int i = 0; i < M; i++) {
            String target = br.readLine();
            if (set.containsKey(target)) {
                counter++;
                DBJSet.add(target);

            }
        }
        for (var name:DBJSet
        ) {
            sb.append(name).append('\n');
        }
        sb.insert(0, counter);
        System.out.println(sb);
    }
}
