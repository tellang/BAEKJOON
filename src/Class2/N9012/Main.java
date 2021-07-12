package Class2.N9012;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            isValid(br.readLine());
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static void isValid(String str) throws IOException{
        char[] target = str.toCharArray();
        int leftPS = 0;
        for (var c:target
        ) {
            switch (c){
                case '(' -> leftPS++;
                case ')' -> {
                    leftPS--;
                }
            }
            if (leftPS < 0)
                break;
        }
        if (leftPS==0)
            bw.write("YES");
        else bw.write("NO");
        bw.newLine();
    }
}
