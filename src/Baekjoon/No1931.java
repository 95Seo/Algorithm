package Baekjoon;

// [문제]
// 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
// 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는
// 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음
// 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

// [입력]
// 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을
// 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 2^31-1보다 작거나 같은 자연수 또는 0이다.

// [출력]
// 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.

// [입력 예시]
// 11
// 1 4
// 3 5
// 0 6
// 5 7
// 3 8
// 5 9
// 6 10
// 8 11
// 8 12
// 2 13
// 12 14

// [출력 예시]
// 4

import java.util.*;

// 이 처럼 시간표를 최대한 많이 배정하거나 선택하는 문제를 '활동 선택 문제'라고 한다. 그리디 알고리즘의 대표적인 문제 중 하나.

// 문제는 맞았으나 적합성 실패 리팩토링 필요
public class No1931 {
    static Set<Integer> key;
    static Map<Integer, List<Integer>> map = new HashMap();
    static List<Integer> list;
    static int count = 1, target = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            int key = s.nextInt();
            int val = s.nextInt();
            
            // 처음 종료 시간 설정
            if (target > val) {
                target = val;
            }

            // 시작 시간을 기준으로 key val 설정
            if (map.containsKey(key)) {
                map.get(key).add(val);
            } else {
                list = new ArrayList<>();
                list.add(val);
                map.put(key, list);
            }
        }

        // 시작 시간 정렬
        key = map.keySet();
        key.stream().sorted();

        for (int key : key) {
            // 시작 시간이 target(이전 종료 시간)보다 클때
            if (key >= target) {
                list = map.get(key);
                list.stream().sorted();
                // 그중 가장 종료시간이 작은 수 다음 타겟
                target = list.get(0);
                count++;
            }
        }

        System.out.println(count);
    }

    // 모범적인 풀이 Comparator에 대해 알아봐야 할듯하다.
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//
//        int N = in.nextInt();
//
//
//    /*
//      time[][0] 은 시작시점을 의미
//      time[][1] 은 종료시점을 의미
//    */
//        int[][] time = new int[N][2];
//
//
//        for(int i = 0; i < N; i++) {
//            time[i][0] = in.nextInt();	// 시작시간
//            time[i][1] = in.nextInt();	// 종료시간
//        }
//
//
//        // 끝나는 시간을 기준으로 정렬하기 위해 compare 재정의
//        Arrays.sort(time, new Comparator<int[]>() {
//
//            @Override
//            public int compare(int[] o1, int[] o2) {
//
//                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
//                if(o1[1] == o2[1]) {
//                    return o1[0] - o2[0];
//                }
//
//                return o1[1] - o2[1];
//            }
//
//        });
//
//        int count = 0;
//        int prev_end_time = 0;
//
//        for(int i = 0; i < N; i++) {
//
//            // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
//            if(prev_end_time <= time[i][0]) {
//                prev_end_time = time[i][1];
//                count++;
//            }
//        }
//
//        System.out.println(count);
//    }
}
