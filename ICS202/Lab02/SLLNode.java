public class SLLNode<String> {

    public String info;
    public SLLNode<String> next;

    public SLLNode() {
        this(null, null);
    }

    public SLLNode(String el) {
        this(el, null);
    }

    public SLLNode(String el, SLLNode<String> ptr) {
        this.info = el;
        this.next = ptr;
    }


}
