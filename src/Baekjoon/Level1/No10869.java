package Baekjoon.Level1;

// [문제]
// 두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오.

// [입력]
// 두 자연수 A와 B가 주어진다. (1 ≤ A, B ≤ 10,000)

// [출력]
// 첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력한다.

// [입력 예시]
// 7 3

// [출력 예시]
// 10
// 4
// 21
// 2
// 1

import java.math.BigDecimal;
import java.util.Scanner;

public class No10869 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BigDecimal x, y, result;

        x = s.nextBigDecimal();
        y = s.nextBigDecimal();

        result = x.add(y);
        System.out.println(result);
        result = x.subtract(y);
        System.out.println(result);
        result = x.multiply(y);
        System.out.println(result);
        result = x.divideToIntegralValue(y);
        System.out.println(result);;
        result = x.remainder(y);
        System.out.println(result);
    }
}
