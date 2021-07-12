package Class2.N10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue q = new Queue();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push" -> q.push(Integer.parseInt(st.nextToken()));
                case "pop" -> sb.append(q.pop()).append('\n');
                case "size" -> sb.append(q.size()).append('\n');
                case "empty" -> sb.append(q.empty()).append('\n');
                case "front" -> sb.append(q.front()).append('\n');
                case "back" -> sb.append(q.back()).append('\n');
            }
        }
        br.close();
        System.out.println(sb);
    }
}
class Queue{
    static List<Integer> data = new ArrayList<>();

    public void push(int num){
        data.add(num);
    }
    public int pop(){
        if (data.isEmpty())
            return -1;

        int result = data.get(0);
        data.remove(0);
        return result;
    }

    public int size(){
        return data.size();
    }
    public int empty(){
        if (data.isEmpty())
            return 1;
        else return 0;
    }
    public int front(){
        if (data.isEmpty())
            return -1;

        return data.get(0);
    }
    public int back(){
        if (data.isEmpty())
            return -1;
        int tail = data.size()-1;
        return data.get(tail);
    }
}
