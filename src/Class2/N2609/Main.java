package Class2.N2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(sb.readLine());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());
        int big, small, MaxC, MinC;
        if (left > right) {
            big = left;
            small = right;
        }else {
            big = right;
            small = left;
        }
        MaxC = getMaxC(big, small);
        MinC = big*small/MaxC;
        System.out.println(MaxC+"\n"+MinC);
    }
    public static int getMaxC(int big, int small){
        int[] bigPF = getPrimeFactor(big);
        int[] smallPF = getPrimeFactor(small);
        int result = 1;
        for (int i = 2; i <= small; i++) {
            int minPrime = Math.min(bigPF[i], smallPF[i]);

            int prime = squre(i,minPrime);
            if (minPrime>0)
                result*=prime;
        }
        return result;
    }
    public static int[] getPrimeFactor(int num){
        int[] pF = new int[num+1];
        int prime = 2;
        while (num > 1){
            if ((num % prime) == 0){
                num/=prime;
                pF[prime]++;
            }else
                prime++;
        }
        return pF;
    }
    public static int squre(int bottom, int up){
        int result = bottom;
        for (int i = 1; i < up; i++) {
            result*=bottom;
        }
        return result;
    }
}
