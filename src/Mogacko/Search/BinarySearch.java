package Mogacko.Search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {215, 513, 712, 803};
        int target = 10;

        int result = binarySearch(arr, target);

        System.out.printf("랜선의 최대 길이는 %d입니다.", result);
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr[arr.length-1];
        int result = 0;

        while(end >= start) {
            int sum = 0;
            int mid = (start + end) / 2;

            for (int k : arr) {
                sum += k/mid;
            }

            if (sum > target) {
                start = mid + 1;
            } else if (sum < target) {
                end = mid - 1;
            } else {
                result = mid;
                break;
            }
        }
        return result;
    }
}
