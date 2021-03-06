package binarySearchTree_treeMap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class BinarySearchTree<E extends Comparable<E>, V> {

    private static class Node<E, V> {
        private E key;
        private List<V> values;
        private Node leftChild;
        private Node rightChild;

        Node(E key, V value, Node<E, V> leftChild, Node<E, V> rightChild) {
            this.key = key;
            this.values = new ArrayList<>();
            this.values.add(value);
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    private Node<E, V> root;

    BinarySearchTree() {
        this.root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void insert(E key, V value) {
        root = insertRecursive(root, key, value);
    }

    private Node<E, V> insertRecursive(Node<E, V> node, E key, V value) {
        if (node == null) {
            node = new Node(key, value, null, null);
            return node;
        }

        if (key.compareTo(node.key) < 0) {
            node.leftChild = insertRecursive(node.leftChild, key, value);
        } else {
            if (key.compareTo(node.key) > 0) {
                node.rightChild = insertRecursive(node.rightChild, key, value);
            } else {
                if (node.key.compareTo(key) == 0) {
                    node.values.add(value);
                }
            }
        }

        return node;
    }

    List<V> delete(E key) {
        List<V> result = getValues(key, root);
        root = deleteRecursive(key, root);
        return result;
    }

    private Node<E, V> deleteRecursive(E key, Node<E, V> node) {

        if (node == null) {
            throw new NoSuchElementException("no such element");
        } else {
            if (node.key.compareTo(key) < 0) {
                node.rightChild = deleteRecursive(key, node.rightChild);
            } else {
                if (node.key.compareTo(key) > 0) {
                    node.leftChild = deleteRecursive(key, node.leftChild);
                } else {

                    if (node.leftChild == null) {
                        return node.rightChild;
                    } else {
                        if (node.rightChild == null) {
                            return node.leftChild;
                        } else {
                            Node<E, V> tempNode = minimalNode(node.rightChild);

                            node.key = tempNode.key;
                            node.values = tempNode.values;
                            node.rightChild = deleteRecursive(tempNode.key, node.rightChild);
                        }
                    }
                }
            }
        }

        return node;
    }

    private Node<E, V> minimalNode(Node<E, V> node) {
        if (node.leftChild != null) {
            minimalNode(node.leftChild);
        }
        return node;
    }


    private List<V> getValues(E key, Node<E, V> node) {
        if (node == null) {
            throw new NoSuchElementException("no such element");
        }

        List<V> result;

        if (node.key.compareTo(key) < 0) {
            result = getValues(key, node.rightChild);
        } else if (node.key.compareTo(key) > 0) {
            result = getValues(key, node.leftChild);
        } else {
            result = node.values;
        }

        return result;
    }

    boolean contains(E key) {
        try {
            getValues(key, root);
        } catch (NoSuchElementException e) {
            return false;
        }

        return true;
    }

    List<V> get(E key) {
        if (contains(key)) {
            return getValues(key, root);
        } else {
            throw new NoSuchElementException();
        }
    }
}

