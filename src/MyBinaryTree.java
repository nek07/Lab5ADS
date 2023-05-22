import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class MyBinaryTree<K extends Comparable<K>,V> implements Iterable<MyBinaryTree<K, V>.Node> {
    private Node root;
    private int size = 0;

    public class Node {
        private K key;
        private V value;
        private Node left, right;
        /*
         * Constructs a node with the given key and value.
         *
         * @param key   the key of the node
         * @param value the value associated with the key
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /*
         * Retrieves the key of the node.
         *
         * @return the key of the node
         */
        public K getKey() {
            return key;
        }

        /*
         * Retrieves the value associated with the key.
         *
         * @return the value associated with the key
         */
        public V getValue() {
            return value;
        }
    }

    /*
     * Constructs an empty binary tree.
     */
    public MyBinaryTree() {
        root = null;
    }

    /*
     * Inserts a key-value pair into the binary tree.
     *
     * @param key   the key to insert
     * @param value the value associated with the key
     */
    private Node insert(Node current, K key, V value) {
        if (current == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(current.getKey());
        if (cmp < 0) {
            current.left = insert(current.left, key, value);
        } else if (cmp > 0) {
            current.right = insert(current.right, key, value);
        }
        return current;
    }

    /*
     * Inserts a key-value pair into the binary tree.
     *
     * @param key   the key to insert
     * @param value the value associated with the key
     */
    public void insert(K key, V value) {
        root = insert(root, key, value);
        size++;
    }

    /*
     * Removes a node with the specified key from the binary tree.
     *
     * @param current the current node being considered
     * @param key     the key to remove
     * @return the updated node after removal
     */
    private Node remove(Node current, K key) {
        if (current == null) {
            return null;
        }
        int cmp = key.compareTo(current.getKey());
        if (cmp < 0) {
            current.left = remove(current.left, key);
        } else if (cmp > 0) {
            current.right = remove(current.right, key);
        } else {
            // Case 1: No children
            if (current.left == null && current.right == null) {
                return null;
            }
            // Case 2: 1 child
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            // Case 3: Two children
            Node node = findSmallestValue(current.right);
            current.key = node.key;
            current.value = node.value;
            current.right = remove(current.right, node.key);
        }

        return current;
    }

    /*
     * Removes a node with the specified key from the binary tree.
     *
     * @param key the key to remove
     * @return the value associated with the removed key
     */
    public V remove(K key) {
        root = remove(root, key);
        size--;
        return root.value;

    }
    /*
       Return the size of binary search tree
     */
        public int getSize() {
            return size;
        }

    private Node findSmallestValue(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    /*
     * Retrieves the node with the specified key from the binary tree.
     *
     * @param node the current node being considered
     * @param key  the key to search for
     * @return the node with the specified key, or null if not found
     */
    private Node getNode(Node node, K key) {
        if (node == null || key.equals(node.getKey())) {
            return node;
        }

        int cpt = key.compareTo(node.getKey());
        if (cpt < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }

    }
    /*
     * Retrieves the value associated with the specified key from the binary tree.
     *
     * @param key the key to search for
     * @return the value associated with the key, or null if not found
     */
    public V get(K key) {
        Node node = getNode(root, key);
        if (node == null) {
            return null;
        }
        return node.getValue();
    }


    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }
    private class inOrderTraversal implements Iterator<Node>{
        private Stack<Node> stack;
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Node next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
        }
    }



}