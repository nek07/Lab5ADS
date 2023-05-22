# | Algorithms and Data Structures | Assignment 5 |

## MyBinaryTree()
### ➕ Constructor of the class
**Description**:
```java
public MyBinaryTree() {
           root = null;
        }
```
### ➕ insert()
**Description**: Compare keys and locates the new value to `left node` if the entry is lesser or `right node` if the entry is bigger than `current node`.
```java
public void insert(K key, V value) {
        root = insert(root, key, value);
        size++;
    }
    
private Node remove(Node current, K key) {
        if (current == null) {
            return null;
        }
        int cpt = key.compareTo(current.getKey());
        if (cpt < 0) {
            current.left = remove(current.left, key);
        }
        if (cpt > 0) {
            current.right = remove(current.right, key);
        } else {
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
        Node node = findSmallestValue(current.right);
        current.key = node.key;
        current.value = node.value;
        current.right = remove(current.right, node.key);
        }

        return current;
        }    
```

### get()
**Description**: Determine in tree and retrieve the value which paired with key.
```java
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

public V get(K key) {
        Node node = getNode(root, key);
        if (node == null) {
            return null;
        }
            return node.getValue();
        }
```
### ➕ remove()
**Description**: Removes the value by key, captures every position of key.
```java
private Node remove(Node current, K key) {
        if (current == null) {
            return null;
        }
        int cpt = key.compareTo(current.getKey());
        if (cpt < 0) {
            current.left = remove(current.left, key);
        }
        if (cpt > 0) {
            current.right = remove(current.right, key);
        } else {
            //case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }
            //case 2:  1 child
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            //case3: two children
            Node node = findSmallestValue(current.right);
            current.key = node.key;
            current.value = node.value;
            current.right = remove(current.right, node.key);
        }

        return current;
    }

    public V remove(K key) {
        root = remove(root, key);
        size--;
        return root.value;
    }
```
### ➕ findTheSmallestValue()
**Description**: Finds the smallest value in a tree
```java
private Node findSmallestValue(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
```
### ➕ iterator()
**Description**: Iterate nodes by calling `InOrderTraversal` class.
```java
 public Iterator<Node> iterator() {
        return new InOrderTraversal();
    }
``` 

# InOrderTraversal
### ➕ InOrderTraversal()
**Description**: Constructor of the class
```java
public InOrderTraversal() {
            stack = new Stack<>();
            pushAll(root);
        }
```
### hasNext()
**Description**: Checks is the next element not null or null, respectively return false or true.
```java
@Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
``` 
**Description**: Returns next node if it is not null, otherwise throw `NoSuchElementException()` exception.
```java
@Override
        public Node next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node node = stack.pop();
            pushAll(node.right);

            return new Node(node.key, node.value);
        }
``` 
**Description**: Insert all nodes in binary search tree to stack
```java
private void pushAll(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
``` 





# Node
### ➕ Node()
**Description**: Constructor of the Node class
```java
public Node(K key, V value) {
        this.key = key;
        this.value = value;
        }
```
### ➕ getKey(()
**Description**:  Returns the key of the node.
```java
public K getKey() {
            return key;
        }
```
### ➕ getValue()
**Description**:  Returns the value of the node.
```java
public V getValue() {
            return value;
        }
```