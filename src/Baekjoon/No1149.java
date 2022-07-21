package Baekjoon;

// [문제]
// RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
// 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
//      1번 집의 색은 2번 집의 색과 같지 않아야 한다.
//      N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
//      i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

// [입력]
// 첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로
// 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.

// [출력]
// 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.

// [입력 예시]
// 3
// 26 40 83
// 49 60 57
// 13 89 99

// [출력 예시]
// 96

// [입력 예시]
// 3
// 1 100 100
// 100 1 100
// 100 100 1

// [출력 예시]
// 3

// [입력 예시]
// 3
// 1 100 100
// 100 100 100
// 1 100 100

// [출력 예시]
// 102

// [입력 예시]
// 6
// 30 19 5
// 64 77 64
// 15 19 97
// 4 71 57
// 90 86 84
// 93 32 91

// [출력 예시]
// 208

// [입력 예시]
// 8
// 71 39 44
// 32 83 55
// 51 37 63
// 89 29 100
// 83 58 11
// 65 13 15
// 47 25 29
// 60 66 19

// [출력 예시]
// 253

import java.util.Scanner;

//
public class No1149 {
    static int[][] rgb;
    static boolean[] houseCheck;
    static int[] colorCheck;
    static int n;
    static int sum = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int target = 0;

        n = s.nextInt();

        rgb = new int[n][3];
        houseCheck = new boolean[n];
        colorCheck = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = s.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            target = search(target);
        }
        System.out.println(sum);
    }

    public static int search(int target) {
        int min = Integer.MAX_VALUE, color = 0, house = 0;

        for (int i = 0; i < n; i++) {
            if (!houseCheck[i]) {
                for (int j = 0; j < 3; j++) {
                    if ((i > 0 && i < n-1) && houseCheck[i-1] && houseCheck[i+1] && colorCheck[i-1] != colorCheck[i+1]) {
                        if (j != colorCheck[i-1] && j != colorCheck[i+1]) {
                            houseCheck[i] = true;
                            colorCheck[i] = j;
                            sum += rgb[i][j];
                            return target;
                        }
                    } else if((i > 0) && houseCheck[i-1]) {
                        if (j != colorCheck[i-1] && rgb[i][j] >= target && min > rgb[i][j]) {
                            min = rgb[i][j];
                            house = i;
                            color = j;
                        }
                    } else if ((i < n-1) && houseCheck[i+1]) {
                        if (j != colorCheck[i+1] && rgb[i][j] >= target && min > rgb[i][j]) {
                            min = rgb[i][j];
                            house = i;
                            color = j;
                        }
                    } else {
                        if (rgb[i][j] >= target && min > rgb[i][j]) {
                            min = rgb[i][j];
                            house = i;
                            color = j;
                        }
                    }
                }
            }
        }

        houseCheck[house] = true;
        colorCheck[house] = color;
        sum += rgb[house][color];
        return min;
    }
}
