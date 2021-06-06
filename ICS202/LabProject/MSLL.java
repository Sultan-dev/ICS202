public class MSLL<T> {

    protected MSLLNode<T> head, tail;

    public void addToMSLLHead(T el) throws Exception {
        if (!isInMSLList(el)) {
            head = new MSLLNode<>(el, head, new SLL<>());
            if (tail == null) {
                tail = head;
            }

        } else {
            throw new Exception("The element " + el + " is in the list");
        }
    }

    public void addToMSLLTail(T el) throws Exception {
        if (!isInMSLList(el)) {
            if (!isEmpty()) {
                tail.next = new MSLLNode<>(el);
                tail = tail.next;
            } else {
                head = tail = new MSLLNode<>(el);
            }

        } else {
            throw new Exception("The element " + el + " is in the list");
        }

    }

    public boolean isEmpty() {
        return head == null;
    }

    public void deleteFromMSLL(T el) throws Exception {
        if (!isInMSLList(el)) {
            throw new Exception("The element " + el + " is not in the list");

        } else if (isEmpty()) {
            throw new Exception("The MSLL list is empty");

        } else {
            if (head == tail && el.equals(head.info)) { // if the only element in the list
                head = tail = null;

            } else if (el.equals(head.info)) {// if the element is the head
                head = head.next;

            } else {
                MSLLNode<T> pred, tmp;

                for (pred = head, tmp = head.next; tmp != null &&
                        !((((String) tmp.info).charAt(0)) == (((String) el).charAt(0)));
                     pred = pred.next, tmp = tmp.next)
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


    public boolean isInMSLList(T el) {
        if (el instanceof City) {
            City city = (City) el;
            MSLLNode<T> tmp;
            for (tmp = head; tmp != null && !((((String) tmp.info).charAt(0)) == city.getCityName().charAt(0)); tmp = tmp.next)
                ;

            return tmp != null;
        } else {
            MSLLNode<T> tmp;
            for (tmp = head; tmp != null && !((((String) tmp.info).charAt(0)) == (((String) el).charAt(0))); tmp = tmp.next)
                ;

            return tmp != null;
        }
    }

    public void displayCitySublist(T el) throws Exception {
        if (!isInMSLList(el)) {
            throw new Exception("The key " + el + " is not in the MSLL list");

        } else if (isEmpty()) {
            throw new Exception("The MSLL list is empty");
        } else {

            for (MSLLNode<T> temp = head; temp != null; temp = temp.next) {
                if ((((String) temp.info).charAt(0)) == (((String) el).charAt(0))) {
                    for (SLLNode<T> tmp = temp.list.head; tmp != null; tmp = tmp.next) {
                        System.out.println((((City) tmp.info).toString()));
                    }
                }
            }

        }
    }

}
