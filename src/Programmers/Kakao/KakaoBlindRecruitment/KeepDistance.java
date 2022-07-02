package Programmers.Kakao.KakaoBlindRecruitment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 적합성 검사 3개 부족 리팩토링 필요
// 프로그래머스 카카오 인턴십 거리두기 확인하기 문제
public class KeepDistance {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        solution(places);
    }

//    public static int[] solution(String[][] places) {
//        int[] answer = new int[places.length];
//
//        for(int i = 0; i < places.length; i++) {
//            String[] p = places[i];
//
//            boolean isOK = true;
//            for(int r = 0; r < 5; r++) {
//                for(int c = 0; c < 5; c++) {
//                    if(p[r].charAt(c) == 'P') {
//                        if (!check(r, c, p))
//                            isOK = false;
//                    }
//                }
//            }
//            answer[i] = isOK ? 1 : 0;
//        }
//        return answer;
//    }
//
//    public static boolean check(int r, int c, String[] p) {
//        int[] dr = {-1, 1, 0, 0};
//        int[] dc = {0, 0, 1, -1};
//
//        Queue<int[]> queue = new LinkedList<int[]>();
//        queue.offer(new int[] {r, c});
//
//        while (!queue.isEmpty()) {
//            int[] position = queue.poll();
//
//            for (int i = 0; i < 4; i++) {
//                int nr = position[0] + dr[i];
//                int nc = position[1] + dc[i];
//
//                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || (nr == r && nc == c))
//                    continue;
//
//                int d = Math.abs(nr - r) + Math.abs(nc - c);
//
//                if (p[nr].charAt(nc) == 'P' && d <= 2)
//                    return false;
//                else if (p[nr].charAt(nc) == 'O' && d < 2)
//                    return queue.offer(new int[] {nr, nc});
//            }
//
//        }
//
//        return true;
//    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        List<Place> placeList = new ArrayList<>();

        for(int i = 0; i < places.length; i++) {
            String[] p = places[i];

            for(int r = 0; r < 5; r++) {
                for(int c = 0; c < 5; c++) {
                    if(p[r].charAt(c) == 'P') {
                        placeList.add(new Place(c, r));
                    }
                }
            }

            answer[i] = checkDistance(p, placeList) ? 1 : 0;
            placeList.clear();
        }

        for (int i : answer) {
            System.out.println(i);
        }
        return answer;
    }

    public static boolean checkDistance(String[] place, List<Place> placeList) {
        for(int i = 0; i < placeList.size() - 1; i++) {
            Place curPlace = placeList.get(i);
            Place nextPlace = placeList.get(i+1);

            int curX = curPlace.cloumn;
            int curY = curPlace.row;
            int nextX = nextPlace.cloumn;
            int nextY = nextPlace.row;

            int dX = nextX - curX;
            int dY = nextY - curY;

            // 실패 조건 검사
            // P와 다음 P사이의 거리 <= 2
            if(Math.abs(dX) + Math.abs(dY) <= 2) {
                // 좌우 노드 검사
                if (dX > 0) {
                    if (place[curY].charAt(curX+1) == 'O' || place[curY].charAt(curX+1) == 'P') {
                        return false;
                    }
                } else if(dX < 0) {
                    if (place[curY].charAt(curX-1) == 'O' || place[curY].charAt(curX-1) == 'P') {
                        return false;
                    }
                }

                if (dY > 0) {
                    // 바로 위 노드 검사
                    if (place[nextY].charAt(curX) == 'O' || place[nextY].charAt(curX) == 'P')
                        return false;
                }
            }
        }

        return true;
    }
}

class Place {
    int cloumn;
    int row;

    public Place(int cloumn, int row) {
        this.cloumn = cloumn;
        this.row = row;
        System.out.println("cloumn : " + cloumn + ", row : " + row);
    }
}