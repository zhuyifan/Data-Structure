package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImplementation<T> implements ListInterface<T> {
	Node<T> head=null;
	Node<T> back=null;
	int num=0;
	
	public ListImplementation(){
		
	}
	
	@Override
	public int size(){
		if(isEmpty()){
			return 0;
		}
		return num;
	}
	

	@Override
	public boolean isEmpty(){
		return head==null;
	}

	@Override
	public T get(int n) throws NoSuchElementException{
		Node<T> node=head;
		int count=0;
		if(count==n){
			return node.getData();
		}
		while(node!=null){
			node=node.getNext();
			if(node==null){
				throw new NoSuchElementException
				("out of bound");
			}
			count++;
			if(count==n){
				return node.getData();
			}
		}
			
		
		
	    return null;	
	}
	
	@Override
	public ListInterface<T> append(T elem){
		Node<T> node=new Node<T>(elem, null);
		if(elem==null){
			throw new NullPointerException("null pointer");
		}
		if(isEmpty()){
			back=node;
			head=node;
			num++;
		return this;
		}
		else{
			back.setNext(node);
			back=node;
			num++;
		return this;
		}
	}

	@Override
	public Iterator<T> iterator(){
		 Iterator<T> a=new LinkedNodeIterator<T>(head);
		return a;
	}
}


