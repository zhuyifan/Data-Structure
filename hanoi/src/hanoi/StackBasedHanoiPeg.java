package hanoi;

import java.util.Stack;

/**
 * A {@link StackBasedHanoiPeg} is an implementation of {@link HanoiPeg}.
 * 
 * @author jcollard
 */
public class StackBasedHanoiPeg implements HanoiPeg {
	public Stack<HanoiRing> peg;
	/**
	 * Creates a new {@link StackBasedHanoiPeg} that has no rings.
	 */
	public StackBasedHanoiPeg() {
		peg = new Stack<HanoiRing>();
		
	}

	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
		if(ring==null){
			throw new NullPointerException("ring is equal to null");
		}
		if(!peg.isEmpty()){
			if(peg.peek().getSize()<=ring.getSize()){
				throw new IllegalHanoiMoveException("topmost ring is smaller then added ring");
			}
			
			else
				peg.push(ring);
		}
		if(peg.isEmpty()){
			peg.push(ring);
		}
		
	}

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
		if(peg.isEmpty()){
			throw new IllegalHanoiMoveException("peg does not contain ring");
		}
		
		return peg.pop();
	}

	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
		if(peg.isEmpty()){
			throw new IllegalHanoiMoveException("peg does not contain ring");
		}
		return peg.peek();
	}

	@Override
	public boolean hasRings() {
		return !peg.isEmpty();
	}
}
