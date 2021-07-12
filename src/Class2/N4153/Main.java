package Class2.N4153;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = -1;
        }
        while (true){
            for (int i = 0; i < 3; i++) {
                arr[i] = square(sc.nextInt());
            }
            if (isEnd(arr))
                return;
            if (isRightAngle(arr))
                System.out.println("right");
            else System.out.println("wrong");
        }
    }
    static boolean isEnd(int[] arr){
        for (int j : arr) {
            if (j != 0)
                return false;
        }
        return true;
    }

    static int square(int val){
        return val * val;
    }

    static boolean isRightAngle(int[] arr){
        Arrays.sort(arr);
        return (arr[0] + arr[1]) == arr[2];
    }
}
