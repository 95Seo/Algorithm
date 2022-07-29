package Baekjoon;

// [안전 영역]

// [문제]
// 재난방재청에서는 많은 비가 내리는 장마철에 대비해서 다음과 같은 일을 계획하고 있다. 먼저 어떤 지역의 높이 정보를 파악한다.
// 그 다음에 그 지역에 많은 비가 내렸을 때 물에 잠기지 않는 안전한 영역이 최대로 몇 개가 만들어 지는 지를 조사하려고 한다.
// 이때, 문제를 간단하게 하기 위하여, 장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다고 가정한다.
// 어떤 지역의 높이 정보는 행과 열의 크기가 각각 N인 2차원 배열 형태로 주어지며 배열의 각 원소는 해당 지점의 높이를 표시하는 자연수이다.
// 예를 들어, 다음은 N=5인 지역의 높이 정보이다.

// [입력]
// 첫째 줄에는 어떤 지역을 나타내는 2차원 배열의 행과 열의 개수를 나타내는 수 N이 입력된다.
// N은 2 이상 100 이하의 정수이다. 둘째 줄부터 N개의 각 줄에는 2차원 배열의 첫 번째 행부터 N번째 행까지
// 순서대로 한 행씩 높이 정보가 입력된다. 각 줄에는 각 행의 첫 번째 열부터 N번째 열까지 N개의 높이 정보를 나타내는
// 자연수가 빈 칸을 사이에 두고 입력된다. 높이는 1이상 100 이하의 정수이다.

// [출력]
// 첫째 줄에 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 출력한다.

// [입력 예시]
// 5
// 6 8 2 6 2
// 3 2 3 4 6
// 6 7 3 3 2
// 7 2 5 3 6
// 8 9 5 2 7

// [출력 예시]
// 5

// [입력 예시]
// 7
// 9 9 9 9 9 9 9
// 9 2 1 2 1 2 9
// 9 1 8 7 8 1 9
// 9 2 7 9 7 2 9
// 9 1 8 7 8 1 9
// 9 2 1 2 1 2 9
// 9 9 9 9 9 9 9

// [출력 예시]
// 6

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 속도가 느릴거 같단 말이지..
public class No2468 {
    static int[][] arr;
    static boolean[][] bArr;
    static int n, m = 0, max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        arr = new int[n][n];

        // 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int input = s.nextInt();
                arr[i][j] = input;
                if (m < input)
                    m = input;
            }
        }

        for (int i = 0; i <= m; i++) {
            int count;
            bArr = new boolean[n][n];

            if (i == 0 || i == m) {
                count = 1;
            }
            else {
                setFlooding(i);
                count = dfs();
            }

            if (count > max)
                max = count;
        }

        System.out.println(max);
    }

    static void setFlooding(int target) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] <= target)
                    bArr[i][j] = true;
            }
        }
    }

    static int dfs() {
        int count = 0;
        int[] dRow = {-1, 0, 1, 0};
        int[] dColumn = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 알고리즘 실행
                if (!bArr[i][j]) {
                    count++;
                    int[] currentPoint = {i , j};
                    queue.add(currentPoint);
                    while (!queue.isEmpty()) {
                        currentPoint = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nextRow = currentPoint[0] + dRow[k];
                            int nextColumn = currentPoint[1] + dColumn[k];

                            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n)
                                continue;
                            if (bArr[nextRow][nextColumn])
                                continue;

                            bArr[nextRow][nextColumn] = true;
                            int[] nextPoint = {nextRow, nextColumn};
                            queue.add(nextPoint);
                        }
                    }

                }
            }
        }

        return count;
    }
}
