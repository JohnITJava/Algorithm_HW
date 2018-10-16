package Lesson3;

public class PriorityQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int size;
    private int items;

    public PriorityQueue(int size) {
        this.size = size;
        this.queue = new int[size];
        head = 0;
        tail = -1;
        items = 0;
    }

    public void insert(int i){
        if (isFull()){
            size *= 2;
            int[] temp = new int [size];
            System.arraycopy(queue, 0, temp, 0, queue.length);
            queue = temp;
        }
        queue[++tail] = i;
        this.items++;
        if (items >= 2) sortInsert();
    }

    public int remove(){
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        int temp = queue[head];
        System.arraycopy(queue, 1, queue, 0, items - 1);
        this.items--;
        return temp;
    }

    public void sortInsert(){
        int in;
        for (int out = 0; out < items; out++) {
            int temp = queue[out];
            in = out;
            while (in > 0 && queue[in - 1] >= temp){
                queue[in] = queue[in - 1];
                in--;
            }
            queue[in] = temp;
        }
    }

    public boolean isEmpty(){
        return items == 0;
    }

    public boolean isFull(){
        return items == size;
    }

    public int length(){
        return items;
    }

    public int peek(){
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return queue[head];
    }
}
