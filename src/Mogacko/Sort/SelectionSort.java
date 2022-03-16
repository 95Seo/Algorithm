package Mogacko.Sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {9, 6, 7, 3, 5};

        System.out.println("before : " + Arrays.toString(arr));

        selectionSort(arr);

        System.out.println("after  : " + Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {

        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
            System.out.printf("swap_%d : " + Arrays.toString(arr) + "\n", i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int buffer;
        buffer = arr[j];
        arr[j] = arr[i];
        arr[i] = buffer;
    }
}
