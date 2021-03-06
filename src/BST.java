/*************************************************************************
 *  Binary Search Tree class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 3.0 1/11/15 16:49:42
 *
 *  @author YI XIANG TAN
 *
 *************************************************************************/

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;             // root of BST

	/**
	 * Private node class.
	 */
	private class Node {
		private Key key;           // sorted by key
		private Value val;         // associated data
		private Node left, right;  // left and right subtrees
		private int N;             // number of nodes in subtree

		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}

	// is the symbol table empty?
	public boolean isEmpty() { return size() == 0; }

	// return number of key-value pairs in BST
	public int size() { return size(root); }

	// return number of key-value pairs in BST rooted at x
	private int size(Node x) {
		if (x == null) return 0;
		else return x.N;
	}

	/**
	 *  Search BST for given key.
	 *  Does there exist a key-value pair with given key?
	 *
	 *  @param key the search key
	 *  @return true if key is found and false otherwise
	 */
	public boolean contains(Key key) {
		return get(key) != null;
	}

	/**
	 *  Search BST for given key.
	 *  What is the value associated with given key?
	 *
	 *  @param key the search key
	 *  @return value associated with the given key if found, or null if no such key exists.
	 */
	public Value get(Key key) { return get(root, key); }

	private Value get(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else              return x.val;
	}

	/**
	 *  Insert key-value pair into BST.
	 *  If key already exists, update with new value.
	 *
	 *  @param key the key to insert
	 *  @param val the value associated with key
	 */
	public void put(Key key, Value val) {
		if (val == null) { delete(key); return; }
		if (key == null) { return; }
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {
		if (x == null) return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) x.left  = put(x.left,  key, val);
		else if (cmp > 0) x.right = put(x.right, key, val);
		else              x.val   = val;
		x.N = 1 + size(x.left) + size(x.right);
		return x;
	}

	/**
	 * Tree height.
	 *
	 * Asymptotic worst-case running time using Theta notation: 0(N)
	 *
	 * @return the number of links from the root to the deepest leaf.
	 *
	 * Example 1: for an empty tree this should return -1.
	 * Example 2: for a tree with only one node it should return 0.
	 * Example 3: for the following tree it should return 2.
	 *   B
	 *  / \
	 * A   C
	 *      \
	 *       D
	 */
	public int height() {
		if (root==null) return -1;
		return height(root);
	}

	private int height(Node node) {
		if (node == null) return -1;
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		return (int) Math.max(leftHeight, rightHeight) + 1;
	}

	/**
	 * Median key.
	 * If the tree has N keys k1 < k2 < k3 < ... < kN, then their median key 
	 * is the element at position (N+1)/2 (where "/" here is integer division)
	 *
	 * @return the median key, or null if the tree is empty.
	 */
	public Key median() {
		if (isEmpty()) return null;
<<<<<<< HEAD
		return median(root,(root.N-1)/2);
	}

	private Key median(Node n, int rank) {
		if(size(n.left)>rank) {
			return median(n.left,rank);
		}
		else if (size(n.left)<rank)
			return median(n.right,rank-size(n.left)-1);
		else
			return n.key;
	}
	
=======
		//TODO fill in the correct implementation. The running time should be Theta(h), where h is the height of the tree.
		return null;
	}

>>>>>>> parent of b77f216... Implemented delete, getMax, prettyPrintKeys, median. Removed getMin.

	/**
	 * Print all keys of the tree in a sequence, in-order.
	 * That is, for each node, the keys in the left subtree should appear before the key in the node.
	 * Also, for each node, the keys in the right subtree should appear before the key in the node.
	 * For each subtree, its keys should appear within a parenthesis.
	 *
	 * Example 1: Empty tree -- output: "()"
	 * Example 2: Tree containing only "A" -- output: "(()A())"
	 * Example 3: Tree:
	 *   B
	 *  / \
	 * A   C
	 *       D
	 *
	 * output: "((()A())B(()C(()D())))"
	 *
	 * output of example in the assignment: (((()A(()C()))E((()H(()M()))R()))S(()X()))
	 *
	 * @return a String with all keys in the tree, in order, parenthesized.
	 */
	public String printKeysInOrder() {

		return printKeysInOrder(root);
	}

	private String printKeysInOrder(Node n) {
		if (n==null) return "()";
		String l ="(";
		String r = ")";
		l += printKeysInOrder(n.left);
		r = printKeysInOrder(n.right)+r;
		return (String) (l+n.key+r);
	}

	/**
	 * Pretty Printing the tree. Each node is on one line -- see assignment for details.
	 *
	 * @return a multi-line string with the pretty ascii picture of the tree.
	 */
	public String prettyPrintKeys() {
		return prettyPrintKeys(root,"");
	}

	private String prettyPrintKeys(Node n, String s) {
		if(n!=null) {

			String s1 = s + "-"+n.val.toString()+"\n";
			s = " |"+s;
			String l = prettyPrintKeys(n.left,s);
			String r = prettyPrintKeys(n.right,"  "+s);
			return s1+l+r;
		}
		else {
			return s+"-null\n"+s+"-null\n";
		}
	}
	

	public Value getMax() {
		return getMax(root);
		}
	
	private Value getMax(Node n) {
		if(n.right==null)
			return n.val;
		else
<<<<<<< HEAD
			return getMax(root);
	}

	private Node getMax(Node n) {
		if(n.right!=null)
=======
>>>>>>> parent of b77f216... Implemented delete, getMax, prettyPrintKeys, median. Removed getMin.
			return getMax(n.right);
	}
<<<<<<< HEAD

	public void deleteMax()
	{
		if(!isEmpty()) 
			root = deleteMax(root); 
	}

	private Node deleteMax(Node x)
	{
		if (x.right == null) return x.left;
		x.right = deleteMax(x.right);
		x.N = 1 + size(x.right) + size(x.left);
		return x;
=======
	
	public Value getMin() {
		return getMin(root);
		}
	
	private Value getMin(Node n) {
		if(n.left==null)
			return n.val;
		else
			return getMin(n.left);
>>>>>>> parent of b77f216... Implemented delete, getMax, prettyPrintKeys, median. Removed getMin.
	}
	/**
	 * Deletes a key from a tree (if the key is in the tree).
	 * Note that this method works symmetrically from the Hibbard deletion:
	 * If the node to be deleted has two child nodes, then it needs to be
	 * replaced with its predecessor (not its successor) node.
	 *
	 * @param key the key to delete
	 */
	public void delete(Key key) {
<<<<<<< HEAD
		if(key!=null)
			root = delete(root,key);
	}

	private Node delete(Node n, Key key) {
		if(n==null) return null;
		int cmp = key.compareTo(n.key);
		if      (cmp < 0) n.left = delete(n.left,key);
		else if (cmp > 0) n.right = delete(n.right,key);
		else {
			if(n.left==null)
				return n.right;
			if(n.right==null) 
				return n.left;

			Node temp = n;
			n = getMax(temp.left);
			n.left= deleteMax(temp.left);
			n.right = temp.right;
		}
		n.N = size(n.left)+ size(n.right) + 1;
		return n;
=======
		//TODO fill in the correct implementation.
		/*
		 * 
		 */
	}

	public static void main(String[]args) {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		 bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
		System.out.println(bst.getMax());
>>>>>>> parent of b77f216... Implemented delete, getMax, prettyPrintKeys, median. Removed getMin.
	}

	/**
	 * Returns the value of a given node
	 * @param Reference to the node
	 * @return Value of the node
	 */
	public Value getVal(Node n) {
		if(n==null) return null;
		return n.val;
	}
	
}