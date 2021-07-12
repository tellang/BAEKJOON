package Class3.N1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append('\n');
        Map<String, Integer> set = new HashMap<>();
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
                sb.append(target).append('\n');
            }
        }
        sb.insert(0, counter);
        System.out.println(sb);
    }
}
