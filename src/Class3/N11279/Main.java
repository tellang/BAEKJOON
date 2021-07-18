package Class3.N11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Heap heap = new Heap(N);
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num==0)
                sb.append(heap.pop()).append('\n');
            else
                heap.add(num);
        }
        System.out.println(sb);
    }
}
class Heap{
    int[] data;
    int maxSize;
    int next;
    int head = 0;
    public Heap(int maxSize){
        this.maxSize = maxSize;
        data = new int[maxSize];
        next = 0;
    }
    public void add(int num){
        data[next] = num;
        shiftUp(next++);
    }
    public int pop(){
        if (isEmpty())
            return 0;
        int max = data[head];
        data[head] = 0;
        int min = next - 1;
        swapData(head, min);
        shiftDown(head);
        next--;
        return max;
    }

    private boolean isEmpty() {
        return next ==0;
    }

    private void shiftDown(int startIndex){
        if (startIndex==-1)
            return;
        shiftDown(swapToLargeChild(startIndex));
    }
    private void shiftUp(int startIndex){
        int target = startIndex;
        int targetParent = getParentIndex(target);
        while (targetParent!=-1&&data[target]>data[targetParent]){
            swapData(target, targetParent);
            target = targetParent;
            targetParent = getParentIndex(target);
        }
    }
    private void swapData(int aIndex, int bIndex){
        int temp = data[aIndex];
        data[aIndex] = data[bIndex];
        data[bIndex] = temp;
    }
    private int swapToLargeChild(int parent){
        int maxChild = getMaxChildIndex(parent);
        if (maxChild == -1)
            return -1;

        if (data[parent]<data[maxChild]) {
            swapData(maxChild, parent);
            return maxChild;
        }
        return -1;
    }

    private int getMaxChildIndex(int parent) {
        int left = getLeftChildIndex(parent);
        int right = getRightChildIndex(parent);
        int maxChild;

        if (right >= maxSize){
            if (left >= maxSize)
                return -1;
            else
                return left;
        }

        if (data[left] > data[right])
            maxChild = left;
        else if ((data[left] == data[right])&&(data[left] == 0))
            maxChild = -1;
        else
            maxChild = right;
        return maxChild;
    }

    private int getLeftChildIndex(int parent){
        return 2*(parent+1)-1;
    }
    private int getRightChildIndex(int parent){
        return 2*(parent+1);
    }
    private int getParentIndex(int child){
        if (child== head)
            return -1;
        return (child-1)/2;
    }

}
