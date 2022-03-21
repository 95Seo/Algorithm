package Mogacko.LinkedList;

public class LinkedList_Ex {
    public static void main(String[] args) {

        LinkedList LL = new LinkedList();

        LL.append(1);
        LL.append(2);
        LL.append(3);
        LL.print_linked_list();

        LL.insert(10, 0);
        LL.print_linked_list();

        LL.insert(20, 3);
        LL.print_linked_list();

        LL.delete(1);
        LL.print_linked_list();

        LL.delete(0);
        LL.print_linked_list();

        LL.insert(30, 3);
        LL.print_linked_list();

    }
}
