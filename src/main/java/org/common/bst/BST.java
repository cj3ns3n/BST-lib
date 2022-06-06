package org.common.bst;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST <T> {
    private Node<T> root;

    public BST() { }

    public BST(Comparable<T> rootValue) {
        root = new Node<>(rootValue);
    }

    public void addValue(Comparable<T> newValue) {
        if (root == null) {
            root = new Node<>(newValue);
        } else {
            Node<T> currentNode = root;
            while (currentNode != null) {
                if (newValue.compareTo(currentNode.getValue()) > 0) {
                    if (currentNode.getRightChild().isEmpty()) {
                        currentNode.setRightChild(new Node<>(newValue));
                        currentNode = null;
                    } else {
                        currentNode = currentNode.getRightChild().get();
                    }
                } else if (newValue.compareTo(currentNode.getValue()) < 0) {
                    if (currentNode.getLeftChild().isEmpty()) {
                        currentNode.setLeftchild(new Node<>(newValue));
                        currentNode = null;
                    } else {
                        currentNode = currentNode.getLeftChild().get();
                    }
                } else { // duplicate value, increment counter
                    currentNode.incrementCount();
                    currentNode = null;
                }
            }
        }
    }

    public Pair<List<T>, Long> getDeepestValues() {
        if (root == null) {
            throw new IllegalStateException("no nodes present in the tree");
        }

        Queue<Node<T>> nextLevel = new LinkedList<>();
        nextLevel.add(root);
        List<T> lastLevel = new ArrayList<>();
        long levelCount = -1;

        while (!nextLevel.isEmpty()) {
            levelCount++;
            Queue<Node<T>> currentLevel = nextLevel;
            nextLevel = new LinkedList<>();
            lastLevel = new ArrayList<>();

            while (!currentLevel.isEmpty()) {
                Node<T> currentNode = currentLevel.remove();
                lastLevel.add(currentNode.getValue());
                if (currentNode.getLeftChild().isPresent()) {
                    nextLevel.add(currentNode.getLeftChild().get());
                }
                if (currentNode.getRightChild().isPresent()) {
                    nextLevel.add(currentNode.getRightChild().get());
                }
            }
        }

        return ImmutablePair.of(lastLevel, levelCount);
    }
}
