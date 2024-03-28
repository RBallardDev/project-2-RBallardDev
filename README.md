Data Structures Programming Assignment 2
due Friday 03/09
Note: this assignment requires understanding AVL trees, which we worked with on the worksheet 6. I strongly recommend completing the AVL tree section of that worksheet before attempting this assignment.

This project asks you to the AVLTreeMap class, which uses an AVL tree to map one number to another. One use of AVLTreeMap might be to use student IDs as the key, and their percentage grade as the value. The signatures of the methods you need to write are below; you can read more about them in the AVLTreeMap JavaDoc.

void clear()

int size()

boolean contains(Integer key)

boolean put(Integer key, Integer value)

Integer get(Integer key)

public void remove(Integer key): This method is optional

This is the most difficult assignment of this entire course. All of the methods above must run in O(log n) time or faster, and the core methods (contain, put, and get) must be recursive, which makes them difficult to debug. I highly encourage you to start early and to seek help as soon as you are stuck.

Supporting Methods and Functions
Since you are writing a Map, each Node contains a key and a value. I have provided a basic Node class for you. In addition to the methods from the Map interface, the AVLTreeMap class has three other public methods for testing and debugging:

void assertStructureEquals(String structure) is a method that returns a String representation of the tree, for testing purposes. Details about the return value of this method can be found in the Javadoc, but in short, if a tree had the following keys (with values being the square of the keys):

    5
/ \
3   6
/ \   \
1   4   7
It's structure string will be "(5:25(3:9(1:1()())(4:16()()))(6:36()(7:49()())))". This may be useful if you are failing a test case and want to understand what the correct tree structure should be.

int[] toKeysArray() is a method that puts the keys of the tree into an array in sorted order. For the tree above, toKeysArray() will return the int array:

{1, 3, 4, 5, 6, 7}
Note that this function creates the array by following the left and right pointers of your tree, meaning that if your tree is malformed, this function could give incorrect arrays or go into an infinite loop. For this reason, you should use the other functions to test your tree first, then use toKeysArray() as a final test.

void prettyPrint() is a method that may help you with debugging, as it will print out the tree in a human-readable form. Using the same tree from the previous example, prettyPrint() will print out:

    7: 49
6: 36
5: 25
4: 16
3: 9
1: 1
This of this output as a normal tree rotated counter clockwise, so the root is on the left and the tree grows towards the right. Like toKeysArray(), this function follows the left and right pointers of your tree, meaning that if your tree is malformed, this function could print nonsensical "trees" or go into an infinite loop. This function is meant to help, but not replace, manual debugging.

You should not change these methods, as the testing code relies on them to work correctly. Similarly, you should not rename the root member variable of AVLTreeMap, or the left and right member variables of TreeNode.

Hints:
Since writing an AVL tree is a significant undertaking, I recommend breaking down the process into the following steps:

Write test cases for storing, checking, and retrieving keys and values. These test cases should not test the structure of the tree.

Write the code for a recursive binary search tree that doesn't self-balance. This tree should pass all of your test cases from the previous step, since the difference between a binary search tree and an AVL tree is not functionality, but complexity. To make the next steps easier, make sure your recursive calls return the root node of the subtree.

Write more test cases that check the structure of an AVL tree. Start with the smallest examples possible - what keys would you have to insert, in what order, to force a clockwise rotation? A counter-clockwise rotation? A double rotation? Then start writing test cases that involve children, etc.

Write the code for a recursive AVL tree. As before, each recursive call should return the root of that subtree, even if a rotation has occurred. The new root will be connected to the parent after the recursive call returns.

While it's easy to find working implementations of AVL trees online, I encourage you not to look at them, and write your code using only the description from the textbook and your own understanding of AVL trees. If you feel the need to look at working code, your aim should be to better understand how that code works, and once you gain that understanding, you should write your program without reference to the working implementation. Do not copy code from an existing AVL tree implementation.

Other Notes
Java automatically converts ints to Integers, so a function void foo(Integer bar) can be used as foo(42). Similarly, Integer.valueOf(2) < 3 and 4 == Integer.valueOf(4) will both evaluate to true.