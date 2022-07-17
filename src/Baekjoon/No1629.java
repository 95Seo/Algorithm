package Baekjoon;

// [문제]
// 자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.

// [입력]
// 첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.

// [출력]
// 첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.

// [입력 예시]
// 10 11 12

// [출력 예시]
// 4

import java.math.BigDecimal;
import java.util.Scanner;

// 분할 정복을 이용한 거듭제곱 문제
public class No1629 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BigDecimal a, b, c;
        BigDecimal result;

        a = s.nextBigDecimal();
        b = s.nextBigDecimal();
        c = s.nextBigDecimal();
        BigDecimal k = fpow(a, b);

        result = k.remainder(c);
        System.out.println(result);
    }

    public static BigDecimal fpow(BigDecimal a, BigDecimal b) {
        if (b.compareTo(BigDecimal.ONE) == 0)
            return a;

        BigDecimal x = fpow(a, b.divideToIntegralValue(BigDecimal.valueOf(2)));

        if (b.remainder(BigDecimal.valueOf(2)).compareTo(BigDecimal.ONE) == 0 ) {
            return x.multiply(x);
        } else {
            return x.multiply(x).multiply(a);
        }
    }
}
