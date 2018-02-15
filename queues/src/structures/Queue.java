package structures;

import java.util.NoSuchElementException;

public class Queue<T> implements UnboundedQueueInterface<T> {
	Node<T> front;
	Node<T> rare;
	int num;
	public Queue() {
		// TODO 1
		front=null;
		rare=null;
		num=0;
		
	}
	
	public Queue(Queue<T> other) {
		
		if(other.isEmpty()){
			front=null;
			rare=null;
			num=0;
		}
	for(int i=0; i<other.size();i++){
		T current=other.dequeue();
		this.enqueue(current);
		other.enqueue(current);
	}	
		
		
		
		// TODO 2
		// Hint: Maybe save this one until after you finish enqueue()/dequeue()
	}
	
	@Override
	public boolean isEmpty() {
		// TODO 3
		return front==null;
	}

	@Override
	public int size() {
		return num;
		// TODO 4
	}

	@Override
	public void enqueue(T element) {
		// TODO 5;
		Node<T> node=new Node<T>(element, null);
		if(element==null){
			throw new NullPointerException("null pointer");
		}
		if(isEmpty()){
			front=node;
			rare=node;
			num++;
		}
		else{
			rare.setNext(node);
			rare=node;
			num++;
		}
	}

	@Override
	public T dequeue() throws NoSuchElementException {
		// TODO 6;
		T a;
		if(isEmpty()){
			throw new NoSuchElementException("queue is empty");
		}
		if(num==1){
			a=front.getData();
			front=null;
			rare=null;
			num=0;
			}
		else{
			a=front.getData();
			front=front.getNext();
			num--;
		}
		return a;
	}

	@Override
	public T peek() throws NoSuchElementException {
		// TODO 7
		T a;
		if(isEmpty()){
			throw new NoSuchElementException("queue empty");
		}
			else{
				a=front.getData();
			}
		return a;
	}

	@Override
	public UnboundedQueueInterface<T> reversed() {
		// TODO 8
		// Hint: Maybe save this one until after you finish enqueue()/dequeue()
		
		UnboundedQueueInterface<T> a=new  Queue<T>();
		LinkedStack<T> b=new LinkedStack<T>();
		Node<T> current;
			current=front;
		for(int i=0; i<this.size();i++){
			
			a.enqueue(current.getData());
			current=current.getNext();
		}	
		for(int i=0;i<this.size();i++){
			b.push(a.dequeue());
		}
	    for(int i=0;i<this.size();i++){
	    	a.enqueue(b.pop());
	    }
        return a;
	}
}
