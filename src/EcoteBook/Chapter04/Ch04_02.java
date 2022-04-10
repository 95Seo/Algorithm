package EcoteBook.Chapter04;

import java.util.Scanner;

// 시각
// 정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성하시오.
// 완전탐색 문제

// [입력 조건]
// 첫째 줄에 정수 N이 입력된다. (0 <= N <= 23)

// [출력 조건]
// 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 출력한다.

// [입력 예시]
// 5

// [출력 예시]
// 11475
public class Ch04_02 {
    public static void main(String[] args) {
        // 시간을 입력 받는 것이기 때문에 시간 이외에 모든 조건은 동일하다
        // 1시간에 [3이들어가는 시간의 수 * N] 하면 될 것
        // 단 0부터 N까지 시간 중 3의 배수가 있다면 [60 * 60]
        int N;
        int result = 0, count = 0;
        String K = "3";
        Scanner s = new Scanner(System.in);

        // 1시간 중 3이 들어가는 시간의 수 측정
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 60; j++) {
                String time = String.valueOf(i) + String.valueOf(j);
                if (time.contains(K))
                    count++;
            }
        }

        System.out.print("정수 N을 입력해 주세요(0 <= N <= 23) : ");
        N = s.nextInt();

        for (int i = 0; i <= N; i++) {
            String time = String.valueOf(i);
            if (time.contains(K))
                result += 60*60;
            else
                result += count;
        }

        System.out.println("00시 00분 00초 부터 " + N + "시 59분 59초 까지 중 3이 들어가는 경우의 수는 " + result + "입니다.");
    }
}
