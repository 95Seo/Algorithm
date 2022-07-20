package Baekjoon.Level1;

// [문제]
// 두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.

// [입력]
// 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

// [출력]
// 첫째 줄에 A/B를 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-9 이하이면 정답이다.

// [입력 예시]
// 1 3
// 4 5

// [출력 예시]
// 0.33333333333333333333333333333333
// 0.8

import java.math.BigDecimal;
import java.util.Scanner;

public class No1008 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BigDecimal x, y, result;

        x = s.nextBigDecimal();
        y = s.nextBigDecimal();

        result = x.divide(y, 9, BigDecimal.ROUND_FLOOR);
        System.out.println(result);
    }
}
