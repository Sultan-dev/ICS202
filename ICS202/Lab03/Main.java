import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        int num;

        DLL<Integer> list = new DLL<>();

        for (int count = 1; count <= 10; count++) {
            num = r.nextInt(11);
            list.addToTail(num);
        }
        list.printAll();
        list.delete7(); // Question 3


        DLL<Integer> list1 = new DLL<>();
        DLL<Integer> list2 = new DLL<>();

        for (int count = 1; count <= 5; count++) {
            num = r.nextInt(11);
            list1.addToTail(num);
            num = r.nextInt(11);
            list2.addToTail(num);
        }

        System.out.println();
        list1.printAll();
        System.out.println();
        list2.printAll();
        System.out.println();
        list1.insertAlternate(list2); // Question 4
        list1.printAll();

        DLL<Integer> list4 = new DLL<>();

        for (int count = 1; count <= 5; count++) {
            num = r.nextInt(11);
            list4.addToTail(num);
        }
        System.out.println();
        list4.printAll();
        System.out.println();
        list4.printReverse(); // Question 2
    }
}
