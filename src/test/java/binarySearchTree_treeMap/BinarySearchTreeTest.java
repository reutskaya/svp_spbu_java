package binarySearchTree_treeMap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinarySearchTreeTest {

    //insert
    @Test
    public void insertManyValuesAtOneKey(){
        BinarySearchTree<Integer, Integer> testBST = new BinarySearchTree<>();
        for (int i = 0; i < 1000; i++){
            testBST.insert(0, i);
        }

        assertTrue(testBST.contains(0));
    }

    @Test
    public void insertManyKeys(){
        BinarySearchTree<Integer, Integer> testBST = new BinarySearchTree<>();
        for (int i = 0; i < 1000; i++){
            testBST.insert(i, i);
        }

        assertTrue(testBST.contains(784));
    }

    //delete
    @Test
    public void delete(){
        BinarySearchTree<Integer, Integer> testBST = new BinarySearchTree<>();
        for(int i = 0; i < 10; i++){
            testBST.insert(i, i);
        }

        assertEquals(testBST.delete(0).get(0), (Integer) 0);
        testBST.delete(9);
        assertFalse(testBST.contains(0));
        assertFalse(testBST.contains(9));
        assertTrue(testBST.contains(2));
    }
}
