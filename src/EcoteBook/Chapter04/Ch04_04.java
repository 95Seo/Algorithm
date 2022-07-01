package EcoteBook.Chapter04;

import java.util.Scanner;

// * 시뮬레이션 문제는 많이 풀어봐야 할거 같다. *

// 게임 개발
// 맵은 N * M 크기의 직사각형. 각각의 칸은 육지 또는 바다이다. 캐릭터는 동서남북 중 한 곳을 바라본다.
// 맵의 각 칸은 (A,B)로 나타낼 수 있고, A는 북쪽으로부터 떨어진 칸의 개수, B는 서쪽으로부터 떨어진 칸의 개수이다.
// 캐릭터는 상하좌우로 움직일 수 있고, 바다로 되어 있는 공간에는 갈 수 없다.
// 캐릭터 움직임 메뉴얼
// 1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향(반시계 90도 회전 방향)부터 차례대로 갈 곳을 정한다.
// 2. 캐릭터의 바로 왼쪽 방향에 아직 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전한 다음 왼쪽으로 한 칸을 전진한다. 왼쪽 방향에 가보지 않은 칸이 없다면, 왼쪽 방향으로 회전만 수행하고 1단계로 돌아간다.
// 3. 만약 네 방향 모두 이미 가본 칸이거나 바다로 되어 있는 칸인 경우에는, 바라보는 방향을 유지한 채로 한칸 뒤로 가고 1단계로 돌아간다. 단, 이때 뒤쪽 방향이 바다인 칸이라 뒤로 갈 수 없는 경우에는 움직임을 멈춘다.
// 메뉴얼에 따라 이동시킨 뒤에 방문한 칸의 수를 출력하시오.

// [입력 조건]
// 첫째 줄에 맵의 세로 크기 N과 가로 크기 M을 공백으로 구분하여 입력한다. (3 <= N, M <= 50)
// 둘째 줄에 게임 캐릭터가 있는 칸의 좌표 (A,B)와 바라보는 방향 d가 각각 서로 공백으로 구분하여 주어진다. 방향 d의 값으로는 다음과 같이 4가지가 존재한다.
// - 0 : 북쪽
// - 1 : 동쪽
// - 2 : 남쪽
// - 3 : 서쪽
// 셋째 줄부터 맵이 육지인지 바다인지에 대한 정보가 주어진다. N개의 줄에 맵의 상태가 북쪽부터 남쪽 순서대로, 각 줄의 데이터는 서쪽부터 동쪽 순서대로 주어진다. 맵의 외곽은 항상 바다로 되어 있다.
// - 0 : 육지
// - 1 : 바다
// 처음에 게임 캐릭터가 위치한 칸의 상태는 항상 육지다.

// [출력 조건]
// 첫째 줄에 이동을 마친 후 캐릭터가 방문한 칸의 수를 출력한다.

// [입력 예시]
// 4 4      # 4*4 맵 생성
// 1 1 0    # (1,1)에 북쪽(0)을 바라보고 서있는 캐릭터
// 1 1 1 1  # 첫 줄은 모두 바다
// 1 0 0 1  # 둘째 줄은 바다/육지/육지/바다
// 1 1 0 1  # 셋째 줄은 바다/바다/육지/바다
// 1 1 1 1  # 넷째 줄은 모두 바다

// [출력 예시]
// 3
public class Ch04_04 {
    // 캐릭터 움직임 정의
    // int[col][row] 0 북, 1 동, 2 남, 3 서
    private static final int[][] steps = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static int cnt = 1;
    private static int backCount = 0;

    private static int col, row;
    private static int charCol, charRow;
    private static int nextCol, nextRow;

    private static int[][] map, moveMap;

    // 방향
    private static int direction;

    private static boolean flag = true;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // 맵 크기 지정
        col = s.nextInt();
        row = s.nextInt();

        map = new int[col][row];
        // 초기화를 안하면 0으로 가득 참
        moveMap = new int[col][row];

        // 캐릭터 위치 / 방향 지정
        charCol = s.nextInt();
        charRow = s.nextInt();
        direction = s.nextInt();

        // 맵 생성
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                map[i][j] = s.nextInt();
            }
        }

        // 캐릭터의 스타트 지점 방문 처리
        moveMap[charCol][charRow] = 1;

        while (flag) {
            nextDirection();
            // 다음 바라볼 방향
            nextCol = charCol + steps[direction][0];
            nextRow = charRow + steps[direction][1];

            // 먼저 아웃 오브 바운스 검사
            if(nextCol < 0 || nextCol > col || nextRow < 0 || nextRow > row) {
                System.out.println("갈수 없습니다.");
                backCount++;
            } // 다음 방향이 육지 & 가보지 않은 곳 이라면
            else if (map[nextCol][nextRow] == 0 && moveMap[nextCol][nextRow] == 0) {
                // 이동 정보가 담긴 맵의 현재 위치 = 1
                map[charCol][charRow] = 1;
                charCol = nextCol;
                charRow = nextRow;
                backCount = 0;
                cnt++;
                System.out.println("육지 입니다.");
                continue;
            } // 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
            else {
                System.out.println("갈수 없습니다.");
                backCount++;
            }

            // 좌표에서 반대 방향은 - 좌표
            // 네 방향 모두 갈 수 없는 경우
            if (backCount == 4) {
                checkEndPoint();
            }
        }

        System.out.println(cnt);
    }

    private static void checkEndPoint() {
            nextCol = charCol - steps[direction][0];
            nextRow = charRow - steps[direction][1];

            // 뒤로 갈 수 있다면 이동하기
            if (map[nextCol][nextRow] == 0) {
                System.out.println("뒤로 돌아 갑니다.");
                charCol = nextCol;
                charRow = nextRow;
            } // 뒤가 바다로 막혀 있는 경우
            else {
                flag = false;
            }
            backCount = 0;
    }

    private static void nextDirection() {
        direction -= 1;
        if (direction < 0)
            direction = 3;
    }
}
