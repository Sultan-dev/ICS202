/************************  BSTNode.java  **************************
 *             node of a generic binary search tree
 */

public class BSTNode<T extends Comparable<? super T>> {
    protected T el;
    protected BSTNode<T> left, right;
    public BSTNode() {
        left = right = null;
    }
    public BSTNode(T el) {
        this(el,null,null);
    }
    public BSTNode(T el, BSTNode<T> lt, BSTNode<T> rt) {
        this.el = el; left = lt; right = rt;
    }
}