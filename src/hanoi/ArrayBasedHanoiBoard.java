package hanoi;

import structures.ListImplementation;

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
	ListImplementation<StackBasedHanoiPeg> Pegs = new ListImplementation<StackBasedHanoiPeg>();

	private int solution;

	public ArrayBasedHanoiBoard(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		StackBasedHanoiPeg Peg0 = new StackBasedHanoiPeg();
		for (int i = n; i > 0; i--) {
			HanoiRing temp = new HanoiRing(i);
			Peg0.addRing(temp);
		}
		Pegs.append(Peg0);
		Pegs.append(new StackBasedHanoiPeg());
		Pegs.append(new StackBasedHanoiPeg());
		solution = n;
	}

	@Override
	public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
		if (!isLegalMove(move)) {
			throw new IllegalHanoiMoveException("Could not perform illegal move.");
		}
		StackBasedHanoiPeg TempFrom = Pegs.get(move.getFromPeg());
		StackBasedHanoiPeg TempTo = Pegs.get(move.getToPeg());
		// so sorry checker

		TempTo.addRing(TempFrom.remove());
	}

	@Override
	public boolean isSolved() {
		if (Pegs.get(2).getSize() == solution) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isLegalMove(HanoiMove move) {
		// if peg is the same peg
		if (move.getFromPeg() == move.getToPeg()) {
			return false;
		}
		// Check if From peg is bad
		if (!Pegs.get(move.getFromPeg()).hasRings()) {
			return false;
		} else {
			if (!Pegs.get(move.getToPeg()).hasRings()) {
				return true;
			}
		}
		int FromRingSize = Pegs.get(move.getFromPeg()).getTopRing().getSize();
		int ToRingSize = Pegs.get(move.getToPeg()).getTopRing().getSize();
		if (FromRingSize > ToRingSize) {
			return false;
		} else if (FromRingSize == 0) {
			return false;
		} else {
			return true;
		}

	}
}
