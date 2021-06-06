import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class TestAVL{

    public static void main(String[] args)throws IOException {

        AVLTree<Integer> avl= new AVLTree<>();

        avl.insertAVL(8);
        avl.insertAVL(14);
        avl.insertAVL(12);
        avl.insertAVL(18);
        avl.insertAVL(23);
        avl.insertAVL(20);
        avl.insertAVL(15);
        avl.insertAVL(13);
        avl.insertAVL(7);
        avl.insertAVL(16);

        avl.breadthFirst();

        Scanner key= new Scanner(System.in);
        int number;

        System.out.println("\nEnter three elements to delete them from the tree: ");
        for(int i= 0; i < 3; i++){
            number= key.nextInt();
            avl.deleteAVL(number);
        }

        avl.breadthFirst();
        key.close();
        System.out.println();

       File file= new File("C:\\Users\\nilyo\\OneDrive\\Desktop\\sampletextfile.txt");
       Scanner input= new Scanner(file);
       String word;

       AVLTree<String> avls= new AVLTree<>();

       while(input.hasNext()){
        word= input.next();
        if(!avls.isInTree(word)){
            avls.insert(word);
        }
       }
        input.close();
        avls.inorder();
    }
}