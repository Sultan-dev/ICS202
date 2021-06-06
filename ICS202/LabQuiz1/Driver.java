public class Driver {

    public static void main(String[] args) {

        // examples in the table

        SLL<Integer> list1 = new SLL<Integer>(); // example 1

        list1.addToTail(3);

        SLL<Integer> newList = new SLL<>();
        newList = list1.deleteSpecial(3);

        // newList.printAll(); // will return an empty list

        SLL<Integer> list2 = new SLL<>(); //example 2

        list2.addToTail(5);
        list2.addToTail(8);
        list2.addToTail(4);
        list2.addToTail(7);
        list2.addToTail(4);
        list2.addToTail(9);
        list2.addToTail(4);
        list2.addToTail(10);

        newList = list2.deleteSpecial(4);
        newList.printAll();

        System.out.println();

        SLL<Integer> list3 = new SLL<>(); // example 3

        list3.addToTail(20);
        list3.addToTail(6);
        list3.addToTail(8);
        list3.addToTail(12);

        newList = list3.deleteSpecial(20);
        newList.printAll();

        System.out.println();

        SLL<Integer> list4 = new SLL<>(); // example 4

        list4.addToTail(2);
        list4.addToTail(4);
        list4.addToTail(70);
        list4.addToTail(3);
        list4.addToTail(70);

        newList = list4.deleteSpecial(70);
        newList.printAll();

        System.out.println();

        SLL<Integer> list5 = new SLL<>(); // example 5

        list5.addToTail(26);
        list5.addToTail(26);
        list5.addToTail(30);
        list5.addToTail(40);
        list5.addToTail(32);

        newList = list5.deleteSpecial(26);
        newList.printAll();

        System.out.println();

        SLL<Integer> list6 = new SLL<>(); // example 6

        list6.addToTail(5);
        list6.addToTail(7);
        list6.addToTail(14);
        list6.addToTail(6);
        list6.addToTail(8);

        // newList= list6.deleteSpecial(40); // throw an exception because 40 is not in the list
        //newList.printAll();

        System.out.println();

        // Invalid cases

        SLL<Integer> listEmpty = new SLL<>(); // case one: is empty

        //newList= listEmpty.deleteSpecial(10); will throw an exception because the list is empty
        // listEmpty.printAll();

        System.out.println();

        SLL<Integer> notEInTheList = new SLL<>(); // case two: null or not in the list

        notEInTheList.addToTail(1);
        notEInTheList.addToTail(2);
        notEInTheList.addToTail(3);
        notEInTheList.addToTail(4);
        notEInTheList.addToTail(5);

        //  newList= notEInTheList.deleteSpecial(null);  will throw an exception because element is null
        // notEInTheList.printAll();
    }
}
