public class MyBinaryTreeNode<T extends Comparable<T>> {
    T data;
    MyBinaryTreeNode<T> left, right;

    public MyBinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void setLeft(MyBinaryTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(MyBinaryTreeNode<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MyBinaryTreeNode<T> getLeft() {
        return left;
    }

    public MyBinaryTreeNode<T> getRight() {
        return right;
    }
}
