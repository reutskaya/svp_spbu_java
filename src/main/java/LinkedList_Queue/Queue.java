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
        throw  new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        throw  new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw  new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw  new UnsupportedOperationException();
    }

    @Override
    public boolean offer(E e) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public E remove() {
        throw  new UnsupportedOperationException();
    }
}
