package org.common.bst;

import java.util.Optional;

public class Node <T> {
    private  Comparable<T> value;
    private Node<T> lChild;
    private Node<T> rChild;
    private int count; // duplicate values are handled by keeping a count

    public Node(Comparable<T>  value) {
        this.value = value;
        this.count = 1;
    }

    public T getValue() {
        return (T) value;
    }

    public Optional<Node<T>> getLeftChild() {
        return Optional.ofNullable(lChild);
    }

    public void setLeftchild(Node<T> lChild) {
        this.lChild = lChild;
    }

    public Optional<Node<T>> getRightChild() {
        return Optional.ofNullable(rChild);
    }

    public void setRightChild(Node<T> rChild) {
        this.rChild = rChild;
    }

    public void incrementCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
