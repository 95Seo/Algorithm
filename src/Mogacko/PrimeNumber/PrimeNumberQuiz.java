package Mogacko.PrimeNumber;

import java.util.ArrayList;

// 함수의 파라미터로 주어진 자연수 N 이하의 연속된 소수들을 더해,
// N을 만들 수 있는지 검사하는 함수를 작성해 보세요!
// 입력 answer(41)
// 출력 "연속된 소수 [2, 3, 5, 7, 11, 13]의 합은 41입니다."
// 입력 answer(20)
// 출력 "연속된 소수의 합으로 20을 만들 수 없습니다."
public class PrimeNumberQuiz {
    public static void main(String[] args) {
        answer(41);
        answer(20);
        answer(100);
    }

    // 1. primeNumber 아래의 소수를 알아야 함 (에라스토테네스의 책)
    // 2. 소수들을 더해서 primeNumber 가 나오는 지 알아야 함
    public static void answer(int primeNumber) {
        ArrayList<Integer> primeList = new ArrayList<>();

        isPrime(primeList, primeNumber);

        int res = 0;
        int left = 0;
        int right = 1;

        while (left < primeList.size() && right < primeList.size()) {
            int sum = 0;
            for(int i = left; i < right; i++) {
                sum += primeList.get(i);
            }

            if (sum < primeNumber) {
                right += 1;
            } else if (sum > primeNumber) {
                left += 1;
            } else if(sum == primeNumber) {
                toString(primeList, primeNumber, left, right);
                res++;
                right += 1;
            }
        }

        if(res != 0) {
            System.out.printf("%d를 만들 수 있는 연속된 소수의 합은 %d개 입니다. \n", primeNumber, res);
        } else {
            System.out.printf("연속된 소수의 합으로 %d을 만들 수 없습니다. \n", primeNumber);
        }
    }

    public static void toString(ArrayList<Integer> primeList, int primeNumber, int left, int right) {
        System.out.printf("연속된 소수 [");
        for(int i = left; i < right; i++) {
            System.out.printf(" %d ", primeList.get(i));
        }
        System.out.printf("]의 합은 %d 입니다.\n", primeNumber);
    }

    public static void isPrime(ArrayList<Integer> primeList, int primeNumber) {

        int range = primeNumber + 1;
        boolean[] pnArr = new boolean[range];
        int sqrt = (int)(Math.sqrt(primeNumber)) + 1;

        for(int i = 0; i < range; i++) {
            pnArr[i] = true;
        }

        for (int i = 2; i < sqrt; i++) {
            if(pnArr[i]) {
                for (int j = i*i; j < range; j += i) {
                    pnArr[j] = false;
                }
            }
        }

        for(int i = 2; i < range; i++) {
            if(pnArr[i])
                primeList.add(i);
        }
    }
}
