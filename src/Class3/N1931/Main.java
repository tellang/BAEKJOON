package Class3.N1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, Integer> map = new TreeMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int exStart = map.getOrDefault(end, -1);
            if (exStart == -1 && exStart < start) {
                map.put(end, start);
            }
        }
        int lastEnd = -1;
        int count = 0;
        for (var end:map.keySet()
        ) {
            if (lastEnd <= map.get(end)){
                count++;
                lastEnd = end;
            }
        }
        System.out.println(count);
    }
}
