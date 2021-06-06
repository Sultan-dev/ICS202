public class Test {

    public static void main(String[] args){

        SLL<String> fruitList = new SLL();
        fruitList.addToTail("Apple");
        fruitList.addToTail("Mango");
        fruitList.addToTail("Banana");
        fruitList.addToTail("Peach");
        fruitList.addToTail("Watermelon");

        fruitList.insertBefore("fruits", "Apple");
        fruitList.insertBefore("Orange", "Banana");
       
        fruitList.deleteBefore("Mango");
        fruitList.deleteAfter("Peach");
        
        fruitList.printAll();

        SortedSLL<String> sortedSLL= new SortedSLL<>();
        System.out.println();
        sortedSLL.insert("Apple");
        sortedSLL.insert("apple");
        sortedSLL.insert("Banana");
        sortedSLL.printAll();
    }
}
