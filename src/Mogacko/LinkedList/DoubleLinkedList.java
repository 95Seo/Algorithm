package Mogacko.LinkedList;

// 구현
// append(value) ▶ 링크드리스트의 마지막에 데이터를 추가
// insert(value, idx) ▶ 링크드리스트의 idx 위치에 데이터를 추가
// delete(idx) ▶ 링크드리스트의 idx 위치의 노드를 제거
// get(idx) ▶ 링크드리스트의 idx 위치의 노드를 가져온다.
// print_linked_list ▶ 링크드리스트의 모든 요소를 출력한다.
public class DoubleLinkedList {
    DoubleNode header = new DoubleNode(null);

    public DoubleNode get(int idx) {
        DoubleNode node = header.nextPointer;

        while (true) {
            if(idx == 0)
                break;
            if (node == null) {
                System.out.println("Index Error");
                return null;
            }
            node = node.nextPointer;
            idx--;
        }
        return node;
    }

    public void append(Object input) {
        DoubleNode node = header;
        DoubleNode newNode = new DoubleNode(input);

        while(true) {
            if(node.nextPointer == null)
                break;
            node = node.nextPointer;
        }
        node.nextPointer = newNode;
        newNode.prePointer = node;
    }

    public void insert(Object input, int idx) {
        DoubleNode node = header;
        DoubleNode newNode = new DoubleNode(input);
        DoubleNode bufferNode = null;

        while (true){
            if (idx == 0)
                break;
            if(node == null) {
                System.out.println("index error");
                break;
            }
            node = node.nextPointer;
            idx--;
        }

        bufferNode = node.nextPointer;
        node.nextPointer = newNode;
        newNode.prePointer = node;
        newNode.nextPointer = bufferNode;
        if (bufferNode != null)
            bufferNode.prePointer = newNode;
    }

    public void delete(int idx) {
        DoubleNode node = null;
        if(idx == 0) {
            header.nextPointer = header.nextPointer.nextPointer;
        } else {
            node = get(idx);
            node.prePointer.nextPointer = node.nextPointer;
            node.nextPointer.prePointer = node.prePointer;
        }
    }

    public void print_linked_list() {
        DoubleNode node = header.nextPointer;

        while (node.nextPointer != null) {
            System.out.print(node.data + " -> ");
            node = node.nextPointer;
        }
        System.out.println(node.data);

    }
}