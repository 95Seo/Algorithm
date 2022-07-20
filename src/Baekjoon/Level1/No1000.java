package Baekjoon.Level1;

// [문제]
// 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

// [입력]
// 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

// [출력]
// 첫째 줄에 A+B를 출력한다.

// [입력 예시]
// 1 2

// [출력 예시]
// 3

import java.util.Scanner;

public class No1000 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x, y, result = 0;

        x = s.nextInt();
        y = s.nextInt();

        result += x + y;
        System.out.println(result);
    }
}
