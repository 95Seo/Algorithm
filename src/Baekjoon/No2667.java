package Baekjoon;

// [단지번호붙이기]

// [문제]
// 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고,
// 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다.
// 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

// [입력]
// 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

// [출력]
// 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

// [입력 예시]
// 7
// 0110100
// 0110101
// 1110101
// 0000111
// 0100000
// 0111110
// 0111000

// [출력 예시]
// 3
// 7
// 8
// 9

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class No2667 {
    static int[][] arr;
    static boolean[][] move;
    static int n, totalCount = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> aptList = new ArrayList<>();

        n = s.nextInt();
        arr = new int[n][n];
        move = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = s.next();
            String[] str = input.split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.valueOf(str[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !move[i][j]) {
                    aptList.add(dfs(i, j));
                    totalCount++;
                }
            }
        }

        Collections.sort(aptList);

        System.out.println(totalCount);
        for (int result : aptList)
            System.out.println(result);
    }

    public static int dfs(int currentRow, int currentColumn) {
        int result = 1;
        int[] dRow = {-1, 0, 1, 0};
        int[] dColumn = {0, 1, 0, -1};
        move[currentRow][currentColumn] = true;

        for (int d = 0;d < 4; d++) {
            int nextRow = currentRow + dRow[d];
            int nextColumn = currentColumn + dColumn[d];

            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n)
                continue;
            if (arr[nextRow][nextColumn] != 1 || move[nextRow][nextColumn])
                continue;

            result += dfs(nextRow, nextColumn);
        }

        return result;
    }
}
