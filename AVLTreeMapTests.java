public class AVLTreeMapTests {

    public static void main(String[] args) {
        testInsertionAndSize();
        testContains();
        testGetAndUpdate();
        testClear();
        testTreeBalancing();
        // Add calls to other test methods here.
        System.out.println("All tests passed.");
    }


    private static void testInsertionAndSize() {
        AVLTreeMap tree = new AVLTreeMap();
        tree.put(10, 100);
        tree.put(20, 200);
        tree.put(5, 50);

        AVLTreeMapTestUtils.assertEquals(tree.size(), 3);

        tree.put(10, 150); // Update an existing key
        AVLTreeMapTestUtils.assertEquals(tree.size(), 3); // Size should not change

        System.out.println("testInsertionAndSize passed.");
    }


    private static void testContains() {
        AVLTreeMap tree = new AVLTreeMap();
        tree.put(10, 100);
        tree.put(20, 200);
        tree.put(5, 50);

        AVLTreeMapTestUtils.assertEquals(tree.contains(10), true);
        AVLTreeMapTestUtils.assertEquals(tree.contains(15), false);

        System.out.println("testContains passed.");
    }


    private static void testGetAndUpdate() {
        AVLTreeMap tree = new AVLTreeMap();
        tree.put(10, 100);
        tree.put(20, 200);

        AVLTreeMapTestUtils.assertEquals(tree.get(10), 100);
        tree.put(10, 150);
        AVLTreeMapTestUtils.assertEquals(tree.get(10), 150);

        System.out.println("testGetAndUpdate passed.");
    }

    private static void testClear() {
        AVLTreeMap tree = new AVLTreeMap();
        tree.put(10, 100);
        tree.put(20, 200);
        tree.clear();

        AVLTreeMapTestUtils.assertEquals(tree.size(), 0);

        System.out.println("testClear passed.");
    }


    private static void testTreeBalancing() {
        try {
        AVLTreeMap tree = new AVLTreeMap();
        // left heavy tree
        tree.put(3, 30); // Insert key 3
        tree.put(2, 20); // Insert key 2, which goes to the left of 3
        tree.put(1, 10); // Insert key 1, which goes to the left of 2, causing an LL imbalance

        // A right rotation should happen around node 3 to balance
        // The expected balanced tree should have 2 as the root, with 1 as its left child and 3 as its right child

            tree.prettyPrint();


            String expectedStructure = "(2:20(1:10()())(3:30()()))";
            AVLTreeMapTestUtils.assertTreeStructure(tree, expectedStructure);
            System.out.println("testTreeBalancing passed.");
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }



}
