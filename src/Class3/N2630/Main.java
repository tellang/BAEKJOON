package Class3.N2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] count = {0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        squareCount(N, 0, 0, matrix);
        System.out.println(""+count[0]+'\n'+count[1]);
    }
    private static boolean isSquare (int size, int x, int y, int[][] target){
        int sample = target[y][x];
        for (int i = y; i < y+size; i++) {
            for (int j = x; j < x+size; j++) {
                if (sample != target[i][j])
                    return false;
            }
        }
        return true;
    }
    public static void squareCount(int size, int x, int y, int[][] target){
        if (size == 1) {
            count[target[y][x]]++;
        }
        else {
            if(isSquare(size, x, y, target)){
                count[target[y][x]]++;
            }else {
                int half = size/2;
                squareCount(half, x, y, target);
                squareCount(half, half+x, y, target);
                squareCount(half, x, half+y, target);
                squareCount(half, half+x, half+y, target);
            }
        }
    }
}
