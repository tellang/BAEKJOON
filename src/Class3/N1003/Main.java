package Class3.N1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] fibonacci = new int[41];
    static int fiboIndex = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());
            if (target == 0){
                sb.append("1 0\n");
            }else {
                getFibo(target);
                sb.append(fibonacci[target - 1]).append(' ').append(fibonacci[target]).append('\n');
            }
        }
        System.out.println(sb);
    }
    public static void getFibo(int target){
        for (int i = fiboIndex; i <= target; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
    }
}
