package Mogacko.BinarySearchTree;

public class BinarySearchTree {
    Node root;

    public void setRoot(int data) {
        this.root = new Node(data);
    }

    public int find_node_by_recursion(Node currentNode, int data) {
        if(currentNode == null)
            return 0;

        if(currentNode.data > data)
            return find_node_by_recursion(currentNode.left, data);
        else if(currentNode.data < data)
            return find_node_by_recursion(currentNode.right, data);

        return 1;
    }

    public int find(int data) {
        if(find_node_by_recursion(root, data) == 0)
            return 0;
        else
            return 1;
    }

    public void insert_node(Node currentNode, int data) {
        if(currentNode.data == data) {
            System.out.printf("이미 %d값이 존재합니다. 중복된 값은 삽입할 수 없습니다. \n", data);
            return;
        }

        if(currentNode.data > data) {
            if(currentNode.left == null)
                currentNode.left = new Node(data);
            else
                insert_node(currentNode.left, data);
        } else if(currentNode.data < data) {
            if(currentNode.right == null)
                currentNode.right = new Node(data);
            else
                insert_node(currentNode.right, data);
        }
    }

    public void insert(int data) {
        if(root == null)
            setRoot(data);
        else
            insert_node(root, data);
    }

    public Node get_next_node(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // 복습하자
    public void delete_node(Node parent, Node currentNode, int data) {
        if(currentNode == null) {
            System.out.printf("트리에 %d가 존재하지 않습니다. \n", data);
            return;
        }

        if(currentNode.data > data)
            delete_node(currentNode, currentNode.left, data);
        else if(currentNode.data < data)
            delete_node(currentNode, currentNode.right, data);
        else {
            if(currentNode.left == null && currentNode.right == null) {
                if(parent.data > data)
                    parent.left = null;
                else
                    parent.right = null;
            } else if(currentNode.left != null && currentNode.right == null) {
                if(parent.data > data)
                    parent.left = currentNode.left;
                else
                    parent.right = currentNode.left;
            } else if(currentNode.left == null && currentNode.right != null) {
                if(parent.data > data)
                    parent.left = currentNode.right;
                else
                    parent.right = currentNode.right;
            } else if(currentNode.left != null && currentNode.right != null) {
                Node next_node = get_next_node(currentNode.right);
                currentNode.data = next_node.data;
                delete_node(currentNode, currentNode.right, next_node.data);
            }
        }
    }

    public void delete(int data) {
        if(root == null)
            System.out.println("트리에 노드가 존재하지 않습니다.");
        else
            delete_node(null, root, data);
    }

    // 중위 탐색
    // 왼쪽 -> 부모 -> 오른쪽
    public void in_order(Node root) {
        if(root == null) {
            return;
        }

        in_order(root.left);
        System.out.print(root.data);
        System.out.print(" -> ");
        in_order(root.right);
    }
}
