package hanoi;

import structures.LinkedStack;

/**
 * A {@link StackBasedHanoiPeg} is an implementation of {@link HanoiPeg}.
 * 
 * @author jcollard
 */
public class StackBasedHanoiPeg implements HanoiPeg {

	private LinkedStack<HanoiRing> Peg;
	/**
	 * Creates a new {@link StackBasedHanoiPeg} that has no rings.
	 */
	public StackBasedHanoiPeg() {
		Peg = new LinkedStack<HanoiRing>();
	}

	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
		if (Peg.getSize() == 0){
			Peg.push(ring);
		}
		else if (Peg.peek().getSize() > ring.getSize()){
			Peg.push(ring);
		}
		else{
			throw new IllegalHanoiMoveException("Bad Move! Ring to add is greater than top ring...");
		}
	}

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
		if (Peg.getSize() == 0){
			throw new IllegalHanoiMoveException("Can't get Top Ring, Peg is Empty!");
		}
		return Peg.pop();
	}

	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
		if (Peg.getSize() == 0)
			throw new IllegalHanoiMoveException("Can't get Top Ring, Peg is Empty!");
		return Peg.peek();
	}

	@Override
	public boolean hasRings() {
		if (Peg.getSize() > 0)
			return true;
		else
			return false;
	}
	public int getSize(){
		return Peg.getSize();
	}
}
