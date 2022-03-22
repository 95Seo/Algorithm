package Mogacko.Tree;

import java.util.Vector;

// 트리의 가장 깊은 레벨에 존재하는 노드와, 그때의 트리의 높이를 구하세요.
// 노드 : 12, 높이 4(0부터 시작)
public class BinaryTreeQuiz {
    static int global_node, global_height = 0;

    public static Node initTree() {
        Node root = new Node(7);

        Node node2 = new Node(3);
        Node node3 = new Node(10);

        root.left = node2;
        root.right = node3;

        Node node4 = new Node(1);
        Node node5 = new Node(5);

        node2.left = node4;
        node2.right = node5;

        Node node6 = new Node(4);

        node5.right = node6;

        Node node7 = new Node(12);

        node6.right = node7;

        Node node8 = new Node(8);

        node3.left = node8;

        return root;
    }

    // 후위 (왼쪽 -> 오른쪽 -> 부모)
    public static void preOrder(Node node, int height) {
        if(node == null) {
            height--;
            return;
        }
        System.out.println("Height[" + height + "] : " + node.data);
        height++;
        preOrder(node.left, height);
        preOrder(node.right, height);
        if (global_height < height) {
            global_node = node.data;
            global_height = height;
        }
    }

    // 중위 (왼쪽 -> 부모 -> 오른쪽)
    public static void inOrder(Node node, int height) {
        if(node == null) {
            height--;
            return;
        }
        System.out.println("Height[" + height + "] : " + node.data);
        height++;
        preOrder(node.left, height);
        if (global_height < height) {
            global_node = node.data;
            global_height = height;
        }
        preOrder(node.right, height);
    }

    // 전위 (부모 -> 왼쪽 -> 오른쪽)
    public static void postOrder(Node node, int height) {
        if(node == null) {
            height--;
            return;
        }
        if (global_height < height) {
            global_node = node.data;
            global_height = height;
        }
        System.out.println("Height[" + height + "] : " + node.data);
        height++;
        preOrder(node.left, height);
        preOrder(node.right, height);
    }

    public static void main(String[] args) {

        System.out.println("================================ PreOrder ================================");
        // preOrder Given
        Node root = initTree();

        // preOrder When
        preOrder(root, 0);

        // preOrder Then
        System.out.printf("가장 깊은 노드 : %d, 가장 깊은 레벨 : %d\n", global_node, global_height);

        // ----------------------------------------------------------------------------------------------------

        System.out.println("================================ InOrder ================================");
        // inOrder Given
        global_node = 0;
        global_height = 0;

        // inOrder When
        inOrder(root, 0);

        // inOrder Then
        System.out.printf("가장 깊은 노드 : %d, 가장 깊은 레벨 : %d\n", global_node, global_height);

        // ----------------------------------------------------------------------------------------------------

        System.out.println("================================ PostOrder ================================");
        // postOrder Given
        global_node = 0;
        global_height = 0;

        // postOrder When
        postOrder(root, 0);

        // postOrder Then
        System.out.printf("가장 깊은 노드 : %d, 가장 깊은 레벨 : %d\n", global_node, global_height);
    }
}
