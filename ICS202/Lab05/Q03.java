public class Q03 {

    public static void main(String[] args) {
        int x = 1234567;

        System.out.println("the number with commas will be " + putCommas(x));
    }

    public static String putCommas(int x) {
        String s = Integer.toString(x);

        if (s.length() == 0) {
            return null;
        } else {
            if (s.length() > 3) {
                String s2 = new String(), s1;

                int i = s.length() - 1, j = 0;

                while (i >= 0) {
                    if (j == 3) {
                        s1 = "," + s.substring(i + 1);
                        s2 = putCommas(Integer.parseInt(s.substring(0, i + 1))) + s1;
                    }

                    i--;
                    j++;

                }

                return s2;
            } else {
                return s;
            }
        }
    }
}
