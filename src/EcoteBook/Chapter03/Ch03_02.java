package EcoteBook.Chapter03;

import java.util.Arrays;
import java.util.Scanner;

// 큰 수의 법칙
// 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙
// 단, 배열의 특정한 인덱스에 해당하는 수가 연속해서 K번 초과하여 더해질 수 없다.

// [입력 조건]
// 첫째 줄에 N(2 <= N <= 1,000), M(1 <= M <= 10,000), K(1 <= K <= 10,000)의 자연수가 주어지며, 각 자연수는 공백으로 구분한다.
// 둘째 줄에 N개의 자연수가 주어진다. 각 자연수는 공백으로 구분한다. 단 각각의 자연수는 1이상 10,000이하의 수로 주어진다.
// 입력으로 주어지는 K는 항상 M보다 작거나 같다.

// [출력 조건]
// 첫째 줄에 공빈이의 큰 수의 법칙에 따라 더해진 답을 출력한다.

// [입력 예시]
// 5 8 3
// 2 4 5 4 6

// [출력 예시]
// 46
public class Ch03_02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = 0, M = 0, K = 0;

        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        System.out.println("N(2 <= N <= 1,000), M(1 <= M <= 10,000), K(1 <= K <= 10,000)를 입력해 주세요");
        N = setN(s);
        M = setMK(s);
        K = setMK(s);

        // N개의 배열 생성
        int[] data = new int[N];

        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        System.out.println(N + "개의 자연수를 입력해 주세요");
        for(int i = 0; i < N; i++) {
            data[i] = s.nextInt();
        }

        sort(data);  // 입력받은 수를 정렬하기
//        Arrays.sort(data);
        System.out.println("정렬 결과");
        toString(data);

        int first = data[N-1];  // 가장 큰 수
        int second = data[N-2]; // 두 번째 큰 수

        // 가장 큰 수가 더해지는 횟수 계산
        int count = (M / (K + 1)) * K;
        count += M % (K + 1);

        int result = 0;
        result += count * first;    // 가장 큰 수 더하기
        result += (M - count) * second; // 두 번째로 큰 수 더하기

        System.out.println("큰 수의 법칙에 따라 더해진 답 : " + result);
    }

    private static int setN(Scanner s) {
        int temp = s.nextInt();

        if (temp < 2 || temp > 1000) {
            System.out.println("정수 N은 2 <= N <= 1,000 범위 안의 정수 여야 합니다.");
            System.out.println("다시 입력해 주세요.");
            return setN(s);
        }
        return temp;
    }

    private static int setMK(Scanner s) {
        int temp = s.nextInt();

        if (temp < 1 || temp > 10000) {
            System.out.println("정수 M은 2 <= M <= 1,0000 범위 안의 정수 여야 합니다.");
            System.out.println("다시 입력해 주세요.");
            return setMK(s);
        }
         return temp;
    }

    // 버블 정렬
    private static void sort(int[] data) {
        int temp;
        int len = data.length - 1;

        for (int i = len; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j+1]) {
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }

    private static void toString(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
