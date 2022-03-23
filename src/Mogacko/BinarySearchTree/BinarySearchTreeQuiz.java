package Mogacko.BinarySearchTree;

// 전위 순회 결과와 중위 순회 결과가 주어질 때, 이를 참고하여 후위 순회 결과로 재구성 하라
// 전위 : 부모 -> 왼쪽 -> 오른쪽
// 중위 : 왼쪽 -> 부모 -> 오른쪽
// 후위 : 왼쪽 -> 오른쪽 -> 부모

// 출력 예시
// 전위 : [7, 3, 1, 5, 4, 12, 10, 8]
// 중위 : [1, 3, 12, 4, 5, 7, 8, 10]
// 후위 : ???
public class BinarySearchTreeQuiz {

    public static void main(String[] args) {
        int[] preOrder = {7,3,1,5,4,12,10,8};
        int[] inOrder = {1,3,12,4,5,7,8,10};

        printPostOrder(preOrder, inOrder);
    }

    // 트리의 전위 탐색 결과와 중위 탐색 결과가 주어질 때 후위 탐색 결과를 출력.
    static void printPostOrder(int[] preOrder, int[] inOrder) {
        // 트리에 포함된 노드 수
        int num = preOrder.length;

        // 전체 : 텅 빈 트리면 return
        if(preOrder == null)
            return;

        // 이 트리의 루트는 전위 탐색 결과로 부터 알 수 있다.
        int root = preOrder[0];

        // 이 트리의 왼쪽 서브트리의 크기는 중위 탐색 결과에서 루트의 위치를 찾아서 알 수 있다.
        int i = 0;
        for(i = 0; i < num; i++) {
            if(inOrder[i] == root)
                break;
        }

        int left = i;

        // 왼쪽 서브트리의 순회 결과 출력
        // left가 0개면 방문할 필요 없음
        if(left != 0) {
            printPostOrder(slice(preOrder, 1, left), slice(inOrder, 0, left - 1));
        }

        // 오른쪽 서브 트리의 크기는 n에서 왼쪽 서브트리와 루트를 빼면 된다.
        // right = num - left - 1, right가 0개면 방문할 필요 없음
        int right = num - left - 1;

        // 오른쪽 서브트리의 순회 결과 출력
        if(right != 0) {
            printPostOrder(slice(preOrder, left + 1, num - 1), slice(inOrder, left + 1, num - 1));
        }

        System.out.print(root + " ");
    }

    static int[] slice(int[] x, int s, int e) {
        int[] temp = new int[e - s + 1];
        int j = 0;
        for(int i = s; i <= e; i++) {
            temp[j] = x[i];
            j++;
        }
        return temp;
    }
}
