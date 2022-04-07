package EcoteBook.Chapter03;

import java.util.Scanner;

// 숫자 카드 게임
// 1. 숫자가 쓰인 카드들이 N * M 형태로 놓여 있다. 이때 N은 행의 개수를 의미하며, M은 열의 개수를 의미한다.
// 2. 먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택한다.
// 3. 그다음 선택된 행에 포함된 카드들 중 가장 숫자가 낮은 카드를 뽑아야 한다.
// 4. 따라서 처음에 카드를 골라낼 행을 선택할 때, 이후에 해당 행에서 가장 숫자가 낮은 카드를 뽑을 것을 고려하여 최종적으로 가장 높은 숫자의 카드를 뽑을 수 있도록 전략을 세워야 한다.

// [입력 조건]
// 첫째 줄에 숫자 카드들이 놓인 행의 개수 N과 열의 개수 M이 공백을 기준으로 하여 각각 자연수로 주어진다.(1 <= N, M <= 100)
// 둘째 줄부터 N개의 줄에 걸쳐 각 카드에 적힌 숫자가 주어진다. 각 숫자는 1이상 10,000 이하의 자연수이다.

// [출력 조건]
// 첫째 줄에 게임의 룰에 맞게 선택한 카드에 적힌 숫자를 출력한다.

// 각 행마다 가장 작은 수를 찾은 후 그중 가장 큰 수를 출력하라.

// [입력 예시]
// 3 3
// 3 1 2    -> 가장 작은 수 1
// 4 2 4    -> 가장 작은 수 2
// 2 2 2    -> 가장 작은 수 2

// [출력 예시]
// 2        -> 1, 2, 2 중 가장 큰 수 2
public class Ch03_03 {
    public static void main(String[] args) {
        int N =0, M =0;
        int result;
        Scanner s = new Scanner(System.in);
        System.out.println("행의 개수 N과 열의 개수 M을 입력하세요.(1 <= N, M <= 100)");
        N = s.nextInt();
        M = s.nextInt();

        int[][] arr = new int[N][M];

        setArr(arr, s);
        System.out.println("카드 세팅 완료");

        result = findResult(arr);

        System.out.println("가장 큰 수는 " + result + "입니다.");
    }

    private static int min(int[][] arr, int line) {
        int min = arr[line][0];
        for (int row = 1; row < arr[line].length; row++) {
            if(min > arr[line][row])
                min = arr[line][row];
        }
        return min;
    }

    private static int findResult(int[][] arr) {
        int max = 0, min;
        for (int i = 0; i < arr.length; i++) {
            min = min(arr, i);

            if (min >= max) {
                max = min;
            }
        }
        return max;
    }

    private static void setArr(int[][] arr, Scanner s) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                temp = s.nextInt();
                if (temp < 1 || temp > 10000) {
                    System.out.println("카드에 적을 숫자는 1이상 10,000 이하여야 합니다.");
                    System.out.println("다시 입력해 주세요");
                    continue;
                }
                arr[i][j] = temp;
            }
        }
    }
}
