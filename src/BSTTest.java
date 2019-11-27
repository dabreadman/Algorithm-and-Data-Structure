import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  TODO
 */

@RunWith(JUnit4.class)
public class BSTTest
{

	//TODO write more tests here.

	/** <p>Test {@link BST#prettyPrintKeys()}.</p> */

	@Test
	public void testPut() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking the empty tree",null,bst.getVal(bst.getMax()));
		bst.put(1, 6);
		assertEquals("Putting valid node on empty tree",(int)0,(int)bst.height());
		assertEquals("Putting valid node on empty tree",(int)6,(int)bst.get(1));
		
		bst.put(1, null);
		assertEquals("Putting invalid node on non-empty tree",(int)0,(int)bst.height());
		
		bst.put(5, 5);
		assertEquals("Putting valid node on empty tree",(int)1,(int)bst.height());
		
		bst.put(5, 5);
		assertEquals("Putting duplicate node on empty tree",(int)1,(int)bst.height());
		
		
	}
	
	/** <p>Test {@link BST#prettyPrintKeys()}.</p> */

	@Test
	public void testContains() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertFalse("Checking contains on the empty tree",bst.contains(3));
		bst.put(1, 1);
		assertTrue("Checking valid contain on non-tree",bst.contains(1));
		
	}
	
	/** <p>Test {@link BST#prettyPrintKeys()}.</p> */

	@Test
	public void testGet() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Get non-existential node",null,bst.get(5));
		bst.put(7, 7);   //        _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \
		bst.put(2, 2);   // 1       6
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4
		bst.put(5, 5);   //        \
		                 //         5
		assertEquals("Get valid node",(int)5,(int)bst.get(5));
		assertEquals("Get valid node",(int)2,(int)bst.get(2));
	}
	
	/** <p>Test {@link BST#prettyPrintKeys()}.</p> */

	@Test
	public void testIsEmpty() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertTrue("Checking isEmpty on the empty tree",bst.isEmpty());
		bst.put(1, 1);
		assertFalse("Checking isEmpty on the non-empty tree",bst.isEmpty());
	}
	
	/** <p>Test {@link BST#prettyPrintKeys()}.</p> */

	@Test
	public void testPrettyPrint() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking pretty printing of empty tree",
				"-null\n", bst.prettyPrintKeys());

		                     //  -7
		                     //   |-3
	                         //   | |-1
		                     //   | | |-null
		bst.put(7, 7);       //   | |  -2
		bst.put(8, 8);       //   | |   |-null
		bst.put(3, 3);       //   | |    -null
		bst.put(1, 1);       //   |  -6
		bst.put(2, 2);       //   |   |-4
		bst.put(6, 6);       //   |   | |-null
		bst.put(4, 4);       //   |   |  -5
		bst.put(5, 5);       //   |   |   |-null
		                     //   |   |    -null
		                     //   |    -null
		                     //    -8
		                     //     |-null
		                     //      -null

		String result = 
				        "-7\n" +
						" |-3\n" + 
						" | |-1\n" +
						" | | |-null\n" + 
						" | |  -2\n" +
						" | |   |-null\n" +
						" | |    -null\n" +
						" |  -6\n" +
						" |   |-4\n" +
						" |   | |-null\n" +
						" |   |  -5\n" +
						" |   |   |-null\n" +
						" |   |    -null\n" +
						" |    -null\n" +
						"  -8\n" +
						"   |-null\n" +
						"    -null\n";
		assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
	}


	/** <p>Test {@link BST#delete(Comparable)}.</p> */
	@Test
	public void testDelete() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.delete(1);
		assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());

		bst.put(7, 7);   //        _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \
		bst.put(2, 2);   // 1       6
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4
		bst.put(5, 5);   //        \
		                 //         5

		assertEquals("Checking order of constructed tree",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

		bst.delete(9);
		assertEquals("Deleting non-existent key",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

		bst.delete(8);
		assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());

		bst.delete(6);
		assertEquals("Deleting node with single child",
				"(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());

		bst.delete(3);
		assertEquals("Deleting node with two children",
				"(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
	}

	/** <p>Test {@link BST#delete(Comparable)}.</p> */
	@Test
	public void testMedian() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		assertEquals("Checking median of empty tree", null,bst.median());
		bst.put(7, 7);   //        _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \
		bst.put(2, 2);   // 1       6
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4
		bst.put(5, 5);   //        \
		//         5

		assertEquals("Checking median of non-empty tree",(int)4,(int)bst.median());
	}

	/** <p>Test {@link BST#delete(Comparable)}.</p> */
	@Test
	public void testHeight() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking height of empty tree",(int)-1,bst.height());

		bst.put(7, 7);   //        _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \
		bst.put(2, 2);   // 1       6
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4
		bst.put(5, 5);   //        \
		//         5
		assertEquals("Checking height of non-empty tree",(int) 4,(int)bst.height());

	}

	/** <p>Test {@link BST#delete(Comparable)}.</p> */
	@Test
	public void testGetMax() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking max of empty tree",null,bst.getMax());
		bst.put(1,1);
		assertEquals("Checking max of non-empty tree",(int)1,(int)bst.getVal(bst.getMax()));
	}

	/** <p>Test {@link BST#delete(Comparable)}.</p> */
	@Test
	public void testDeleteMax() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.deleteMax();
		assertTrue("Checking deleteMax on empty tree",bst.isEmpty());
		bst.put(1, 1);
		bst.deleteMax();
		assertTrue("Checking deleteMax on single node tree",bst.isEmpty());
	}

}

