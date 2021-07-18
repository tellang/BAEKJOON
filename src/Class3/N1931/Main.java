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
        Map<Integer, Integer> shortTimeCounter = new TreeMap<>();
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int exStart = map.getOrDefault(end, -1);
            if (end != start){
                if (exStart == -1 || exStart < start) {
                    map.put(end, start);
                }else if (exStart == end){
                    map.put(end, start);
                    shortTimeCounter.put(end, shortTimeCounter.getOrDefault(end, 0)+1);
                }
            }else{
                if (exStart == -1) {
                    map.put(end, start);
                }else
                    shortTimeCounter.put(end, shortTimeCounter.getOrDefault(end, 0)+1);
            }
        }
        int lastEnd = -1;
        for (var end:map.keySet()
        ) {
            int start = map.get(end);
            if (lastEnd <= start){
                count+= shortTimeCounter.getOrDefault(end, 0)+1;
                lastEnd = end;
            }
        }
        System.out.println(count);
    }
}
