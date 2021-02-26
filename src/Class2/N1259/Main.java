package Class2.N1259;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine();
        while (!target.equals("0")){
            Queue<String> queue = new LinkedList<>();
            Stack<String> stack = new Stack<>();
            String result = "yes";

            for (int i = 0; i < target.length(); i++) {
                queue.add(target.substring(i, i+1));
                stack.push(target.substring(i, i+1));
            }
            for (int i = 0; i < target.length(); i++) {
                if (!Objects.equals(queue.poll(), stack.pop())){
                    result = "no";
                    break;
                }
            }
            System.out.println(result);
            target = scanner.nextLine();
        }
    }
}
