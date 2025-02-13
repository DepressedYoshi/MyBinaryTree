import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
public class MyBinaryTree<T extends Comparable<T>> {
    private MyBinaryTreeNode<T> root;

    public MyBinaryTree() {
        this.root = null;
    }
    public void insert(T value) {
        root = insertRecursive(root, value);
    }
    public void delete(T value) {root = deleteRecursive(root, value);}
    public boolean contains(T value) {
        return containsRecursive(root, value);
    }
    public void inOrderTraversal() {
        inOrderRecursive(root);
        System.out.println();
    }
    public void preOrderTraversal() {
        preOrderRecursive(root);
        System.out.println();
    }
    public void postOrderTraversal() {
        postOrderRecursive(root);
        System.out.println();
    }
    public void levelOrderTraversal() {
        if (root == null) return;

        Queue<MyBinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            MyBinaryTreeNode<T> current = queue.poll();
            System.out.print(current.getData() + " ");

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
        System.out.println();
    }
    public T findMin() {
        return findMin(root);
    }
    public T findMax() {
        return findMax(root);
    }
    public int height() {
        return heightRecursive(root);
    }
    public int size() {
        return sizeRecursive(root);
    }
    public boolean isEmpty() {
        return root == null;
    }
    public boolean isBalanced() {
        return isBalancedRecursive(root);
    }
    public List<T> toSortedArray() {
        List<T> sortedList = new ArrayList<>();
        inOrderToArray(root, sortedList);
        return sortedList;
    }
    public boolean isValidBST() {
        return isValidBSTRecursive(root, null, null);
    }
    //--------------------------THE REAL STUFF STARTS HERE--------------------------//
    private MyBinaryTreeNode<T> insertRecursive(MyBinaryTreeNode<T> node, T value) {
        if (node == null) {
            return new MyBinaryTreeNode<>(value);
        }

        if (value.compareTo(node.getData()) < 0) {
            node.setLeft(insertRecursive(node.getLeft(), value));
        } else if (value.compareTo(node.getData()) > 0) {
            node.setRight(insertRecursive(node.getRight(), value));
        }

        return node;
    }
    private MyBinaryTreeNode<T> deleteRecursive(MyBinaryTreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }
        if (value.compareTo(node.getData()) < 0) {
            node.setLeft(deleteRecursive(node.getLeft(), value));
        } else if (value.compareTo(node.getData()) > 0) {
            node.setRight(deleteRecursive(node.getRight(), value));
        } else {
            // Node with only one child or no child
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            node.setData(findMin(node.getRight()));
            node.setRight(deleteRecursive(node.getRight(), node.getData()));
        }

        return node;
    }
    private boolean containsRecursive(MyBinaryTreeNode<T> node, T value) {
        if (node == null) {
            return false;
        }

        if (value.compareTo(node.getData()) == 0) {
            return true;
        } else if (value.compareTo(node.getData()) < 0) {
            return containsRecursive(node.getLeft(), value);
        } else {
            return containsRecursive(node.getRight(), value);
        }
    }
    private T findMax(MyBinaryTreeNode<T> node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node.getData();
    }
    private T findMin(MyBinaryTreeNode<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getData();
    }
    private void inOrderRecursive(MyBinaryTreeNode<T> node) {
        if (node != null) {
            inOrderRecursive(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrderRecursive(node.getRight());
        }
    }
    private void preOrderRecursive(MyBinaryTreeNode<T> node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preOrderRecursive(node.getLeft());
            preOrderRecursive(node.getRight());
        }
    }
    private void postOrderRecursive(MyBinaryTreeNode<T> node) {
        if (node != null) {
            postOrderRecursive(node.getLeft());
            postOrderRecursive(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }
    private void inOrderToArray(MyBinaryTreeNode<T> node, List<T> sortedList) {
        if (node != null) {
            inOrderToArray(node.getLeft(), sortedList);
            sortedList.add(node.getData());
            inOrderToArray(node.getRight(), sortedList);
        }
    }
    private int heightRecursive(MyBinaryTreeNode<T> node) {
        if (node == null) {
            return -1;
        }
        return Math.max(heightRecursive(node.getLeft()), heightRecursive(node.getRight())) + 1;
    }
    private int sizeRecursive(MyBinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + sizeRecursive(node.getLeft()) + sizeRecursive(node.getRight());
    }
    private boolean isBalancedRecursive(MyBinaryTreeNode<T> node) {
        if (node == null) {
            return true;
        }

        int leftHeight = heightRecursive(node.getLeft());
        int rightHeight = heightRecursive(node.getRight());

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalancedRecursive(node.getLeft()) && isBalancedRecursive(node.getRight());
    }
    //Check if the tree is valid
    /* A valid BST must satisfy:
    - Left subtree values are smaller than the root
    - Right subtree values are greater than the root
    - No duplicate values  */
    private boolean isValidBSTRecursive(MyBinaryTreeNode<T> node, T min, T max) {
        if (node == null) return true;

        if ((min != null && node.getData().compareTo(min) <= 0) ||
                (max != null && node.getData().compareTo(max) >= 0)) {
            return false;
        }

        return isValidBSTRecursive(node.getLeft(), min, node.getData()) &&
                isValidBSTRecursive(node.getRight(), node.getData(), max);
    }
}
