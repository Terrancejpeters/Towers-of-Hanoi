package hanoi;

/**
 * A {@link StackBasedHanoiPeg} is an implementation of {@link HanoiPeg}.
 * 
 * @author jcollard
 */
public class StackBasedHanoiPeg implements HanoiPeg {

	/**
	 * Creates a new {@link StackBasedHanoiPeg} that has no rings.
	 */
	public StackBasedHanoiPeg() {
	}

	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
	}

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
		return null;
	}

	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
		return null;
	}

	@Override
	public boolean hasRings() {
		return false;
	}
}
