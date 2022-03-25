package EcoteBook.Chapter03.GreedyAlgorithm;

import java.util.Scanner;

// 거스름 돈
// 카운터에는 거스름돈으로 사용할 500원, 100원, 50원, 10원짜리 동전이 무한히 존재함
// 거슬러 줘야할 돈이 N원일 때 거슬러 줘야 할 동전의 최소 개수를 구하라.
// 단, 거슬러 줘야 할 돈 N은 항상 10의 배수이다.
public class Ch03_01 {
    public static void main(String[] args) {
        int[] coin = {500, 100, 50, 10};
        while (true) {
            int count = 0;
            int N = 0;
            Scanner s = new Scanner(System.in);
            System.out.print("거슬러 줘야 할 돈 N을 입력해 주세요(종료는 0) : ");
            N = s.nextInt();

            if (toContinue(N)) {
                System.out.println("숫자 N은 10의 배수여야 합니다.");
                System.out.println("다시 입력해 주세요.");
                continue;
            }

            if (toBreak(N)) {
                System.out.println("종료합니다.");
                break;
            }

            for (int i = 0; i < coin.length; i++) {
                count += N/coin[i];
                N %= coin[i];
            }

            System.out.println("동전의 최소 갯수는 " + count + "입니다.");
        }
    }

    private static boolean toBreak(int N) {
        if (N == 0)
            return true;
        return false;
    }

    private static boolean toContinue(int N) {
        if (N%10 != 0)
            return true;
        return false;
    }
}
