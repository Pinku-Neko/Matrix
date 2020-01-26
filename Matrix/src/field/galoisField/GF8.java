/**
 * 
 */
package field.galoisField;

import field.Field;

/**
 * @author Pinku_Neko
 *
 */
public class GF8 implements Field<GF8> {

private final byte value;
	
	public GF8(final int argument) {
		if (argument < 0) {
			this.value = (byte) ( (0 - argument) % 8);
		} else {
			this.value = (byte) (argument % 8);
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
			element += "+β";
		}
		if (this.value / 4 == 0) {
			element += "   ";
		} else {
			element += "+β²";
		}
		return element;
	}

	@Override
	public GF8 getNeutralElementAdd() {
		return new GF8(0);
	}

	@Override
	public GF8 getNeutralElementMult() {
		return new GF8(1);
	}

	@Override
	public GF8 getInverseElementAdd() {
		final int[][] additionTable = Addition.F8.getTable();
		for (int i = 0; i < additionTable.length; i++) {
			if (new GF8(additionTable[this.value][i]).isZero()) {
				return new GF8(i);
			}
		}
		throw new IllegalArgumentException("Element not found, please check value and the addition table.");
	}

	@Override
	public GF8 getInverseElementMult() {
		final int[][] multiplicationTable = Multiplication.F8.getTable();
		for (int i = 0; i < multiplicationTable.length; i++) {
			if (new GF8(multiplicationTable[this.value][i]).isOne()) {
				return new GF8(i);
			}
		}
		throw new IllegalArgumentException("Element not found, please check value and the addition table.");
	}

	@Override
	public GF8 add(final GF8 element) {
		return new GF8(Addition.F8.getTable()[this.value][element.value]);
	}

	@Override
	public GF8 substract(final GF8 element) {
		return this.add(element.getInverseElementAdd());
	}

	@Override
	public GF8 multipliesWith(final GF8 element) {
		return new GF8(Multiplication.F8.getTable()[this.value][element.value]);
	}

	@Override
	public GF8 dividedBy(final GF8 element) {
		return this.multipliesWith(element.getInverseElementMult());
	}

	@Override
	public void checkIfDefined(final GF8 element) {
		if (element == null) {
			throw new NullPointerException("This element is not defined.");
		}
	}

	@Override
	public boolean isSameAs(final GF8 element) {
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
