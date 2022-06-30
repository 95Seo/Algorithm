package Programmers.Kakao.KakaoBlindRecruitment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChat {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        List<String> actions = new ArrayList<>();
        List<String> userIds = new ArrayList<>();
        Map<String, String> user = new HashMap<>();

        for (String r : record) {
            String[] buffer = r.split(" ");
            if (buffer[0].equals("Enter") || buffer[0].equals("Change"))
                setUser(user, buffer[1], buffer[2]);

            if (buffer[0].equals("Enter") || buffer[0].equals("Leave")) {
                actions.add(buffer[0]);
                userIds.add(buffer[1]);
            }
        }

        String[] answer = new String[actions.size()];

        for (int i = 0; i < actions.size(); i++) {
            String message = user.get(userIds.get(i));
            if (actions.get(i).equals("Enter"))
                message += "님이 들어왔습니다.";
            else
                message += "님이 나갔습니다.";

            answer[i] = message;
        }

        for (String i : answer) {
            System.out.println(i);
        }
    }

    public static void setUser(Map<String, String> map, String userId, String nick) {
        map.put(userId, nick);
    }
}
