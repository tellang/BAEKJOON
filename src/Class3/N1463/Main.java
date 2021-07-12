package Class3.N1463;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt(); //1000000
        int[] arr = new int[target+1];
        if (target < 4){
            if (target == 1)
                System.out.println(0);
            else
                System.out.println(1);
        } else {
            arr[1] = 0;
            arr[2] = 1;
            arr[3] = 1;
            for (int i = 4; i < target + 1; i++) {
                int preVal = arr[i - 1];
                if (i % 2 ==0)
                    if (preVal > arr[i / 2])
                        preVal = arr[i / 2];
                if (i % 3 ==0)
                    if (preVal > arr[i / 3])
                        preVal = arr[i / 3];
                arr[i] = preVal+1;
            }
            System.out.println(arr[target]);
        }
    }
}
