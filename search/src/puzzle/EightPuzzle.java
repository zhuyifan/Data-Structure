package puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import search.SearchProblem;
import search.Solver;

/**
 * A class to represent an instance of the eight-puzzle.
 * 
 * The spaces in an 8-puzzle are indexed as follows:
 * 
 * 0 | 1 | 2
 * --+---+---
 * 3 | 4 | 5
 * --+---+---
 * 6 | 7 | 8
 * 
 * The puzzle contains the eight numbers 1-8, and an empty space.
 * If we represent the empty space as 0, then the puzzle is solved
 * when the values in the puzzle are as follows:
 * 
 * 1 | 2 | 3
 * --+---+---
 * 4 | 5 | 6
 * --+---+---
 * 7 | 8 | 0
 * 
 * That is, when the space at index 0 contains value 1, the space 
 * at index 1 contains value 2, and so on.
 * 
 * From any given state, you can swap the empty space with a space 
 * adjacent to it (that is, above, below, left, or right of it,
 * without wrapping around).
 * 
 * For example, if the empty space is at index 2, you may swap
 * it with the value at index 1 or 5, but not any other index.
 * 
 * Only half of all possible puzzle states are solvable! See:
 * https://en.wikipedia.org/wiki/15_puzzle
 * for details.
 * 

 * @author liberato
 *
 */
public class EightPuzzle implements SearchProblem<List<Integer>> {
	/**
	 * Creates a new instance of the 8 puzzle with the given starting values.
	 * 
	 * The values are indexed as described above, and should contain exactly the
	 * nine integers from 0 to 8.
	 * 
	 * @param startingValues
	 *            the starting values, 0 -- 8
	 * @throws IllegalArgumentException
	 *             if startingValues is invalid
	 */
	List<Integer> a=new ArrayList<Integer>();
	
	public EightPuzzle(List<Integer> startingValues) {
		// TODO
		if(startingValues.size()!=9){
			throw new IllegalArgumentException("invalid");
		}
		for(int i=0;i<9;i++){
			if(startingValues.get(i)<0||startingValues.get(i)>8){
				throw new IllegalArgumentException("invalid");
			}
		}
		for(int j=0;j<8;j++){
			for(int k=j+1;k<9;k++){
				if(startingValues.get(j)==startingValues.get(k)){
					throw new IllegalArgumentException("invalid");
				}
			}
		}
		a=startingValues;
	}

	@Override
	public List<Integer> getInitialState() {
		// TODO
		return a;
	}

	@Override
	public List<List<Integer>> getSuccessors(List<Integer> currentState) {
		// TODO
		List<List<Integer>> s=new ArrayList<List<Integer>>();
		int num=0;
		for(int i=0;i<9;i++){
			if(currentState.get(i)==0){
				num=i;
				}
		}
		if(num==0){
			List<Integer> x=new ArrayList<Integer>();
			x.addAll(currentState);
		x.set(0,x.get(1));
		x.set(1, 0);
		List<Integer> y=new ArrayList<Integer>();
		y.addAll(currentState);
		y.set(0,x.get(3));
		y.set(3, 0);
		s.add(x);
		s.add(y);
		}
		if(num==1){
			List<Integer> x=new ArrayList<Integer>();
			x.addAll(currentState);
			x.set(1,x.get(0));
			x.set(0, 0);
			List<Integer> y=new ArrayList<Integer>();
			y.addAll(currentState);
			y.set(1,x.get(2));
			y.set(2, 0);
			List<Integer> z=new ArrayList<Integer>();
			z.addAll(currentState);
			z.set(1,x.get(4));
			z.set(4, 0);
			s.add(x);
			s.add(y);
			s.add(z);
		}
		if(num==2){
			List<Integer> x=new ArrayList<Integer>();
			x.addAll(currentState);
			x.set(2,x.get(1));
			x.set(1, 0);
			List<Integer> y=new ArrayList<Integer>();
			y.addAll(currentState);
			y.set(2,x.get(5));
			y.set(5, 0);
			s.add(x);
			s.add(y);
			}
		if(num==3){
			List<Integer> x=new ArrayList<Integer>();
			x.addAll(currentState);
			x.set(3,x.get(0));
			x.set(0, 0);
			List<Integer> y=new ArrayList<Integer>();
			y.addAll(currentState);
			y.set(3,x.get(4));
			y.set(4, 0);
			List<Integer> z=new ArrayList<Integer>();
			z.addAll(currentState);
			z.set(3,x.get(6));
			z.set(6, 0);
			s.add(x);
			s.add(y);
			s.add(z);
			}
		if(num==4){
			List<Integer> x=new ArrayList<Integer>();
			x.addAll(currentState);
			x.set(4,x.get(1));
			x.set(1, 0);
			List<Integer> y=new ArrayList<Integer>();
			y.addAll(currentState);
			y.set(4,x.get(3));
			y.set(3, 0);
			List<Integer> z=new ArrayList<Integer>();
			z.addAll(currentState);
			z.set(4,x.get(5));
			z.set(5, 0);
			List<Integer> zz=new ArrayList<Integer>();
			zz.addAll(currentState);
			zz.set(4,x.get(7));
			zz.set(7, 0);
			s.add(x);
			s.add(y);
			s.add(z);
			s.add(zz);
		    }
		if(num==5){
			List<Integer> x=new ArrayList<Integer>();
			x.addAll(currentState);
			x.set(5,x.get(2));
			x.set(2, 0);
			List<Integer> y=new ArrayList<Integer>();
			y.addAll(currentState);
			y.set(5,x.get(4));
			y.set(4, 0);
			List<Integer> z=new ArrayList<Integer>();
			z.addAll(currentState);
			z.set(5,x.get(8));
			z.set(8, 0);
			s.add(x);
			s.add(y);
			s.add(z);
			}
		if(num==6){
			List<Integer> x=new ArrayList<Integer>();
			x.addAll(currentState);
			x.set(6,x.get(3));
			x.set(3, 0);
			List<Integer> y=new ArrayList<Integer>();
			y.addAll(currentState);
			y.set(6,x.get(7));
			y.set(7, 0);
			s.add(x);
			s.add(y);
		}
		if(num==7){
			List<Integer> x=new ArrayList<Integer>();
			x.addAll(currentState);
			x.set(7,x.get(4));
			x.set(4, 0);
			List<Integer> y=new ArrayList<Integer>();
			y.addAll(currentState);
			y.set(7,x.get(6));
			y.set(6, 0);
			List<Integer> z=new ArrayList<Integer>();
			z.addAll(currentState);
			z.set(7,x.get(8));
			z.set(8, 0);
			s.add(x);
			s.add(y);
			s.add(z);
			}
		if(num==8){
			List<Integer> x=new ArrayList<Integer>();
			x.addAll(currentState);
			x.set(8,x.get(5));
			x.set(5, 0);
			List<Integer> y=new ArrayList<Integer>();
			y.addAll(currentState);
			y.set(8,x.get(7));
			y.set(7, 0);
			s.add(x);
			s.add(y);
		}
		return s;
	}

	@Override
	public boolean isGoal(List<Integer> state) {
		// TODO
		boolean a=true;
		for(int i=0;i<8;i++){
			if(state.get(i)!=i+1){
				a=false;
			}
		}
		if(state.get(8)!=0){
			a=false;
		}
		return a;
	}

	public static void main(String[] args) {
		EightPuzzle e = new EightPuzzle(Arrays.asList(new Integer[] { 1, 2, 3,
				4, 0, 6, 7, 5, 8 }));

		List<List<Integer>> r = new Solver<List<Integer>>(e).solveWithBFS();
		for (List<Integer> l : r) {
			System.out.println(l);
		}
	}
}
