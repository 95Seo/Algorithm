package EcoteBook.Chapter04;

import java.util.Scanner;

// 왕실의 나이트
// 체스판은 8 * 8 좌표 평면이다.
// 특정칸에 나이트가 서있다. 나이트는 L자 형태로만 이동할 수 있다. 또한 체스판 밖으로 나갈 수 없다.
// 나이트는 특정한 위치에서 다음과 같은 2가지 경우로 이동할 수 있다.
// 1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
// 2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
// 좌표 평면상 나이트의 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 작성하시오.

// [체스판]
//   a  b  c  d  e  f  g  h
// 1
// 2
// 3
// 4
// 5
// 6
// 7
// 8

// [입력 조건]
// 첫째 줄에 8 * 8 좌표 평면상에서 현재 나이트가 위치한 곳의 좌표를 나타내는 두 문자로 구성된 문자열이 입력된다. 입력 문자는 a1처럼 열과 행으로 이뤄진다.

// [출력 조건]
// 첫째 줄에 나이트가 이동할 수 있는 경우의 수를 출력하시오.

// [입력 예시]
// a1

// [출력 예시]
// 2
public class Ch04_03 {
    public static void main(String[] args) {
        // 나이트가 움직일 수 있는 경우의 수는 8가지
        // {column, row}
        int[][] steps = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}};
        int count = 0;

        Scanner s = new Scanner(System.in);
        System.out.print("나이트의 위치를 입력해 주세요 : ");
        String inputData = s.nextLine();

        // 최적의 해
        // '0' - ASCII 번호 48, 'a' - 97 ASCII 번호 48
//        int column = inputData.charAt(0) - 'a' + 1;
//        int row = inputData.charAt(1) - '0';

        // 내가 푼 것
        char[] c;
        int column = 0, row = 0, stepColumn = 0, stepRow = 0;

        c = inputData.toCharArray();

        // x 값 세팅
        switch (c[0]) {
            case 'a':
                column = 1;
                break;
            case 'b':
                column = 2;
                break;
            case 'c':
                column = 3;
                break;
            case 'd':
                column = 4;
                break;
            case 'e':
                column = 5;
                break;
            case 'f':
                column = 6;
                break;
            case 'g':
                column = 7;
                break;
            case 'h':
                column = 8;
                break;
        }

        // y 값 세팅
        row = Character.getNumericValue(c[1]);

        for (int i = 0; i < steps.length; i++) {
            stepColumn = column + steps[i][0];
            stepRow = row + steps[i][1];

            if (stepColumn > 0 && stepColumn < 8 && stepRow > 0 && stepRow < 8)
                count++;
        }

        System.out.print("나이트가 움직일 수 있는 경우의 수는 " + count + "입니다.");
    }
}
