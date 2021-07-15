package Class3.N11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] isVisit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] matrix = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            matrix[left][right] = true;
            matrix[right][left] = true;
        }
        int result = 0;
        int visitIndex = 1;
        isVisit = new boolean[N+1];
        isVisit[0] = true;
        while (visitIndex != -1){
            BFS(matrix, visitIndex);
            visitIndex = getUnvisitedVertex();
            result++;
        }
        System.out.println(result);
    }
    public static void BFS(boolean[][] matrix, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()){
            int targetVertex = q.poll();
            if (!isVisit[targetVertex]){
                isVisit[targetVertex] = true;
                for (int i = 0; i <= N; i++) {
                    if (matrix[targetVertex][i])
                        q.add(i);
                }
            }
        }
    }
    public static int getUnvisitedVertex(){
        for (int i = 0; i <= N; i++) {
            if (!isVisit[i])
                return i;
        }
        return -1;
    }
}
