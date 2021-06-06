public class SortedSLL<String extends Comparable<String>> {

    protected SLL<String> sllList;
    protected SLLNode<String> sllNode = null;

    public void insert(String el) {

    }

    public void delete(String el) {

        if (!sllList.isEmpty()) {
            if (sllList.head == sllList.tail && el.equals(sllList.head.info)) { // if the only element in the list
                sllList.head = sllList.tail = null;
            } else if (el.equals(sllList.head.info)) {// if the element is the head
                sllList.head = sllList.head.next;
            } else {
                SLLNode<String> pred, tmp;

                for (pred = sllList.head, tmp = sllList.head.next; tmp != null && !tmp.info.equals(el); pred = pred.next, tmp = tmp.next)
                    ;

                if (tmp != null) {
                    pred.next = tmp.next;
                    if (tmp == sllList.tail) {
                        sllList.tail = pred;
                    }
                }
            }
        }
    }


    public void printAll() {
        for (SLLNode<String> tmp = sllList.head; tmp != null; tmp = tmp.next) {
            System.out.print(tmp.info + " ");
        }

    }

}