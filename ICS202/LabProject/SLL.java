public class SLL<T> {

    protected MSLL<T> mList;
    protected SLLNode<T> head, tail;

    public SLL() {

    }

    public SLL(MSLL<String> list) {
        this.mList = (MSLL<T>) list;
    }

    public void addCityToSublistAtRear(T el) throws Exception {
        if (mList.isEmpty()) {
            throw new Exception("The MSLL list is empty");
        } else if (!cityIsInSubList(el)) {
            if (!mList.isEmpty()) {
                if (el instanceof City) { // if el is a city object
                    City city = (City) el;

                    for (MSLLNode<T> temp = mList.head; temp != null; temp = temp.next) { // MSLL list
                        if ((((String) temp.info).charAt(0)) == city.getCityName().charAt(0)) { // checking MSLL list if contains the same key as the name of the city first character
                            if (!temp.list.isEmpty()) {
                                temp.list.tail.next = new SLLNode<>(el);
                                temp.list.tail = temp.list.tail.next;
                                break;
                            } else {
                                temp.list.head = temp.list.tail = new SLLNode<>(el);
                                break;
                            }
                        }
                    }

                } else {
                    throw new Exception("The MSLL list is empty");
                }
            }
        } else {
            throw new Exception("The city " + el + " is in the list");
        }
    }

    // helper method
    private void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<>(el);
            tail = tail.next;
        } else {
            head = tail = new SLLNode<>(el);
        }
    }

    //helper methods for checking
    private boolean isEmpty() {
        return head == null;
    }

    // I will consider position 0 as the head meaning the length will start from zero
    public void addToCitySublist(T el, int position) throws Exception {
        if (mList.isEmpty()) {
            throw new Exception("The MSLL list is empty");

        } else if (!mList.isInMSLList(el)) {
            throw new Exception("The key " + el.toString().charAt(0) + " is not in the MSLL list");

        } else if (position < 0) {
            throw new Exception("The position can not be negative");

        } else {
            if (el instanceof City) { // if el is a city object
                City city = (City) el;
                for (MSLLNode<T> temp = mList.head; temp != null; temp = temp.next) { // MSLL list
                    if ((((String) temp.info).charAt(0)) == city.getCityName().charAt(0)) { // checking MSLL list if contains the same key as the name of the city first character
                        if (position > temp.list.getLength()) { // checking the length of city sublist SLL
                            throw new Exception("The position is bigger than the length of city sublist");

                        } else {
                            if (position == 0) { // if the position is head
                                temp.list.addToHead(el); // helper method

                            } else if (position == temp.list.getLength()) { // if the position is tail
                                for (SLLNode<T> tmp = temp.list.head; tmp != null; tmp = tmp.next) {
                                    if (tmp.next == temp.list.tail) {
                                        SLLNode<T> node = temp.list.tail;
                                        tmp.next = new SLLNode<>(el);
                                        tmp.next.next = node;
                                        break;
                                    }
                                }

                            } else { // if position is in between
                                int count = 0;
                                for (SLLNode<T> tmp = temp.list.head; tmp != null; count++, tmp = tmp.next) {
                                    if ((count + 1) == position) {
                                        SLLNode<T> node = tmp.next;
                                        tmp.next = new SLLNode<>(el);
                                        tmp.next.next = node;
                                        break;
                                    }
                                }

                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    // helper method
    private void addToHead(T el) {
        head = new SLLNode<T>(el, head);
        if (tail == null)
            tail = head;
    }

    // helper method
    private int getLength() {
        SLLNode<T> tmp = head;
        int size = 0;
        if (!isEmpty()) {
            while (tmp != null) {
                size++;
                tmp = tmp.next;
            }
        }
        return size;
    }

    public boolean cityIsInSubList(T el) throws Exception {
        if (mList.isEmpty()) {
            throw new Exception("The MSLL list is empty");
        } else if (!mList.isInMSLList(el)) {
            throw new Exception("The key " + (((City) el).getCityName().charAt(0)) + " is not in MSLL list");
        }
        if (el instanceof City) {// if el is a city object
            City city = (City) el;
            SLLNode<T> tmp = null;

            for (MSLLNode<T> temp = mList.head; temp != null; temp = temp.next) { // MSLL list
                if ((((String) temp.info).charAt(0)) == city.getCityName().charAt(0)) { // checking MSLL list if contains the same key as the name of the city first character
                    for (tmp = temp.list.head; tmp != null; tmp = tmp.next) {
                        if ((((City) tmp.info).getCityName()).equals(city.getCityName())) {
                            if ((((City) tmp.info).getDecimalLatitude()) == city.getDecimalLatitude() && (((City) tmp.info).getDecimalLongitude()) == city.getDecimalLongitude())
                                return true;
                        }
                    }

                }
            }
            return false;
        } else { // if it is a string used for getDistance() method
            SLLNode<T> tmp = null;

            for (MSLLNode<T> temp = mList.head; temp != null; temp = temp.next) {
                if ((((String) temp.info).charAt(0)) == (((String) el).charAt(0))) {
                    for (tmp = temp.list.head; tmp != null &&
                            !((((City) tmp.info).getCityName()).equals(el));
                         tmp = tmp.next)
                        ;
                    break;

                }
            }
            return tmp != null;
        }

    }

    public void deleteCityFromSublist(T el) throws Exception {
        if (mList.isEmpty()) {
            throw new Exception("The MSLL list is empty");

        } else if (!mList.isInMSLList(el)) {
            throw new Exception("The key " + (((City) el).getCityName().charAt(0)) + " is not in the MSLL list");

        } else {
            if (el instanceof City) {
                City city = (City) el;

                for (MSLLNode<T> temp = mList.head; temp != null; temp = temp.next) {
                    if ((((String) temp.info).charAt(0)) == city.getCityName().charAt(0)) {
                        if (!temp.list.isEmpty()) {
                            if (temp.list.head == temp.list.tail && city.getCityName().equals((((City) temp.list.head.info).getCityName()))) { // if the only element in the list
                                temp.list.head = temp.list.tail = null;
                                return;

                            } else if (city.getCityName().equals((((City) temp.list.head.info).getCityName()))) { // if the element is the head
                                temp.list.head = temp.list.head.next;
                                return;

                            } else {
                                SLLNode<T> pred, tmp;

                                for (pred = temp.list.head, tmp = temp.list.head.next;
                                     tmp != null && !((((City) tmp.info).getCityName()).equals(city.getCityName()));
                                     pred = pred.next, tmp = tmp.next)
                                    ;

                                if (tmp != null) {
                                    pred.next = tmp.next;
                                    if (tmp == temp.list.tail) {
                                        temp.list.tail = pred;
                                    }
                                }
                                return;

                            }
                        } else { // if sub list is empty
                            throw new Exception("The sublist is empty");
                        }
                    }
                }
                throw new Exception("The city " + el + " is not in the list"); // if the city not found
            }
        }
    }

    public void makeCitySublistEmpty(String str) throws Exception {
        if (mList.isEmpty()) {
            throw new Exception("The MSLL list is empty");

        } else if (!mList.isInMSLList((T) str)) {
            throw new Exception("The key " + str.charAt(0) + " is not in the MSLL list");

        } else {
            for (MSLLNode<T> temp = mList.head; temp != null; temp = temp.next) {
                if ((((String) temp.info).charAt(0)) == str.charAt(0)) {
                    if (temp.list.isEmpty()) {
                        throw new Exception("The city sublist " + str + " is empty");

                    } else {
                        temp.list.head = temp.list.tail = null;
                    }
                }
            }
        }
    }

    public double getDistance(String city1, String city2) throws Exception {
        if (mList.isEmpty()) {
            throw new Exception("The MSLL list is empty");

        } else if (!mList.isInMSLList((T) city1)) {
            throw new Exception("The key of the city1 not in MSLL list");

        } else if (!mList.isInMSLList((T) city2)) {
            throw new Exception("The key of the city2 not in MSLL list");

        } else if (cityIsInSubList((T) city1) && cityIsInSubList((T) city1)) {
            City City1 = null, City2 = null;

            //finding city1
            for (MSLLNode<T> temp = mList.head; temp != null; temp = temp.next) { // MSLL list
                if ((((String) temp.info).charAt(0)) == city1.charAt(0)) { // checking MSLL list if contains the same key as the name of the city first character
                    for (SLLNode<T> tmp = temp.list.head; tmp != null; tmp = tmp.next) { // SLL list
                        if (((((City) tmp.info).getCityName()).equals(city1))) { // checking citySublis
                            City1 = (City) tmp.info;
                        }
                    }
                }
            }

            // finding city2
            for (MSLLNode<T> temp = mList.head; temp != null; temp = temp.next) { // MSLL list
                if ((((String) temp.info).charAt(0)) == city2.charAt(0)) {// checking MSLL list if contains the same key as the name of the city first character
                    for (SLLNode<T> tmp = temp.list.head; tmp != null; tmp = tmp.next) { // SLL list
                        if (((((City) tmp.info).getCityName()).equals(city2))) { // checking citySublist
                            City2 = (City) tmp.info;
                        }
                    }
                }
            }

            double city1LatitudeInRadian = City1.getDecimalLatitude() * (Math.PI / 180),
                    city1LongitudeInRadian = City1.getDecimalLongitude() * (Math.PI / 180),
                    city2LatitudeInRadian = City2.getDecimalLatitude() * (Math.PI / 180),
                    city2LongitudeInRadian = City2.getDecimalLongitude() * (Math.PI / 180),
                    radiusOfEarth = 6372.8;

            double distance = 2 * radiusOfEarth * Math.asin(Math.sqrt(Math.pow(Math.sin((city2LatitudeInRadian - city1LatitudeInRadian) / 2.0), 2) +
                    (Math.cos(city1LatitudeInRadian) * Math.cos(city2LatitudeInRadian) * Math.pow(Math.sin((city2LongitudeInRadian - city1LongitudeInRadian) / 2.0), 2))));

            return distance;
        } else {
            throw new Exception("city1 or city2 is not in city sublist");
        }
    }
}
