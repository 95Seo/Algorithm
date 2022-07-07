package Baekjoon;

// [문제]
// 해커 김지민은 잘 알려진 어느 회사를 해킹하려고 한다. 이 회사는 N개의 컴퓨터로 이루어져 있다.
// 김지민은 귀찮기 때문에, 한 번의 해킹으로 여러 개의 컴퓨터를 해킹 할 수 있는 컴퓨터를 해킹하려고 한다.
//이 회사의 컴퓨터는 신뢰하는 관계와, 신뢰하지 않는 관계로 이루어져 있는데, A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다는 소리다.
//이 회사의 컴퓨터의 신뢰하는 관계가 주어졌을 때, 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력하는 프로그램을 작성하시오.

// [입력]
// 첫째 줄에, N과 M이 들어온다. N은 10,000보다 작거나 같은 자연수,
// M은 100,000보다 작거나 같은 자연수이다. 둘째 줄부터 M개의 줄에 신뢰하는 관계가 A B와 같은 형식으로 들어오며,
// "A가 B를 신뢰한다"를 의미한다. 컴퓨터는 1번부터 N번까지 번호가 하나씩 매겨져 있다.

// [출력]
// 첫째 줄에, 김지민이 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 오름차순으로 출력한다.

// [입력 예시]
// 5 4
// 3 1
// 3 2
// 4 3
// 5 3

import java.util.*;

// [출력 예시]
// 1 2
public class No1325 {

    static int[] answer;
    static boolean[] visit;
    static Pc[] pcs;

    // 개선
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n, m, a, b;
        int max = 0;

        // 입력값
        n = s.nextInt();
        m = s.nextInt();

        pcs = new Pc[n+1];
        for (int i = 1; i <= n; i++) {
            pcs[i] = new Pc(i);
        }

        for (int i = 0; i < m; i++) {
            a = s.nextInt();
            b = s.nextInt();

            pcs[b].trustArr.add(pcs[a]);
        }

        answer = new int[n+1];
        // 연결된 pc 수 검사
        for (int i = 1; i < n+1; i++) {
            Pc pc = pcs[i];
            // 여기서 new 하니깐 false로 다 초기화 되는 듯
            visit = new boolean[n+1];
            visit[i] = true;
            answer[i] = getTotalCount(pc);
        }

//        for (int i = 1; i < n+1; i++) {
//            // 여기서 new 하니깐 false로 다 초기화 되는 듯
//            visit = new boolean[n+1];
//            visit[i] = true;
//            dfs(i, i);
//        }

        // getMax
        for (int i : answer) {
            max = Math.max(max, i);
        }

        // 출력
        for (int i = 1; i <= n; i++) {
            if (answer[i] == max)
                System.out.print(i + " ");
        }
    }

//    public static void dfs(int start, int now) {
//        for (Pc p : pcs[now].trustArr) {
//            if (!visit[p.idx]) {
//                visit[p.idx] = true;
//                dfs(start, p.idx);
//                answer[start]++;
//            }
//        }
//    }

    public static int getTotalCount(Pc pc) {
        int result = 1;
        if (pc.trustArr != null) {
            for (Pc p : pc.trustArr) {
                if (!visit[p.idx]) {
                    visit[p.idx] = true;
                    result += getTotalCount(p);
                }
            }
        }

        return result;
    }
}

class Pc {
    // 나를 신뢰 하는 컴터 목록
    List<Pc> trustArr;
    int idx;

    public Pc(int idx) {
        this.idx = idx;
        this.trustArr = new ArrayList<>();
    }
}
