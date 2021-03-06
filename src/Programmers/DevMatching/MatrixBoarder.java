package Programmers.DevMatching;

public class MatrixBoarder {
    static int[][] arr;
    public static void main(String[] args) {
        int rows = 6, columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        int[] result = {8, 10, 25};

        int[] solution = solution(rows, columns, queries);

        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        arr = new int[rows][columns];
        int[] answer = new int[queries.length];

        // 초기화
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                arr[i][j] = 1+(i * rows) + j;
            }
        }

        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];

            int x1 = query[1]-1;
            int y1 = query[0]-1;
            int x2 = query[3]-1;
            int y2 = query[2]-1;

            answer[i] = rotation(x1, x2, y1, y2);

            printArr(rows, columns);

        }

        return answer;
    }

    static int rotation(int x1, int x2, int y1, int y2) {
        int min = Integer.MAX_VALUE;
        int first = arr[y1][x1];
        int temp;

        // 상하좌우 움직임 나눠서 풀어보기
        // 우
        for (int i = x1; i < x2; i++) {
            min = Math.min(min, arr[y1][i]);
            temp = arr[y1][i+1];
            arr[y1][i+1] = first;
            first = temp;
        }

        // 하
        for (int i = y1; i < y2; i++) {
            min = Math.min(min, arr[i][x2]);
            temp = arr[i+1][x2];
            arr[i+1][x2] = first;
            first = temp;
        }

        // 좌
        for (int i = x2; i > x1; i--) {
            min = Math.min(min, arr[y2][i]);
            temp = arr[y2][i-1];
            arr[y2][i-1] = first;
            first = temp;
        }

        // 상
        for (int i = y2; i > y1; i--) {
            min = Math.min(min, arr[i][x1]);
            temp = arr[i-1][x1];
            arr[i-1][x1] = first;
            first = temp;
        }

        return min;
    }
    
    // 적합성 부족 리팩토링 필요
//    static int rotation(int x1, int x2, int y1, int y2) {
//        // 움직임 정의
//        int[] dx = {1, 0, -1, 0};
//        int[] dy = {0, 1, 0, -1};
//
//        int curX = x1;
//        int curY = y1;
//
//        int first = arr[curY][curX], temp;
//        int min = Integer.MAX_VALUE;
//        int idx = 0;
//
//        int nextX;
//        int nextY;
//
//        while(idx < 4) {
//            nextX = curX + dx[idx];
//            nextY = curY + dy[idx];
//
//            if(nextX < x1 || nextX > x2 || nextY > y2 || nextY < y1) {
//                idx++;
//            } else {
//                temp = arr[nextY][nextX];
//                arr[nextY][nextX] = first;
//                first = temp;
//
//                if (min > arr[curY][curX])
//                    min = arr[curY][curX];
//
//                curX = nextX;
//                curY = nextY;
//            }
//        }
//        return min;
//    }

    static void printArr(int rows, int columns) {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
