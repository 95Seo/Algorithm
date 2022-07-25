package Baekjoon;

// [문제]
// 눈금의 간격이 1인 M×N(M,N≤100)크기의 모눈종이가 있다. 이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때,
// 이들 K개의 직사각형의 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어진다.
// 예를 들어 M=5, N=7 인 모눈종이 위에 <그림 1>과 같이 직사각형 3개를 그렸다면, 그 나머지 영역은 <그림 2>와 같이 3개의 분리된 영역으로 나누어지게 된다.
// M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때, K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지,
// 그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 출력하는 프로그램을 작성하시오.

// [입력]
// 첫째 줄에 M과 N, 그리고 K가 빈칸을 사이에 두고 차례로 주어진다. M, N, K는 모두 100 이하의 자연수이다.
// 둘째 줄부터 K개의 줄에는 한 줄에 하나씩 직사각형의 왼쪽 아래 꼭짓점의 x, y좌표값과 오른쪽 위 꼭짓점의 x, y좌표값이 빈칸을 사이에 두고 차례로 주어진다.
// 모눈종이의 왼쪽 아래 꼭짓점의 좌표는 (0,0)이고, 오른쪽 위 꼭짓점의 좌표는(N,M)이다. 입력되는 K개의 직사각형들이 모눈종이 전체를 채우는 경우는 없다.

// [출력]
// 첫째 줄에 분리되어 나누어지는 영역의 개수를 출력한다. 둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력한다.

// [입력 예시]
// 5 7 3
// 0 2 4 4
// 1 1 2 5
// 4 0 6 2

// [출력 예시]
// 3
// 1 7 13

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class No2583 {
    static int[][] arr;
    static boolean[][] bArr;
    static int n, m, k;
    static int sX = 0, sY = 0, eX = 0, eY = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        n = s.nextInt();
        m = s.nextInt();

        arr = new int[n][m];
        bArr = new boolean[n][m];
        k = s.nextInt();

        for (int i = 0; i < k; i++) {
            sX = s.nextInt();
            sY = s.nextInt();
            eX = s.nextInt();
            eY = s.nextInt();

            for (int y = sY; y < eY; y++) {
                for (int x = sX; x < eX; x++) {
                    arr[y][x]+= arr[y][x]++;
                    bArr[y][x] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!bArr[i][j]) {
                    int result = bfs(i, j);
                    list.add(result);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    // 열, 행을 받음
    static int bfs(int row, int column) {
        int result = 1;

        bArr[row][column] = true;
        // 열
        int[] dX = {0, 1, 0, -1};
        // 행
        int[] dY = {-1, 0, 1, 0};

        for (int d = 0; d < 4; d++) {
            int nextX = column + dX[d];
            int nextY = row + dY[d];

            if (nextY >= n || nextY < 0 || nextX >= m || nextX < 0)
                continue;

            if (!bArr[nextY][nextX]) {
                result += bfs(nextY, nextX);
            }
        }

        return result;
    }
}
