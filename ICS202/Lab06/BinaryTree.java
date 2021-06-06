import java.util.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BinaryTree<T extends Comparable<? super T>> {
    BTNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public void purge() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(T key) {
        if (root == null) {
            root = new BTNode<T>(key);
            return;
        }

        BTNode<T> temp;
        Queue<BTNode<T>> q = new LinkedList<BTNode<T>>();
        q.add(root);

        // Do level order traversal until we find the first empty left or right child.
        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp.left == null) {
                temp.left = new BTNode<T>(key);
                break;
            } else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new BTNode<T>(key);
                break;
            } else
                q.add(temp.right);
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

        Queue<BTNode<T>> queue = new LinkedList<BTNode<T>>();
        queue.add(root);
        BTNode<T> keyNode = null;
        BTNode<T> currentNode = null;
        BTNode<T> parentNode = root;
        boolean found = false;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();

            if (currentNode.data.equals(data)) {
                if (!found) {
                    keyNode = currentNode;
                    found = true;
                }
            }

            if (currentNode.left != null) {
                queue.add(currentNode.left);
                parentNode = currentNode;
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
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
        Queue<BTNode<T>> queue = new LinkedList<BTNode<T>>();
        BTNode<T> node = root;
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.data + "  ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
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
        Queue<BTNode<T>> queue = new LinkedList<BTNode<T>>();
        BTNode<T> node = root;
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (key.equals(node.data))
                return true;
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return false;
    }


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

    public int count() throws Exception {
        if (root == null) {
            throw new Exception("The tree is empty");
        } else {
            return count(root);
        }
    }

    //helper method
    private int count(BTNode node) {

        if (node != null) {
            return 1 + count(node.left) + count(node.right);
        } else {
            return 0;
        }
    }


    public boolean isLeaf(BTNode node) throws Exception {

        if (!search((T) node.data)) {
            throw new Exception("the node is not in the tree");
        } else {
            BTNode<T> p = root;
            while (p != null && !p.data.equals(node.data)) {  // find the node p
                if (node.data.compareTo(p.data) < 0) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }

            if (p != null && p.data.equals(node.data)) {
                if (p.right == null) {
                    if (p.left == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int countLeaves() throws Exception {
        if (root == null) {
            throw new Exception("the tree is empty");
        } else {
            return countLeaves(root);
        }
    }

    //helper method for countleaves
    private int countLeaves(BTNode node) throws Exception {

        if (node == null) {
            if (node.right == null && node.left == null) {
                return 1 ;
            } else {
                return countLeaves(node.left) + countLeaves(node.right);
            }
        } else {
            return 0;
        }
    }

    public int getLevel(T data) throws Exception {
        int level = 0;
        if (!search((data))) {
            throw new Exception("the key " + data + " is not in the tree");
        } else {

            BTNode<T> p = root;
            while (p != null && !p.data.equals(data)) {  // find the node p
                if (data.compareTo(p.data) < 0) {
                    p = p.left;
                } else {
                    p = p.right;
                }
                level++;
            }

            if (p != null && p.data.equals(data)) {
                if (p.right == null) {
                    if (p.left == null) {
                        level++;
                    }
                }
            }
        }
        return level;
    }
}