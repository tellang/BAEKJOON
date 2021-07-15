package Class3.N11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Heap heap = new Heap(N);
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num==0)
                sb.append(heap.getMax()).append('\n');
            else
                heap.add(num);
        }
        System.out.println(sb);
    }
}
class Heap{
    int[] data;
    int maxSize;
    int nextIndex;
    public Heap(int maxSize){
        this.maxSize = maxSize;
        data = new int[maxSize];
        nextIndex = 0;
    }
    public void add(int num){
        data[nextIndex] = num;
        shiftUp(nextIndex++);
    }
    public int getMax(){
        int max = data[0];
        data[0] = 0;
        if (nextIndex==0)
            return 0;
        swapData(0, nextIndex-1);
        shiftDown(0);
        nextIndex--;
        return max;
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
        int left = getLeftChildIndex(parent);
        int right = getRightChildIndex(parent);
        int maxChild;
        if (data[left] > data[right])
            maxChild = left;
        else maxChild = right;
        if (!hasChild(parent))
            return -1;
        if (data[parent]<data[maxChild]) {
            swapData(maxChild, parent);
            return maxChild;
        }
        return -1;
    }
    private boolean hasChild(int parent){
        int left =getLeftChildIndex(parent);
        int right = getRightChildIndex(parent);

        return !(data[left]==0)&&(data[right] == 0);
    }
    private int getLeftChildIndex(int parent){
        return 2*(parent+1)-1;
    }
    private int getRightChildIndex(int parent){
        return 2*(parent+1);
    }
    private int getParentIndex(int child){
        if (child==0)
            return -1;
        return (child-1)/2;
    }

}
