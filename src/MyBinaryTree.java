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
        if(key.hashCode()<current.key.hashCode()){
            current.left = insert(current.left, key, value);
        } else if (key.hashCode()>current.key.hashCode()) {
            current.right = insert(current.right, key, value);
        }
        return current;
    }
    public void insert(K key, V value){
        root = insert(root,key,value);
        size++;
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
}
