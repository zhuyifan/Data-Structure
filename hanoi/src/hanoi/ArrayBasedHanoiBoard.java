package hanoi;
/**
 * A {@link ArrayBasedHanoiBoard} is a simple implementation of
 * {@link HanoiBoard}
 * 
 * @author jcollard
 * 
 */
public class ArrayBasedHanoiBoard implements HanoiBoard {
	/**
	 * Creates a {@link ArrayBasedHanoiBoard} with three empty {@link HanoiPeg}s
	 * and {@code n} rings on peg 0.
	 */
	StackBasedHanoiPeg[] array=new StackBasedHanoiPeg[3];
	
	
	public ArrayBasedHanoiBoard(int n) {
	 array[0]=new StackBasedHanoiPeg();
	 array[1]=new StackBasedHanoiPeg();
	 array[2]=new StackBasedHanoiPeg();
	 int num=n;
		
		if(n<0){
			throw new IllegalArgumentException("n is not eigible");
		}
	
		else
			for(int i=0;i<n;i++){
				HanoiRing h=new HanoiRing(num);
				array[0].addRing(h);
				num--;
		}
	}

	@Override
	public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
		if (!isLegalMove(move)) {
			throw new IllegalHanoiMoveException(
					"Could not perform illegal move.");
		}
		else{
			( array[move.getToPeg()]).addRing((array[move.getFromPeg()]).getTopRing());
			( array[move.getFromPeg()]).remove();
			
		}
			
	}

	@Override
	public boolean isSolved() {
		if(!array[0].hasRings()&&!array[1].hasRings()){
		return true;
		}
		if(!array[0].hasRings()&&!array[2].hasRings()){
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean isLegalMove(HanoiMove move) {
		if (move==null) {
			throw new NullPointerException(
					"move is null.");
		}
		int a=move.getFromPeg();
		int b=move.getToPeg();		
		
		if(!array[a].hasRings()){
			return false;
		}
			
			if(array[a].hasRings()&&array[b].hasRings()){
			if(( array[a]).getTopRing().getSize()>(array[b]).getTopRing().getSize()){
				return false;
			}
			}
			
	    if(a==b){
	    	return false;
	    }

		
			return true;
	}
}
