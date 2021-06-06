public class BinaryTreeDriver {
    public static void main(String args[]) {

           /* Construct the following Binary tree:
                   2
                 /   \
                /     \
               2       4
              / \     / \
             /   \   /   \
            5     6 8    10
                        /
                       /
                      3

        */

        BinaryTree<Integer> myBinaryTree = new BinaryTree<Integer>();
        myBinaryTree.root = new BTNode<Integer>(2);
        myBinaryTree.root.right = new BTNode<>(4);
        myBinaryTree.root.right.left = new BTNode<>(8);
        myBinaryTree.root.right.right = new BTNode<>(10);
        myBinaryTree.root.right.right.left = new BTNode<>(3);
        myBinaryTree.root.left = new BTNode<>(2);
        myBinaryTree.root.left.right = new BTNode<>(6);
        myBinaryTree.root.left.left = new BTNode<>(5);

        myBinaryTree.printTree(); // print the tree

        myBinaryTree.modifyBinaryTree(2); // method modify binary tree

        System.out.println();
        myBinaryTree.printTree();

        //     myBinaryTree.modifyBinaryTree(30);// throw exception

        //     BinaryTree<Integer> bt = new BinaryTree<>();
        //    bt.modifyBinaryTree(10); // throw exception
    }
}
