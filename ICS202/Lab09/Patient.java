public class Patient<T extends Comparable<? super T>> {

    private String name;
    private int statuslevel;

    public Patient(String name, int statuslevel) {
        this.name = name;
        this.statuslevel = statuslevel;
    }


    public String getName() {
        return name;
    }

    public int getStatuslevel() {
        return statuslevel;
    }


    public int compareTo(Object o) {
        if (o instanceof Patient) {
            Patient p = (Patient) o;

            if (this.getStatuslevel() == p.getStatuslevel()) {
                for (int i = 0; i < this.getName().length() && i < p.getName().length(); i++) {
                    if (this.getName().charAt(i) > p.getName().charAt(i)) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                return 0;
            } else if (this.statuslevel > p.getStatuslevel()) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }
}
