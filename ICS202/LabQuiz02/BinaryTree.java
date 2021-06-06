import java.util.NoSuchElementException;

public class BinaryTree<T extends Comparable<? super T>> {
    BTNode<T> root;
    int height = -1;

    public BinaryTree() {
        root = null;
    }

    public void purge() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    int getBalanceFactor(BTNode node) {
        if (node == null)
            return -1;
        else {
            /* compute the height of each subtree */
            int heightLeftSubtree = getBalanceFactor(node.left);
            int heightRightSubtree = getBalanceFactor(node.right);

            return heightRightSubtree - heightLeftSubtree;
        }
    }

    public void iterativeInorderTraversal() {
        iterativeInorderTraversal(root);
    }

    private void iterativeInorderTraversal(BTNode<T> root) {

        if (root == null)
            return;

        Stack s = new Stack();

        BTNode<T> curr = root;

        // traverse the tree
        while (curr != null || !s.isEmpty()) {
            /* Reach the left most Node of the curr Node */

            while (curr != null) {
                /* place pointer to a tree node on the stack before traversing the node's left subtree */

                s.push(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = (BTNode) s.pop();

            System.out.print(curr.data + " ");


            /* we have visited the node and its left subtree.  Now, it's right subtree's turn */
            curr = curr.right;
        }
    }

    public void insert(T key) {
        if (root == null) {
            root = new BTNode<T>(key);
            return;
        }

        BTNode<T> temp;
        Queue q = new Queue();
        q.enqueue(root);

        // Do level order traversal until we find the first empty left or right child.
        while (!q.isEmpty()) {
            temp = (BTNode) q.dequeue();

            if (temp.left == null) {
                temp.left = new BTNode<T>(key);
                break;
            } else
                q.enqueue(temp.left);

            if (temp.right == null) {
                temp.right = new BTNode<T>(key);
                break;
            } else
                q.enqueue(temp.right);
        }
    }

    public void deleteByCopying(T data) {
        if (root == null)
            throw new UnsupportedOperationException("Tree is empty!");
        else if (root.left == null && root.right == null) {
            if (root.data.equals(data))
                root = null;
            else
                throw new NoSuchElementException(data + " not in the tree.");
            return;
        }

        Queue queue = new Queue();
        queue.enqueue(root);
        BTNode<T> keyNode = null;
        BTNode<T> currentNode = null;
        BTNode<T> parentNode = root;
        boolean found = false;
        while (!queue.isEmpty()) {
            currentNode = (BTNode) queue.dequeue();

            if (currentNode.data.equals(data)) {
                if (!found) {
                    keyNode = currentNode;
                    found = true;
                }
            }

            if (currentNode.left != null) {
                queue.enqueue(currentNode.left);
                parentNode = currentNode;
            }
            if (currentNode.right != null) {
                queue.enqueue(currentNode.right);
                parentNode = currentNode;
            }
        }

        if (!found)
            throw new NoSuchElementException(data + " not in tree.");

        keyNode.data = currentNode.data;
        if (parentNode.left == currentNode)
            parentNode.left = null;
        else if (parentNode.right == currentNode)
            parentNode.right = null;
    }

    public void levelOrderTraversal() { // BreadthFirstTraversal
        levelOrderTraversal(root);
    }

    private void levelOrderTraversal(BTNode<T> root) {
        if (root == null)
            return;
        Queue queue = new Queue();
        BTNode<T> node = root;
        queue.enqueue(node);
        while (!queue.isEmpty()) {
            node = (BTNode) queue.dequeue();
            System.out.print(node.data + "  ");
            if (node.left != null)
                queue.enqueue(node.left);
            if (node.right != null)
                queue.enqueue(node.right);
        }
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }

    protected void inorderTraversal(BTNode<T> node) {
        if (node == null)
            return;

        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    public void postorderTraversal() {
        postorderTraversal(root);
    }

    private void postorderTraversal(BTNode<T> node) {
        if (node == null)
            return;

        postorderTraversal(node.left);
        postorderTraversal(node.right);

        System.out.print(node.data + " ");
    }

    public void preorderTraversal() {
        preorderTraversal(root);
    }

    private void preorderTraversal(BTNode<T> node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");

        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public boolean search(T key) {
        if (root == null)
            return false;
        Queue queue = new Queue();
        BTNode<T> node = root;
        queue.enqueue(node);
        while (!queue.isEmpty()) {
            node = (BTNode) queue.dequeue();
            if (key.equals(node.data))
                return true;
            if (node.left != null)
                queue.enqueue(node.left);
            if (node.right != null)
                queue.enqueue(node.right);
        }
        return false;
    }

    //===============================================================================
    public void modifyBinaryTree(T key) throws IllegalArgumentException {
        if (isEmpty()) {
            throw new IllegalArgumentException("Warning: The tree is Empty");
        } else if (!search(key)) {
            throw new IllegalArgumentException("Warning: the key " + key + " is not in the tree");
        } else {
            modifyBinaryTree(root, key); // helper method
        }
    }

    // helper method
    private void modifyBinaryTree(BTNode<T> p, T key) {
        if (p != null) {
            if (p.data.compareTo(key) < 0) { // go to left subtree
                modifyBinaryTree(p.left, key);

            } else if (p.data.compareTo(key) > 0) { // go to right subtree
                modifyBinaryTree(p.right, key);

            } else {
                if (p.right != null) {
                    T data1;
                    T data2;

                    while (p != null) {
                        if (p.right != null) {
                            data1 = p.data;
                            data2 = p.right.data;
                            p.data = data2;
                            p.right.data = data1;
                            p = p.right;

                        } else {
                            break;

                        }
                    }
                }
            }
        }
    }


//===============================================================================

    public void printTree() {
        printTree(root, "", true);
    }

    // Print the tree
    private void printTree(BTNode<T> currPtr, String indent, boolean last) {
        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(currPtr.data);
            printTree(currPtr.left, indent, false);
            printTree(currPtr.right, indent, true);
        }
    }
}
