package binarySearchTree_treeMap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class TreeMap<E extends Comparable<E>, V> implements java.util.Map<E, V> {

    private BinarySearchTree<E, V> tree = new BinarySearchTree<>();

    @Override
    public int size() {
        throw new UnsupportedOperationException("operation is unsupported");
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) {
            throw new NullPointerException("map does not permit null keys");
        }

        return tree.contains((E) key);
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("operation is unsupported");
    }

    @Override
    public V get(Object key) {
        if (key == null) {
            throw new NullPointerException("map does not permit null keys");
        }

        return tree.get((E) key).get(0);
    }

    @Override
    public V put(E key, V value) {
        if (key == null) {
            throw new NullPointerException("map does not permit null keys");
        }

        if (tree.contains(key)) {
            V temp = tree.get(key).get(0);
            tree.get(key).remove(0);
            tree.get(key).add(0, value);

            return temp;
        } else {
            tree.insert(key, value);
            return null;
        }
    }

    @Override
    public V remove(Object key) {
        if(key == null){
            throw  new NullPointerException("map does not permit null keys");
        }

        if (tree.contains((E) key)){
            V temp = tree.get((E) key).get(0);
            tree.delete((E) key);
            return temp;
        }

        return  null;
    }

    @Override
    public void putAll(Map<? extends E, ? extends V> m) {
        throw new UnsupportedOperationException("operation is unsupported");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("operation is unsupported");
    }

    @Override
    public Set<E> keySet() {
        throw new UnsupportedOperationException("operation is unsupported");
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException("operation is unsupported");
    }


    public Set<Entry<E, V>> entrySet() {
        throw new UnsupportedOperationException("operation is unsupported");
    }
}
