package LinkedList_Queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<E> implements List<E> {
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> previous;

        Node(Node<E> previous, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.previous = previous;
        }
    }

    private int size;
    private Node<E> first;
    private Node<E> last;

    LinkedList() {
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null)
            throw new IllegalArgumentException("null was requested");
        else {
            for (Node<E> node = first; node != null; node = node.next) {
                if (node.item.equals(o))
                    return true;
            }
        }

        return false;
    }

    @Override
    public boolean add(E o) {
        if (o == null) {
            throw new NullPointerException("You try to add null element");
        }

        if (!isEmpty()) {
            Node<E> temp = this.last;
            last = new Node(this.last, o, null);
            temp.next = last;
        } else {
            last = new Node(null, o, null);
            first = last;
        }
        size++;

        return true;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> element = this.first;

        for (int i = 0; i < index; i++) {
            element = element.next;
        }

        return element.item;
    }

    @Override
    public void add(int index, E element) {
        if (element == null) {
            throw new NullPointerException("You try to add null element");
        }

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            Node<E> node = new Node<>(null, element, first);
            first.previous = node;
            first = node;
            size++;
            return;
        }

        if (index == size) {
            add(element);
            return;
        }

        Node<E> nodeForSearch = this.first;

        for (int i = 0; i < index; i++) {
            nodeForSearch = nodeForSearch.next;
        }

        Node<E> previousNode = nodeForSearch.previous;
        Node<E> nodeToAdd = new Node<>(previousNode, element, nodeForSearch);
        previousNode.next = nodeToAdd;
        nodeForSearch.previous = nodeToAdd;
        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node<E> e = this.first;

        if (index == 0) {
            this.first = this.first.next;
            E result = e.item;
            e.previous = null;
            e.next = null;
            size--;

            return result;
        }

        for (int i = 0; i < index; i++) {
            e = e.next;
        }

        E result = e.item;
        Node<E> ePrevious = e.previous;
        Node<E> eNext = e.next;
        ePrevious.next = eNext;
        if (eNext != null) {
            eNext.previous = ePrevious;
        }

        e.next = e.previous = null;
        e.item = null;
        size--;

        return result;
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        if (!contains(o)) {
            return -1;
        }

        for (Node<E> node = first; node != null; node = node.next) {
            if (node.item.equals(o)) {
                return i;
            } else {
                i++;
            }
        }
        return i;
    }

    @Override
    public E set(int index, E element) {
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
    public boolean addAll(int index, Collection<? extends E> c) {
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
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
