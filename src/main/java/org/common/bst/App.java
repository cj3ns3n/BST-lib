package org.common.bst;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class App
{
    public static void main(String[] args)
    {
        final BST tree = new BST();
        Arrays.stream(args).forEach(input -> tree.addValue(Integer.valueOf(input)));
        Pair<List<Integer>, Long> deepestNodes = tree.getDeepestValues();
        System.out.println(String.format("deepest, %s; depth, %d", deepestNodes.getLeft().toString(), deepestNodes.getRight()));
    }
}
