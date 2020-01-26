package field.galoisField;

import field.Field;

public class GF4 implements Field<GF4> {

	private final byte value;
	
	public GF4(final int argument) {
		if (argument < 0) {
			this.value = (byte) ( (0 - argument) % 4);
		} else {
			this.value = (byte) (argument % 4);
		}
	}

	@Override
	public String toString() {
		String element = "";
		if (this.value % 2 == 0) {
			element += "0";
		} else {
			element += "1";
		}
		if (this.value / 2 == 0) {
			element += "  ";
		} else {
			element += "+α";
		}
		return element;
	}

	@Override
	public GF4 getNeutralElementAdd() {
		return new GF4(0);
	}

	@Override
	public GF4 getNeutralElementMult() {
		return new GF4(1);
	}

	@Override
	public GF4 getInverseElementAdd() {
		final int[][] additionTable = Addition.F4.getTable();
		for (int i = 0; i < additionTable.length; i++) {
			if (new GF4(additionTable[this.value][i]).isZero()) {
				return new GF4(i);
			}
		}
		throw new IllegalArgumentException("Element not found, please check value and the addition table.");
	}

	@Override
	public GF4 getInverseElementMult() {
		final int[][] multiplicationTable = Multiplication.F4.getTable();
		for (int i = 0; i < multiplicationTable.length; i++) {
			if (new GF4(multiplicationTable[this.value][i]).isOne()) {
				return new GF4(i);
			}
		}
		throw new IllegalArgumentException("Element not found, please check value and the addition table.");
	}

	@Override
	public GF4 add(final GF4 element) {
		return new GF4(Addition.F4.getTable()[this.value][element.value]);
	}

	@Override
	public GF4 substract(final GF4 element) {
		return this.add(element.getInverseElementAdd());
	}

	@Override
	public GF4 multipliesWith(final GF4 element) {
		return new GF4(Multiplication.F4.getTable()[this.value][element.value]);
	}

	@Override
	public GF4 dividedBy(final GF4 element) {
		return this.multipliesWith(element.getInverseElementMult());
	}

	@Override
	public void checkIfDefined(final GF4 element) {
		if (element == null) {
			throw new NullPointerException("This element is not defined.");
		}
	}

	@Override
	public boolean isSameAs(final GF4 element) {
		return (this.value == element.value);
	}

	@Override
	public boolean isZero() {
		return this.isSameAs(getNeutralElementAdd());
	}

	@Override
	public boolean isOne() {
		return this.isSameAs(getNeutralElementMult());
	}

}
