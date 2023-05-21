# | Algorithms and Data Structures | Assignment 5 |

## MyBinaryTree()
### ➕ Constructor of the class
**Description**:
```java
public MyBinaryTree() {
           root = null;
        }
```
### ➕ insert(Node current, K key, V value)
**Description**: Compare keys and locates the new value to `left node` if the entry is lesser or `right node` if the entry is bigger than `current node`.
```java

```
### ➕ insert(K key, V value)
**Description**: Insert new `key-value` pair and calling the private insert method.
```java
public void insert(K key, V value) {
        root = insert(root, key, value);
        size++;
    }
```
### 
**Description**:
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
## 
### ➕
**Description**:
```java

```
## 
### ➕
**Description**:
```java

```