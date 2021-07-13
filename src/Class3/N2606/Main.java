package Class3.N2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] isVisit;
    private static boolean[][] map;
    static int N;
    static int counter = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine())+1;
        isVisit = new boolean[N];
        map = new boolean[N][N];
        int M= Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            map[left][right] = true;
            map[right][left] = true;
        }
        BFS(1);
        System.out.println(counter);
    }
    public static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            int visitTarget = queue.poll();
            if (!isVisit[visitTarget]){
                isVisit[visitTarget] = true;
                counter++;
                for (int i = 1; i < N; i++) {
                    if (map[visitTarget][i])
                        queue.add(i);
                }
            }
        }
    }
}
