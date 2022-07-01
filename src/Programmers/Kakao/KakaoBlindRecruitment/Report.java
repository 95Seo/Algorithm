package Programmers.Kakao.KakaoBlindRecruitment;

import java.util.*;

// 신고 결과 받기
public class Report {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi","apeach muzi"};
        int k = 2;

        int[] answer = solution(id_list, report, k);

        for (int i = 0; i < answer.length; i ++) {
            System.out.print(id_list[i] + " : ");
            System.out.println(answer[i]);
        }
    }

    // 나의 풀이
//    public static int[] solution(String[] id_list, String[] report, int k) {
//        int[] answer = new int[id_list.length];
//
//        // 중복 제거를 위해 set으로 변경
//        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));
//
//        Map<String, Integer> map = new HashMap<>();
//
//        // 맵 초기화 - 각 id가 신고를 몇회 받았는가를 저장 0으로 초기화
//        for (String id : id_list) {
//            map.put(id, 0);
//        }
//
//        // 신고 당한 횟수
//        for (String rep : reportSet) {
//            String[] split = rep.split(" ");
//            map.put(split[1], map.get(split[1])+1);
//        }
//
//        // 메일 받은 횟수 세알리기
//        for (String rep : reportSet) {
//            String[] split = rep.split(" ");
//            for (int j = 0; j < id_list.length; j++) {
//                if (id_list[j].equals(split[0]) && map.get(split[1]) >= k)
//                    answer[j]++;
//            }
//        }
//
//        return answer;
//    }

    // 다른 사람 풀이 객체 지향 크..
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<User> users = new ArrayList<>();
        HashMap<String,Integer> suspendedList = new HashMap<>(); //<이름>
        HashMap<String,Integer> idIdx = new HashMap<String,Integer>(); // <이름, 해당 이름의 User 클래스 idx>
        int idx = 0;

        for(String name : id_list) {
            idIdx.put(name,idx++);
            users.add(new User(name));
        }

        for(String re : report) {
            String[] str = re.split(" ");
            //suspendedCount.put(str[0], suspendedCount.getOrDefault(str[0],0)+1);
            users.get( idIdx.get(str[0])).reportList.add(str[1]);
            users.get( idIdx.get(str[1])).reportedList.add(str[0]);
        }

        for(User user : users) {
            if(user.reportedList.size() >= k)
                suspendedList.put(user.name,1);
        }

        for(User user : users) {
            for(String nameReport : user.reportList){
                if(suspendedList.get(nameReport) != null){
                    answer[idIdx.get(user.name)]++;
                }
            }
        }

        return answer;
    }
}

class User {
    String name;
    HashSet<String> reportList;
    HashSet<String> reportedList;

    public User(String name) {
        this.name = name;
        reportList = new HashSet<>();
        reportedList = new HashSet<>();
    }
}