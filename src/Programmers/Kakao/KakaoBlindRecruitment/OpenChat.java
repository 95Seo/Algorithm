package Programmers.Kakao.KakaoBlindRecruitment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChat {
    private static final String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
    private static final String EnterAction = "님이 들어왔습니다.";
    private static final String LeaveAction = "님이 나갔습니다.";
    private static Map<String, userInfo> userMap = new HashMap<>();
    private static List<userAction> actionList = new ArrayList<>();

    public static void main(String[] args) {
        // 리팩토링
        for (String request : record) {
            String[] buffer = request.split(" ");
            String action = buffer[0];
            String userId = buffer[1];

            switch (action) {
                case "Enter" :
                    if (userMap.containsKey(userId) == false) {
                        userMap.put(userId, new userInfo(userId, buffer[2]));
                    } else {
                        userMap.get(userId).userNick = buffer[2];
                    }
                    actionList.add(new userAction(action, userId));
                    break;
                case "Leave" :
                    actionList.add(new userAction(action, userId));
                    break;
                case "Change" :
                    userMap.get(userId).userNick = buffer[2];
                    break;
            }
        }

        String[] answer = new String[actionList.size()];

        for (int i = 0; i < actionList.size(); i++) {
            String action = actionList.get(i).action;
            String userId = actionList.get(i).userId;

            String message = userMap.get(userId).userNick;
            if (action.equals("Enter")) {
                message += EnterAction;
            } else {
                message += LeaveAction;
            }

            answer[i] = message;
            System.out.println("message = " + message);
        }
    }


        // 최초 풀이
//        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
//        List<String> actions = new ArrayList<>();
//        List<String> userIds = new ArrayList<>();
//        Map<String, String> user = new HashMap<>();
//
//        for (String r : record) {
//            String[] buffer = r.split(" ");
//            if (buffer[0].equals("Enter") || buffer[0].equals("Change"))
//                setUser(user, buffer[1], buffer[2]);
//
//            if (buffer[0].equals("Enter") || buffer[0].equals("Leave")) {
//                actions.add(buffer[0]);
//                userIds.add(buffer[1]);
//            }
//        }
//
//        String[] answer = new String[actions.size()];
//
//        for (int i = 0; i < actions.size(); i++) {
//            String message = user.get(userIds.get(i));
//            if (actions.get(i).equals("Enter"))
//                message += "님이 들어왔습니다.";
//            else
//                message += "님이 나갔습니다.";
//
//            answer[i] = message;
//        }
//
//        for (String i : answer) {
//            System.out.println(i);
//        }
//    }

//    public static void setUser(Map<String, String> map, String userId, String nick) {
//        map.put(userId, nick);
//    }
}

class userInfo {
    String userId;
    String userNick;

    public userInfo(String userId, String userNick) {
        this.userId = userId;
        this.userNick = userNick;
    }
}

class userAction {
    String action;
    String userId;

    public userAction(String action, String userId) {
        this.action = action;
        this.userId = userId;
    }
}