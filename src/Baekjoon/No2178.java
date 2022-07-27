package Baekjoon;

// [문제]
// N×M크기의 배열로 표현되는 미로가 있다.
// 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
// 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸
// 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
// 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

// [입력]
// 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다.
// 각각의 수들은 붙어서 입력으로 주어진다.

// [출력]
// 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

// [입력 예시]
// 4 6
// 101111
// 101010
// 101011
// 111011

// [출력 예시]
// 15

// [입력 예시]
// 4 6
// 110110
// 110110
// 111111
// 111101

// [출력 예시]
// 9

// [입력 예시]
// 2 25
// 1011101110111011101110111
// 1110111011101110111011101

// [출력 예시]
// 38

// [입력 예시]
// 7 7
// 1011111
// 1110001
// 1000001
// 1000001
// 1000001
// 1000001
// 1111111

// [출력 예시]
// 13

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No2178 {
    static int[][] maze;
    static int[][] move;
    static int n,m;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input;

        n = s.nextInt();
        m = s.nextInt();

        maze = new int[n][m];
        move = new int[n][m];

        // 초기화
        for (int i = 0; i < n; i++) {
            input = s.next();
            String[] str = input.split("");
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.valueOf(str[j]);
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        // 상하좌우
        int[] nextMove = {0,0};
        move[0][0] = 1;
        int[] dRow = {-1, 0, 1, 0};
        int[] dColumn = {0, 1, 0, -1};
        int currentRow, currentColumn, nextRow, nextColumn;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(nextMove);
        while (!queue.isEmpty()) {
            nextMove = queue.poll();
            currentRow = nextMove[0];
            currentColumn = nextMove[1];

            for (int i = 0; i < 4; i++) {
                nextRow = currentRow + dRow[i];
                nextColumn = currentColumn + dColumn[i];

                if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= m) {
                    continue;
                }
                if (maze[nextRow][nextColumn] == 0) {
                    continue;
                }
                if (move[nextRow][nextColumn] != 0) {
                    continue;
                }
                if (nextRow == n-1 && nextColumn == m-1) {
                    return move[currentRow][currentColumn]+1;
                }

                move[nextRow][nextColumn] = move[currentRow][currentColumn]+1;
                int[] arr = {nextRow, nextColumn};
                queue.add(arr);
            }
        }
        return 0;
    }
}
