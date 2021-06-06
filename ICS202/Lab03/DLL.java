public class DLL<Integer> {

    private DLLNode<Integer> head, tail;

    public DLL() {
        head = tail = null;
    }

    public void printAll() {
        for (DLLNode<Integer> tmp = head; tmp != null; tmp = tmp.next) {
            System.out.print(tmp.info + " ");
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void setToNull() {
        head = tail = null;
    }

    public Integer firstEl() {
        if (head != null) {
            return head.info;
        } else {
            return null;
        }
    }

    public void addToHead(Integer el) {
        if (head != null) {
            head = new DLLNode<Integer>(el, head, null);
            head.next.prev = head;
        } else head = tail = new DLLNode<Integer>(el);
    }

    public void addToTail(Integer el) {
        if (tail != null) {
            tail = new DLLNode<Integer>(el, null, tail);
            tail.prev.next = tail;
        } else head = tail = new DLLNode<Integer>(el);
    }

    public Integer deleteFromHead() {

        if (isEmpty())
            return null;
        Integer el = head.info;
        if (head == tail)   // if only one node on the list;
            head = tail = null;
        else {              // if more than one node in the list;
            head = head.next;
            head.prev = null;
        }
        return el;
    }

    public Integer deleteFromTail() {
        if (isEmpty())
            return null;
        Integer el = tail.info;
        if (head == tail)   // if only one node on the list;
            head = tail = null;
        else {              // if more than one node in the list;
            tail = tail.prev;
            tail.next = null;
        }
        return el;
    }

    public Integer find(Integer el) {
        DLLNode<Integer> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next) ;
        if (tmp == null)
            return null;
        else return tmp.info;
    }

    public void printReverse() {
        DLLNode<Integer> tmp;

        for (tmp = tail; tmp != null; tmp = tmp.prev) {
            System.out.print(tmp.info + " ");
        }
    }

    public void delete7() {
        int count = 1;
        DLLNode<Integer> tmp;

        if (!isEmpty()) {
            for (tmp = head; tmp != null; count++) {
                if (head == tail) {
                    head = tail = null;
                    System.out.println();
                    printAll();
                    break;

                } else {
                    if (count == 7) {
                        if (tmp.next == null) { // if number 7 is the tail
                            if (tmp == tail) {
                                tail = tail.prev;
                                tail.next = null;
                                tmp = head;
                                count = 0;
                                System.out.println();
                                printAll();

                            }
                        } else if (tmp.next != null) { // if number 7 is at the middle
                            tmp.prev.next = tmp.next;
                            tmp.next.prev = tmp.prev;
                            tmp = null;
                            tmp = head;
                            count = 0;
                            System.out.println();
                            printAll();

                        }
                    } else {
                        if (tmp.next == null) { // if tmp reaches the tail and count does not reach 7
                            for (; tmp != null; count++) {// go with reverse order
                                if (head == tail) {
                                    head = tail = null;
                                    System.out.println();
                                    printAll();
                                    break;

                                } else {
                                    if (count == 7) {
                                        if (tmp.prev != null) { // if number 7 is in the middle
                                            tmp.prev.next = tmp.next;
                                            tmp.next.prev = tmp.prev;
                                            tmp = null;

                                        } else { // if number 7 is the head
                                            head = head.next;
                                            head.prev = null;

                                        }
                                        tmp = head;
                                        count = 0;
                                        System.out.println();
                                        printAll();
                                        break;

                                    } else {
                                        if (tmp.prev == null) { // if the tmp reaches head and count does not reach 7
                                            tmp = head;
                                            count--;
                                            break;

                                        } else {
                                            tmp = tmp.prev;

                                        }
                                    }
                                }
                            }
                        } else {
                            tmp = tmp.next;

                        }
                    }
                }
            }
        }
    }

    public void insertAlternate(DLL<Integer> newList) {
        if (getSize() == newList.getSize()) { // check if the size's of the two DLL are equal
            DLLNode<Integer> tmp1, tmp2;
            DLL<Integer> alternateList= new DLL<>();
            for (tmp1 = head, tmp2 = newList.head; tmp1 != null && tmp2 != null; tmp1 = tmp1.next, tmp2 = tmp2.next) {
                alternateList.addToTail(tmp1.info);// adding tmp1 and tmp2 to a new DLL
                alternateList.addToTail(tmp2.info);
            }

            int count= 1;
           while (this.head != null){ // remove all the element from the DLL
               this.deleteFromTail();
           }

           for (tmp1= alternateList.head; tmp1 != null; tmp1= tmp1.next){ // adding elements from alternateList to the DLL
               this.addToTail(tmp1.info);
           }
        }
    }

    public int getSize() {
        int size = 1;
        DLLNode<Integer> tmp = head;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        return size;
    }
}


      