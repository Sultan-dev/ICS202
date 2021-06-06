public class BTNode<T extends Comparable<? super T>> {
    protected T data;
    protected BTNode<T> left, right;

    public BTNode() {
        left = right = null;
    }

    public BTNode(T data) {
        this(data,null,null);
    }

    public BTNode(T data, BTNode<T> left, BTNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
