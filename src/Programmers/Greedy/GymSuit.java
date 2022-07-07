package Programmers.Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GymSuit {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        System.out.println(solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int count = 0;
        int[] arr = {-1, 1};
        Arrays.sort(lost);
        Arrays.sort(reserve);

        Map<Integer, Boolean> reserveMap = new HashMap<Integer, Boolean>();
        Map<Integer, Boolean> lostMap = new HashMap<Integer, Boolean>();

        for(int i : lost) {
            boolean isLost = true;
            for(int j : reserve) {
                if(i == j) {
                    isLost = false;
                    count++;
                }
            }
            lostMap.put(i, isLost);
        }

        int answer = n - (lost.length-count);

        for(int i : reserve) {
            boolean isReserve = true;
            for(int j : lost) {
                if(i == j) {
                    isReserve = false;
                }
            }
            reserveMap.put(i, isReserve);
        }

        for(int i : lost) {
            for(int j : arr) {
                if(lostMap.get(i)) {
                    int tempInt = i + j;
                    Boolean isReserve = reserveMap.containsKey(tempInt);
                    Boolean isLost = lostMap.containsKey(tempInt);
                    if(isReserve && !isLost && reserveMap.get(tempInt)) {
                        answer++;
                        reserveMap.put(tempInt, false);
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
