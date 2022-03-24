package Mogacko.Heap;

public class PriorityQueue3 {
    static int MAX_QUEUE_SIZE = 101;
    int[][] arr;
    int queue_count = 0;

    public PriorityQueue3() {
        this.arr = new int[MAX_QUEUE_SIZE][2];
    }

    private boolean compare_with_parent(int index) {
        if(index <= 1)
            return false;

        int parent_index = index/2;
        if (this.arr[index][0] < this.arr[parent_index][0])
            return true;
        else
            return false;
    }

    //삽입
    public boolean insert(int priority, int data) {
        int insert_index, parent, priority_tmp, data_tmp;

        this.queue_count++;
        if(this.queue_count == 1) {
            this.arr[this.queue_count][0] = priority;
            this.arr[this.queue_count][1] = data;
            return true;
        }

        this.arr[this.queue_count][0] = priority;
        this.arr[this.queue_count][1] = data;
        insert_index = this.queue_count;

        while (this.compare_with_parent(insert_index)) {
            parent = insert_index / 2;

            priority_tmp = this.arr[insert_index][0];
            this.arr[insert_index][0] = this.arr[parent][0];
            this.arr[parent][0] = priority_tmp;

            data_tmp = this.arr[insert_index][1];
            this.arr[insert_index][1] = this.arr[parent][1];
            this.arr[parent][1] = data_tmp;

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
            if (this.arr[left][0] < this.arr[right][0])
                return left;

        if (this.arr[left][0] < this.arr[right][0])
            return left;
        else
            return right;
    }

    // 추출
    public int pop() {
        int index = 1, child_index, root, terminal_priority, terminal_data, priority_tmp, data_tmp;
        root = this.arr[1][0];

        terminal_priority = this.arr[this.queue_count][0];
        this.arr[this.queue_count][0] = -1;
        this.arr[1][0] = terminal_priority;

        terminal_data = this.arr[this.queue_count][1];
        this.arr[this.queue_count][1] = -1;
        this.arr[1][1] = terminal_data;
        this.queue_count--;

        while (true) {
            child_index = compare_with_child(index);
            if(child_index == 0)
                break;

            priority_tmp = this.arr[child_index][0];
            this.arr[child_index][0] = this.arr[index][0];
            this.arr[index][0] = priority_tmp;

            data_tmp = this.arr[child_index][1];
            this.arr[child_index][1] = this.arr[index][1];
            this.arr[index][1] = data_tmp;

            index = child_index;
        }

        return root;
    }
}
