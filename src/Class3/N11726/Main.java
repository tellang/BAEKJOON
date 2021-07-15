package Class3.N11726;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int[] matrix = new int[target];
        matrix[0] = 1;
        if (target>1){
            matrix[1] = 2;
            for (int i = 2; i < target; i++) {
                matrix[i] = (matrix[i-1] + matrix[i-2])%10_007;
            }
        }
        System.out.println(matrix[target-1]);
    }
}
