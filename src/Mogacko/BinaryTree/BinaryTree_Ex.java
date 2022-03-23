package Mogacko.BinaryTree;

public class BinaryTree_Ex {
    public static void main(String[] args) {
        Node root = new Node(1);

        Node node2 = new Node(2);
        Node node3 = new Node(3);

        root.left = node2;
        root.right = node3;

        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node2.left = node4;
        node2.right = node5;

        System.out.println(root.data);
        System.out.printf("%d %d\n", root.left.data ,root.right.data);
        System.out.printf("%d %d\n", root.left.left.data, root.left.right.data);
    }
}
