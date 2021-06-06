public class Q04 {

    public static void main(String[] args) {

        SLL<String> list = new SLL<>();
        list.addToTail("m");
        list.addToTail("o");
        list.addToTail("o");
        list.addToTail("n");
        //the word is moon

        System.out.println(findPalindrome(list));


        SLL<String> list2 = new SLL<>();
        list.addToTail("m");
        list.addToTail("o");
        list.addToTail("o");
        list.addToTail("n");
        //the word is noon

        System.out.println(findPalindrome(list2));
    }

    public static boolean findPalindrome(SLL<String> list) {

        if (list.isEmpty() || list.getSize() == 1) {
            return true;

        } else {
            if (list.head.info.equals(list.tail.info)) {
                SLL<String> newList = new SLL<>();
                SLLNode<String> tmp;
                for (tmp = list.head; tmp != null; tmp = tmp.next) {
                    if (tmp != list.head || tmp != list.tail) {
                        newList.addToTail(tmp.info);
                    }
                }

                return findPalindrome(newList);

            } else {
                return false;
            }
        }
    }
}
