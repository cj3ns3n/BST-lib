package org.common.bst;

public class BST <T> {
    private Node root;

    public BST() { }

    public BST(Comparable<T> rootValue) {
        root = new Node(rootValue);
    }

    public void addValue(Comparable newValue) {
        if (root == null) {
            root = new Node(newValue);
        } else {
            Node currentNode = root;
            while (currentNode != null) {
                if (newValue.compareTo(currentNode.getValue()) > 0) {
                    if (currentNode.getRightChild() == null) {
                        currentNode.setRightChild(new Node(newValue));
                        currentNode = null;
                    } else {
                        currentNode = currentNode.getRightChild();
                    }
                } else if (newValue.compareTo(currentNode.getValue()) < 0) {
                    if (currentNode.getLeftChild() == null) {
                        currentNode.setLeftchild(new Node(newValue));
                        currentNode = null;
                    } else {
                        currentNode = currentNode.getLeftChild();
                    }
                } else { // duplicate value, increment counter
                    currentNode.incrementCount();
                    currentNode = null;
                }
            }
        }
    }
}
