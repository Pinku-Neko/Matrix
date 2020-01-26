/**
 * 
 */
package field.galoisField;

import field.Field;

/**
 * @author Pinku_Neko
 *
 */
public class GF9 implements Field<GF9> {

private final byte value;
	
	public GF9(final int argument) {
		if (argument < 0) {
			this.value = (byte) ( (0 - argument) % 9);
		} else {
			this.value = (byte) (argument % 9);
		}
	}

	@Override
	public String toString() {
		String element = "";
		switch (this.value % 3) {
		case 0:
			element += " 0";
			break;
		case 1:
			element += " 1";
			break;
		case 2:
			element += "-1";
			break;	
		default:
			break;
		}
		switch (this.value / 3) {
		case 0:
			element += "  ";
			break;
		case 1:
			element += "+ι";
			break;
		case 2:
			element += "-ι";
			break;	
		default:
			break;
		}
		return element;
	}

	@Override
	public GF9 getNeutralElementAdd() {
		return new GF9(0);
	}

	@Override
	public GF9 getNeutralElementMult() {
		return new GF9(1);
	}

	@Override
	public GF9 getInverseElementAdd() {
		final int[][] additionTable = Addition.F9.getTable();
		for (int i = 0; i < additionTable.length; i++) {
			if (new GF9(additionTable[this.value][i]).isZero()) {
				return new GF9(i);
			}
		}
		throw new IllegalArgumentException("Element not found, please check value and the addition table.");
	}

	@Override
	public GF9 getInverseElementMult() {
		final int[][] multiplicationTable = Multiplication.F9.getTable();
		for (int i = 0; i < multiplicationTable.length; i++) {
			if (new GF9(multiplicationTable[this.value][i]).isOne()) {
				return new GF9(i);
			}
		}
		throw new IllegalArgumentException("Element not found, please check value and the addition table.");
	}

	@Override
	public GF9 add(final GF9 element) {
		return new GF9(Addition.F9.getTable()[this.value][element.value]);
	}

	@Override
	public GF9 substract(final GF9 element) {
		return this.add(element.getInverseElementAdd());
	}

	@Override
	public GF9 multipliesWith(final GF9 element) {
		return new GF9(Multiplication.F9.getTable()[this.value][element.value]);
	}

	@Override
	public GF9 dividedBy(final GF9 element) {
		return this.multipliesWith(element.getInverseElementMult());
	}

	@Override
	public void checkIfDefined(final GF9 element) {
		if (element == null) {
			throw new NullPointerException("This element is not defined.");
		}
	}

	@Override
	public boolean isSameAs(final GF9 element) {
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
