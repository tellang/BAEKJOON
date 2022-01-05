package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class N1918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String infix = br.readLine();
        getPostfix(infix);
    }

    public static void getPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> level = new HashMap<>();
        level.put('(', -1);
        level.put('+', 0);
        level.put('-', 0);
        level.put('*', 1);
        level.put('/', 1);
        level.put(')', 2);

        StringBuilder sb = new StringBuilder();
        for (var c : infix.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                sb.append(c);
            } else {
                if (c == '(')
                    stack.push(c);
                else {
                    if (stack.isEmpty())
                        stack.push(c);
                    else {
                        if (level.get(stack.peek()) > level.get(c)) {
                            popAll(stack, sb);
                        }
                        if (c != ')')
                            stack.push(c);
                    }
                }
            }
        }
        if (!stack.isEmpty())
            popAll(stack, sb);
        System.out.println(sb);
    }

    private static void popAll(Stack<Character> stack, StringBuilder sb) {
        do {
            char opr = stack.pop();
            if (opr != '(')
                sb.append(opr);
        } while (!stack.isEmpty());
    }
}
