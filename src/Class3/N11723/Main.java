package Class3.N11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        MySet ms = new MySet();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "add" -> ms.add(Integer.parseInt(st.nextToken()));
                case "remove" -> ms.remove(Integer.parseInt(st.nextToken()));
                case "check" -> sb.append(ms.check(Integer.parseInt(st.nextToken()))).append('\n');
                case "toggle" -> ms.toggle(Integer.parseInt(st.nextToken()));
                case "all" -> ms.all();
                case "empty" -> ms.empty();
            }
        }
        System.out.println(sb);
    }
}
class MySet {
    private Set<Integer> data;
    public MySet(){
        data = new HashSet<>();
    }
    public int check(int target){
        if (data.contains(target))
            return 1;
        else return 0;
    }
    public void all(){
        data = new HashSet<>();
        for (int i = 20; i > 0; i--) {
            data.add(i);
        }
    }
    public void add (int input){
        data.add(input);
    }
    public void remove (int target){
        data.remove(target);
    }
    public void toggle(int target){
        if (data.contains(target))
            data.remove(target);
        else
            data.add(target);
    }
    public void empty(){
        data = new HashSet<>();
    }
}