package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;


import structures.Queue;


/**
 * An iterator to perform a level order traversal of part of a 
 * filesystem. A level-order traversal is equivalent to a breadth-
 * first search.
 * 
 * @author liberato
 *
 */
public class LevelOrderIterator extends FileIterator<File> {
	
	Queue<File> a=new Queue<File>();
	/**
	 * Instantiate a new LevelOrderIterator, rooted at the rootNode.
	 * @param rootNode
	 * @throws FileNotFoundException if the rootNode does not exist
	 */
	public LevelOrderIterator(File rootNode) throws FileNotFoundException {
		if(!rootNode.exists()){
			throw new FileNotFoundException("file not found");
	}
		a.enqueue(rootNode);
		}
		 
		// TODO 1
	
	
	@Override
	public boolean hasNext() {
		// TODO 2
		 if(!a.isEmpty())
			  return true;
		  else
			  return false;
		
	}

	@Override
	public File next() throws NoSuchElementException {
		// TODO 3
		if(!hasNext()){
			throw new NoSuchElementException("no next element");
		}
		File b=a.dequeue();
		if(b.isDirectory())
		{
		File[] array = b.listFiles();
		Arrays.sort(array);
		for(int i=0;i<array.length;i++){
			a.enqueue(array[i]);
		}
		}
		
			return b;
		  
	}

	@Override
	public void remove() {
		// Leave this one alone.
		throw new UnsupportedOperationException();		
	}

}
