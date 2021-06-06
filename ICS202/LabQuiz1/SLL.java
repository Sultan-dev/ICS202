//**************************  SLL.java  *********************************
//           a generic singly linked list class 

public class SLL<T> {
    protected SLLNode<T> head, tail;

    public SLL() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToHead(T el) {
        head = new SLLNode<T>(el, head);
        if (tail == null)
            tail = head;
    }

    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        } else head = tail = new SLLNode<T>(el);
    }

    public T deleteFromHead() { // delete the head and return its info;
        if (isEmpty())
            return null;
        T el = head.info;
        if (head == tail)       // if only one node on the list;
            head = tail = null;
        else head = head.next;
        return el;
    }

    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail)       // if only one node in the list;
            head = tail = null;
        else {                  // if more than one node in the list,
            SLLNode<T> tmp;    // find the predecessor of tail;
            for (tmp = head; tmp.next != tail; tmp = tmp.next) ;
            tail = tmp;        // the predecessor of tail becomes tail;
            tail.next = null;
        }
        return el;
    }

    public void delete(T el) {  // delete the node with an element el;
        if (!isEmpty()) {
            if (head == tail && el.equals(head.info)) // if only one
                head = tail = null;       // node on the list;
            else if (el.equals(head.info)) // if more than one node on the list;
                head = head.next;    // and el is in the head node;
            else {                    // if more than one node in the list
                SLLNode<T> pred, tmp;// and el is in a nonhead node;
                for (pred = head, tmp = head.next;
                     tmp != null && !tmp.info.equals(el);
                     pred = pred.next, tmp = tmp.next)
                    ;
                if (tmp != null) {   // if el was found;
                    pred.next = tmp.next;
                    if (tmp == tail) // if el is in the last node;
                        tail = pred;
                } else
                    throw new IllegalArgumentException("Element not found.");
            }
        } else
            throw new UnsupportedOperationException("List is empty.");
    }

    public void printAll() {
        if (isEmpty())
            throw new UnsupportedOperationException("List is empty.");

        SLLNode<T> tmp;
        for (tmp = head; tmp.next != null; tmp = tmp.next)
            System.out.print(tmp.info + ", ");
        System.out.print(tmp.info);
    }

    public boolean isInList(T el) {
        SLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next) ;
        return tmp != null;
    }

    public SLL<T> deleteSpecial(T e) {
        SLL<T> newList = new SLL<>();

        if (isEmpty()) { // check if the list is empty
            throw new IllegalArgumentException("Warning: The list is empty");

        } else {
            if (e == null || !isInList(e)) { // check if e is null or not in the list
                throw new IllegalArgumentException("Warning: e is null or not in the list");

            } else {
                if (length() == 1) { // if only one node
                    head = tail = null;

                } else { // multiple nodes
                    int numOccu = getNumberOccur(e);

                    if (numOccu == 1) { // if one occurance
                        if (e == head.info) { // if e is the head
                            SLLNode<T> tmp1, tmp2;

                            tmp2 = head;

                            for (tmp1 = tmp2.next; tmp1 != null; tmp1 = tmp1.next) {
                                newList.addToTail(tmp1.info);
                            }
                            newList.addToTail(tmp2.info);

                        } else if (e == tail.info) { // if e is tail
                            SLLNode<T> tmp1, tmp2;
                            tmp2 = tail;

                            newList.addToHead(tmp2.info);
                            for (tmp1 = head; tmp1 != null; tmp1 = tmp1.next) {
                                if (tmp1 == tail) {
                                    break;
                                } else {
                                    newList.addToTail(tmp1.info);
                                }
                            }
                        } else { // if e is in between will be deleted
                            SLLNode<T> tmp;

                            for (tmp = head; tmp != null; tmp = tmp.next) {
                                if (!tmp.info.equals(e)) {
                                    newList.addToTail(tmp.info);
                                }
                            }
                        }

                    } else { // if number of occurrences is multiple
                        int pos = getLastOccurPos(e), count = 0;
                        SLLNode<T> tmp;

                        for (tmp = head; tmp != null; tmp = tmp.next, count++) {
                            if (count == pos) {
                                newList.addToHead(tmp.info);
                            } else {
                                newList.addToTail(tmp.info);
                            }
                        }

                    }
                }
            }
        }
        return newList;
    }

    public int length() { // return the length of the list
        SLLNode<T> tmp = head;
        int length = 0;

        if (!isEmpty()) {
            while (tmp != null) {
                length++;
                tmp = tmp.next;
            }
            return length;
        } else {
            return 0;
        }
    }

    public int getNumberOccur(T e) { // return the number of occurrence
        SLLNode<T> tmp;
        int num = 0;

        for (tmp = head; tmp != null; tmp = tmp.next) {
            if (tmp.info.equals(e)) {
                num++;
            }
        }

        return num;
    }

    public int getLastOccurPos(T e) { // return the position of the last occurrence
        SLLNode<T> tmp;
        int numOccur = getNumberOccur(e), pos = 0, count = 0;

        for (tmp = head; tmp != null; tmp = tmp.next, pos++) {
            if (tmp.info.equals(e)) {
                count++;
                if (count == numOccur) {
                    return pos;
                }
            }
        }
        return pos;
    }
}