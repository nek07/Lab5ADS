public class MyBinaryTree<K extends Comparable<K>,V> {
    private Node root;
    private int size = 0;
    private class Node{
        private K key;
        private V value;
        private Node left,right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
    }
    public MyBinaryTree(){
        root = null;
    }
    private Node insert(Node current, K key, V value){
        if(current == null){
            return new Node(key,value);
        }
        int cpt=key.compareTo(current.getKey());
        if(cpt<0){
            current.left = insert(current.left, key, value);
        } else if (cpt>0) {
            current.right = insert(current.right, key, value);
        }
        return current;
    }
    public void insert(K key, V value){
        root = insert(root,key,value);
        size++;
    }
    private Node remove(Node current, K key){
        if(current == null) {
            return null;
        }
        int cpt=key.compareTo(current.getKey());
        if(cpt<0){
            current.left = remove(current.left, key);
        }
        if (cpt>0) {
            current.right = remove(current.right, key);
            }
        else {
                //case 1: no children
                if (current.left == null && current.right == null) {
                    return null;
                }
                ;
                //case 2:  1 child
                if (current.left == null) {
                    return current.right;
                }
                if (current.right == null) {
                    return current.left;
                }
                //case3: two children
                K smallestValue = findSmallestValue(current.right);
                current.key = smallestValue;
                current.right = remove(current.right, key);
        }
        return current;
    }

    public V remove(K key){
        root = remove(root,key);
        return root.value;
    }
    private void inOrder(Node node){
        if(node !=null){
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }
    public void inOrder(){
        inOrder(root);
    }
    public int size(){
        return size;
    }
    private K findSmallestValue(Node root){
        return root.left.key == null ? root.key : findSmallestValue(root.left);
    }
}
