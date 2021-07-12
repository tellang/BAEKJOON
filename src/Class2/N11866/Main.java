package Class2.N11866;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int offset = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        int N = sc.nextInt();
        int K = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        offset = K;
        while (!list.isEmpty()){
            dropNum(list, result, K);
        }
        sb.append(result.toString(), 1, result.toString().length() - 1).append('>');
        System.out.println(sb);
    }
    public static void dropNum(List<Integer> list, List<Integer> result, int target){
        while (offset<=list.size()){
            result.add(list.get(offset -1));
            offset+=target;
        }
        offset -= list.size();
        list.removeAll(result);
    }
}
