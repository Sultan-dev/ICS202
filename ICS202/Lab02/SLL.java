public class SLL<String> {

    protected SLLNode<String> head, tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void addToHead(String el) {
        head = new SLLNode<>(el, head);
        if (tail == null) {
            tail = head;
        }
    }

    public void addToTail(String el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<>(el);
            tail = tail.next;
        } else {
            head = tail = new SLLNode<>(el);
        }
    }

    public String deleteFromTail() {
        if (isEmpty()) {
            return null;
        }
        String el = tail.info;
        if (head == tail) {
            head = tail = null;
        } else {
            SLLNode<String> tmp;
            for (tmp = head; tmp.next != null; tmp = tmp.next) ;
            tail = tmp;
            tail.next = null;
        }
        return el;
    }

    public String deleteFormHead() {
        if (isEmpty()) {
            return null;
        }

        String el = head.info;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        return el;
    }

    public void delete(String el) {

        if (!isEmpty()) {
            if (head == tail && el.equals(head.info)) { // if the only element in the list
                head = tail = null;
            } else if (el.equals(head.info)) {// if the element is the head
                head = head.next;
            } else {
                SLLNode<String> pred, tmp;

                for (pred = head, tmp = head.next; tmp != null && !tmp.info.equals(el); pred = pred.next, tmp = tmp.next)
                    ;

                if (tmp != null) {
                    pred.next = tmp.next;
                    if (tmp == tail) {
                        tail = pred;
                    }
                }
            }
        }
    }

    public void printAll() {
        for (SLLNode<String> tmp = head; tmp != null; tmp = tmp.next) {
            System.out.print(tmp.info + " ");
        }

    }

    public boolean isInList(String el) {
        SLLNode<String> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next) ;

        return tmp != null;
    }

    public int length() { // return the size of the list
        int size = 0;
        SLLNode<String> tmp;
        for (tmp = head; tmp != null; size++, tmp = tmp.next) ;
        return size;
    }

    public void insertBefore(String newElem, String existingElem) {

        if (isEmpty()) {
            System.out.println("No elements exist");

        } else {
            boolean exist = isInList(existingElem); // checking whether the existingElem exist!

            if (exist) { // if the existingElem exist

                if (head == tail) { // if there is one element
                    head = new SLLNode<>(newElem, head);

                } else { // if there is multiple elements
                    SLLNode<String> tmp, pred;

                    for (pred = head, tmp = head.next; tmp != null; pred = pred.next, tmp = tmp.next) {
                        if (tmp.info.equals(existingElem)) {
                            pred.next = new SLLNode<>(newElem);
                            pred.next.next = tmp;
                            break;

                        } else if (existingElem == head.info) { // if the existingElem is the head
                            head = new SLLNode<>(newElem, head);
                            break;

                        }
                    }
                }
            } else { // if the existingElem does not exist
                System.out.println("Warning: The element " + existingElem + " does not exist in the linked list.");
            }
        }
    }

    public void insertAfter(String newElem, String existingElem) {

        if (isEmpty()) {
            System.out.println("No elements exist");

        } else {
            boolean exist = isInList(existingElem); // checking whether the existingElem exist!

            if (exist) { // if the existingElem exist

                if (head == tail) {
                    tail.next = new SLLNode<>(newElem);
                    tail = tail.next;

                } else { // if there is multiple elements
                    SLLNode<String> tmp, pred;

                    for (tmp = head; tmp != null; tmp = tmp.next) {
                        if (tmp.info.equals(existingElem)) {
                            if (tmp.info.equals(tail.info)) { // if the existingElem is the tail
                                tail.next = new SLLNode<>(newElem);
                                tail = tail.next;

                            } else {
                                pred = tmp.next;

                                SLLNode<String> newNode = new SLLNode<>(newElem);
                                tmp.next = newNode;
                                newNode.next = pred;

                            }
                            break;
                        }
                    }
                }
            } else { // if the existingElem does not exist
                System.out.println("Warning: The element " + existingElem + " does not exist in the linked list.");

            }
        }
    }

    public void deleteBefore(String el) {
        if (isEmpty()) {
            System.out.println("No elements exist");

        } else {
            boolean exist = isInList(el); // checking whether the el exists!

            if (exist) {
                if (el.equals(head.info)) { // if the el is the head
                    System.out.println("There is no elements exists before " + el);

                } else {
                    if (el.equals(head.next.info)) { // if the element will be deleted is before head.next
                        head = head.next;

                    } else {
                        SLLNode<String> tmp, pred;

                        for (pred = head, tmp = head.next; tmp != null; pred = pred.next, tmp = tmp.next) {
                            if (tmp.info.equals(el)) {
                                SLLNode<String> node = getThePreviousNode(pred.info); // helper method to get the
                                // the element before
                                // the element that will be deleted
                                node.next = tmp;
                            }
                        }
                    }
                }
            } else { // if the el does not exist
                System.out.println("The " + el + " does not exist");
            }
        }
    }

    // helper Method for deleteBefore method
    private SLLNode<String> getThePreviousNode(String predInfo) {

        SLLNode<String> tmp, pred;

        for (pred = head, tmp = head.next; tmp.next != null; pred = pred.next, tmp = tmp.next) {
            if (tmp.info.equals(predInfo)) {
                break;
            }
        }
        return pred;
    }

    public void deleteAfter(String el) {

        if (isEmpty()) {
            System.out.println("No elements exist");

        } else {
            boolean exist = isInList(el);

            if (exist) {
                if (el.equals(head.info) && (head == tail)) { // if the el is the head and the only element in the list
                    System.out.println("There is no elements exists after " + el);

                } else {
                    if (el.equals(tail.info)) { // if el is the tail and there is multiple elements
                        System.out.println("There is no elements exists after " + el);

                    } else {
                        SLLNode<String> tmp, pred = null;

                        for (tmp = head; tmp != null; tmp = tmp.next) {
                            if (tmp.info.equals(el)) {
                                if (tmp.next == tail) { // if the tail will be deleted
                                    tmp.next = null;
                                    tail = tmp;

                                } else {
                                    pred = tmp.next;
                                    tmp.next = pred.next;

                                }
                            }
                        }
                    }
                }

            } else { // if el does not exist
                System.out.println("The " + el + " does not exist");

            }
        }
    }


}
