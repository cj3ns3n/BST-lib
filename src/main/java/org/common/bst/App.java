package org.common.bst;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class App
{
    /**
     * Displayes the deepest nodes of a BST.
     *
     * @param args space separated list of integers to insert into the BST
     */
    public static void main(String[] args)
    {
        BST<Integer> tree = new BST<>();
        Arrays.stream(args).forEach(input -> tree.addValue(Integer.valueOf(input)));
        Pair<List<Integer>, Long> deepestNodes = tree.getDeepestValues();
        System.out.println(String.format("deepest, %s; depth, %d", deepestNodes.getLeft().toString(), deepestNodes.getRight()));
    }
}
