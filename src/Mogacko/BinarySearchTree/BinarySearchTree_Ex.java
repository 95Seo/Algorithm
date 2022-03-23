package Mogacko.BinarySearchTree;

// 이진 탐색 트리는 기본적으로 데이터의 삽입, 검색, 삭제 기능이 있어야 함
public class BinarySearchTree_Ex {



    public static void main(String[] args) {
        BinarySearchTree BST = new BinarySearchTree();
        BST.setRoot(7);

        BST.insert(3);
        BST.insert(1);
        BST.insert(5);
        BST.insert(10);
        BST.insert(8);

        System.out.printf("root -> left -> left : %d\n", BST.root.left.left.data);
        System.out.printf("root -> left -> right : %d\n", BST.root.left.right.data);
        System.out.printf("root -> right -> left : %d\n", BST.root.right.left.data);

        BST.insert(4);
        BST.insert(12);
        BST.insert(15);

        System.out.printf("root -> right -> right : %d\n", BST.root.right.right.data);
        System.out.printf("root -> right -> right -> right : %d\n", BST.root.right.right.right.data);

        BST.delete(7);
        BST.in_order(BST.root);
    }
}
