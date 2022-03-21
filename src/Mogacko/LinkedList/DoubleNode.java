package Mogacko.LinkedList;

public class DoubleNode {
    public Object data;
    public DoubleNode prePointer;
    public DoubleNode nextPointer;

    public DoubleNode(Object input) {
        this.data = input;
        this.prePointer = null;
        this.nextPointer = null;
    }
}
