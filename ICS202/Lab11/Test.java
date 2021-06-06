

public class Test {

    public static void main(String[] args){

        Hashtable ht= new Hashtable(13);

        ht.insert(1);
        ht.insert(2);
        ht.insert(3);
        ht.insert(4);
        ht.insert(17);
        ht.insert(30);
        ht.insert(5);
        ht.insert(6);
        ht.insert(7);
        ht.insert(8);
        ht.insert(9);
        ht.insert(22);
        ht.insert(35);

        ht.toString();
        System.out.println(ht.find(4));
        ht.delete(4);

        System.out.println();
        ht.toString();

        System.out.println();
        ht.insert(4);
        ht.toString();
    }
}
