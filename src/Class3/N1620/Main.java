package Class3.N1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Dogam dogam = new Dogam();
        for (int i = 0; i < N; i++) {
            dogam.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            sb.append(dogam.getAnswer(br.readLine())).append('\n');
        }
        System.out.println(sb);
    }
}
class Dogam{
    private List<String> data;
    private Map<String, Integer> map;
    int index = 1;
    public Dogam(){
        data = new ArrayList<>();
        data.add("");
        map = new HashMap<>();
    }
    public void add(String input){
        data.add(input);
        map.put(input, index++);
    }
    public String getAnswer(String target){
        try {
            int num = Integer.parseInt(target);
            return getName(num);
        }catch (Exception e){
            return String.valueOf(getIndex(target));
        }
    }
    private int getIndex(String target){
        return map.get(target);
    }
    private String getName(int target){
        return data.get(target);
    }
}
