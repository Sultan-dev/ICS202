public class SLLNode<T> {

    public T info;
    public SLLNode<T> next;

    public SLLNode() {
        this(null, null);
    }

    public SLLNode(T el) {
        this(el, null);
    }

    public SLLNode(T el, SLLNode<T> ptr) {
        this.info = el;
        this.next = ptr;
    }


}
