package Mogacko.Heap;

public class PriorityQueue2 {
    static int MAX_QUEUE_SIZE = 101;
    QueueNode[] arr;
    int queue_count = 0;

    public PriorityQueue2() {
        this.arr = new QueueNode[MAX_QUEUE_SIZE];
    }

    private boolean compare_with_parent(int index) {
        if(index <= 1)
            return false;

        int parent_index = index/2;
        if (this.arr[index].priority < this.arr[parent_index].priority)
            return true;
        else
            return false;
    }

    //삽입
    public boolean insert(QueueNode data) {
        QueueNode tmp;
        int insert_index, parent;

        this.queue_count++;
        if(this.queue_count == 1) {
            this.arr[this.queue_count] = data;
            return true;
        }

        this.arr[this.queue_count] = data;
        insert_index = this.queue_count;

        while (this.compare_with_parent(insert_index)) {
            parent = insert_index / 2;
            tmp = this.arr[insert_index];
            this.arr[insert_index] = this.arr[parent];
            this.arr[parent] = tmp;

            insert_index = parent;
        }
        return true;
    }

    private int compare_with_child (int index) {
        int left, right;
        left = 2 * index; right = 2 * index + 1;

        if(left >= this.queue_count && right >= this.queue_count)
            return 0;

        if (right >= this.queue_count)
            if (this.arr[left].priority < this.arr[right].priority)
                return left;

        if (this.arr[left].priority < this.arr[right].priority)
            return left;
        else
            return right;
    }

    // 추출
    public int pop() {
        QueueNode root, terminal_data, tmp;
        int index = 1, child_index;
        root = this.arr[1];
        terminal_data = this.arr[this.queue_count];
        this.arr[this.queue_count] = null;
        this.arr[1] = terminal_data;
        this.queue_count--;

        while (true) {
            child_index = compare_with_child(index);
            if (child_index == 0)
                break;

            tmp = this.arr[child_index];
            this.arr[child_index] = this.arr[index];
            this.arr[index] = tmp;

            index = child_index;
        }
        return root.priority;
    }
}
