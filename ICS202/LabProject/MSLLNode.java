public class MSLLNode<T> {
    public T info;
    public SLL<T> list;
    public MSLLNode<T> next;

    public MSLLNode() {
        this(null, null, null);
    }

    public MSLLNode(T el) {
        this(el, null, new SLL<T>());
    }

    public MSLLNode(T el, MSLLNode<T> ptr, SLL<T> sub) {
        this.info = el;
        this.next = ptr;
        this.list = sub;
    }
}
