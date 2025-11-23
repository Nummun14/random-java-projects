package school;

public class Test {
    public static void main(String[] args) {
        Node<Integer> L1 = new Node<>(4, new Node<>(3, new Node<>(2, new Node<>(6))));
        Node<Integer> L2 = new Node<>(10, new Node<>(11, new Node<>(19, new Node<>(1, new Node<>(7, new Node<>(100))))));
        System.out.println(NodeUtils.veryAnnoyingQuestionINeverWantToTouchAgain(L1, L2));
    }
}
