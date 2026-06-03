package school.binnode;

import school.Table;
import school.nodes.Node;
import school.nodes.NodeUtils;
import school.queue.Queue;

public class BinNodeUtils {
    public static boolean isDivisor(BinNode<Integer> T1, BinNode<Integer> T2) {
        if (T1 == null)
            return true;
        if (getAmountOfDevisors(T2, T1.getValue()) < 3)
            return false;
        return isDivisor(T1.getLeft(), T2) && isDivisor(T1.getRight(), T2);
    }

    private static int getAmountOfDevisors(BinNode<Integer> tree, int num) {
        if (tree == null)
            return 0;
        if (num % tree.getValue() == 0)
            return 1 + getAmountOfDevisors(tree.getRight(), num) + getAmountOfDevisors(tree.getLeft(), num);
        return getAmountOfDevisors(tree.getRight(), num) + getAmountOfDevisors(tree.getLeft(), num);
    }

    public static boolean treeEqual(BinNode<Integer> tree) {
        int amount0 = getAmountOfRemainder(tree, 0);
        return amount0 == getAmountOfRemainder(tree, 1) && amount0 == getAmountOfRemainder(tree, 2);
    }

    private static int getAmountOfRemainder(BinNode<Integer> tree, int remainder) {
        if (tree != null && tree.getValue() % 3 == remainder)
            return getAmountOfRemainder(tree.getLeft(), remainder) + getAmountOfRemainder(tree.getRight(), remainder) + 1;
        if (tree != null)
            return getAmountOfRemainder(tree.getLeft(), remainder) + getAmountOfRemainder(tree.getRight(), remainder);
        return 0;
    }

    public static void printAll(BinNode<Integer> tree) {
        printAllHelper(tree, "");
    }

    private static void printAllHelper(BinNode<Integer> tree, String current) {
        if (tree == null)
            return;
        current += tree.getValue();
        if (!tree.hasLeft() && !tree.hasRight())
            System.out.println(current);
        if (tree.hasRight())
            printAllHelper(tree.getRight(), current);
        if (tree.hasLeft())
            printAllHelper(tree.getLeft(), current);
    }

    public static boolean isLeftK(BinNode<Integer> tree, int k) {
        return isLeftK(tree.getLeft(), k, 1) && isLeftK(tree.getRight(), k, 0);
    }

    private static boolean isLeftK(BinNode<Integer> tree, int k, int num) {
        if (tree == null)
            return true;
        if (num > k)
            return false;
        return isLeftK(tree.getLeft(), k, num + 1) && isLeftK(tree.getRight(), k, num);
    }

    public static boolean getBooleanValue(BinNode<String> tree) {
        if (!tree.hasLeft() && !tree.hasRight())
            return tree.getValue().equals("T");
        if (tree.getValue().equals("AND"))
            return getBooleanValue(tree.getRight()) && getBooleanValue(tree.getLeft());
        return getBooleanValue(tree.getRight()) || getBooleanValue(tree.getLeft());
    }

    public static boolean areAllNumbersEven(BinNode<Integer> tree) {
        if (tree == null)
            return true;
        if (tree.getValue() % 2 != 0)
            return false;

        return areAllNumbersEven(tree.getLeft()) && areAllNumbersEven(tree.getRight());
    }

    public static boolean isMoreRightNodesThanLeft(BinNode<Integer> tree) {
        if (tree == null)
            return false;
        return getNumNodes(tree.getRight()) > getNumNodes(tree.getLeft());
    }

    public static Node<Integer> getSum(BinNode<Node<Integer>> tree) {
        Node<Integer> node = new Node<>(0);
        add(tree, node);
        return node;
    }

    public static void add(BinNode<Node<Integer>> tree, Node<Integer> node) {
        if (tree != null) {
            node.setValue(node.getValue() + tree.getValue().getValue());
            add(tree.getRight(), node);
            add(tree.getLeft(), node);
        }
    }

    public static Queue<Integer> getEvenQueue(BinNode<Integer> tree) {
        Queue<Integer> queue = new Queue<>();
        add(queue, tree);
        return queue;
    }

    public static void add(Queue<Integer> queue, BinNode<Integer> tree) {
        if (tree != null) {
            if (tree.getValue() % 2 == 0)
                queue.insert(tree.getValue());
            add(queue, tree.getRight());
            add(queue, tree.getLeft());
        }
    }

    public static String hasMoreOddEvenOrEqual(BinNode<Integer> tree) {
        int odd = getAmountOfEvenOrOddNodes(tree, false);
        int even = getAmountOfEvenOrOddNodes(tree, true);
        if (even == odd)
            return "Equal";
        if (even > odd)
            return "Even";
        return "Odd";
    }

    public static int getAmountOfEvenOrOddNodes(BinNode<Integer> tree, boolean even) {
        if (tree == null)
            return 0;

        int mod = even ? 0 : 1;
        return (tree.getValue() % 2 == mod ? 1 : 0) + getAmountOfEvenOrOddNodes(tree.getLeft(), even) + getAmountOfEvenOrOddNodes(tree.getRight(), even);
    }

    public static int getBiggest(BinNode<Integer> tree) {
        if (tree == null)
            return 0;

        int rightBiggest = getBiggest(tree.getRight());
        int leftBiggest = getBiggest(tree.getLeft());
        if (tree.getValue() > rightBiggest && tree.getValue() > leftBiggest)
            return tree.getValue();
        if (rightBiggest > leftBiggest)
            return rightBiggest;
        return leftBiggest;
    }

    public static int getNumLeaves(BinNode<Integer> tree) {
        if (tree == null)
            return 0;
        if (!tree.hasLeft() && !tree.hasRight())
            return 1;
        return getNumLeaves(tree.getRight()) + getNumLeaves(tree.getLeft());
    }

    public static int getSumOfNodes(BinNode<Integer> tree) {
        if (tree == null)
            return 0;
        return tree.getValue() + getSumOfNodes(tree.getLeft()) + getSumOfNodes(tree.getRight());
    }

    public static boolean isAmountOfNodesEven(BinNode<Integer> tree) {
        return getNumNodes(tree) % 2 == 0;
    }

    public static int getNumNodes(BinNode<Integer> tree) {
        if (tree == null)
            return 0;
        return 1 + getNumNodes(tree.getLeft()) + getNumNodes(tree.getRight());
    }

    public static void printBlue(BinNode<Table> tables) {
        if (tables != null) {
            System.out.println(tables.getValue());
            printBlue(tables.getRight());
            printBlue(tables.getLeft());
        }
    }

    public static void colorYellowTables(BinNode<Table> tables, String color) {
        if (tables != null) {
            if (tables.getValue().getColor().equals("Yellow"))
                tables.getValue().setColor(color);

            colorYellowTables(tables.getLeft(), color);
            colorYellowTables(tables.getRight(), color);
        }
    }

    public static void printSingleChildNodes(BinNode<Integer> tree) {
        if (tree != null) {
            boolean hasRightChild = tree.getRight() != null;
            boolean hasLeftChild = tree.getLeft() != null;

            if ((hasRightChild && !hasLeftChild) || (!hasRightChild && hasLeftChild))
                System.out.println(tree.getValue());

            printSingleChildNodes(tree.getLeft());
            printSingleChildNodes(tree.getRight());
        }
    }

    public static void printLeaves(BinNode<Integer> tree) {
        if (tree != null) {
            if (tree.getLeft() == null & tree.getRight() == null)
                System.out.println(tree.getValue());

            printLeaves(tree.getRight());
            printLeaves(tree.getLeft());
        }
    }

    public static void printLeftChildren(BinNode<Integer> tree) {
        if (tree != null)
            printLeftChildrenHelper(tree.getLeft());
    }

    public static void printSumOfNodesInBinNode(BinNode<Node<Integer>> tree) {
        if (tree != null) {
            System.out.println(NodeUtils.getSum(tree.getValue()));
            printSumOfNodesInBinNode(tree.getLeft());
            printSumOfNodesInBinNode(tree.getRight());
        }
    }

    private static void printLeftChildrenHelper(BinNode<Integer> tree) {
        if (tree != null) {
            System.out.println(tree.getLeft());
            printLeftChildrenHelper(tree.getLeft());
        }
    }
}