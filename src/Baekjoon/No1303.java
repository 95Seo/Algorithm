package Baekjoon;

// [문제]
// 전쟁은 어느덧 전면전이 시작되었다. 결국 전투는 난전이 되었고, 우리 병사와 적국 병사가 섞여 싸우게 되었다.
// 그러나 당신의 병사들은 흰색 옷을 입고, 적국의 병사들은 파란색 옷을 입었기 때문에 서로가 적인지 아군인지는 구분할 수 있다.
// 문제는 같은 팀의 병사들은 모이면 모일수록 강해진다는 사실이다.
// N명이 뭉쳐있을 때는 N2의 위력을 낼 수 있다. 과연 지금 난전의 상황에서는 누가 승리할 것인가?
// 단, 같은 팀의 병사들이 대각선으로만 인접한 경우는 뭉쳐 있다고 보지 않는다.

// [입력]
// 첫째 줄에는 전쟁터의 가로 크기 N, 세로 크기 M(1 ≤ N, M ≤ 100)이 주어진다.
// 그 다음 두 번째 줄에서 M+1번째 줄에는 각각 (X, Y)에 있는 병사들의 옷색이 띄어쓰기 없이 주어진다.
// 모든 자리에는 병사가 한 명 있다. B는 파란색, W는 흰색이다. 당신의 병사와 적국의 병사는 한 명 이상 존재한다.

// [출력]
// 첫 번째 줄에 당신의 병사의 위력의 합과 적국의 병사의 위력의 합을 출력한다.

// [입력 예시]
// 5 5
// WBWWW
// WWWWW
// BBBBB
// BBBWW
// WWWWW

// [출력 예시]
// 130 65

import java.io.IOException;
import java.util.Scanner;

public class No1303 {
    static char[][] cArr;
    static boolean[][] bArr;
    static int n, m;
    static int wResult = 0, bResult = 0;
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dColumn = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        cArr = new char[m][n];
        bArr = new boolean[m][n];

        // ======================= 입력 =======================
        for (int i = 0; i < m; i++) {
            String input = s.next();
            for (int j = 0; j < n; j++) {
                cArr[i][j] = input.charAt(j);
            }
        }

        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                char c = cArr[row][column];
                int count = 0;
                if (!bArr[row][column])
                    count = dfs(row, column, c);

                if (c == 'W') {
                    wResult += count*count;
                } else {
                    bResult += count * count;
                }
            }
        }

        // ======================= 출력 =======================
        System.out.println(wResult + " " + bResult);
    }

    public static int dfs(int row, int column, char c) {
        int result = 1;
        bArr[row][column] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dRow[i];
            int nextColumn = column + dColumn[i];

            if (nextColumn >= n || nextColumn < 0 || nextRow >= m || nextRow < 0) {
                continue;
            }

            if (c == cArr[nextRow][nextColumn] && !bArr[nextRow][nextColumn]) {
                result += dfs(nextRow, nextColumn, c);
            }
        }

        return result;
    }
}
