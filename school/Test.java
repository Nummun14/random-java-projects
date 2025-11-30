package school;

public class Test {
    public static void main(String[] args) {
        Node<Integer> L1 = new Node<>(3, new Node<>(4, new Node<>(5, new Node<>(12, new Node<>(19, new Node<>(20, new Node<>(100, new Node<>(101, new Node<>(102, new Node<>(103, new Node<>(104)))))))))));
        System.out.println(NodeUtils.toRange(L1));
    }
}
