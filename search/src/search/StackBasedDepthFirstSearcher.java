package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Stack. This results in a
 * depth-first search.
 * 
 */
public class StackBasedDepthFirstSearcher<T> extends Searcher<T> {
	
	public StackBasedDepthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
	}
    Stack<T> stack=new Stack<T>();
    List<T> L=new ArrayList<T>();
    int a=0;
    
    
	/*@Override
	public List<T> findSolution() {	
		stack.push(searchProblem.getInitialState());
		return findHelper();
	}
	
	/*private List<T> findHelper(){
		
		T b=stack.pop();
		L.add(b);
		if(a==1){
			return L;
		}
		List<T> list=searchProblem.getSuccessors(b);
		for(int i=0;i<list.size();i++){
			if(!L.contains(list.get(i))){
			stack.push(list.get(i));
			}
			if(searchProblem.isGoal(list.get(i))){
				a=1;
			}
			if(a==1)
				break;
		}
		if(stack.isEmpty()){
			return L;
		}
		findHelper();
		return L;
	}*/
	
	 @Override
	 public List<T> findSolution(){
	 stack.push(searchProblem.getInitialState());
	 L.add(searchProblem.getInitialState());
	 T state;
	
	 while(!searchProblem.isGoal(stack.peek())){
		 state=stack.peek();
		 if(searchProblem.getSuccessors(state).isEmpty()){
			 stack.pop();
		 }
		 else{
		 List<T> R=searchProblem.getSuccessors(state);
		 for(int i=0;i<R.size();i++){
			 if(!L.contains(R.get(i))){
				stack.push(R.get(i));
				L.add(R.get(i));
				 break;
			 }
		  }
		 }
	 }
	
	 List<T> a=new ArrayList<T>();
	 Stack<T> s=new Stack<T>();
	 
	 while(!stack.isEmpty()){
		s.push(stack.pop());
	 }
	 while(!s.empty()){
		 a.add(s.pop());
	 }
	 return a;
	 }
	 
}
