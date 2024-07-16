package com.example.tennis_backend;

import com.googlecode.concurrenttrees.common.Iterables;
import com.googlecode.concurrenttrees.radix.ConcurrentRadixTree;
import com.googlecode.concurrenttrees.radix.RadixTree;
import com.googlecode.concurrenttrees.radix.node.concrete.DefaultCharArrayNodeFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConcurrentTreeTests {


    @Test
    void testKeysStartingWith() {
        RadixTree<Integer> tree = new ConcurrentRadixTree<Integer>(new DefaultCharArrayNodeFactory());

        tree.put("FEDERER", 1);
        tree.put("FERRERO", 2);
        tree.put("DJOKOVIC", 3);
        assertEquals("[FEDERER, FERRERO]", Iterables.toString(tree.getKeysStartingWith("FE")));
    }

    @Test
    void testKeysClosestTo() {
        RadixTree<Integer> tree = new ConcurrentRadixTree<Integer>(new DefaultCharArrayNodeFactory());

        tree.put("FEDERER", 1);
        tree.put("FERRERO", 2);
        tree.put("DJOKOVIC", 3);
        assertEquals("[DJOKOVIC]", Iterables.toString(tree.getClosestKeys("DUSTIN")));
    }

}
