package structures;
	import java.util.Iterator;
	import java.util.NoSuchElementException;

	class LinkedNodeIterator<T> implements Iterator<T> {
	   
		
		private Node<T> current;

	    
	  public LinkedNodeIterator(Node<T> b) {
		  current=b;
		  
	   
	 }

	  @Override
	  public boolean hasNext() {
	    
		  if(current!=null)
			  return true;
		  else
			  return false;
	  }

	  @Override
	  public T next() {
	    
		  if(this.hasNext()==true){
			  T a=current.getData();		 
	          current=current.getNext();
			  return a;
		 }  
	       
		else
	    throw new NoSuchElementException();
	  }

	  @Override
	  public void remove() {
		  
	    throw new UnsupportedOperationException();
	  }
	}


