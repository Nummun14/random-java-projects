package school.nodes;

public class IntNode {
    private int value;
    private IntNode next;

    public IntNode(int value, IntNode next) {
        this.value = value;
        this.next = next;
    }

    public IntNode(int value) {
        this(value, null);
    }

    public int getValue() {
        return value;
    }

    public IntNode getNext() {
        return next;
    }

    public void setNext(IntNode next) {
        this.next = next;
    }

    public void setValue(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "IntNode{" +
                "value=" + value +
                ", next=" + (next == null ? "null" : next.toString()) +
                '}';
    }
}