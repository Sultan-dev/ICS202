public class DLLNode<Integer> {

    public Integer info;
    public DLLNode<Integer> next, prev;

    public DLLNode() {
        next = null;
        prev = null;
    }

    public DLLNode(Integer el) {
        info = el;
        next = prev = null;
    }

    public DLLNode(Integer el, DLLNode<Integer> n, DLLNode<Integer> p) {
        info = el;
        next = n;
        prev = p;
    }
}
