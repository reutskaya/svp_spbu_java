package binarySearchTree_treeMap;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class TreeMapTest {

    //isEmpty
    @Test
    public void isEmpty(){
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        System.out.println(treeMap.isEmpty());
    }

    //put
    @Test
    public void putMappedKey(){
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int i = 0; i < 10; i++){
            treeMap.put(i, i);
        }

        assertEquals(treeMap.put(2, 1), (Integer) 2);
    }

    @Test
    public void putUnmappedKey(){
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int i = 0; i < 10; i++){
            treeMap.put(i, i);
        }

        assertNull(treeMap.put(12, 12));
    }

    //remove
    @Test
    public void removeMappedKey(){
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(Integer i = 0; i < 10; i++){
            treeMap.put(i, i);
        }

        assertEquals(treeMap.remove(5), (Integer) 5);
        assertFalse(treeMap.containsKey(5));
        assertTrue(treeMap.containsValue(5));
    }

    @Test
    public void removeUnmappedKey(){
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int i = 0; i < 10; i++){
            treeMap.put(i, i);
        }

        assertNull(treeMap.remove(12));
    }

    //get
    @Test
    public void get(){
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int i = 0; i < 10; i++){
            treeMap.put(i, i);
        }

        assertEquals(treeMap.get(5),(Integer) 5);
    }
}
