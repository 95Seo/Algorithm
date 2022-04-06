package EcoteBook.Chapter03.GreedyAlgorithm;

// 1이 될 때까지
// 어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 한다. 단, 두 번째 연산은 N이 K로 나누어떨어질 때만 선택할 수 있다.
// 1. N에서 1을 뺀다.
// 2. N을 K로 나눈다.
// N과 K가 주어질 때 N이 1이 될 때까지 1번 혹은 2번의 과정을 수행해야 하는 최소 횟수를 구하는 프로그램을 작성하시오.

// [입력조건]
// 첫째 줄에 N(2 <= N <= 100,000)과 K(2 <= k <= 100,000)가 공백으로 구분되며 각각 자연수로 주어진다. 이때 입력으로 주어지는 N은 항상 K보다 크거나 같다.

// [출력조건]
// 첫째 줄에 N이 1이 될 때까지 1번 혹은 2번의 과정을 수행해야 하는 횟수의 최솟값을 출력한다.

// [입력예시]
// 25 5

import java.util.Scanner;

// [출력예시]
// 2
public class Ch03_04 {
    public static void main(String[] args) {
        int N, K;
        int count = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("N(2 <= N <= 100,000)과 K(2 <= k <= 100,000)를 입력해 주세요.");
        N = s.nextInt();
        K = s.nextInt();

        // 내가 푼것
//        while (N != 1) {
//            if (N%K != 0)
//                N -= 1;
//            else
//                N /= K;
//            count++;
//        }

        // 최적의 해
        while (true) {
            // 무조건 K의 배수가 나온다.
            int target = (N/K) * K;

            // 1.번 조건이 1씩 빼는 것 이기 때문에
            // N - target(나머지가 있을 땐 나머지가, 딱 나누어 떨어 질 땐 0이 됨) 나머지가 있을때는 1씩 뺄때의 카운트와 된다.
            count += (N - target);
            N = target;

            // N이 K보다 작을 때(더이상 나눌 수 없을 때) 반복문 탈출
            if (N < K)
                break;

            // K로 나누기
            count += 1;
            N /= K;
        }

        System.out.println(count);
    }
}
