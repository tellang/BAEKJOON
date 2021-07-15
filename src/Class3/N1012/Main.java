package Class3.N1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            boolean[][] matrix = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                matrix[y][x] = true;
            }
            int count = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (matrix[y][x]) {
                        BFS(matrix, y, x);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
    public static void BFS(boolean[][] matrix, int y, int x){
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(matrix, y, x));
        while (!q.isEmpty()){
            var target = q.poll();
            if (target.isOn()){
                target.off();
                if (target.x>0)
                    q.add(new Pos(target, 0, -1));
                if (target.y>0)
                    q.add(new Pos(target, -1, 0));
                if (target.x<M-1)
                    q.add(new Pos(target, 0, +1));
                if (target.y<N-1)
                    q.add(new Pos(target, +1, 0));
            }

        }
    }
}
class Pos{
    public int x;
    public int y;
    public boolean[][] targetMatrix;
    public Pos(boolean[][] targetMatrix, int y, int x){
        this.x = x;
        this.y = y;
        this.targetMatrix = targetMatrix;
    }
    public Pos(Pos base, int yOffset, int xOffset){
        this.x = base.x+xOffset;
        this.y = base.y+yOffset;
        this.targetMatrix = base.targetMatrix;
    }
    public void off(){
        this.targetMatrix[y][x] = false;
    }
    public boolean isOn(){
        return this.targetMatrix[y][x];
    }
}
