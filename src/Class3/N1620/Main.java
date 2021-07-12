package Class3.N1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
    public Dogam(){
        data = new ArrayList<>();
        data.add("");
    }
    public void add(String input){
        data.add(input);
    }
    public String getAnswer(String target){
        if (Character.isDigit(target.toCharArray()[0]))
            return getName(Integer.parseInt(target));
        else return String.valueOf(getIndex(target));
    }
    private int getIndex(String target){
        return data.indexOf(target);
    }
    private String getName(int target){
        return data.get(target);
    }
}
