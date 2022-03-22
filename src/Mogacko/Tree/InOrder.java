package Mogacko.Tree;

// 중위 순회
// 왼쪽 자식 노드 -> 부모 노드 -> 오른쪽 자식 노드
// 출력 : 4 -> 2 -> 5 -> 1 -> 3
public class InOrder {
    public static Node initTree() {
        Node root = new Node(1);

        Node node2 = new Node(2);
        Node node3 = new Node(3);

        root.left = node2;
        root.right = node3;

        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node2.left = node4;
        node2.right = node5;



        return root;
    }

    public static void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    public static void main(String[] args) {
        Node root = initTree();
        inOrder(root);
    }
}
