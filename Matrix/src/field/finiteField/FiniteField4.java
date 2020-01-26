package field.finiteField;

import field.Field;

public class FiniteField4 implements Field<FiniteField4> {

	private final byte value;
	
	private static final byte[][] additionTable = new byte[][] {
		{0,1,2,3},
		{1,0,3,2},
		{2,3,0,1},
		{3,2,1,0}
	};
	
	private static final byte[][] multiplicationTable = new byte[][] {
		{0,0,0,0},
		{0,1,2,3},
		{0,2,3,1},
		{0,3,1,2}
	};
	
	public FiniteField4(final int argument) {
		if (argument < 0) {
			this.value = (byte) ( (0 - argument) % 4);
		} else {
			this.value = (byte) (argument % 4);
		}
	}

	@Override
	public String toString() {
		return String.format("%d + " + "%d α", this.value % 2, this.value / 2);
	}

	@Override
	public FiniteField4 getNeutralElementAdd() {
		return new FiniteField4(0);
	}

	@Override
	public FiniteField4 getNeutralElementMult() {
		return new FiniteField4(1);
	}

	@Override
	public FiniteField4 getInverseElementAdd() {
		for (int i = 0; i < additionTable.length; i++) {
			if (new FiniteField4(additionTable[this.value][i]).isZero()) {
				return new FiniteField4(i);
			}
		}
		throw new IllegalArgumentException("Element not found, please check value and the addition table.");
	}

	@Override
	public FiniteField4 getInverseElementMult() {
		for (int i = 0; i < multiplicationTable.length; i++) {
			if (new FiniteField4(multiplicationTable[this.value][i]).isSameAs(getNeutralElementMult())) {
				return new FiniteField4(i);
			}
		}
		throw new IllegalArgumentException("Element not found, please check value and the addition table.");
	}

	@Override
	public FiniteField4 add(final FiniteField4 element) {
		return new FiniteField4(additionTable[this.value][element.value]);
	}

	@Override
	public FiniteField4 substract(final FiniteField4 element) {
		return this.add(element.getInverseElementAdd());
	}

	@Override
	public FiniteField4 multipliesWith(final FiniteField4 element) {
		return new FiniteField4(multiplicationTable[this.value][element.value]);
	}

	@Override
	public FiniteField4 dividedBy(final FiniteField4 element) {
		return this.multipliesWith(element.getInverseElementMult());
	}

	@Override
	public void checkIfDefined(final FiniteField4 element) {
		if (element == null) {
			throw new NullPointerException("This element is not defined.");
		}
	}

	@Override
	public boolean isSameAs(final FiniteField4 element) {
		return (this.value == element.value);
	}

	@Override
	public boolean isZero() {
		return (this.isSameAs(getNeutralElementAdd()));
	}

}
