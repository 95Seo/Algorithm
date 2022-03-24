package Mogacko.Heap;

// 최소 힙(부모 노드가 가장 작은 힙) 구현
public class Heap {
    static int MAX_HEAP_SIZE = 101;
    int[] arr;
    int heap_count = 0;

    public Heap() {
        this.arr = new int[MAX_HEAP_SIZE];
    }

    // 부모 노드 값이 더 크면 true
    private boolean compare_with_parent(int index) {
        if(index <= 1)
            return false;

        int parent_index = index/2;
        if(this.arr[index] < this.arr[parent_index])
            return true;
        else
            return false;
    }

    // 삽입
    public boolean insert(int data) {
        int insert_index, parent, tmp;

        this.heap_count++;
        if(this.heap_count == 1) {
            this.arr[this.heap_count] = data;
            return true;
        }

        this.arr[this.heap_count] = data;
        insert_index = this.heap_count;

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
        // left 노드 index = 부모 노드 index * 2
        // right 노드 index = 부모 노드 index * 2 + 1
        int left, right;
        left = 2 * index; right = 2 * index + 1;

        if(left >= this.heap_count && right >= this.heap_count)
            return 0;

        if(right >= this.heap_count)
            if(this.arr[left] < this.arr[right])
                return left;

        if (this.arr[left] < this.arr[right])
            return left;
        else
            return right;
    }

    // 추출
    public int pop() {
        int index = 1, child_index, root, terminal_data, tmp;
        root = this.arr[1];
        terminal_data = this.arr[this.heap_count];
        this.arr[this.heap_count] = -1;
        this.arr[1] = terminal_data;
        this.heap_count--;

        while (true) {
            child_index = compare_with_child(index);
            if (child_index == 0)
                break;

            tmp = this.arr[child_index];
            this.arr[child_index] = this.arr[index];
            this.arr[index] = tmp;

            index = child_index;
        }
        return root;
    }
}
