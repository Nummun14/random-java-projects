package school;

public class Test {
    public static void main(String[] args) {
        IntNode node = new IntNode(1, new IntNode(3, new IntNode(4, new IntNode(6, new IntNode(9)))));
        IntNode node2 = new IntNode(2, new IntNode(3, new IntNode(5, new IntNode(7, new IntNode(9, new IntNode(19, new IntNode(21)))))));
        System.out.println(IntNodeUtils.mergeSortedNodes(node, node2));
    }
}
