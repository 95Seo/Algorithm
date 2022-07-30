package Programmers.MonthlyCodeChallengeSeason3;

import java.util.*;

// 싸이클이 몇개인지 판단하는 건 첫 번째 노드에 1234로 입력이 다 있을 경우
// queue에 0123을 담아두고 첫 노드에 123이 들어갈 경우 없애면 될듯

// 방향 정의
// 0 : ->
// 1 : V
// 2 : <-
// 3 : ^

public class LightPathCycle {
    static int num;
    static String[][] arr;
    static int[] nextRow = {0, 1, 0, -1};
    static int[] nextColumn = {1, 0, -1, 0};
    static int rowSize, columnSize;
    static Queue<Integer> queue;

    public static void main(String[] args) {
        String[] input = {"SL","LR"};
        solution(input);
        System.out.println();
        String[] input1 = {"S"};
        solution(input1);
        System.out.println();
        String[] input2 = {"R","R"};
        solution(input2);
        System.out.println();
        String[] input3 = {"R","R","R","R"};
        solution(input3);
        System.out.println();
        String[] input4 = {"RRL","LLR","LRL","RLR"};
        solution(input4);
        System.out.println();
        String[] input5 = {"LLR"};
        solution(input5);
    }

    static int[] solution(String[] grid) {
        List<Integer> result = new ArrayList<>();

        rowSize = grid.length;
        columnSize = grid[0].length();

        arr = new String[rowSize][columnSize];

        // 입력 초기화
        for (int i = 0; i < rowSize; i++) {
            String[] s = grid[i].split("");
            for (int j = 0; j < columnSize; j++) {
                arr[i][j] = s[j];
            }
        }

        queue = new LinkedList<>();
        queue.add(0);
        queue.add(1);
        queue.add(2);
        queue.add(3);

        while(!queue.isEmpty()) {
            int num = queue.poll();
            Node node = new Node(num, 0, 0);
            result.add(roof(node));
        }

        for(int i : result)
            System.out.print(i + " ");

        int[] answer = result.stream().mapToInt(i -> i).toArray();

        Arrays.sort(answer);

        return answer;
    }

    // 들어오는 노드 루프 돌리기
    static int roof(Node node) {
        Node startNode = new Node(node.num, node.row, node.column);
        while (true) {
            switch (arr[node.row][node.column]) {
                case "L" :
                    setLeft(node);
                    break;
                case "R" :
                    setRight(node);
                    break;
            }

            // 움직인 방향대로 노드 이동
            node.row += nextRow[node.num];
            node.column += nextColumn[node.num];
            node.count += 1;

            // 범위를 넘어가면 값 변경
            if (node.row < 0 || node.row >= rowSize || node.column < 0 || node.column >= columnSize)
                switchNode(node);

            // 0, 0 으로 들어올때 num 이 queue에 있으면 queue에서 제거
            // 루프롤 줄이기 위함
            if (node.column == 0 && node.row == 0) {
                if (queue.contains(node.num))
                    queue.remove(node.num);
            }

            // 첫 노드와 같은 값이 들어왔다면 루프를 모두 확인한 것
            if (equals(startNode, node))
                break;
        }

        return node.count;
    }

    static void switchNode(Node node) {
        if (node.row < 0)
            node.row = rowSize - 1;
        if (node.row >= rowSize)
            node.row = 0;
        if(node.column < 0)
            node.column = columnSize - 1;
        if (node.column >= columnSize)
            node.column = 0;
    }

    static void setLeft(Node node) {
        num = node.num;
        switch (num) {
            case 0 :
                node.num = 3;
                    break;
            case 1 :
                node.num = 0;
                break;
            case 2 :
                node.num = 1;
                break;
            case 3 :
                node.num = 2;
                break;
        }
    }

    static void setRight(Node node) {
        num = node.num;

        switch (num) {
            case 0 :
                node.num = 1;
                break;
            case 1 :
                node.num = 2;
                break;
            case 2 :
                node.num = 3;
                break;
            case 3 :
                node.num = 0;
                break;
        }
    }

    // hashCode or equals 매서드로 가능할듯?
    static boolean equals(Node sNode, Node cNode) {
        return (sNode.num == cNode.num && sNode.row == cNode.row && sNode.column == cNode.column) ? true : false;
    }
}

class Node {
    int num;
    int row;
    int column;
    int count;

    public Node(int num, int row, int column) {
        this.num = num;
        this.row = row;
        this.column = column;
        this.count = 0;
    }
}
