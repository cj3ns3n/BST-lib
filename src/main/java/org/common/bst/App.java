package org.common.bst;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Integer> inputs = Arrays.asList(12, 11, 90, 82, 7, 9);
        //List<int> input = Arrays.asList(26, 82, 16, 92, 33);

        final BST tree = new BST();
        inputs.forEach(input -> tree.addValue(input));
    }
}
