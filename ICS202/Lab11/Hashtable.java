

public class Hashtable {

    private Entry[] entry;
    private int size;

    public Hashtable() {
        this(10);
    }

    public Hashtable(int size) {
        entry = new Entry[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            entry[i] = new Entry();
        }
    }

    public void insert(Object o) {
        boolean flag = false;

        for (int i = 0; i < entry.length; i++) {
            if (entry[i].getStatus().equals("E")) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }

        if (flag) { // if all slots are empty
            for (int i = 0; i < entry.length; i++) {
                int hashValue = ((o.hashCode() % entry.length) + i) % entry.length;

                if (entry[hashValue].getStatus().equals("E")) {
                    entry[hashValue] = new Entry(o, "O");
                    break;
                }
            }

        } else {

            for (int i = 0; i < entry.length; i++) {
                if (entry[i].getStatus().equals("O")) {
                    if (entry[i].hash() == o.hashCode()) {
                        System.out.println("You cannot insert duplicated objects");
                        return;
                    }
                }
            }

            for (int i = 0; i < entry.length; i++) {
                int hashValue = ((o.hashCode() % entry.length) + i) % entry.length;

                if (entry[hashValue].getStatus().equals("E")) { // if the slot is empty
                    entry[hashValue] = new Entry(o, "O");
                    break;
                }else if (entry[hashValue].getStatus().equals("D")){
                    entry[hashValue] = new Entry(o, "O");
                    break;
                }
                // if the slot is empty hash value will increase by 1 until it find an empty slot
            }

        }
    }

    public boolean find(Object o) {
        for (int i = 0; i < entry.length; i++) {
            if (entry[i].getStatus().equals("O")) {
                if (entry[i].hash() == o.hashCode()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void delete(Object o) {
        for (int i = 0; i < entry.length; i++) {
            if (entry[i].getStatus().equals("O")) {
                if (entry[i].hash() == o.hashCode()) {
                    entry[i].status= "D";
                }
            }
        }
    }

    public String toString() {
        for (int i = 0; i < size; i++) {
            if (entry[i].getStatus().equals("O")) {
                System.out.print(entry[i].toString() + " ");
            }
            System.out.println();
        }
        return "";
    }


    public int getSize() {
        return size;
    }
}
