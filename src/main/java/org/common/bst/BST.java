package org.common.bst;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

/**
 * Generic Binary Search Tree supporting any "Comparable" type.
 */
public class BST <T> {
    private Node<T> root;

    public BST() { }

    /**
     * Constructor with root node value
     *
     * @param rootValue the initial root node value
     */
    public BST(Comparable<T> rootValue) {
        root = new Node<>(rootValue);
    }

    /**
     * Add a value to the tree.
     *
     * @param newValue the value to be added
     */
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

    /**
     * Finds a value in the tree.
     *
     * @return true if the value exists, false otherwise
     */
    public boolean findValue(Comparable<T> valueToFind) {
        Optional<Node<T>> currentNodeOptional = Optional.ofNullable(root);

        while (currentNodeOptional.isPresent()) {
            Node<T> currentNode = currentNodeOptional.get();
            int compareValue = valueToFind.compareTo(currentNode.getValue());
            if (compareValue > 0) {
                currentNodeOptional = currentNode.getRightChild();
            } else if (compareValue < 0) {
                currentNodeOptional = currentNode.getLeftChild();
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * Finds the deepest level of the tree and return the level and values.
     * Throws IllegalStateException if there are not values in the tree.
     *
     * @return a pair where the left is a list of the values at the deepest level of
     * the tree and the right is the index of the level (starting with 0)
     */
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
