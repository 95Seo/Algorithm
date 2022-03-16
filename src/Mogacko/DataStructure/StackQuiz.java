package Mogacko.DataStructure;

import java.util.ArrayList;

// 리팩토링 필요함
// 검증단계에서 flag없애도록 변경

// 1. 문자열의 처음부터 끝까지 여는 중괄호의 개수가 같거나 많아야 한다. (여는 중괄호가 항상 먼저 나와야 한다)
// 2. 문자열이 종료되었을 때, 여는 중괄호의 개수와 닫는 중괄호의 개수가 같아야한다.
// 3. 개수가 같으면 "유효한 중괄호 쌍입니다." 다르면 "유효하지 않은 중괄호 쌍입니다." 출력
public class StackQuiz {
    public static void main(String[] args) {

        //입력
        validateBracePair("{{}}{}");
        validateBracePair("{{}");
        validateBracePair("{{{}}}");
        validateBracePair("}{{{}}}{");
        validateBracePair("{}{{{}}}{}");

        // 출력
//        유효한 중괄호 쌍입니다.
//        유효하지 않은 중괄호 쌍입니다.
//        유효한 중괄호 쌍입니다.
//        유효하지 않은 중괄호 쌍입니다.
//        유효한 중괄호 쌍입니다.
    }

    public static void validateBracePair (String value) {
        ArrayList<String> stack = new ArrayList<>();
        boolean flag = true;

        for (String s : value.split("")) {
            if(s.equals("{")) {
                push(stack, s);
            }
            else if(s.equals("}") && stack.size() <=0) {
                flag = false;
                break;
            }
            else {
                pop(stack);
            }
        }

        if(stack.size() == 0 && flag == true) {
            System.out.println("유효한 중괄호 쌍입니다.");
        } else {
            System.out.println("유효하지 않은 중괄호 쌍입니다.");
        }

    }

    public static void push (ArrayList<String> arr, String s) {
        arr.add(s);
    }

    public static void pop(ArrayList<String> arr) {
        arr.remove(arr.size()-1);
    }
}
