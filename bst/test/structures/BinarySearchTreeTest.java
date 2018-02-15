package structures;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.Timeout;

public class BinarySearchTreeTest {

	private BSTInterface<Integer> emptyTree;
	private BSTInterface<String> oneNodeTree;
	private BSTInterface<Integer> fourNodeTree;
	private static final String FOO = "foo";

	//@Rule
    //public Timeout timeout = new Timeout(1L, TimeUnit.SECONDS);
	
	@Before
	public void before() {
		emptyTree = new BinarySearchTree<Integer>();
		oneNodeTree = new BinarySearchTree<String>();
		oneNodeTree.add(FOO);
		fourNodeTree=new BinarySearchTree<Integer>();
		fourNodeTree.add(4);
		fourNodeTree.add(2);
		fourNodeTree.add(5);
		fourNodeTree.add(3);
		
	}
	
	@Test
	public void testEmpty() {
		assertTrue(emptyTree.isEmpty());
		
	}

	@Test
	public void testNotEmpty() {
		assertFalse(oneNodeTree.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, emptyTree.size());
		assertEquals(1, oneNodeTree.size());
		assertEquals(4,fourNodeTree.size());
	}
	
	@Test
	public void testContains() {
		assertTrue(oneNodeTree.contains(FOO));
		assertFalse(fourNodeTree.contains(6));
		assertTrue(fourNodeTree.contains(3));
	}
	
	@Test
	public void testRemove() {
		assertFalse(emptyTree.remove(0));
		assertTrue(fourNodeTree.remove(4));
		assertFalse(fourNodeTree.remove(4));
		fourNodeTree.add(4);
	}
	
	@Test
	public void testGet() {
		assertEquals(FOO, oneNodeTree.get(FOO));
		assertEquals((Integer)4,fourNodeTree.get(4));
	}
	
	@Test
	public void testAdd() {
		emptyTree.add(1);
		assertFalse(emptyTree.isEmpty());
		assertEquals(1, emptyTree.size());
	}
	
	@Test
	public void testGetMinimum() {
		assertEquals(null, emptyTree.getMinimum());
		assertEquals((Integer)2,fourNodeTree.getMinimum());
	}

	@Test
	public void testGetMaximum() {
		assertEquals(FOO, oneNodeTree.getMaximum());
		assertEquals((Integer)5,fourNodeTree.getMaximum());
	}

	@Test
	public void testHeight() {
		assertEquals(-1, emptyTree.height());
		assertEquals(0, oneNodeTree.height());
		assertEquals(2,fourNodeTree.height());
	}
	
	@Test
	public void testPreorderIterator() {
		Iterator<String> i = oneNodeTree.preorderIterator();
		while (i.hasNext()) {
			assertEquals(FOO, i.next());			
		}
		Iterator<Integer> integer=fourNodeTree.preorderIterator();
		int[] integertest=new int[]{4,2,3,5};
		int traverse=0;
		while(integer.hasNext())
		{
			assertEquals((Integer)integertest[traverse],integer.next());
			traverse++;
		}
		
	}

	/*@Test
	public void testInorderIterator() {
		Iterator<String> i = oneNodeTree.inorderIterator();
		while (i.hasNext()) {
			assertEquals(FOO, i.next());			
		}
		
		Iterator<Integer> integer2=fourNodeTree.preorderIterator();
		int[] integertest=new int[]{2,3,4,5};
		int traverse=0;
		while(integer2.hasNext())
		{
		
			traverse++;
		}
	}

	@Test
	public void testPostorderIterator() {
		Iterator<Integer> i = emptyTree.postorderIterator();
		assertFalse(i.hasNext());
		Iterator<Integer> integer3=fourNodeTree.preorderIterator();
		int[] integertest=new int[]{3,2,5,4};
		int traverse=0;
		while(integer3.hasNext())
		{
			traverse++;
		}
	}
	*/
	@Test
	public void testEquals() {
		BSTInterface<String> tree = new BinarySearchTree<String>();
		assertFalse(oneNodeTree.equals(tree));
		tree.add(new String("foo"));
		assertTrue(oneNodeTree.equals(tree));
		BSTInterface<Integer> tree1 = new BinarySearchTree<Integer>();
		BSTInterface<Integer> tree2 = new BinarySearchTree<Integer>();
		tree1.add(4);
		tree1.add(2);
		tree1.add(6);
		tree1.add(1);
		tree1.add(3);
		tree1.add(5);
		tree1.add(7);
		tree2.add(4);
		tree2.add(2);
		tree2.add(6);
		tree2.add(1);
		tree2.add(3);
		tree2.add(5);
		tree2.add(7);
		assertTrue(tree1.equals(tree2));
	}
	
	@Test
	public void testSameValues() {
		BSTInterface<Integer> tree = new BinarySearchTree<Integer>();
		assertTrue(emptyTree.sameValues(tree));
		
		emptyTree.add(1);
		emptyTree.add(2);
		
		tree.add(2);
		tree.add(1);
		
		assertTrue(emptyTree.sameValues(tree));
		BSTInterface<Integer> tree1 = new BinarySearchTree<Integer>();
		BSTInterface<Integer> tree2 = new BinarySearchTree<Integer>();
		tree1.add(5);
		tree1.add(3);
		tree1.add(6);
		tree1.add(7);
		tree1.add(2);
		tree2.add(3);
		tree2.add(2);
		tree2.add(7);
		tree2.add(6);
		tree2.add(5);
		assertTrue(tree2.sameValues(tree1));
	}
	
	@Test(timeout=50000000)
	public void testIsBalanced() {
		assertTrue(emptyTree.isBalanced());
		emptyTree.add(1);
		assertTrue(emptyTree.isBalanced());
		emptyTree.add(2);
		assertEquals(2,emptyTree.size());
		assertEquals(1,emptyTree.height());
		assertTrue(emptyTree.isBalanced());
		emptyTree.add(3);
		assertFalse(emptyTree.isBalanced());
	}
	
	@Test 
	public void testBalance() {
		emptyTree.add(1);
		emptyTree.add(2);
		emptyTree.add(3);
		assertFalse(emptyTree.isBalanced());
		emptyTree.balance();
		Iterator<Integer> integer2=emptyTree.preorderIterator();
		
		assertTrue(emptyTree.isBalanced());
		
	}
	
	@Test 
	public void testHeight2() {
		emptyTree.add(4);
		emptyTree.add(6);
		emptyTree.add(2);
		emptyTree.add(5);
		emptyTree.add(3);
		emptyTree.add(1);
		emptyTree.add(7);
		emptyTree.add(8);
		assertEquals(3,emptyTree.height());
	}
	@Test 
	public void testBalance2() {
		emptyTree.add(1);
		emptyTree.add(2);
		emptyTree.add(5);
		emptyTree.add(8);
		emptyTree.add(4);
		emptyTree.add(6);
		emptyTree.add(7);
		emptyTree.add(3);
		emptyTree.add(9);
		emptyTree.add(10);
		assertFalse(emptyTree.isBalanced());
		assertEquals(5,emptyTree.height());
		emptyTree.balance();
		assertEquals(3,emptyTree.height());
		assertTrue(emptyTree.isBalanced());
	}
	@Test 
	public void testContain() {
		emptyTree.add(1);
		emptyTree.add(2);
		emptyTree.add(3);
		assertTrue(emptyTree.contains(3));
		assertFalse(emptyTree.contains(4));
		}
}







