package Class2.N2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int MAX = 2_000_001;
    final static int MIL = 1_000_000;
    static boolean[] arr = new boolean[MAX];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine())+MIL] = true;
        }

        for (int i = 0, c = 0; c < N &&i < MAX; i++) {
            if (arr[i]) {
                sb.append((i - MIL)).append('\n');
                c++;
            }
        }
        System.out.println(sb);
    }
}
