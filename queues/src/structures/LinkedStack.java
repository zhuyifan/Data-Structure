package structures;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> {
	Node<T> top;

	/**
	 * {@inheritDoc}
	 */
	
	public T pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		T a;
		if(!isEmpty()){
		a=top.getData();
		top=top.getNext();
		return a;
		}
		throw new StackUnderflowException("top of empty stack");
	}

	/**
	 * {@inheritDoc}
	 */
	
	public T top() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if (!isEmpty( ))
	         return top.getData( );
	    throw new StackUnderflowException("top of empty stack");
	}

	/**
	 * {@inheritDoc}
	 */
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
	     return (top == null);
	}

	/**
	 * {@inheritDoc}
	 */
	
	public int size() {
		// TODO Auto-generated method stub
		Node<T> current=top;
		int count=0;
		while(current!=null){
				current=current.getNext();
			count++;
		}
		return count;
	}

	/**
	 * {@inheritDoc}
	 */
	
	public void push(T elem) {
		// TODO Auto-generated method stub
		Node<T> newNode = new Node<T>(elem,null);
	    if(!isEmpty()){
		newNode.setNext(top);
	    top = newNode;
	    }
	    else
	    top=newNode;
	}

}
