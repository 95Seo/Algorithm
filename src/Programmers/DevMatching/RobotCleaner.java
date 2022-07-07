package Programmers.DevMatching;

// int n은 배열의 넓이
// flag가 true면 수평 시작, false면 수직 시작

// [입력 예시] n = 5, flag = true
// [출력 예시]
// 1  2  9  10 25
// 4  3  8  11 24
// 5  6  7  12 23
// 16 15 14 13 22
// 17 18 19 20 21

// [입력 예시] n = 5, flag = false
// [출력 예시]
// 1  4  5  16 17
// 2  3  6  15 18
// 9  8  7  14 19
// 10 11 12 13 20
// 25 24 23 22 21
public class RobotCleaner {
    public static void main(String[] args) {
        int n = 5;
        boolean flag = true;
        int[][] answer = solution(n, flag);

        // 출력 확인
        for (int[] i : answer) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solution(int n, boolean flag) {
        int[][] answer = new int[n][n];
        int[] trueMoveR = {0, 1, 0, 1, 0, -1};
        int[] trueMoveC = {1, 0, -1, 0, 1, 0};
        int[] falseMoveR = {1, 0, -1, 0, 1, 0};
        int[] falseMoveC = {0, 1, 0, 1, 0, -1};
        int num = 1, count = 0;
        int row = 0, column = 0;

        while (num <= (n*n)) {
            answer[row][column] = num;
            if (flag) {
                column += trueMoveC[count%trueMoveR.length];
                row += trueMoveR[count%trueMoveR.length];
            } else {
                column += falseMoveC[count%trueMoveR.length];
                row += falseMoveR[count%trueMoveR.length];
            }
            if (column ==0 || row == 0 || column == row)
                count++;
            num++;
        }

        return answer;
    }
}
