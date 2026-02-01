package school.binnode;

import school.Table;
import school.nodes.Node;
import school.nodes.NodeUtils;

public class BinNodeUtils {
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
        if (tree != null) {
            printLeftChildrenHelper(tree.getLeft());
        }
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
            printLeftChildrenHelper(tree);
        }
    }
}