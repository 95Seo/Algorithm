package Mogacko.Graph;

public class Queue {
    private int MAX_QUEUE_SIZE = 10;
    private int queue[];
    private int head;
    private int tail;

    public Queue() {
        head = -1;
        tail = -1;
        queue = new int[MAX_QUEUE_SIZE];
    }

    boolean is_empty() {
        if (head == tail) {
            return true;
        }
        return false;
    }

    boolean is_full() {
        if ((tail + 1) % MAX_QUEUE_SIZE == head) {
            return true;
        }
        return false;
    }

    void enqueue(int item) {
        if (this.is_full()) {
            System.out.println("큐에 더이상 데이터를 넣을 수 없습니다.\n");
            return ;
        }
        tail = (tail + 1) % MAX_QUEUE_SIZE;
        queue[tail] = item;
    }

    int dequeue() {
        if (is_empty()) {
            System.out.println("큐가 비어있습니다. \n");
            return -1;
        }
        head = (head + 1) % MAX_QUEUE_SIZE;
        return queue[head];
    }
}
