package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Queue. This results in a
 * breadth-first search.
 * 
 */
public class QueueBasedBreadthFirstSearcher<T> extends Searcher<T> {
	public QueueBasedBreadthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
	}
    Queue<T> queue= new LinkedList<T>();
	List<T> L=new ArrayList<T>();
	List<T> R=new ArrayList<T>();
	int num=0;
   
	/*  @Override
	public List<T> findSolution() {
		// TODO
	   queue.add(searchProblem.getInitialState());
	   R.add(searchProblem.getInitialState());
	  return this.pathHelper();	
	}
	
	private List<T> pathHelper(){
		
		T a=queue.poll();
		L.add(a);
		if(num==1){
			return R;
		}
		List<T> list=searchProblem.getSuccessors(a);
		for(int i=0;i<list.size();i++){
			if(!L.contains(list.get(i))){
			queue.add(list.get(i));
			 if(R.isEmpty()){
				   R.add(list.get(i));
			   }
			   if(searchProblem.getSuccessors(R.get(R.size()-1)).contains(list.get(i))){
				   R.add(list.get(i));
			   }
		}
		if(searchProblem.isGoal(list.get(i))){
			num=1;
		}
		}
		pathHelper();
		return R;
}*/

	
	@Override
	public List<T> findSolution() {
		// TODO
	   queue.add(searchProblem.getInitialState());
	   T state;
	   while(!queue.isEmpty()){
		   state=queue.remove();
		   if(searchProblem.isGoal(state)){
			   L.add(state); 
			   break;
		   }
		   if(!L.contains(state)){
			   L.add(state);
		   }
			   List<T> a=searchProblem.getSuccessors(state);
			   for(int i=0;i<a.size();i++){
				   if(!L.contains(a.get(i))){
					   queue.add(a.get(i));				  
			   }
		   }
	   }
	   R.add(L.get(L.size()-1));
	   while(!R.contains(searchProblem.getInitialState())){
		  for(int i=0;i<L.size()-1;i++){
			  if(searchProblem.getSuccessors(R.get(R.size()-1)).contains(L.get(i))){
				  R.add(L.get(i));
				  break;
			  }
		  }
	   }
	   List<T> G=new ArrayList<T>();
	   for(int i=R.size()-1;i>=0;i--){
		   G.add(R.get(i));
	   }
	 return G;	
	}
	/*@Override
	public List<T> findSolution() {
		queue.add(searchProblem.getInitialState());
		T state;
		while(!searchProblem.isGoal(queue.peek())){
			state=queue.poll();
			R.add(state);
			if(!searchProblem.getSuccessors(state).isEmpty()){
				List<T> a=new ArrayList<T>();
				a=searchProblem.getSuccessors(state);
				for(int i=0;i<a.size();i++){
					if(!L.contains(a.get(i)));
					L.add(a.get(i));
					queue.add(a.get(i));
				}
			}
		}
		return L;
	}*/
	
}
