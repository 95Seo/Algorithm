package Programmers.Kakao.KakaoBlindRecruitment;

import java.util.Arrays;

// 문자열 압축
public class StringCompression {
    public static void main(String[] args) {
        String s = "ababcdcdababcdcd";
        System.out.println("min = " + solution(s));
    }

    public static int solution(String s) {
        if (s.length() == 1)
            return 1;

        int count = 0, min = Integer.MAX_VALUE;
        String str = "", beforeStr = "", result = "";
        char[] cArr = s.toCharArray();

        for (int i = 1; i <= cArr.length/2; i++) {
            for (int j = 0; j < cArr.length; j += i) {

                if (j+i > cArr.length) {
                    str = s.substring(j, cArr.length);
                } else {
                    str = s.substring(j, j+i);
                }

                if (beforeStr.equals(str) || j == 0) {
                    count++;
                } else {
                    if (count == 1) {
                        result += beforeStr;
                    } else {
                        result += count + beforeStr;
                    }
                    count = 1;
                }
                beforeStr = str;
            }

            if (count == 1) {
                result += beforeStr;
            } else {
                result += count + beforeStr;
            }

            if (min > result.length()) {
                min = result.length();
            }

            result = "";
            count = 0;

        }

        return min;
    }
}
