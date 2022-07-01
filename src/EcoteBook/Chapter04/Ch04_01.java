package EcoteBook.Chapter04;

import java.util.Scanner;

// 상하좌우
// [입력 조건]
// 첫째 줄에 공간의 크기를 나타내는 N이 주어진다. (1 <= N <= 100)
// 둘째 줄에 여행가 A가 이동할 계획서 내용이 주어진다. (1 <= 이동 횟수 <= 100)

// [출력 조건]
// 첫째 줄에 여행가 A가 최종적으로 도착할 지점의 좌표 (X,Y)를 공백으로 구분하여 출력한다.
public class Ch04_01 {
    public static void main(String[] args) {
        int N;
        int line = 1, row = 1;
        int count = 6;
        char cMove;
        Scanner s = new Scanner(System.in);

        System.out.println("===============게임 규칙===============");
        System.out.println("L : 왼쪽으로 한 칸 이동");
        System.out.println("R : 오른쪽으로 한 칸 이동");
        System.out.println("U : 위로 한 칸 이동");
        System.out.println("D : 아래로 한 칸 이동\n");

        // N을 입력 받기
        System.out.print("지도의 크기 N을 입력해 주세요 : ");
        N = s.nextInt();

        // 나의 풀이
//        while (count != 0) {
//            System.out.print("동작을 입력해 주세요 : ");
//            cMove = s.next().charAt(0);
//            switch (cMove) {
//                case 'L' :
//                    if (line > 1)
//                        line--;
//                    break;
//                case 'R' :
//                    if (line < N)
//                        line++;
//                    break;
//                case 'U' :
//                    if (row > 1)
//                        row--;
//                    break;
//                case 'D' :
//                    if (row < N)
//                        row++;
//                    break;
//            }
//            count--;
//        }

        // 예시 풀이
        s.nextLine();   // 버퍼 비우기
        String[] plans = s.nextLine().split(" ");

        // L, R, U, D에 따른 이동 방향
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveType = {'L', 'R', 'U', 'D'};

        // 이동 계획을 하나씩 확인
        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);
            // 이동 후 좌표 구하기
            int nx = -1, ny = -1;
            for (int j = 0; j < 4; j++) {
                if (plan == moveType[j]) {
                    nx = row + dx[j];
                    ny = line + dy[j];
                }
            }
            // 공간을 벗어나는 경우 무시
            if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
            // 이동 수행
            row = nx;
            line = ny;
        }

        System.out.println("동작이 완료되었습니다.");
        System.out.println("최종 좌표는 (" + row + "," + line + ") 입니다.");
    }
}
