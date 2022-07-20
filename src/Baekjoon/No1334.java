package Baekjoon;

// [문제]
// 팰린드롬 수는 앞으로 읽어도, 뒤로 읽어도 같은 숫자이다.
// 101, 4, 6666와 같은 숫자는 팰린드롬 수이고, 10, 564, 15452와 같은 숫자는 아니다.
//어떤 수 N이 주어질 때, N보다 큰 팰린드롬 수 중에서 가장 작은 수를 출력한다.

// [입력]
// 첫째 줄에 N이 주어진다. N은 최대 50자리인 양의 정수이다. 첫 숫자는 0이 아니다.

// [출력]
// 첫째 줄에 문제의 정답을 출력한다.

// [입력 예시]
// 12345

// [출력 예시]
// 12421

// [입력 예시]
// 858

// [출력 예시]
// 868

// [입력 예시]
// 1999

// [출력 예시]
// 2002
import java.math.BigInteger;
import java.util.Scanner;

public class No1334 {
    static int digit;   // 자릿수
    static char[] cArr;
    static int mark;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BigInteger num = s.nextBigInteger();
        String r_num = "";
        String result = "";

        setting(num);

        String leftNum = getLeftNum();
        String rightNum = getRightNum();
        BigInteger midNum = getMidNum();
        String reversNum = getReversNum(leftNum);

        if(digit == 1 || num.equals(BigInteger.TEN)) {
            if(num.compareTo(BigInteger.valueOf(9)) < 0) {
                result = num.add(BigInteger.ONE).toString();
            } else {
                result = "11";
            }
        } else {
            if(digit % 2 == 0) {
                r_num = leftNum + midNum + getReversNum(leftNum);
            } else {
                r_num = leftNum + getReversNum(leftNum);
            }

            if (r_num.compareTo(num.toString()) > 0) {
                result = r_num;
            } else {
                // num + 1 후 홀짝 판단
                num = num.add(BigInteger.ONE);
                setting(num);

                // 홀수
                if (digit %2 == 0) {

                    leftNum = getLeftNum();
                    rightNum = getRightNum();
                    midNum = getMidNum();
                    reversNum = getReversNum(leftNum);

//                    System.out.println("leftNum = " + leftNum);
//                    System.out.println("rightNum = " + rightNum);
//                    System.out.println("midNum = " + midNum);
//                    System.out.println("reversNum = " + reversNum);

                    //left를 뒤집은 수가 right보다 크거나 같다면 (left, mid, left를 뒤집은 수)를 이은 수가 팰린드롬 수
                    if (reversNum.compareTo(rightNum) >= 0) {
                        result = leftNum + midNum + reversNum;
                        // mid의 값을 1 올린 후에 left를 뒤집은 값을 left, mid를 이은 값에 이어주면 N보다 크면서 가장 작은 팰린드롬 수가 됨
                    } else {
                        if (midNum.equals(BigInteger.valueOf(9))) {
                            midNum = BigInteger.ZERO;
                            int before = leftNum.length();
                            leftNum = new BigInteger(leftNum).add(BigInteger.ONE).toString();
                            int after = leftNum.length();

                            // left에 1을 더해준 후 left의 자리 값이 바뀌었다면 10의 제곱수가 되었다는 뜻, 자리수가 2개 들어남으로 mid(0)를 빼고 이어준다.
                            if (after > before) {
                                result = leftNum + getReversNum(leftNum);
                                // 자리수가 변경되지 않았다면 (left, 1을 더해준 mid, left를 뒤집은 수)를 이어준 값이 답
                            } else {
                                result = leftNum + midNum + getReversNum(leftNum);
                            }
                            // midNum이 9가 아니라면 (left, 1을 더해준 mid, left를 뒤집은 수)를 이어준 값이 답
                        } else {
                            result = leftNum + midNum.add(BigInteger.ONE) + getReversNum(leftNum);
                        }
                    }

                    // 짝수
                } else {

                    leftNum = getLeftNum();
                    rightNum = getRightNum();
                    reversNum = getReversNum(leftNum);

                    if (reversNum.compareTo(rightNum) >= 0) {
                        result = leftNum + reversNum;
                        // 자릿수가 짝수인 경우에는 left를 뒤집은 수가 right보다 작다면 left의 값을 1 올린 후에 left를 뒤집은 값을 left와 이어주면 N보다 크면서 가장 작은 팰린드롬 수가 됨
                    } else {
                        int before = leftNum.length();
                        leftNum = new BigInteger(leftNum).add(BigInteger.ONE).toString();
                        int after = leftNum.length();

                        // left에 1을 더해준 후 left의 자리 값이 바뀌었다면 10의 제곱수가 되었다는 뜻, 자리수가 2개 들어남으로 left의 가장 마지막 수를 빼고 이어준다.
                        if (before < after) {
                            result = leftNum.substring(0, leftNum.length() - 1) + getReversNum(leftNum);
                            // 자리수가 변경되지 않았다면 (left, 1을 더해준 mid, left를 뒤집은 수)를 이어준 값이 답
                        } else {
                            result = leftNum + getReversNum(leftNum);
                        }
                    }

                }
            }
        }

        System.out.println(result);

    }

    public static void setting(BigInteger num) {
        String buffer = num.toString();
        cArr = buffer.toCharArray();
        digit = buffer.length()-1; // 자리수
        mark = digit / 2;       // 검사 기준점
    }

    public static BigInteger getMidNum() {
        return BigInteger.valueOf(Character.getNumericValue(cArr[mark]));
    }

    public static String getRightNum() {
        String str = "";
        for (int i = mark+1; i <= digit; i++) {
            str += cArr[i];
        }
        return str;
    }

    public static String getLeftNum() {
        String str = "";
        for (int i = 0; i <= mark; i++) {
            if (digit % 2 == 0) {
                if (i == mark) {
                    continue;
                }
            }
            str += cArr[i];
        }
        return str;
    }

    public static String getReversNum(String num) {
        char[] c = num.toCharArray();
        String str = "";
        for (int i = num.length()-1; i >= 0; i--) {
            str += cArr[i];
        }
        return str;
    }
}
