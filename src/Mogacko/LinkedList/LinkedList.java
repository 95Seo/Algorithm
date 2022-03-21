package Mogacko.LinkedList;

public class LinkedList {
    private Node head = new Node(null);

    public Node get(int index) {
        Node node = this.head.pointer;

        while (true) {
            if (index == 0)
                return node;

            if (node == null) {
                System.out.println("Index Error");
                return null;
            }

            node = node.pointer;
            index--;
        }
    }

    public void append(int data) {
        Node node = head;
        Node newNode = new Node(data);

        while (true) {
            if (node.pointer == null)
                break;
            node = node.pointer;
        }

        node.pointer = newNode;
    }

    public void insert(int data, int index) {
        Node node = head;
        Node newNode = new Node(data);

        while (true) {
            if (node == null) {
                System.out.println("Index error");
                return;
            }

            if (index == 0) {
                Node nextNode = node.pointer;
                node.pointer = newNode;
                newNode.pointer = nextNode;
                break;
            }

            node = node.pointer;
            index--;
        }
    }

    void delete(int index) {
        if (index == 0) {
            head.pointer = head.pointer.pointer;
        }
        else {
            // get함수를 사용해, 인덱스 위치의 데이터를 얻어온다
            Node node = get(index - 1);
            node.pointer = node.pointer.pointer;
        }
    }

    void print_linked_list() {
        Node node = head.pointer;
        while (node != null) {
            if (node.pointer != null)
                System.out.print(node.data + " -> ");
            else
                System.out.println(node.data);

            node = node.pointer;
        }
    }
}
