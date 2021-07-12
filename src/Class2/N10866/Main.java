package Class2.N10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue q = new Queue();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_back" -> q.pushBack(Integer.parseInt(st.nextToken()));
                case "push_front" -> q.pushFront(Integer.parseInt(st.nextToken()));
                case "pop_back" -> System.out.println(q.popBack());
                case "pop_front" -> System.out.println(q.popFront());
                case "size" -> System.out.println(q.size());
                case "empty" -> System.out.println(q.empty());
                case "front" -> System.out.println(q.front());
                case "back" -> System.out.println(q.back());
            }
        }
    }
}
class Queue{
    static List<Integer> data = new ArrayList<>();

    public void pushFront(int num){
        data.add(0, num);
    }
    public void pushBack(int num){
        data.add(num);
    }
    public int popFront(){
        if (data.isEmpty())
            return -1;

        int result = data.get(0);
        data.remove(0);
        return result;
    }
    public int popBack(){
        if (data.isEmpty())
            return -1;
        int tail = data.size()-1;
        int result = data.get(tail);
        data.remove(tail);
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
