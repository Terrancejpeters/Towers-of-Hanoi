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
	private StackBasedHanoiPeg Peg0;
	private StackBasedHanoiPeg Peg1;
	private StackBasedHanoiPeg Peg2;
	private int solution;

	public ArrayBasedHanoiBoard(int n) {
		Peg0 = new StackBasedHanoiPeg();
		for (int i = n; i > 0; i--) {
			HanoiRing temp = new HanoiRing(i);
			Peg0.addRing(temp);
		}
		Peg1 = new StackBasedHanoiPeg();
		Peg2 = new StackBasedHanoiPeg();
		solution = n;
	}

	@Override
	public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
		if (!isLegalMove(move)) {
			throw new IllegalHanoiMoveException("Could not perform illegal move.");
		}
		int from = move.getFromPeg();
		int to = move.getToPeg();
		StackBasedHanoiPeg TempFrom = null;
		StackBasedHanoiPeg TempTo = null;
		// so sorry checker
		if (from == 0) {
			TempFrom = Peg0;
		} else if (from == 1) {
			TempFrom = Peg1;
		} else if (from == 2) {
			TempFrom = Peg2;
		}
		if (to == 0) {
			TempTo = Peg0;
		} else if (to == 1) {
			TempTo = Peg1;
		} else if (to == 2) {
			TempTo = Peg2;
		}

		TempTo.addRing(TempFrom.remove());
	}

	@Override
	public boolean isSolved() {
		if (Peg2.getSize() == solution) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isLegalMove(HanoiMove move) {
		int from = move.getFromPeg();
		int to = move.getToPeg();
		StackBasedHanoiPeg TempFrom = null;
		StackBasedHanoiPeg TempTo = null;
		if (from == 0) {
			TempFrom = Peg0;
		} else if (from == 1) {
			TempFrom = Peg1;
		} else if (from == 2) {
			TempFrom = Peg2;
		} else {
			return false;
		}
		if (to == 0) {
			TempTo = Peg0;
		} else if (to == 1) {
			TempTo = Peg1;
		} else if (to == 2) {
			TempTo = Peg2;
		} else {
			return false;
		}
		if (TempFrom.getSize() == 0) {
			return false;
		}
		if (TempTo.getTopRing().getSize() < TempFrom.getTopRing().getSize()) {
			return false;
		} else {
			return true;
		}
	}
}
