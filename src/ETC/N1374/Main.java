package ETC.N1374;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Lecture> q = new PriorityQueue<>(((o1, o2) -> {
            if (o1.endTime == o2.endTime)
                return o1.startTime - o2.startTime;
            return o1.endTime - o2.endTime;
        })) {
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                while (!isEmpty()) {
                    sb.append(poll()).append("\n");
                }
                return sb.toString();
            }
        };
        Queue<Stack<Lecture>> stacks = new PriorityQueue<>(((o1, o2) ->
            o2.peek().endTime - o1.peek().endTime));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken(); // ignore index
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            var lecture = new Lecture(startTime, endTime);

            q.add(lecture);
        }
        stacks.add(new Stack<>());
        while (!q.isEmpty()) {
            boolean isFull = true;
            var lecture = q.poll();
            for (var stack : stacks) {
                if (stack.isEmpty()) {
                    stack.push(lecture);
                    isFull = false;
                } else if (stack.peek().endTime <= lecture.startTime) {
                    stack.push(lecture);
                    isFull = false;
                    break;
                }
            }
            if (isFull) {
                var newStack = new Stack<Lecture>();
                newStack.add(lecture);
                stacks.add(newStack);
//                System.out.println("stacks = " + stacks);
            }
        }

        System.out.println(stacks.size());
    }
}

class Lecture {

    int startTime, endTime;

    public Lecture(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Lecture{" +
            "startTime=" + startTime +
            ", endTime=" + endTime +
            '}';
    }
}
