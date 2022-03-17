package Mogacko.TwoPointer;

// 1.아래 10개의 에너지 드링크의 번호와 카페인 함량과 타우린 함량이 아래와 같을 때,
// 2.타우린 함량의 합 - 카페인 함량의 합이 가장 높은
// 3.연속된 세 개의 에너지 드링크를 출력하세요.

// 입력
// 번호 카페인 타우린
//  0 100 320
//  1 232 720
//  2 600 103
//  3 100 124
//  4 730 1076
//  5 185 125
//  6 104 600
//  7 392 705
//  8 33 265
//  9 89 421

// ** 리팩토링 : 변수 선언이 너무 많은 줄이자!, 메서드를 조금 더 잘게 나누어 보자!
import java.util.Scanner;

// 출력
// a b c의 타우린 합은 x, 카페인 합은 x로 가장 효과가 좋습니다.
public class SlidingWindow {
    public static void main(String[] args) {
        // 테스트용 데이터
//        int[] taurineArr = {320, 720, 103, 124, 1076, 125, 600, 705, 265, 421};
//        int[] caffeineArr = {100, 232, 600, 100, 730, 185, 104, 392, 33, 89};

        int[] taurineArr = new int[10];
        int[] caffeineArr = new int[10];

        insertArr(taurineArr, caffeineArr);

        slidingWindow(taurineArr, caffeineArr);

    }

    private static void insertArr(int[] taurineArr, int[] caffeineArr) {
        System.out.println("10개의 에너지 드링크의 성분을 입력해 주세요.");
        System.out.println("번호 카페인 타우린");
        Scanner s = new Scanner(System.in);

        for(int i = 0; i < caffeineArr.length; i++) {
            System.out.print(" " + i + "   ");
            caffeineArr[i] = s.nextInt();
            taurineArr[i] = s.nextInt();
        }
    }

    public static void slidingWindow(int[] taurineArr, int[] caffeineArr) {
        int start = 0;
        int max = 0;
        int index = 0;
        int taurineSum = 0;
        int caffeineSum = 0;

        while (start+3 <= taurineArr.length) {
            int resilt = 0;

            for(int i = start; i < start + 3; i++) {
                taurineSum += taurineArr[i];
                caffeineSum += caffeineArr[i];
            }

            resilt = taurineSum - caffeineSum;

            if(max < resilt) {
                max = resilt;
                index = start;
            }
            taurineSum = 0;
            caffeineSum = 0;
            start++;
        }

        for(int i = index; i < index + 3; i++) {
            System.out.print(i + " ");
            taurineSum += taurineArr[i];
            caffeineSum += caffeineArr[i];
        }
        System.out.printf("의 타우린 합 = %d, 카페인 합 = %d, ", taurineSum, caffeineSum);
        System.out.printf("타우린 합 - 카페인 합 = %d로 가장 효과가 좋습니다.\n", max);
    }
}
