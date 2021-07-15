package Class3.N18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        int N = Integer.parseInt(br.readLine());
        int[] order = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            order[i] = num;
            set.add(num);
        }
        int count = 0;
        for (var num: set
        ) {
            map.put(num, count++);
        }
        for (var num: order
        ) {
            sb.append(map.get(num)).append(' ');
        }
        System.out.println(sb);
    }
}
