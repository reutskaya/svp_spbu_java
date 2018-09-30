package LinkedList_Queue;

import java.util.Collection;
import java.util.Iterator;

public class Queue<E> implements java.util.Queue<E> {
    private LinkedList<E> queue;

    Queue() {
        this.queue = new LinkedList<E>();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return queue.contains(o);
    }

    @Override
    public boolean add(E e) {
        return queue.add(e);
    }

    @Override
    public E poll() {
        E item = queue.get(0);
        queue.remove(0);
        return item;
    }

    @Override
    public E peek() {
        return queue.get(0);
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }
}
