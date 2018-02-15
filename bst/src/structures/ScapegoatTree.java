package structures;
import java.util.Stack;

public class ScapegoatTree<T extends Comparable<T>> extends
		BinarySearchTree<T> {

	private int upperBound=0;
	
	/**
	 * Adds an element to the tree.
	 * 
	 * The modified tree must still obey the BST rule, though it might not be
	 * balanced.
	 * 
	 * In addition to obeying the BST rule, the resulting tree must also obey
	 * the scapegoat rule. 
	 * 
	 * This method must only perform rebalancing of subtrees when indicated
	 * by the scapegoat rule; do not unconditionally call balance() 
	 * after adding, or you will receive no credit. 
	 * See the project writeup for details.
	 * 
	 * @param element
	 * @throws NullPointerException if element is null
	 */
	@Override
	public void add(T element) {
		Stack<BSTNode<T>> a=new Stack<BSTNode<T>>();
		root = addToSubtree(element, root,a);
		if(this.size()<3){
			upperBound++;
			return;
		}
		boolean t=false;
		while(!a.isEmpty()){
			BSTNode<T> b=a.pop();
			
			if(a.size()>0){
				if(3*subtreeSize(b)-2*subtreeSize(a.peek())>0){
	            t=true;
				break;
			}
			}
		}
		if(a.size()<=1&&t==false){
			upperBound++;
			return;
			
		}
		if(a.size()<=1&&t==true){
			return;
		}
		ScapegoatTree<T> c=new ScapegoatTree<T>();
		c.root=a.pop();
		c.balance();
		if(a.peek().getLeft()==null){
			a.peek().setRight(c.root);
		}
		if(a.peek().getRight()==null){
			a.peek().setLeft(c.root);
		}
		upperBound++;
		return;
		}
		


	private BSTNode<T> addToSubtree(T t, BSTNode<T> node,Stack<BSTNode<T>> a) {
		if (node == null) {
			return new BSTNode<T>(t, null, null);
		}
		a.push(node);
		if (t.compareTo(node.getData()) <= 0) {
			node.setLeft(addToSubtree(t, node.getLeft(),a));
		} else {
			node.setRight(addToSubtree(t, node.getRight(),a));
		}
		return node;
	}

	private int subtreeSize(BSTNode<T> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + subtreeSize(node.getLeft())
					+ subtreeSize(node.getRight());
		}
	}

	/**
	 * Attempts to remove one copy of an element from the tree, returning true
	 * if and only if such a copy was found and removed.
	 * 
	 * The modified tree must still obey the BST rule, though it might not be
	 * balanced.
	 * 
	 * In addition to obeying the BST rule, the resulting tree must also obey
	 * the scapegoat rule.
	 * 
	 * This method must only perform rebalancing of subtrees when indicated
	 * by the scapegoat rule; do not unconditionally call balance() 
	 * after removing, or you will receive no credit. 
	 * See the project writeup for details.

	 * @param element
	 * @return true if and only if an element removed
	 * @throws NullPointerException if element is null
	 */
	@Override
	public boolean remove(T element) {
		// TODO
		if(element==null){
			throw new NullPointerException("element is null");
		}
		if(this.contains(element)){
			root = removeFromSubtree(root, element);
			if(this.size()*2<upperBound){
			this.balance();
			upperBound=this.size();
			}
			return true; 
			}
				return false;
		}
	private BSTNode<T> removeFromSubtree(BSTNode<T> node, T t) {
		// node must not be null
		int result = t.compareTo(node.getData());
		if (result < 0) {
			node.setLeft(removeFromSubtree(node.getLeft(), t));
			return node;
		} else if (result > 0) {
			node.setRight(removeFromSubtree(node.getRight(), t));
			return node;
		} else { // result == 0
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			} else { // neither child is null
				T predecessorValue = getHighestValue(node.getLeft());
				node.setLeft(removeRightmost(node.getLeft()));
				node.setData(predecessorValue);
				return node;
			}
		}
	}

	private T getHighestValue(BSTNode<T> node) {
		// node must not be null
		if (node.getRight() == null) {
			return node.getData();
		} else {
			return getHighestValue(node.getRight());
		}
	}

	private BSTNode<T> removeRightmost(BSTNode<T> node) {
		// node must not be null
		if (node.getRight() == null) {
			return node.getLeft();
		} else {
			node.setRight(removeRightmost(node.getRight()));
			return node;
		}
	}
}
