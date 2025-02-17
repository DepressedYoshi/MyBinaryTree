public class Main {
    public static void main(String[] args) {
        MyBinaryTree<Integer> bst = new MyBinaryTree<>();

        // ===== TEST 1: Insert =====
        System.out.println("===== TEST 1: Insert =====");
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        System.out.print("In-order Traversal (should be sorted): ");
        bst.inOrderTraversal(); // Expected: 20 30 40 50 60 70 80

        // Test duplicate insertion (should not affect tree structure)
        System.out.println("Inserting duplicate value (50):");
        bst.insert(50);
        bst.inOrderTraversal(); // Expected: 20 30 40 50 60 70 80 (no duplicates)

        // ===== TEST 2: Search =====
        System.out.println("\n===== TEST 2: Search =====");
        System.out.println("Contains 40: " + bst.contains(40)); // Expected: true
        System.out.println("Contains 100: " + bst.contains(100)); // Expected: false

        // ===== TEST 3: Find Min/Max =====
        System.out.println("\n===== TEST 3: Find Min/Max =====");
        System.out.println("Minimum value: " + bst.findMin()); // Expected: 20
        System.out.println("Maximum value: " + bst.findMax()); // Expected: 80

        // ===== TEST 4: Height =====
        System.out.println("\n===== TEST 4: Height =====");
        System.out.println("Height of tree: " + bst.height()); // Expected: 2

        // ===== TEST 5: Size =====
        System.out.println("\n===== TEST 5: Size =====");
        System.out.println("Size of tree: " + bst.size()); // Expected: 7

        // ===== TEST 6: Traversals =====
        System.out.println("\n===== TEST 6: Traversals =====");
        System.out.print("In-order Traversal: ");
        bst.inOrderTraversal(); // Expected: 20 30 40 50 60 70 80
        System.out.print("Pre-order Traversal: ");
        bst.preOrderTraversal(); // Expected: 50 30 20 40 70 60 80
        System.out.print("Post-order Traversal: ");
        bst.postOrderTraversal(); // Expected: 20 40 30 60 80 70 50
        System.out.print("Level-order Traversal: ");
        bst.levelOrderTraversal(); // Expected: 50 30 70 20 40 60 80

        // ===== TEST 7: Delete =====
        System.out.println("\n===== TEST 7: Delete =====");
        System.out.println("Deleting a leaf node (20):");
        bst.delete(20);
        bst.inOrderTraversal(); // Expected: 30 40 50 60 70 80

        System.out.println("Deleting a node with one child (30):");
        bst.delete(30);
        bst.inOrderTraversal(); // Expected: 40 50 60 70 80

        System.out.println("Deleting a node with two children (50):");
        bst.delete(50);
        bst.inOrderTraversal(); // Expected: 40 60 70 80

        // ===== TEST 8: Balance =====
        System.out.println("\n===== TEST 8: Balance =====");
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        System.out.println("Tree before balancing:");
        bst.levelOrderTraversal();
        System.out.println("Is tree balanced: " + bst.isBalanced()); // Expected: false
        bst.balance();
        System.out.println("Tree after balancing:");
        bst.levelOrderTraversal(); // Expected: balanced tree
        System.out.println("Is tree balanced: " + bst.isBalanced()); // Expected: true

        // ===== TEST 9: Valid BST Check =====
        System.out.println("\n===== TEST 9: Valid BST Check =====");
        System.out.println("Is tree a valid BST: " + bst.isValidBST()); // Expected: true

        // ===== TEST 10: Edge Cases =====
        System.out.println("\n===== TEST 10: Edge Cases =====");

        // Edge Case 1: Empty Tree
        MyBinaryTree<Integer> emptyTree = new MyBinaryTree<>();
        System.out.println("Empty tree is valid BST: " + emptyTree.isValidBST()); // Expected: true
        System.out.println("Empty tree is balanced: " + emptyTree.isBalanced()); // Expected: true
        System.out.println("Empty tree size: " + emptyTree.size()); // Expected: 0
        System.out.println("Empty tree height: " + emptyTree.height()); // Expected: -1

        // Edge Case 2: Single Node
        emptyTree.insert(42);
        System.out.println("Single-node tree is valid BST: " + emptyTree.isValidBST()); // Expected: true
        System.out.println("Single-node tree is balanced: " + emptyTree.isBalanced()); // Expected: true
        System.out.println("Single-node tree size: " + emptyTree.size()); // Expected: 1
        System.out.println("Single-node tree height: " + emptyTree.height()); // Expected: 0

        // Edge Case 3: Large Dataset
        System.out.println("\nTesting large dataset:");
        MyBinaryTree<Integer> largeTree = new MyBinaryTree<>();
        for (int i = 1; i <= 1000; i++) {
            largeTree.insert(i);
        }
        System.out.println("Large tree size: " + largeTree.size()); // Expected: 1000
        System.out.println("Large tree height before balancing: " + largeTree.height()); // Expected: close to 999
        largeTree.balance();
        System.out.println("Large tree height after balancing: " + largeTree.height()); // Expected: close to log2(1000)
    }
}
