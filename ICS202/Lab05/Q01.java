public class Q01 {

    public static void main(String[] args) {

        String[] array = {"apple", "mango", "banana", "nut", "watermelon"};

        System.out.println("The smallest string in the list is '" + findSmallest(array, 0) + "'");

        System.out.println("The longest string in the list is '" + findLongest(array, 0) + "'");
    }

    public static String findSmallest(String[] array, int index) {

        if (array.length == 0) {
            return null;
        } else {
            if (index != array.length - 1) {
                if (array[index].length() < array[index + 1].length()) {
                    String el;
                    int indexOfSmall = index;
                    el = findSmallest(array, index + 1);

                    if (el.length() < array[indexOfSmall].length()) {
                        return el;
                    } else {
                        return array[indexOfSmall];
                    }

                } else if (array[index].length() > array[index + 1].length()) {
                    String el;
                    int indexOfSmall = index + 1;
                    el = findSmallest(array, index + 1);

                    if (el.length() < array[indexOfSmall].length()) {
                        return el;
                    } else {
                        return array[indexOfSmall];
                    }
                } else {
                    return findSmallest(array, index + 1);
                }
            } else {
                return array[index];
            }
        }

    }

    public static String findLongest(String[] array, int index) {
        if (array.length == 0) {
            return null;
        } else {
            if (index != array.length - 1) {
                if (array[index].length() > array[index + 1].length()) {
                    String el;
                    int indexOflong = index;
                    el = findLongest(array, index + 1);

                    if (el.length() > array[indexOflong].length()) {
                        return el;
                    } else {
                        return array[indexOflong];
                    }

                } else if (array[index].length() < array[index + 1].length()) {
                    String el;
                    int indexOflong = index + 1;
                    el = findLongest(array, index + 1);

                    if (el.length() > array[indexOflong].length()) {
                        return el;
                    } else {
                        return array[indexOflong];
                    }
                } else {
                    return findLongest(array, index + 1);
                }
            } else {
                return array[index];
            }
        }

    }

}
