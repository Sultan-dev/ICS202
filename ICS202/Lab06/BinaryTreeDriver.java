
public class BinaryTreeDriver {

    public static void main(String[] args)throws Exception {

        BinaryTree<Integer> bt= new BinaryTree<>();
        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(12);
        bt.insert(5);




        System.out.println("the number of nodes is "+bt.count());

        System.out.println("the number of leaves is "+bt.countLeaves());

        System.out.println("The level of node with key 4 is "+bt.getLevel(4));

       // System.out.println("The level of the node with key 60 is"+bt.getLevel(60));

        System.out.println("The preorder traversal: ");
        bt.preorderTraversal();

        System.out.println("\nThe inorder traversal: ");
        bt.inorderTraversal();

        System.out.println("\nThe postorder traversal: ");
        bt.preorderTraversal();

        System.out.println("\nThe order before deleting key 3 is ");
        bt.levelOrderTraversal();

        System.out.println("\nThe tree is:");
        bt.printTree();

        System.out.println("\nAfter deleting key 3: ");
        bt.levelOrderTraversal();

        System.out.println("\nThe tree is: ");
        bt.printTree();


    }
}
