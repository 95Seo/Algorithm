package Mogacko.Recursion;

public class BinarySearch_Recursion {
    public static void main(String[] args) {
        int[] arr = {215, 513, 712, 803};
        int target = 10;
        int start = 0;
        int end = arr[arr.length-1];

        int result = binarySearch(arr, target, start, end);

        System.out.printf("랜선의 최대 길이는 %d입니다.", result);
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        int sum = 0;
        int mid = (start + end) / 2;

        for(int k : arr)
            sum += k/mid;

        if (sum == target)
            return mid;

        if (sum > target)
            return binarySearch(arr, target, mid + 1, end);
        else
            return binarySearch(arr, target, start, mid - 1);
    }
}