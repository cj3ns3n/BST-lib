package org.common.bst;

public class Node <T> {
    private  Comparable value;
    private Node lChild;
    private Node rChild;
    private int count; // duplicate values are handled by keeping a count

    public Node(Comparable<T> value) {
        this.value = value;
        this.count = 1;
    }

    public Comparable<T> getValue() {
        return value;
    }

    public Node getLeftChild() {
        return lChild;
    }

    public void setLeftchild(Node lChild) {
        this.lChild = lChild;
    }

    public Node getRightChild() {
        return rChild;
    }

    public void setRightChild(Node rChild) {
        this.rChild = rChild;
    }

    public void incrementCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
