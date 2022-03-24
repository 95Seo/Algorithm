package Mogacko.Heap;

// 힙을 이용한 우선 순위 큐 구현
// priority = 우선 순위
// data = 값
public class PriorityQueue1 {
    static int MAX_QUEUE_SIZE = 101;
    int[] priority_arr;
    String[] data_arr;
    int queue_count = 0;

    public PriorityQueue1() {
        this.priority_arr = new int[MAX_QUEUE_SIZE];
        this.data_arr = new String[MAX_QUEUE_SIZE];
    }

    private boolean compare_with_parent(int index) {
        if(index <= 1)
            return false;

        int parent_index = index/2;
        if (this.priority_arr[index] < this.priority_arr[parent_index])
            return true;
        else
            return false;
    }

    //삽입
    public boolean insert(int priority, String data) {
        int insert_index, parent, priority_tmp;
        String data_tmp;

        this.queue_count++;
        if(this.queue_count == 1) {
            this.data_arr[this.queue_count] = data;
            this.priority_arr[this.queue_count] = priority;
            return true;
        }

        this.data_arr[this.queue_count] = data;
        this.priority_arr[this.queue_count] = priority;
        insert_index = this.queue_count;

        while (this.compare_with_parent(insert_index)) {
            parent = insert_index / 2;
            data_tmp = this.data_arr[insert_index];
            this.data_arr[insert_index] = this.data_arr[parent];
            this.data_arr[parent] = data_tmp;

            priority_tmp = this.priority_arr[insert_index];
            this.priority_arr[insert_index] = this.priority_arr[parent];
            this.priority_arr[parent] = priority_tmp;

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
            if (this.priority_arr[left] < this.priority_arr[right])
                return left;

        if (this.priority_arr[left] < this.priority_arr[right])
            return left;
        else
            return right;
    }

    // 추출
    public int pop() {
        int index = 1, child_index, root, terminal_priority, priority_tmp;
        String terminal_data, data_tmp;
        root = this.priority_arr[1];

        terminal_priority = this.priority_arr[this.queue_count];
        this.priority_arr[this.queue_count] = -1;
        this.priority_arr[1] = terminal_priority;

        terminal_data = this.data_arr[this.queue_count];
        this.data_arr[this.queue_count] = null;
        this.data_arr[1] = terminal_data;
        this.queue_count--;

        while (true) {
            child_index = compare_with_child(index);
            if(child_index == 0)
                break;

            data_tmp = this.data_arr[child_index];
            this.data_arr[child_index] = this.data_arr[index];
            this.data_arr[index] = data_tmp;

            priority_tmp = this.priority_arr[child_index];
            this.priority_arr[child_index] = this.priority_arr[index];
            this.priority_arr[index] = priority_tmp;

            index = child_index;
        }

        return root;
    }
}
