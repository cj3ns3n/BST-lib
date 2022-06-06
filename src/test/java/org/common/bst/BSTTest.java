package org.common.bst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BSTTest
{
    @Test
    public void basicTest1()
    {
        List<Integer> inputs = Arrays.asList(12, 11, 90, 82, 7, 9);
        //List<Integer> inputs = Arrays.asList(26, 82, 16, 92, 33);

        BST tree = new BST();
        inputs.forEach(input -> tree.addValue(input));
        Pair<List<Integer>, Long> deepestNodes = tree.getDeepestValues();
        assertEquals(3L, (long)deepestNodes.getRight());
        assertEquals(1, deepestNodes.getLeft().size());
        assertEquals(9, (int)deepestNodes.getLeft().get(0));
    }

    @Test
    public void basicTest2()
    {
        List<Integer> inputs = Arrays.asList(26, 82, 16, 92, 33);

        BST tree = new BST();
        inputs.forEach(input -> tree.addValue(input));
        Pair<List<Integer>, Long> deepestNodes = tree.getDeepestValues();
        assertEquals(2L, (long)deepestNodes.getRight());
        assertEquals(2, deepestNodes.getLeft().size());
        assertTrue(deepestNodes.getLeft().contains(33));
        assertTrue(deepestNodes.getLeft().contains(92));
    }

    @Test
    public void doubleTest()
    {
        List<Double> inputs = Arrays.asList(5.0, 6.1, 6.9, 1.1, 6.7, 13.725, 1337.0, 2.25, 3.45, 0.8, 0.2, 0.1);

        BST tree = new BST();
        inputs.forEach(input -> tree.addValue(input));
        Pair<List<String>, Long> deepestNodes = tree.getDeepestValues();
        assertEquals(4L, (long)deepestNodes.getRight());
        assertEquals(2, deepestNodes.getLeft().size());
        assertTrue(deepestNodes.getLeft().contains(0.1));
        assertTrue(deepestNodes.getLeft().contains(1337.0));
    }

    @Test
    public void stringTest() {
        List<String> inputs = Arrays.asList("a", "b", "c", "d", "e");

        BST tree = new BST();
        inputs.forEach(input -> tree.addValue(input));
        Pair<List<String>, Long> deepestNodes = tree.getDeepestValues();
        assertEquals(4L, (long)deepestNodes.getRight());
        assertEquals(1, deepestNodes.getLeft().size());
        assertEquals("e", deepestNodes.getLeft().get(0));
    }

    @Test
    public void deepTest() {
        Random random = new Random(1000);

        BST tree = new BST();
        for(int i = 0; i < 1000000; i++) {
            tree.addValue(random.nextInt());
        }

        Pair<List<String>, Long> deepestNodes = tree.getDeepestValues();
        assertEquals(48L, (long)deepestNodes.getRight());
        assertTrue(deepestNodes.getLeft().contains(-384081406));
        assertTrue(deepestNodes.getLeft().contains(780253443));
    }

    @Test(expected = IllegalStateException.class)
    public void noNodesTest() {
        BST tree = new BST();
        tree.getDeepestValues();
    }
}
