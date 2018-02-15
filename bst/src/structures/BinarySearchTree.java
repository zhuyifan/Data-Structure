package structures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> implements
		BSTInterface<T> {
	protected BSTNode<T> root;
	BSTNode<T> current;

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return subtreeSize(root);
	}

	private int subtreeSize(BSTNode<T> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + subtreeSize(node.getLeft())
					+ subtreeSize(node.getRight());
		}
	}

	private boolean containHelper(BSTNode<T> a, T b ){
			int comp=a.getData().compareTo(b);
			 if(comp  == 0) return true;
			 if(comp > 0 && a.getLeft()!= null &&containHelper(a.getLeft(),b))return true;
			 if(comp < 0 && a.getRight()!= null &&containHelper(a.getRight(),b)) return true;
			 return false;
	}

	
	public boolean contains(T t) {
		// TODO
		if(t==null){
			throw new NullPointerException("element is null");
		}
		if(root==null){
			return false;
		}
		return containHelper(root,t);
	}

	public boolean remove(T t) {
		if(t==null){
			throw new NullPointerException("element is null");
		}
		boolean result = contains(t);
		if (result) {
			root = removeFromSubtree(root, t);
		}
		return result;
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
	
	public T get(T t) {
		// TODO
		if(t==null){
			throw new NullPointerException("element is null");
		}
		if(contains(t)){
			return t;
		}
		return null;
	}

	public void add(T t) {
		if(t==null){
			throw new NullPointerException("element is null");
		}
		root = addToSubtree(t, root);
	}

	private BSTNode<T> addToSubtree(T t, BSTNode<T> node) {
		if (node == null) {
			return new BSTNode<T>(t, null, null);
		}
		if (t.compareTo(node.getData()) <= 0) {
			node.setLeft(addToSubtree(t, node.getLeft()));
		} else {
			node.setRight(addToSubtree(t, node.getRight()));
		}
		return node;
	}
	
	@Override
	public T getMinimum() {
		// TODO
		if(root==null){
			return null;
		}
	current=root;
	while(current.getLeft()!=null){
		current=current.getLeft();
	}
	return current.getData();
	}

	@Override
	public T getMaximum() {
		// TODO
		if(root==null){
			return null;
		}
	current=root;
	while(current.getRight()!=null){
		current=current.getRight();
	}
	return current.getData();
	}
	

	private int heightHelper(BSTNode<T> a){
		if(a==null){
			return 0;
		}
		int leftHeight=1+heightHelper(a.getLeft());
		int rightHeight=1+heightHelper(a.getRight());
		return Math.max(leftHeight,rightHeight);
		
	}
	
	@Override
	public int height() {
		// TODO
		if(root==null){
			return -1;
		}
		current=root;
		return heightHelper(current)-1;
	}

	@Override
	public Iterator<T> preorderIterator() {
		// TODO
			Queue<T> queue = new LinkedList<T>();
			preorderTraverse(queue, root);
			return queue.iterator();
		}

	private void preorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			queue.add(node.getData());
			preorderTraverse(queue, node.getLeft());
			preorderTraverse(queue, node.getRight());
		}
	}
	
	@Override
	public Iterator<T> inorderIterator() {
		Queue<T> queue = new LinkedList<T>();
		inorderTraverse(queue, root);
		return queue.iterator();
	}
	
	private void inorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			inorderTraverse(queue, node.getLeft());
			queue.add(node.getData());
			inorderTraverse(queue, node.getRight());
		}
	}

	@Override
	public Iterator<T> postorderIterator() {
		// TODO
		Queue<T> queue = new LinkedList<T>();
		postorderTraverse(queue, root);
		return queue.iterator();
	}

	private void postorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			postorderTraverse(queue, node.getLeft());
			queue.add(node.getData());
			postorderTraverse(queue, node.getRight());
			queue.add(node.getData());
		}
	}
	
	@Override
	public boolean equals(BSTInterface<T> other) {
		// TODO
		if(other==null){
			throw new NullPointerException("element is null");
		}
		return equalsHelper(other.getRoot(),this.getRoot()); 
	}
	
	private boolean equalsHelper(BSTNode<T> o,BSTNode<T> t){
		if(o==t){
			return true;
		}
		
		if (o==null || t == null) {
	        return false;
	    }
	    return o.getData().equals(t.getData()) &&equalsHelper(o.getLeft(), t.getLeft()) && equalsHelper(o.getRight(), t.getRight());
	} 
	

	@Override
	public boolean sameValues(BSTInterface<T> other) {
		// TODO
		if(other==null){
			throw new NullPointerException("other is null");
		}
		if(this.size()!=other.size()){
			return false;
		}
		Iterator<T> a=this.inorderIterator();
		Iterator<T> b=other.inorderIterator();
		T[] array1 = (T[]) new Comparable[this.size()];
		for(int i=0;i<this.size();i++){
			array1[i]=a.next();
		}
		T[] array2 = (T[]) new Comparable[this.size()];
		for(int i=0;i<this.size();i++){
			array2[i]=b.next();
		}   
		boolean boo=true;
		for(int i=0;i<this.size();i++){
			if(array1[i]!=array2[i]){
				boo=false;
			}
		}
		return boo;
	}

	@Override
	public boolean isBalanced() {
		// TODO
		if(root==null){
			return true;
		}
		int x=1;
		int n=this.size();
		for(int i=0;i<this.height();i++){
			x=x*2;
		}
		int y=x*2;
		if(n>=x&&n<y){
			return true;
		}
		return false;
	}

	@Override
	public void balance() {
		// TODO	
		if(this.isEmpty()||this.size()==1||this.size()==2){
        return;
    }	
		int s=this.size();
		Iterator<T> a=this.inorderIterator();
		T[] array = (T[]) new Comparable[s];
		for(int i=0;i<s;i++){
			array[i]=a.next();
		}
		root=new BSTNode<T>(null,null,null);
		
		this.InsertTree(array, 0, s-1);		
	}

	private void InsertTree(T[] nodes,int low, int high){
	
	if (low == high) {
		this.add(nodes[low]); 
		return;
	}
	
	if ((low + 1) == high) {
		this.add(nodes[low]);
		this.add(nodes[high]);
		return;
	}
	else{
	int mid=(low + high)/2 ;
	if(root.getData()==null){
		root.setData(nodes[mid]);
	}
	else{
	this.add(nodes[mid]) ;
	}
	this.InsertTree(nodes,low, mid-1) ;
	this.InsertTree(nodes,mid + 1, high);
	}
	}

	

	
	@Override
	public BSTNode<T> getRoot() {
		// DO NOT MODIFY
		return root;
	}

	public static <T extends Comparable<T>> String toDotFormat(BSTNode<T> root) {
		// DO NOT MODIFY
		// see project description for explanation

		// header
		int count = 0;
		String dot = "digraph G { \n";
		dot += "graph [ordering=\"out\"]; \n";
		// iterative traversal
		Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
		queue.add(root);
		BSTNode<T> cursor;
		while (!queue.isEmpty()) {
			cursor = queue.remove();
			if (cursor.getLeft() != null) {
				// add edge from cursor to left child
				dot += cursor.getData().toString() + " -> "
						+ cursor.getLeft().getData().toString() + ";\n";
				queue.add(cursor.getLeft());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count
						+ ";\n";
				count++;
			}
			if (cursor.getRight() != null) {
				// add edge from cursor to right child
				dot += cursor.getData().toString() + " -> "
						+ cursor.getRight().getData().toString() + ";\n";
				queue.add(cursor.getRight());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count
						+ ";\n";
				count++;
			}

		}
		dot += "};";
		return dot;
	}
}