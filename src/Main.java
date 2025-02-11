
public class Main {
    public static void main(String[] args) {
        MyBinaryTree<Integer> bst = new MyBinaryTree<>();

        System.out.println("===== TESTING INSERTION =====");
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        System.out.println("Tree after insertions (In-order traversal):");
        bst.inOrderTraversal();  // Expected: 20 30 40 50 60 70 80

        System.out.println("\n===== TESTING CONTAINS =====");
        System.out.println("Tree contains 40: " + bst.contains(40));  // Expected: true
        System.out.println("Tree contains 100: " + bst.contains(100)); // Expected: false

        System.out.println("\n===== TESTING FIND MIN/MAX =====");
        System.out.println("Minimum value in tree: " + bst.findMin()); // Expected: 20
        System.out.println("Maximum value in tree: " + bst.findMax()); // Expected: 80

        System.out.println("\n===== TESTING TREE SIZE =====");
        System.out.println("Total nodes in tree: " + bst.size()); // Expected: 7

        System.out.println("\n===== TESTING TREE HEIGHT =====");
        System.out.println("Tree height: " + bst.height()); // Expected: 2

        System.out.println("\n===== TESTING TREE BALANCE =====");
        System.out.println("Is tree balanced: " + bst.isBalanced()); // Expected: true

        System.out.println("\n===== TESTING TRAVERSALS =====");
        System.out.print("In-order Traversal: ");
        bst.inOrderTraversal();  // Expected: 20 30 40 50 60 70 80
        System.out.print("Pre-order Traversal: ");
        bst.preOrderTraversal(); // Expected: 50 30 20 40 70 60 80
        System.out.print("Post-order Traversal: ");
        bst.postOrderTraversal(); // Expected: 20 40 30 60 80 70 50
        System.out.print("Level-order Traversal: ");
        bst.levelOrderTraversal(); // Expected: 50 30 70 20 40 60 80

        System.out.println("\n===== TESTING DELETE =====");
        System.out.println("Deleting node 20 (leaf node)...");
        bst.delete(20);
        System.out.print("Tree after deletion (In-order): ");
        bst.inOrderTraversal(); // Expected: 30 40 50 60 70 80

        System.out.println("Deleting node 30 (node with one child)...");
        bst.delete(30);
        System.out.print("Tree after deletion (In-order): ");
        bst.inOrderTraversal(); // Expected: 40 50 60 70 80

        System.out.println("Deleting node 50 (node with two children)...");
        bst.delete(50);
        System.out.print("Tree after deletion (In-order): ");
        bst.inOrderTraversal(); // Expected: 40 60 70 80

        System.out.println("\n===== TESTING TO SORTED ARRAY =====");
        System.out.println("Sorted Array: " + bst.toSortedArray()); // Expected: [40, 60, 70, 80]

        System.out.println("\n===== TESTING TREE VALIDITY =====");
        System.out.println("Is tree a valid BST: " + bst.isValidBST()); // Expected: true

        System.out.println("\n===== FINAL TEST COMPLETED SUCCESSFULLY =====");
    }
}