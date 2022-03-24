package Mogacko.Heap;

public class Heap_Ex {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(1);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.insert(9);
        heap.insert(10);
        heap.insert(11);

        System.out.println(heap.pop());

        for (int i = 1; i < heap.heap_count+1; i++) {
            System.out.print(heap.arr[i] + " ");
        }

        System.out.println();

        System.out.println(heap.pop());

        for (int i = 1; i < heap.heap_count+1; i++) {
            System.out.print(heap.arr[i] + " ");
        }
    }
}
