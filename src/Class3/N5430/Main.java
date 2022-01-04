package Class3.N5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static final int NORMAL = 1, REVERSE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int status = NORMAL;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            status = NORMAL;
            Deque<String> dq = new LinkedList<>() {
                @Override
                public String toString() {
                    return super.toString().trim();
                }
            };
            var func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            boolean hasError = false;
            String array = br.readLine();
            if (n > 0)
                dq.addAll(Arrays.asList(array.substring(1, array.length() - 1).split(",")));
            for (var token : func.toCharArray()) {
                if (token == 'R')
                    status *= REVERSE;
                else if (token == 'D') {
                    if (dq.isEmpty()) {
                        hasError = true;
                        break;
                    } else {
                        if (status == NORMAL)
                            dq.pollFirst();
                        else
                            dq.pollLast();
                    }
                }
            }
            if (hasError)
                sb.append("error\n");
            else {
//                if (status == NORMAL)
//                    sb.append(dq).append("\n");
//                else
//                    sb.reverse().append(dq).append("\n").reverse();
                sb.append(dq).append("\n");
            }
        }
        System.out.println(sb);
    }
}
