package Mogacko.LinkedList;

public class DoubleLinkedList_Ex {
    public static void main(String[] args) {

        DoubleLinkedList DLL = new DoubleLinkedList();

        DLL.append(1);
        DLL.append(2);
        DLL.append(3);
        DLL.print_linked_list();

        DLL.insert(10, 0);
        DLL.print_linked_list();

        DLL.insert(20, 3);
        DLL.print_linked_list();

        DLL.delete(1);
        DLL.print_linked_list();

        DLL.delete(0);
        DLL.print_linked_list();

        DLL.insert(30, 3);
        DLL.print_linked_list();

    }
}
