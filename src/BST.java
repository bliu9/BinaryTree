import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 *
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     *
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size() - 1));
    }

    /**
     * A function that searches for a value in the tree
     *
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        return searchHelper(val, this.getRoot());
    }

    // Helper method to search for a given value in BST
    // Returns true if the value is found
    // Returns false if the specific value is not found
    public boolean searchHelper(int val, BSTNode root) {
        // Base case 1: if it reaches the bottom of the tree, return false because it has not been found
        if (root == null) {
            return false;
        }
        // Base case 2: if the value is found, return true
        if (val == root.getVal()) {
            return true;
        }

        // Recursive steps
        // If the value is less than the current root
        if (val < root.getVal()) {
            // Step to the left node
            return searchHelper(val, root.getLeft());
        }
        // If the value is more than the current root
        if (val > root.getVal()) {
            // Step to the right node
            return searchHelper(val, root.getRight());
        }
        return false;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        // Create the arraylist of nodes to be returned
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        // Call the helper function to fill the arraylist
        getInorderHelper(this.getRoot(), nodes);
        // Return the array of nodes
        return nodes;
    }

    //
    public void getInorderHelper(BSTNode root, ArrayList<BSTNode> nodes) {
        // Base Case: if the root is null (does not exist), the code has reached the end of the tree, so it should return
        if (root == null) {
            return;
        }

        // Recursive steps
        // Traverse the tree to the left
        getInorderHelper(root.getLeft(), nodes);
        // Print the current root
        nodes.add(root);
        // Traverse the tree to the right
        getInorderHelper(root.getRight(), nodes);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        // Create the arraylist to be returned with the preorder traversal
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        // Call the helper method to fill the arraylist
        getPreorderHelper(this.getRoot(), nodes);
        // return the nodes in preorder traversal format
        return nodes;
    }

    public void getPreorderHelper(BSTNode root, ArrayList<BSTNode> nodes) {
        // Base Case: if the root is null (does not exist), the code has reached the end of the tree, so it should return
        if (root == null) {
            return;
        }

        // Print the current node
        nodes.add(root);
        // Traverse the tree to the left
        getPreorderHelper(root.getLeft(), nodes);
        // Traverse the tree to the right
        getPreorderHelper(root.getRight(), nodes);
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        // Create the arraylist to be returned with the preorder traversal
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        // // Call the helper method to fill the arraylist
        getPostorderHelper(this.getRoot(), nodes);
        // Return the nodes in post order traversal format
        return nodes;
    }

    public void getPostorderHelper(BSTNode root, ArrayList<BSTNode> nodes) {
        // Base Case: if the root is null (does not exist), the code has reached the end of the tree, so it should return
        if (root == null) {
            return;
        }

        // Traverse the tree to the left
        getPostorderHelper(root.getLeft(), nodes);
        // Traverse the tree to the right
        getPostorderHelper(root.getRight(), nodes);
        // Print out the current node
        nodes.add(root);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     *
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        // Call helper method that will do the insertion of the value
        insertHelper(this.root, val);
    }

    // Inserts a value into the correct position in a BST
    public void insertHelper(BSTNode root, int val) {
        // Base Case: If the left and right child of the current root is null (does not exist),
        // the code has reached the end of the tree, so it should now insert the value
        if (root.getLeft() == null && root.getRight() == null) {
            // If the value is less than the current root's value
            if (val < root.getVal()) {
                // Insert the new node as a left child
                root.setLeft(new BSTNode(val));
            }
            // If the value is more than the current root's value
            if (val > root.getVal()) {
                // Insert the new node as a right child
                root.setRight(new BSTNode(val));
            }
            return;
        }

        // Recursive steps
        // If the value is less than the current root's value
        if (val < root.getVal()) {
            // Traverse the tree to the left
            insertHelper(root.getLeft(), val);
        }
        // If the value is more than tha current root's value
        if (val > root.getVal()) {
            // Traverse the tree to the right
            insertHelper(root.getRight(), val);
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     *
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
